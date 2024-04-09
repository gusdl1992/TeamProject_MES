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
                <tr><th>제품명</th><th>분량</th><th>비고</th></tr>
            </thead>
        </table>
    </>)
}