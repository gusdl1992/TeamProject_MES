import axios from "axios"
import { useEffect } from "react"
import { useState } from "react"

export default function ReportForMInput(props){
    
    const [report2 , setReport2] = useState({})
    useEffect( () =>{
        const callbackeffect = async () =>{
            await axios.get("/wp/fidsno/get.do?wno="+props.wno).then(r=>{setReport2(r.data)}).catch(e=>{console.log(e)})
        }
        callbackeffect();
    },[])

    return(<>원료투입에대한세부리포트샘플입니다. 뒤의 번호는 wno를 의미합니다.{props.wno}</>)
}