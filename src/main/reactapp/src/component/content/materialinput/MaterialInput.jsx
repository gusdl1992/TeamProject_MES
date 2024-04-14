import SurveyList from "./SurveyList";
import MaterialInputPrintBox from "./MaterialInputPrintBox";
import MaterialInput2 from "./MaterialInput2";
import MaterialInputTotalBox from "./MaterialInputTotalBox";
import SurveyTotalBox from "../survey/SurveyTotalBox";

export default function MaterialInput(props){

    return(
        <div className="contentWrap">
            
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