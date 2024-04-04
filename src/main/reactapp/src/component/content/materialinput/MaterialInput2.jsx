import axios from "axios";
import { useCallback, useEffect, useRef, useState } from "react";
import { useSearchParams } from "react-router-dom";
import SurveyList from "./SurveyList";

export default function MaterialInput2(props){
    // 1. 컨텍스트 가져오기 (로그인 정보)
//     const { logininfo, setLogin } = useContext(LoginInfoContext);
// console.log(logininfo);
    

    // 쿼리스트링 값 가져오기 sno
    let [query, setQuery] = useSearchParams();

    const [ surveyB , setSurveyB ] = useState([
        {
            "pname":"",
            "wcount":0,
            "wendtime":"2024T"
        }
    ]);
    console.log(query)
    console.log(query.get("sno"))
            
    const survey =
     () =>{
     axios.get('/material/input/info/get.do', { params :{ sno :query.get("sno") }} )
    .then((response)=>{
    console.log(response);
    setSurveyB(response.data);
    

    }).catch( (e) => {console.log(e)})
    }
    console.log(surveyB);

    useEffect (() => { 
        if(query.get("sno")){
            survey() 
        }
    } , [query.get("sno")])
    

    function onClickBtn(){
        console.log( query.get("sno"))
        axios.post("/material/input/post.do?sno="+query.get("sno"))
        .then( (r) => {
            console.log(r);
        })
        .catch( (e) => {console.log(e)})
    }


    return(<>
        <div>
        <h3>
            <span>생산제품 : {surveyB[0].pname}</span>
            <span>생산수량 : {surveyB[0].wcount.toLocaleString()} EA</span>
            <span>생산기한 : {surveyB[0].wendtime.split('T')[0]} 까지</span>
            
        </h3>
        <ul>
            {surveyB.map((r,index)=>
                {
                    return (<>
                        <li>투입재료 : {r.rmname} 계량된 값 = {r.sbcount}g</li>
                        <div>입력된 양 : <input type="text"  /></div>
                    </>)
                }
            )}
        </ul>
        <button type="button" onClick={onClickBtn}>등록</button>
        </div>

    </>)
}




