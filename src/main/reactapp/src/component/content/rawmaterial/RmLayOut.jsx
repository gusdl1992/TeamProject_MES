import LayoutTest from "../layouttest/Layouttest";
import RmCount from "./RmCount";
import RmWrites from "./RmWirtes";
import RmWrite from "./RmWrite";

export default function RmLayOut(props){
    return(
        <LayoutTest insert={<RmWrites/>} list={<RmCount/>} />
    )
}