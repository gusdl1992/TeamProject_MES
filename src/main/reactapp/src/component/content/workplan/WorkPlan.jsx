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
        <div className="contentWrap">
            <div id="workPlanmInputBoxWrapT">
                <form className="workPlanForm" id="workPlanmInputBoxWrap">
                    
                    거래처  <input type="text"/> 
                    제품  <input type="text" name="pname"/> 
                    수량  <input type="text" name="wcount"/> 
                    납기 일  <input type="text" name="wendtime"/>

                    <div id="workPlanmInputBoxWrapBox">
                        <button type="button" onClick={writeWorkPlan}>등록</button>
                    </div>
                </form>
            </div>
        </div>
    )
}