import axios from "axios";
import { useEffect, useState } from "react";

export default function MaterialInput(props){
    let snoInfo = {sno:1};

    let [test,setTest] = useState([]);
    let [test1,setTest1] = useState([]);

    useEffect(()=>{
        axios.get('/material/input/info/get.do',snoInfo)
        .then((response)=>{
            console.log(response);
            if(response.data != []){
                setTest(response.data);
                   
            }
        })
    },[])

    useEffect(() =>{
        axios.get('/material/input/info/get.do',snoInfo)
    .then((response)=>{
        console.log(response);
        if(response.data != []){
            setTest1(response.data);
        }
    })
    } , [])
    console.log(test)

    return(
        <div style={{maxWidth:'66%',minWidth:'1100px',margin:'0 auto',border:'1px solid red'}}>
            <div className="searchBox">
                <h3>검색</h3>
            </div>
            <div className="statistics">
                <h3>통계</h3>
                <div className="statisticsWrap">
                    <div className="statisticsBox">
                        
                    </div>
                    <div className="statisticsBox">
                        
                    </div>
                    <div className="statisticsBox">
                        
                    </div>
                    <div className="statisticsBox">
                        
                    </div>
                </div>
            </div>
            <div className="AinputBox">
                <h3>작성</h3>
            </div>
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
                            test.map((r)=>{
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
                                            {r.mipstate}
                                        </td>
                                    </tr>
                                )
                            })
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}