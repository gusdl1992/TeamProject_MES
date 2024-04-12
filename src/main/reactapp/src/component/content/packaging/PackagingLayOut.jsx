import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import { Link } from "react-router-dom";

export default function PackagingLayOut(props){

    // 계량
    const [ subdivision , setSubdivision ] = useState([]);    
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
                if(r.manufacturingDto.materialInputDto.workPlanDto.wstate == 8 && r.sdstate == 2){
                    return(
                        <div>
                            <Link to={`/packaging?sdno=${r.sdno}`}>
                                <span>소분내역 : {r.sdno}</span>
                                <span>등록일자 : {r.cdate}</span>
                            </Link>
                        </div>
                    )
                }
            })}
        </div>    
    </>)
}