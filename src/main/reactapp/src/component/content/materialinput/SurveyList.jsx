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

   


    return(<>
        <div id="workPlanListBox">
            {survey.map((s) => {
                
                return(
                    <>
                    {s.sstate==2?
                    <div>
                        <Link to={`/material/input?sno=${s.sno}`}>
                            <span>작업계획 {s.sno}</span>
                            <span>등록일자 : {s.cdate}</span>
                        </Link>
                    </div>
                    :""}

                </>)
            })}
        </div>    
    </>)
}