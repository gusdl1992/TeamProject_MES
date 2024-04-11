import axios from "axios"
import { useEffect, useState } from "react"
import { Link } from "react-router-dom";
import "./manufacturingCSS.css"

export default function MaterialinputList(){
    
    // 투입테이블
    const [ materialinput , setMaterialinput] = useState([]);

    useEffect(()=>{
        axios.get("/manufacturing/MaterialInput.do")
        .then((response)=>{
            // console.log(response);
            const result = response.data.map((materialinput)=>{return materialinput;})
            setMaterialinput(result);
        })
    },[])
    
    return(<>
        <div id="materialinputCssBox">
        {materialinput.map((mip)=>{
            return(
                <>
                {console.log(mip)}
                {mip.workPlanDto.wstate<6?
                    <div className="materialinputCss">
                        <Link to={`/manufacturing/info?mipno=${mip.mipno}`}>
                            <h4>투입내역{mip.mipno}</h4>
                            <div>PlanNumber : {mip.workPlanDto.wno}</div>
                            <div>등록일자 : {mip.cdate.split('T')[0].split('-')[0]}년 {mip.cdate.split('T')[0].split('-')[1]}월 {mip.cdate.split('T')[0].split('-')[2]}일</div>
                        </Link>
                    </div>
                :""}
                </>)
        })}
        </div>
    </>)
}