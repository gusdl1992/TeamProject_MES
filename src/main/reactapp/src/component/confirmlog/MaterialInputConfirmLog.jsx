import axios from "axios"
import { useState } from "react";

export default function MaterialInputLog(props){
    const [materialconfirmlog , setMaterialconfirmlog] = useState([]);
    axios.get('/materialinput/confirm/log.do').then((response)=>{
        console.log(response); 
        response.data.map((result=>{
            console.log(result);
            if(result.checkmembername != null){
                <tr>
                    <td>
                        {result.udate}
                    </td>
                    <td>
                        {result.mipno}
                    </td>
                </tr>
            }
        }))
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
                    {
                        
                    }
                </tbody>
            </table>
        </div>
    )
}