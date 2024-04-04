import axios from "axios"
import { useEffect, useState } from "react"

export default function ReportForSurvey(props){
    const [report1 , setReport1 ]= useState({})
    console.log(props.wno)

    useEffect( () =>{
        axios.post("/survey/workplanoneinfo.do?wno="+props.wno).then( r=> {console.log(r)}).catch(e=>{console.log(e)})
    },[])
    return(<>원료계량에대한세부리포트샘플입니다.뒤의 번호는 wno를 의미합니다.{props.wno}</>)
}