import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import { Link } from "react-router-dom";

export default function SubDivisionPreviousWork(props){

    // 계량
    const [ previousWork , setPreviousWork ] = useState([]);

    useEffect( ( ) => {
        axios.get("/subdivision/manufacturing/get.do")
        .then( (r) => {
            console.log(r);
            setPreviousWork(r.data);
        })
    },[])

    return(<>
        <div id="workPlanListBox">
            {previousWork.map((r) => {
                return(
                    <div>
                        <Link to={`/subdivision/input?mfno=${r.mfno}`}>
                            <span>작업계획 {r.mfno}</span>
                            <span>등록일자 : {r.cdate}</span>
                        </Link>
                    </div>
                )
            })}
        </div>    
    </>)
}