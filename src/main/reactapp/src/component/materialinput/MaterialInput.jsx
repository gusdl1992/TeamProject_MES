import axios from "axios";
import { useCallback, useEffect, useRef, useState } from "react";

export default function MaterialInput(props){
    let snoInfo = {sno:1};

    let [test,setTest] = useState([]);

    //
    const infoGet =  useCallback ( () => { 
        axios.get('/material/input/info/get.do',snoInfo)
        .then((response)=>{
            console.log(response);
            if(response.data != []){
                setTest(response.data);
            }
        })
    } , [ test] ) 


    useEffect(()=>{ infoGet()  },[  ])

    const [confirmstate , setConfirmState] = useState('0');

    const confirmStateChange = (e)=>{
        setConfirmState(e.target.value);
        e.preventDefault();
    }

    let materialConfirmForm = useRef();
    let confirmStatePrint = '';

    let onMaterialConfirm = ()=>{
        axios.put('/materialinput/confirm.do',materialConfirmForm.current)
        .then(r=>{
            console.log(r);
            if(r.data){
                infoGet()
            }
        })
        .catch(e=>{
            console.log(e);
        })
    }

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
                <form ref={materialConfirmForm}>
                    <input type="text" value="1" style={{display:'none'}} name="mipno"/>
                    검사자 : <input type="text" name="mname"/>
                    검사상태
                    <select name="mipstate" value={confirmstate} onChange={confirmStateChange}>
                        <option value="0">
                            검사대기
                        </option>
                        <option value="1">
                            검사불합격
                        </option>
                        <option value="2">
                            검사합격
                        </option>
                    </select>
                    <button type="button" onClick={onMaterialConfirm}>검사 완료</button>
                </form>
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
                                원료1
                            </th>
                            <th>
                                원료2
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
                                            {r.productDto.pname}
                                        </td>
                                        <td>
                                            {r.workPlanDto.wcount}
                                        </td>
                                        <td>
                                            
                                        </td>
                                        <td>
                                            
                                        </td>
                                        <td>
                                            {r.cdate}
                                        </td>
                                        <td>
                                            {r.inputmemberDto.mname}
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
        </div>
    )
}