import axios from "axios";
import { useContext, useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";
import { LoginInfoContext } from "../../Index";

export default function PackagingWrite(props){    
    // 1. 컨텍스트 가져오기 (로그인 정보)
    const { logininfo, setLogin } = useContext(LoginInfoContext);
    //console.log(logininfo); 

    const [ packagingInfo , setPackagingInfo] = useState([]);

    // 쿼리스트링 값 가져오기 sdno
    let [query, setQuery] = useSearchParams();
    
    const packaging = ()=>{
        axios.get("/packaging/subdivision/info/get.do", { params :{ sdno :query.get("sdno") }} )
        .then((r)=>{
            console.log(r);
        }).catch( (e) => {console.log(e)})
    }   

    useEffect( () => { packaging(); },[query])

    if(logininfo != null ){
    return(<>
        <div>
        <h3>
            <span>포장제품 : {}</span>
            <span>포장수량 : {} EA</span>
            <span>포장기한 : {} 까지</span>
            
        </h3>
        <ul>
            
        </ul>
        {/* <button type="button" onClick={onClickBtn}>등록</button> */}
        </div>

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