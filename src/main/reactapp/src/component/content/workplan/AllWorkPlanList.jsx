import axios from "axios";
import { useEffect } from "react";

export default function AllWorkPlanList(props){
    useEffect( ()=>{
        axios.get("/wp/list/get.do").then(r=>{console.log(r)})
    },[])
    
    


    return(<div>안녕</div>);
}