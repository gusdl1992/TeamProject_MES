import styles from "./main.css";
import Header from "./header/Header";
import Login from "./login/Login";
import Main from "./content/Main";
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import React, { useEffect, useState } from "react";
import ProductWrite from "./content/product/ProductWrite";
import ProductList from "./content/product/Productlist";
import RmWrite from "./content/rawmaterial/RmWrite";
import RmCount from "./content/rawmaterial/RmCount";
import RmLogList from "./content/rawmaterial/RMLogList";
import MaterialInput from "./content/materialinput/MaterialInput";
import ProductRecipieList from "./content/recipie/ProductRecipieList";

import Survey from "./content/survey/Survey" // 승호
import WorkPlanList from "./content/survey/WorkPlanList"; // 승호
import SurveyList from "./content/materialinput/SurveyList";
import ProductLayOut from "./content/product/ProductLayOut";
import RmLayOut from "./content/rawmaterial/RmLayOut";
import LayoutTest from "./content/layouttest/Layouttest";
import RmWrites from "./content/rawmaterial/RmWirtes";
import axios from "axios";
import RmLLayOut from "./content/rawmaterial/RmLLayOut";
import AllWorkPlanList from "./content/workplan/AllWorkPlanList";
import ReportAll from "./content/workplan/ReportAll";
import WorkPlan from "./content/workplan/WorkPlan";



import ProductRLayOut from "./content/recipie/ProductRLayout";
import SubDivision from "./content/subdivision/SubDivision";
import Manufacturing from "./content/manufacturing/Manufacturing";//승호
import Packaging from "./content/packaging/Packaging";
import ExpirationLayOut from "./content/expiration/ExpirationLayOut";
import MeberList from "./member/MeberList"; // 시현 멤버 리스트 출력






export const LoginInfoContext = React.createContext("");

export default function Index(props){
    const[logininfo,setLogin] = useState(null);
    useEffect(()=>{
        axios.get("/member/login/info/get.do")
            .then( (r)=>{console.log(r)
                    setLogin(r.data)
            } )
            .catch( (e) => {console.log(e)})

    } ,[] )


    return(
        <LoginInfoContext.Provider value={{logininfo,setLogin}}>
        <BrowserRouter>
                <div id="wrap">
                {logininfo && <Header/>}
                {logininfo && <span onClick={() => window.location.href='/c'}>Profile</span>}
                    <Routes>
                    <Route path="/" element={<Login/>}/>
                    <Route path="/c" element={<Main/>}/>
                    {/* <Route path="/product/write" element={<ProductWrite />}/> */}
                    <Route path="/product" element={<ProductLayOut />}/>
                    <Route path="/RM" element={<RmLayOut/>}/>
                    <Route path="/RM/log" element={<RmLLayOut/>}/>
                    <Route path="/material/input" element={ <MaterialInput/> }/>
                    <Route path="/subdivision" element={ <SubDivision/> }/>
                    <Route path="/survey/survey" element={<Survey/> } />
                    <Route path="/survey/plan" element={<WorkPlanList/> } />
                    <Route path="/product/recipie/get" element={<ProductRLayOut/>}/>
                    <Route path="/wp/list" element={<LayoutTest list={<AllWorkPlanList/>} />}/>
                    <Route path="/wp/write" element={<WorkPlan/>}/>
                    <Route path="/wp/report" element={<ReportAll/>}/>
                    <Route path="/manufacturing/info" element={<Manufacturing/>}/>
                    <Route path="/packaging" element={<Packaging />} />
                    <Route path="/expirationlayout" element={<ExpirationLayOut/>}/>
                    <Route path="/member/List" element={<MeberList/>}/>
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