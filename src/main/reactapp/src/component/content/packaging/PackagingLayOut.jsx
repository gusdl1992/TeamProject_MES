import axios from "axios";
import { useContext, useEffect } from "react";
import { useState } from "react";
import { Link } from "react-router-dom";
import { RenderContext } from "./Packaging";

export default function PackagingLayOut(props){
    // 재 랜더링용
    // - provider 컴포넌트의 value 호출
    const { render ,setRender } = useContext(RenderContext);

    // 계량
    const [ subdivision , setSubdivision ] = useState([]);    
    useEffect( ( ) => {
        axios.get("/packaging/subdivision.do")
        .then( (r) => {
            console.log(r);
            setSubdivision(r.data);
        })
    },[render])

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