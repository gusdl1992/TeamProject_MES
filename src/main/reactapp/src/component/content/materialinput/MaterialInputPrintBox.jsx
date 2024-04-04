import axios from "axios";
import { useEffect, useRef, useState } from "react";

export default function MaterialInputPrintBox(props){
    let [material,setMaterial] = useState([]);
    const [confirmstate , setConfirmState] = useState('0');
    let [confirmrender , setConfirmReder] = useState(false);

    // 출력
    useEffect(() =>{
        axios.get('/material/input/allinfo/get.do')
        .then((response)=>{
            console.log(response);
        if(response.data != []){
            setMaterial(response.data);
        }
    })
    } , [])

    // 검사
    const confirmStateChange = (e)=>{
        setConfirmState(e.target.value);
        e.preventDefault();
    }

    let materialConfirmForm = useRef();

    let onMaterialConfirm = ()=>{
        axios.put('/materialinput/confirm.do',materialConfirmForm.current)
        .then(r=>{
            console.log(r);
            if(r.data){
                window.location.href='/material/input';
            }
        })
        .catch(e=>{
            console.log(e);
        })
    }
    
    return(
        <div className="AcontentBox">
            <h3>목록</h3>
            <table>
            <colgroup>
                <col width="10%"/>
                <col width="20%"/>
                <col width="30%"/>
                <col width="15%"/>
                <col width="25%"/>
            </colgroup>
                <thead>
                    <tr>
                        <th>
                            생산 계획 번호
                        </th>
                        <th>
                            담당자
                        </th>
                        <th>
                            날짜
                        </th>
                        <th>
                            상태
                        </th>
                        <th>
                            비고
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {
                        material.map((r)=>{
                            let cdate = r.cdate.split('T')[0];
                            let udate = r.udate.split('T')[0];

                            return(
                                <>
                                    <tr>
                                        <td>
                                            {r.workPlanDto.wno}
                                        </td>
                                        <td>
                                            {r.inputmemberDto.mname}
                                        </td>
                                        <td>
                                            {udate}
                                        </td>
                                        <td>
                                            {
                                                r.mipstate == 0 ? '검사대기' : r.mipstate == 1 ? '검사불합격' : r.mipstate == 2 ? '검사합격' : '-'
                                            }
                                        </td>
                                        <td>
                                            <button onClick={()=>{document.querySelector('.modal'+r.mipno).style.display = 'block'}} type="button">상세보기</button>
                                        </td>
                                    </tr>
                                    <div style={{display:'none'}} className={"modal"+r.mipno}>
                                        <p>생산계획 번호 : {r.workPlanDto.wno}</p>
                                        <p>제품명 : {r.productDto.pname}</p>
                                        <p>제품수량 : {r.workPlanDto.wcount}</p>
                                        <p>{r.surveyBDto.rmname}투입량 : {r.surveyBDto.sbcount}</p>
                                        <p>날짜 : {cdate}</p>
                                        <p>담당자 : {r.inputmemberDto.mname}</p>
                                        <form ref={materialConfirmForm}>
                                            <input type="text" value="1" style={{display:'none'}} name="mipno"/>
                                            검사자 : <input disabled={r.checkmemberDto != null ? true : false }  value={r.checkmemberDto != null ? r.checkmemberDto.mname : ''} className="checkMemberInput" type="text" name="mname"/>
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
                                        <button onClick={()=>{document.querySelector('.modal'+r.mipno).style.display = 'none'}} type="button">x</button>
                                    </div>
                                </>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}