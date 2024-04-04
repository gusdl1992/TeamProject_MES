import LayoutTest from "../layouttest/Layouttest";
import RmLogList from "./RMLogList";
import RmCount from "./RmCount";
import RmLogWrite from "./RmLogWrite";
import RmWrites from "./RmWirtes";
import RmWrite from "./RmWrite";

export default function RmLLayOut(props){
    return(
        <LayoutTest list={<RmLogList/>} />
    )
}