import axios from "axios";
import { useState } from "react";

export default function RmWrite(props){

    const [rmname,setrmname] = useState("");

    const doPost = ()=>{
        const formData = new FormData();
        formData.append("rmname",rmname);
        axios.post("/RM/post.do",formData).then( r=> {
            if(r.data){
                alert("등록성공")
                props.setrerender(!props.rerender)
            }
        }).catch(e=>{console.log(e)})
    }
    return(<>
        <input value={rmname} onChange={(e)=>{setrmname(e.target.value)}}/>
        <button type="button" onClick={doPost}>제품 등록</button>
    </>)
}