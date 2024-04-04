import axios from "axios"
import { useEffect, useState } from "react"
import { Link } from "react-router-dom";
import "./survey.css"

export default function WorkPlanList(){
    
    // 워크플랜
    const [ workPlan , setWorkPlan] = useState([]);

    useEffect(()=>{
        axios.get("/survey/workplaninfo.do")
        .then((response)=>{
            // console.log(response);
            const result = response.data.map((workPlan)=>{return workPlan;})
            setWorkPlan(result);

        })
    },[])
    
    return(<>
        <div id="workplanCssBox">
        {workPlan.map((w)=>{
            return(
                <div className="workplanCss">
                    <Link to={`/survey/survey?wno=${w.wno}`}>
                        <h4>작업계획{w.wno}</h4>
                        <div>PlanNumber : {w.wno}</div>
                        <div>등록일자 : {w.cdate.split('T')[0].split('-')[0]}년 {w.cdate.split('T')[0].split('-')[1]}월 {w.cdate.split('T')[0].split('-')[2]}일</div>
                    </Link>
                </div>
                )
        })}
        </div>
    </>)
}