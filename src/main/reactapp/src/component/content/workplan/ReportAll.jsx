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
        
        switch (wstate) {
            case 6 || 5:
                <Check1 wno={wno}/>;
            case 4 || 3:
                <Check2 wno={wno}/>;
            case 2 || 1:
                // <Check3 wno={wno}/>;아직 안 만든 컴포넌트
        }
    
        // componentsToRender 배열을 반환합니다.
    };

    const result = checkreport(wno,wstate)
    
    return(<><LayoutTest list={checkreport}/></>)


}