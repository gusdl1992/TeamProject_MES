import styles from "./main.css";
import Header from "./header/Header";
import Login from "./login/Login";
import Mensuration from "./content/Mensuration";
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import React, { useState } from "react";
import ProductWrite from "./content/product/ProductWrite";
import ProductList from "./content/product/Productlist";
import RmWrite from "./content/rawmaterial/RmWrite";
import RmCount from "./content/rawmaterial/RmCount";
import RmLogList from "./content/rawmaterial/RMLogList";
import MaterialInput from "./materialinput/MaterialInput";
import ProductRecipieList from "./content/recipie/ProductRecipieList";

import Survey from "./content/survey/Survey" // 승호
import WorkPlanList from "./content/survey/WorkPlanList"; // 승호
import Test from "./member/Test"; // 시현 사원등록 테스트
import ProductLayOut from "./content/product/ProductLayOut";
import RmLayOut from "./content/rawmaterial/RmLayOut";
import LayoutTest from "./content/layouttest/Layouttest";
import RmWrites from "./content/rawmaterial/RmWirtes";

export const LoginInfoContext = React.createContext("");

export default function Index(props){
    const[logininfo,setLogin] = useState(null);
    return(
        <LoginInfoContext.Provider value={{logininfo,setLogin}}>
        <BrowserRouter>
                <div id="wrap">
                {logininfo !== "" && <Header/>}
                {logininfo && <span onClick={() => window.location.href='/c'}>Profile</span>}
                    <Routes>
                    <Route path="/" element={<Login/>}/>
                    <Route path="/c" element={<Mensuration/>}/>
                    {/* <Route path="/product/write" element={<ProductWrite />}/> */}
                    <Route path="/product" element={<LayoutTest insert={<ProductWrite/>} list={<ProductList/>} />}/>
                    <Route path="/RM" element={<LayoutTest insert={<RmWrites/>} list={<RmCount/>} />}/>
                    <Route path="/RM/log" element={<RmLogList/>}/>
                    <Route path="/material/input" element={ <MaterialInput /> } />
                    <Route path="/survey/survey" element={<Survey/> } />
                    <Route path="/survey/plan" element={<WorkPlanList/> } />
                    <Route path="/member/test" element={<Test/> } />
                    <Route path="/product/recipie/get" element={<ProductLayOut/>}/>
                    </Routes>
                </div>
        </BrowserRouter>
        </LoginInfoContext.Provider>
    )
}


        // <div id="wrap">
        //     <Header/>
        //     <Mensuration/>
        // </div>