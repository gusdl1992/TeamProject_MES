import SubDivisionPrintBox from "./SubDivisionPrintBox";

export default function SubDivision(props){

    return(
        <div style={{maxWidth:'66%',minWidth:'1100px',margin:'0 auto',border:'1px solid red'}}>
            
            <div className="statistics">
                <h3>통계</h3>
                <div className="statisticsWrap">
                    <div className="statisticsBox">
                        
                    </div>
                    <div className="statisticsBox">
                        
                    </div>
                    <div className="statisticsBox">
                        
                    </div>
                    <div className="statisticsBox">
                        
                    </div>
                </div>
            </div>
            <div id="workplanCssBox">
                <SurveyList/>
            </div>
            <div id="workplanCssBox">
                <MaterialInput2/>
            </div>
            <SubDivisionPrintBox/>
        </div>
    )
}