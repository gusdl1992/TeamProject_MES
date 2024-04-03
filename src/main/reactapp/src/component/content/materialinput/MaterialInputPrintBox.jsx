import axios from "axios";
import { useEffect, useState } from "react";

export default function MaterialInputPrintBox(props){
    let snoInfo = {sno:1};

    let [test1,setTest1] = useState([]);

    useEffect(() =>{
        axios.get('/material/input/info/get.do',snoInfo)
    .then((response)=>{
        console.log(response);
        if(response.data != []){
            setTest1(response.data);
        }
    })
    } , [])
    
    return(
        <div className="AcontentBox">
            <h3>목록</h3>
            <table>
            <colgroup>
                <col width="5%"/>
                <col width="10%"/>
                <col width="5%"/>
                <col width="20%"/>
                <col width="20%"/>
                <col width="25%"/>
                <col width="8%"/>
                <col width="7%"/>
            </colgroup>
                <thead>
                    <tr>
                        <th>
                            번호
                        </th>
                        <th>
                            제품명
                        </th>
                        <th>
                            제품수량
                        </th>
                        <th>
                            원료
                        </th>          
                        <th>
                            원료투입량
                        </th>                     
                        <th>
                            날짜
                        </th>
                        <th>
                            담당자
                        </th>
                        <th>
                            상태
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {
                        test1.map((r)=>{
                            return(
                                <tr>
                                    <td>
                                        {r.mipno}
                                    </td>
                                    <td>
                                        {r.pname}
                                    </td>
                                    <td>
                                        {r.wcount}
                                    </td>
                                    <td>
                                        {r.rmname}
                                    </td>
                                    <td>
                                        {r.sbcount}
                                    </td>
                                    <td>
                                        {r.cdate}
                                    </td>
                                    <td>
                                        {r.mname}
                                    </td>
                                    <td>
                                        {
                                            r.mipstate == 0 ? '검사대기' : r.mipstate == 1 ? '검사불합격' : r.mipstate == 2 ? '검사합격' : '-'
                                        }
                                    </td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}