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

    
    const state = ["진행전","계량확인전","계량확인완료","투입확인전","투입완료","벌크제조전","벌크제조완료","소분작업전","소분작업완료","포장전","포장완료"] //추후 추가
    



    console.log(Planlist);
    return (
        <table>
            <thead>
                <tr><th>작업번호</th><th>생산제품</th><th>생산수량</th><th>상태</th><th>시작일</th></tr>
            </thead>
            <tbody>
            {Planlist.map((e) => (
                <tr key={e.id}>
                    <td>
                        {e.wno}
                    </td>
                    <td>
                        <Link to={"/wp/report?wno="+e.wno+"&wstate="+e.wstate} wno={e.wno} wstate={e.wstate}  onClick={(event) => {
                         if (!e.wstate) {
                                event.preventDefault();
                                alert("진행 전입니다");
                            }
                    }}>{e.pname} </Link>
                    </td>
                    <td>
                        {e.wcount}
                    </td>
                    <td>
                        {state[e.wstate]}
                    </td>
                    <td>
                        {e.cdate.split("T")[0]}
                    </td>

                </tr>
            ))}
            </tbody>
        </table>
    );
}