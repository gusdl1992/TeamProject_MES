import { useLocation, useSearchParams } from "react-router-dom";

import LayoutTest from "../layouttest/Layouttest";
import ReportForSurvey from "./ReportForSurvey";
import ReportForMInput from "./ReportForMInput";
import ReportForBulk from "./ReportForBulk";



export default function ReportAll(props){
    
    const[query] = useSearchParams();
    console.log(query)
    const wno = query.get("wno")
    const wstate = query.get("wstate")
    console.log(wno,wstate)

    const checkreport = (wno, wstate) => {
        
        if (wstate == 6 || wstate == 5){
            return(<><ReportForSurvey wno={wno}/><ReportForMInput wno={wno}/><ReportForBulk wno={wno}/></>) //추가 값 대입
        }
        else if (wstate==4|| wstate ==3){
            return(<><ReportForSurvey wno={wno}/><ReportForMInput wno={wno}/></>)
        }//이런식으로 해야할듯?
        else if (wstate==2|| wstate ==1){
            return(<><ReportForSurvey wno={wno}/></>)
        }
    };

    const result = checkreport(wno,wstate)
    console.log(result)
    return(<><LayoutTest list={result}/></>)


}