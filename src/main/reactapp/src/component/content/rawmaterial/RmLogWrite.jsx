import axios from "axios";
import { useEffect, useRef, useState } from "react";

export default function RmLogWrite(props){
    const boardWriteFormRef = useRef();
    const [rmlist,setrmlist] = useState([]);

    useEffect(()=>{
        axios.get("/RM/get.do").then( e=>{setrmlist(e.data)})
    },[])

    const handleSubmit = (e) => {
        const formdata = new FormData(boardWriteFormRef.current);
        axios.post("/RM/log/post.do", formdata) // axios contentType : mulitpart
            .then((response) => {
                if(response.data){
                    alert("글 작성 성공");
                    // 성공 시 처리
                    window.location.href="/RM"
                }
                else{
                    alert("작성실패")
                }
            })
            .catch((error) => {
                console.error("Error:", error);
                // 실패 시 처리
            });
    }; 
    console.log(rmlist)

    return(
        <>
            <form ref={boardWriteFormRef}>
                <select name="rmname">
                {rmlist.map((e) => (
                    <option key={e.rmlno} value={e.rmname}>
                        {e.rmname}
                    </option>
                    ))}
                </select>
                <input type="text" name="rmlcount"></input>
                <button type="button" onClick={handleSubmit}>전송</button>
            </form>
        </>
    )

}