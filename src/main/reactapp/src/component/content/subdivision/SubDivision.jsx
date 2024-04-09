import SubDivisionPreviousWork from "./SubDivisionPreviousWork";
import SubDivisionPrintBox from "./SubDivisionPrintBox";
import SubDivisionTotalBox from "./SubDivisionTotalBox";
import SubDivisionWriteBox from "./SubDivisionWriteBox";

export default function SubDivision(props){

    return(
        <div style={{maxWidth:'66%',minWidth:'1100px',margin:'0 auto',border:'1px solid red'}}>
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