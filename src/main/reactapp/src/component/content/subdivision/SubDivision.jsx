import SubDivisionPreviousWork from "./SubDivisionPreviousWork";
import SubDivisionPrintBox from "./SubDivisionPrintBox";
import SubDivisionTotalBox from "./SubDivisionTotalBox";
import SubDivisionWriteBox from "./SubDivisionWriteBox";

export default function SubDivision(props){

    return(
        <div className="contentWrap">
            <SubDivisionTotalBox/>
            <div id="workplanCssBox">
                <SubDivisionPreviousWork/>
            </div>
            <div id="workplanCssBox">
                <SubDivisionWriteBox/>
            </div>
            <SubDivisionPrintBox/>
        </div>
    )
}