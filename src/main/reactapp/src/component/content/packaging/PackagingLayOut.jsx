import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import { Link } from "react-router-dom";

export default function PackagingLayOut(props){

    // 계량
    const [ subdivision , setSubdivision ] = useState([]);
    console.log(subdivision);
    useEffect( ( ) => {
        axios.get("/packaging/subdivision.do")
        .then( (r) => {
            console.log(r);
            setSubdivision(r.data);
        })
    },[])

    return(<>
        <div id="workPlanListBox">
            {subdivision.map((r) => {
                return(
                    <div>
                        <Link to={`/packaging?sdno=${r.sdno}`}>
                            <span>작업계획 {r.sdno}</span>
                            <span>등록일자 : {r.cdate}</span>
                        </Link>
                    </div>
                )
            })}
        </div>    
    </>)
}