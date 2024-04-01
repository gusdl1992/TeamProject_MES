import axios from "axios";
import { useEffect, useState } from "react";

export default function RmCount(props){
    const [infos, setInfos] = useState([]);
    useEffect(
        ()=>{
            axios.get("/RM/log/count/get.do").then( (r) => { 
                setInfos(r.data);
            }).catch((error) => {
                console.error("Error:", error);
            });

        },[]
    )

    console.log(infos)

    // return(<table>
    //         <thead>
    //             <tr>
    //                 <th>
    //                 제품번호
    //                 </th>
    //                 <th>
    //                 제품명
    //                 </th>
    //             </tr>
    //         </thead>
    //         <tbody>
    //             {/* {infos.map( (e)=>(
    //                 <tr key={e.pno}>
    //                     <td>{e.pno}</td><td>{e.pname}</td>
    //                 </tr>
    //             ))} */}
    //             {infos.map((product) => (
    //                 <tr key={product.pno}>
    //                     <td>{product.pno}</td>
    //                     <td>{product.pname}</td>
    //                 </tr>
    //             ))}
    //         </tbody>
    // </table>)
}