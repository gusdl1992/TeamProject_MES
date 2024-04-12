import axios from "axios";
import { useContext, useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";
import { LoginInfoContext } from "../../Index";

export default function PackagingWrite(props){    
    // 1. 컨텍스트 가져오기 (로그인 정보)
    const { logininfo, setLogin } = useContext(LoginInfoContext);
    //console.log(logininfo); 

    const [ packagingInfo , setPackagingInfo] = useState("");

    const [ render , setRender ] = useState(false);
    
    const [ 박스개수 , set박스개수 ] = useState("");

    // 쿼리스트링 값 가져오기 sdno
    let [query, setQuery] = useSearchParams();
    
    const packaging = ()=>{
        axios.get("/packaging/subdivision/info/get.do", { params :{ sdno :query.get("sdno") }} )
        .then((r)=>{
            console.log(r); 

            setRender(true);
            setPackagingInfo(r.data);            
        }).catch( (e) => {console.log(e)})
    }   

    const 박스개수처리 = (event) => {
        console.log(event.target.value);
        console.log(packagingInfo.manufacturingDto.materialInputDto.productDto.packagingcount);
        console.log(parseInt((박스개수)/(packagingInfo.manufacturingDto.materialInputDto.productDto.packagingcount)));
        set박스개수(event.target.value);
    }
    
    

    const packaginPost = () => {
        

        let packagingForm = document.querySelector(".packagingForm");
        let packagingFormData = new FormData(packagingForm);
        
        console.log(packagingForm.pgcount.value);
        console.log(packagingFormData.pgcount);

        axios.post("/packaging/post.do?sdno="+query.get('sdno') , packagingFormData)
        .then((r)=>{
            console.log(r);
        }).catch((e) => {console.log(e)})   
        console.log(packagingForm.pgcount.value);
        console.log(packagingInfo.manufacturingDto.materialInputDto.productDto.pno)

        let packagingFormData2 = new FormData();
        packagingFormData2.append('pno', packagingInfo.manufacturingDto.materialInputDto.productDto.pno);
        packagingFormData2.append('pgcount', packagingForm.pgcount.value);

        
        axios.post("/productlog/post.do" , packagingFormData2 )
        .then( (r2) => {
            console.log(r2);
        }).catch((e) => {console.log(e)})
    }


    useEffect( () => { packaging(); },[query])

    if(logininfo != null && render ){
    return(<>
        <div>
        <form className="packagingForm">
        <h3>
            <span>포장제품 : {packagingInfo.manufacturingDto.materialInputDto.workPlanDto.pname}</span>
            <span>포장수량 : {packagingInfo.manufacturingDto.materialInputDto.workPlanDto.wcount} EA</span>
            <span>포장기한 : {packagingInfo.manufacturingDto.materialInputDto.workPlanDto.wendtime.split('T')[0]} 까지</span>            
        </h3>
        <div>
            소분완료량 : {packagingInfo.successcount}            
            <input type="text" name="successcount" onChange={박스개수처리}/>
            박스개수 : <input type="text" name="pgcount" value={parseInt((박스개수)/(packagingInfo.manufacturingDto.materialInputDto.productDto.packagingcount))}/>            
        </div>
            <button type="button" onClick={packaginPost}>등록</button>
            </form>
        </div>

    </>);
    }else{
       return(<></>) 
    }
}
