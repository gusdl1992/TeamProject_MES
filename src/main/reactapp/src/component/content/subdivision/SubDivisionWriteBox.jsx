import axios from "axios";
import { useContext, useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";
import { LoginInfoContext } from "../../Index";

export default function SubDivisionWriteBox(props){
    // 1. 컨텍스트 가져오기 (로그인 정보)
    const { logininfo, setLogin } = useContext(LoginInfoContext);
    //console.log(logininfo); 


    // 쿼리스트링 값 가져오기 mfno
    let [query, setQuery] = useSearchParams();

    // 벌크 객체
    const [ manufacturingInfo , setManufacturingInfo] = useState({
        wcount:0,
        wendtime:"2024-03-30T10:00:12.123456"
    });
            
    const manufacturing = ()=>{
        axios.get('/subdivision/manufacturing/one/get.do', { params :{ mfno :query.get("mfno") }} )
        .then((r)=>{
            console.log(r);
            setManufacturingInfo(r.data);
        }).catch( (e) => {console.log(e)})
    }

    useEffect (()=>{
        if(query.get("mfno")){
            manufacturing();
        }
    },[query.get("mfno")])

    const onClickBtn = ()=>{
        let subdivisionForm = document.querySelector('.subdivisionForm');
        let subdivisionFormData = new FormData(subdivisionForm);
        subdivisionFormData.append('mfno',query.get('mfno'));
        console.log(subdivisionFormData);
        axios.post("/subdivision/input/post.do?mfno="+query.get('mfno'),subdivisionFormData)
        .then( (r) => {
            console.log(r);
        })
        .catch( (e) => {console.log(e)})
    }

    if(logininfo != null && manufacturingInfo.materialInputDto && manufacturingInfo.materialInputDto.workPlanDto){
    return(<>
        {manufacturingInfo.materialInputDto.workPlanDto.wcount!=""?
            <div id="surveyCssBox">
                <form className="subdivisionForm">
                    <h3>
                        <span>생산제품 : {manufacturingInfo.materialInputDto.workPlanDto.pname}</span>
                        <span>생산수량 : {manufacturingInfo.materialInputDto.workPlanDto.wcount} EA</span>
                        <span>생산기한 : {manufacturingInfo.materialInputDto.workPlanDto.wendtime} 까지</span>
                    </h3>
                    <div>
                        벌크완료량 : {manufacturingInfo.mfcount}
                        {console.log(manufacturingInfo.materialInputDto.productDto.standard)}
                        {console.log(manufacturingInfo.mfcount)}
                        {console.log(((manufacturingInfo.materialInputDto.productDto.standard) / (1)))}
                        만들수 있는 제품 수량 : {parseInt((manufacturingInfo.mfcount) / (manufacturingInfo.materialInputDto.productDto.standard))}
                        소분완료량 : <input type="text" name="successcount"/>
                        불량품량 : <input type="text" name="failcount"/>
                        <button type="button" onClick={onClickBtn}>버튼</button>
                    </div>
                </form>
            </div>
            :""}
    </>);
    }
}
/*
{query.map((r,index)=>
                {
                    return (<>
                        <li>투입재료 : {r.rmname} 계량된 값 = {r.sbcount}g</li>
                        <div>입력된 양 : <input type="text"  /></div>
                    </>)
                }
            )}
*/