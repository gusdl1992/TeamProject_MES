import axios from "axios"
import { useEffect, useState } from "react"
import { Link } from "react-router-dom";
export default function WorkPlanList(){
    
    // 워크플랜
    const [ workPlan , setWorkPlan] = useState([]);

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
        {workPlan.map((w)=>{
            return(
                <div>
                    <Link to={`/survey/survey?wno=${w.wno}`}><span>작업계획{w.wno}</span> &nbsp; <span>식별번호 : {w.wno}</span> &nbsp; <span>등록일자 : {w.cdate}</span></Link>
                </div>
                )
        })}
        </div>
    </>)
}