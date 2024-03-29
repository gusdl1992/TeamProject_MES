import axios from "axios"
import { useState } from "react";

export default function MaterialInputLog(props){
    const [materialconfirmlog , setMaterialconfirmlog] = useState([]);
    axios.get('http:localhost:80/materialinput/confirm/log.do').then((response)=>{
        console.log(response);
    }).catch(error=>{
        console.log(error);
    })
    
    return(
        <div>
            <table>
                <thead>
                    <tr>
                        <th>

                        </th>
                    </tr>
                </thead>
                <tbody className="materialInfo">
                    <tr>
                        <td>
                            
                        </td>
                    </tr>
                    {}
                </tbody>
            </table>
        </div>
    )
}