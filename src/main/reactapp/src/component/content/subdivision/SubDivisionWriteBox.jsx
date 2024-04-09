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
            
    const manufacturing = ()=>{
        axios.get('/subdivision/input/post.do', { params :{ mfno :query.get("mfno") }} )
        .then((r)=>{
            console.log(r);
        }).catch( (e) => {console.log(e)})
    }

    function onClickBtn(){
        console.log( query.get("sno"))
        axios.post("/material/input/post.do?sno="+query.get("sno"))
        .then( (r) => {
            console.log(r);
        })
        .catch( (e) => {console.log(e)})
    }

    if(logininfo != null ){
    return(<>
        <div>
        <h3>
            <span>생산제품 : {}</span>
            <span>생산수량 : {} EA</span>
            <span>생산기한 : {} 까지</span>
            
        </h3>
        <ul>
            
        </ul>
        <button type="button" onClick={onClickBtn}>등록</button>
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