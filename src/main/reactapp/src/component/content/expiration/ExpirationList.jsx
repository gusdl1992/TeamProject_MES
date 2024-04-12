import axios from "axios";
import { useEffect, useState } from "react";

export default function ExpirationList(props){
    const [rerender , setrerender] = useState(false);
    const[elist,setElist] = useState([]);
    useEffect(()=>{
        axios.get("/expiration/list/get.do").then( r=>{setElist(r.data)})
    } ,[rerender])

    console.log(elist)
    
    const postHandler = ()=>{
        axios.post("/expiration/log/post.do").then ( r => {if(r){
            alert("폐기완료")
            setrerender(!rerender)
        }}
        ).catch(e=>console.log(e))
    }


    return(<>
        <h3>유통기한이 지나 폐기해야되는 제품 목록</h3>
        <table>
            <thead>
                <tr><th>제품명</th><th>분량</th></tr>
            </thead>
            <tbody>
                {elist.map(e=>{
                     return(<tr><td>{e.pname}</td><td>{e.plcount*(-1)}</td></tr>)
                })}
            </tbody>
        </table>
        <button type="button" onClick={postHandler}>폐기 </button>
    </>)
}