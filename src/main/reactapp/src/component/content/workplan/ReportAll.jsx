import { useLocation, useSearchParams } from "react-router-dom";

import LayoutTest from "../layouttest/Layouttest";
import ReportForSurvey from "./ReportForSurvey";
import ReportForMInput from "./ReportForMInput";



export default function ReportAll(props){
    
    const[query] = useSearchParams();
    console.log(query)
    const wno = query.get("wno")
    const wstate = query.get("wstate")
    console.log(wno,wstate)

    const checkreport = (wno, wstate) => {
        
        if (wstate == 6 || wstate == 5){
            return(<><ReportForSurvey wno={wno}/><ReportForMInput wno={wno}/></>) //추가 값 대입
        }
        else if (wstate==4|| wstate ==3){
            return(<><ReportForSurvey wno={wno}/><ReportForMInput wno={wno}/></>)
        }//이런식으로 해야할듯?
        else if (wstate==2|| wstate ==1){
            return(<><ReportForSurvey wno={wno}/></>)
            
        }
        // componentsToRender 배열을 반환합니다.
    };

    const result = checkreport(wno,wstate)
    console.log(result)
    return(<><LayoutTest list={result}/></>)


}