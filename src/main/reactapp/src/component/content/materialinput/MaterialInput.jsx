import SurveyList from "./SurveyList";
import MaterialInputPrintBox from "./MaterialInputPrintBox";
import MaterialInput2 from "./MaterialInput2";
import MaterialInputTotalBox from "./MaterialInputTotalBox";
import SurveyTotalBox from "../survey/SurveyTotalBox";

export default function MaterialInput(props){

    return(
        <div style={{maxWidth:'66%',minWidth:'1100px',margin:'0 auto',border:'1px solid red'}}>
            
            <MaterialInputTotalBox/>
            <div id="workplanCssBox">
                <SurveyList/>
            </div>
            <div id="workplanCssBox">
                <MaterialInput2/>
            </div>
            <MaterialInputPrintBox/>
        </div>
    )
}