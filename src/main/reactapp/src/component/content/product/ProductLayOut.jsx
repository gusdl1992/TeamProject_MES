import LayoutTest from "../layouttest/Layouttest";
import ProductWrite from "./ProductWrite";
import ProductList from "./Productlist";

export default function ProductLayOut(props){
    return(
        <LayoutTest insert={<ProductWrite/>} list={<ProductList/>} />
    )
}