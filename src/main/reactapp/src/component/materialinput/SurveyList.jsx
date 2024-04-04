import axios from "axios";
import { useEffect, useState } from "react"
import { Link } from "react-router-dom";

export default function SurveyList(props){

    // 계량
    const [ survey , setSurvey ] = useState([]);

    // 워크플랜
    const [ workPlan , setWorkPlan] = useState([]);

    useEffect( ( ) => {
        axios.get("/material/surveyinfo.do")
        .then( (r) => {
            console.log(r);
            const result = r.data.map((survey) => {return survey;})
            setSurvey(result)
        })
    },[])

    useEffect(()=>{
        axios.get("/survey/workplaninfo.do")
        .then((response)=>{
            console.log(response);
            const result = response.data.map((workPlan)=>{return workPlan;})
            setWorkPlan(result);

        })
    },[])



    return(<>
        <div id="workPlanListBox">
            {workPlan.map((s) => {
                
                return(
                    <div>
                        <Link to={`/material/input?sno=${s.wno}`}>
                            <span>작업계획 {s.wno}</span>
                            <span>등록일자 : {s.cdate}</span>
                        </Link>
                    </div>
                )
            })}
        </div>    
    </>)
}