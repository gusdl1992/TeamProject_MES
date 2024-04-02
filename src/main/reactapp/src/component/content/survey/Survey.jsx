import axios from "axios";
import { useEffect, useState } from "react";
import { Await, useSearchParams } from "react-router-dom";
import WorkPlanList from "./WorkPlanList";

export default function Survey(props){

    console.log(props);
    const [query , setQuery] = useSearchParams();
    console.log(query.get("wno"));

    // 워크플랜 객체
    const [ workPlanInfo , setWorkPlanInfo] = useState({});
    // 레시피리스트
    const [ recipeDtoList , setRecipeDtoList] = useState([]);
    

    useEffect( ()=>{
        const formData = new FormData();
        formData.append("wno",1); // 바꿔야함
        axios.post("/survey/workplan/clilck.do",formData)
        .then((response)=>{
            console.log(response);
            setWorkPlanInfo(response.data.workPlanDto);
            const result = response.data.recipeDto.map( (re) =>{return re;})// 레시피 dto state 추가하기
            setRecipeDtoList(result);
            
        })
        .catch(re =>{console.log(re)})
    },[])
    
    console.log(recipeDtoList);
    
    
    return(<>
        {console.log(workPlanInfo)}
        <WorkPlanList/>
        <div id="surveyCssBox">
            <form>
                {/* <div>
                    <span>생산제품 : {recipeDtoList[0].pname}</span>
                    <span>생산수량 : {workPlanInfo.wcount} EA</span>
                    <span>생산기한 : {workPlanInfo.wendtime} 까지</span>
                </div> */}
                <div>
                    <ul>
                    {
                        recipeDtoList.map((r)=>{
                            return(<>
                                <li>투입재료 {r.rmname} 투입양 {r.reamount*workPlanInfo.wcount}</li>
                                <div><input type="text" name="surveyBDto" /></div>
                            </>
                            );
                        })
                    }
                    </ul>
                    <button onClick={''}>버튼</button>
                </div>
            </form>

        </div>
    </>);
}