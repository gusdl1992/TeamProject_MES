import styles from "./main.css";
import Header from "./header/Header";
import Login from "./login/Login";
import Mensuration from "./content/Mensuration";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import React, { useState } from "react";
import ProductWrite from "./content/product/ProductWrite";
import ProductList from "./content/product/Productlist";
import RmWrite from "./content/rawmaterial/RmWrite";
import RmCount from "./content/rawmaterial/RmCount";
import RmLogList from "./content/rawmaterial/RMLogList";
import MaterialInput from "./materialinput/MaterialInput";

export const LoginInfoContext = React.createContext("");

export default function Index(props){
    const[logininfo,setLogin] = useState(null);
    return(
        <LoginInfoContext.Provider value={{logininfo,setLogin}}>
        <BrowserRouter>
                <div id="wrap">
                {logininfo !== "" && <Header/>}
                    <Routes>
                    <Route path="/" element={<Login />}/>
                    <Route path="/c" element={<Mensuration/>}/>
                    <Route path="/product/write" element={<ProductWrite />}/>
                    <Route path="/product" element={<ProductList/>}/>
                    <Route path="/RM/write" element={<RmWrite/>}/>
                    <Route path="/RM" element={<RmCount/>}/>
                    <Route path="/RM/log" element={<RmLogList/>}/>
                    <Route path="/material/input" element={ <MaterialInput /> } />
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