import { BrowserRouter, Route, Routes } from "react-router-dom";
import React, { useState } from "react";
import WorkPlanList from "./WorkPlanList";
import Survey from "./Survey";


export const LoginInfoContext = React.createContext('');
export default function Index(props){

    // 0. 로그인정보 state변수
    const [loginInfo , setLoginInfo] = useState('');
    
    
    return(<>
        <LoginInfoContext.Provider value={{ loginInfo , setLoginInfo }}>
            <WorkPlanList/>
            <BrowserRouter>
                <div id="wrap">
                <Routes>
                    {/* 예시 : <Route path="/board/write" element={<Write/>}></Route> */}
                    <Route path="/survey/shcaduel" element={<Survey value={dd}/>}></Route>
                </Routes>
                
                </div>
            </BrowserRouter>
        </LoginInfoContext.Provider>
    </>);
}
