import axios from "axios";
import { useEffect, useState } from "react";

import { Link } from "react-router-dom";


export default function AllWorkPlanList(props){

    const [Planlist, SetPlanList] = useState([]);
    useEffect( ()=>{
        axios.get("/wp/list/get.do").then(r=>{console.log(r)
        SetPlanList(r.data)
        })
    },[])
    
    // const link = [<Check1 /> , <Check2 />]

    

    
    console.log(Planlist);
    return (
        <div>
            {Planlist.map((e) => (
                <div key={e.id}>
                    <Link to={"/wp/report?wno="+e.wno+"&wstate="+e.wstate} wno={e.wno} wstate={e.wstate}>이동 </Link>
                </div>
            ))}
        </div>
    );
}