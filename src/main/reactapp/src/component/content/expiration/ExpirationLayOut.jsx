import { useState } from "react";
import ExpirationList from "./ExpirationList";
import LayoutTest from "../layouttest/Layouttest";

export default function ExpirationLayOut(props){
    return(
        <LayoutTest list={<ExpirationList />} />
    )
}