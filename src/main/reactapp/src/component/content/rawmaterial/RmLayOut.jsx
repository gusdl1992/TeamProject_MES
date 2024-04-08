import { useState } from "react";
import LayoutTest from "../layouttest/Layouttest";
import RmCount from "./RmCount";
import RmWrites from "./RmWirtes";
import RmWrite from "./RmWrite";

export default function RmLayOut(props){
    const [rerender , setrerender] = useState(false);
    return(
        <LayoutTest insert={<RmWrites rerender ={rerender} setrerender={setrerender} />} list={<RmCount rerender={rerender}/>} />
    )
}