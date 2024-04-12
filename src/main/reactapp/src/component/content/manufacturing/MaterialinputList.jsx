import axios from "axios"
import { useContext, useEffect, useState } from "react"
import { Link } from "react-router-dom";
import "./manufacturingCSS.css"
import { RenderContext } from "./Manufacturing";

export default function MaterialinputList(){

    // 재 랜더링용
    // - provider 컴포넌트의 value 호출
    const { render ,setRender } = useContext(RenderContext);
    
    // 투입테이블
    const [ materialinput , setMaterialinput] = useState([]);

    useEffect(()=>{
        axios.get("/manufacturing/MaterialInput.do")
        .then((response)=>{
            setMaterialinput(response.data);
            console.log(materialinput);
        })
    },[render])
    
    return(<>
        <div id="materialinputCssBox">
            {materialinput.map((mip)=>{
                if(mip.workPlanDto.wstate == 4 && mip.mipstate == 2){
                    return(
                        <>
                            <div className="materialinputCss">
                                <Link to={`/manufacturing/info?mipno=${mip.mipno}`}>
                                    <h4>투입내역{mip.mipno}</h4>
                                    <div>PlanNumber : {mip.workPlanDto.wno}</div>
                                    <div>등록일자 : {mip.cdate.split('T')[0].split('-')[0]}년 {mip.cdate.split('T')[0].split('-')[1]}월 {mip.cdate.split('T')[0].split('-')[2]}일</div>
                                </Link>
                            </div>
                        </>)
                }
            })}
        </div>
    </>)
}