import axios from "axios";
import { useEffect, useState } from "react";

export default function ExpirationList(props){
    const [rerender , setrerender] = useState(false);
    const[elist,setElist] = useState([]);
    useEffect(()=>{
        axios.get("/expiration/list/get.do").then( r=>{setElist(r.data)})
    } ,[rerender])

    console.log(elist)

    return(<>
        <table>
            <thead>
                <tr><th>제품명</th><th>분량</th></tr>
            </thead>
            <tbody>
                {elist.map(e=>{
                    //  return(<tr><td>{e.rmname}</td><td>{e.reamount*report2.workPlanDto.wcount}</td></tr>)
                })}
            </tbody>
        </table>
    </>)
}