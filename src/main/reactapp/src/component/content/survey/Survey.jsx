import axios from "axios";
import { useEffect, useState } from "react";

export default function Survey(props){

    // 워크플랜
    const [ workPlanInfo , setWorkPlanInfo] = useState({});

    useEffect( ()=>{
        const formData = new FormData();
        formData.append("wno",1); // 바꿔야함
        axios.post("/survey/workplan/clilck.do",formData)
        .then((response)=>{
            console.log(response);
            setWorkPlanInfo(response.data);
        })
        .catch(re =>{console.log(re)})
    },[])
    
    return(<>
        {console.log(workPlanInfo)}
        <div id="surveyCssBox">
            <div>
                {workPlanInfo.recipeDto.map( e => {<span>생산제품 : {e}</span>})}
                <span>생산제품 : {workPlanInfo.recipeDto[0].pname}</span>
                <span>생산수량 : {workPlanInfo.workPlanDto.wcount} EA</span>
                <span>생산기한 : {workPlanInfo.workPlanDto.wendtime} 까지</span>
            </div>

        </div>
    </>);
}