import React, { useState } from 'react';
import styles from './login.css';
import axios from 'axios';

export default function Header(props) {
    const [info, setInfo] = useState({});

    const handleMidChange = (e) => {
        setInfo(prevInfo => ({
            ...prevInfo,
            mid: e.target.value
        }));
    }

    const handleMpwChange = (e) => {
        setInfo(prevInfo => ({
            ...prevInfo,
            mpw: e.target.value
        }));
    }

    const doLogin = ()=>{
        const formData = new FormData();
        formData.append("mpw", info.mpw);
        formData.append("mid",info.mid)
        console.log(formData)
        axios.post("/member/login/post.do",formData).then( r=>{if(r.data){
            alert("로그인성공");
            window.location.href = "/c" 
        }}).catch(e=>{console.log(e)})
    }

    return (
        <div id='loginWrap'>
            <h2>로그인</h2>
            <form>
                ID : <input type='text' onChange={handleMidChange} />
                PassWord : <input type='password' onChange={handleMpwChange} />
            </form>
            <button type='button' onClick={doLogin}>로그인</button>
        </div>
    );
}