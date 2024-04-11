import axios from "axios";
import { useState } from "react";

export default function WorkPlan(props){
    const [reRender , setReRender] = useState(false);

    const writeWorkPlan = ()=>{
        let workPlanForm = document.querySelector('.workPlanForm');
        let workPlanFormData = new FormData(workPlanForm);

        axios.post('/wp/write/post.do',workPlanFormData)
        .then(r=>{
            console.log(r);
            if(r){
                setReRender(!reRender);
            }
        })
        .catch(e=>{
            console.log(e);
        })
    } 

    return(
        <div style={{maxWidth:'66%',minWidth:'1100px',margin:'0 auto',border:'1px solid red'}}>
            <form className="workPlanForm">
                거래처 : <input type="text"/>
                제품 : <input type="text" name="pname"/>
                수량 : <input type="text" name="wcount"/>
                납기 일 : <input type="text" name="wendtime"/>
                <button type="button" onClick={writeWorkPlan}>등록</button>
            </form>
        </div>
    )
}