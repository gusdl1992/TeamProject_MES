import { useLocation, useSearchParams } from "react-router-dom";
import Check1 from "./Check1";
import LayoutTest from "../layouttest/Layouttest";
import Check2 from "./Check2";


export default function ReportAll(props){
    
    const[query] = useSearchParams();
    console.log(query)
    const wno = query.get("wno")
    const wstate = query.get("wstate")
    console.log(wno,wstate)

    const checkreport = (wno, wstate) => {
        
        if (wstate == 6 || wstate == 5){
            return(<><Check1 wno={wno}/><Check2 wno={wno}/></>)
        }
        else if (wstate==4|| wstate ==3){
            
        }//이런식으로 해야할듯?
    
        // componentsToRender 배열을 반환합니다.
    };

    const result = checkreport(wno,wstate)
    
    return(<><LayoutTest list={checkreport}/></>)


}