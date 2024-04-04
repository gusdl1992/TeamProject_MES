import { useState } from "react";
import LayoutTest from "../layouttest/Layouttest";
import Productinput from "../recipie/ProductInput";
import ProductRecipieList from "../recipie/ProductRecipieList";
import ProductWrite from "./ProductWrite";
import ProductList from "./Productlist";
import { useSearchParams } from "react-router-dom";

export default function ProductLayOut(props){

    const [reroad, setReroad] = useState(true);
    //쿼리스트링 받아오기
    let [query, setQuery] = useSearchParams();

    
    console.log(query.get("pno"))


    return(
        <LayoutTest insert={<Productinput pno={query.get("pno")} reroad={reroad} setReroad={setReroad}/>} list={<ProductRecipieList pno={query.get("pno")} reroad={reroad}/>} />
    )
}