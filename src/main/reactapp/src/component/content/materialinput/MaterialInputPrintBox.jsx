import axios from "axios";
import { useEffect, useRef, useState } from "react";

export default function MaterialInputPrintBox(props){
    let [material,setMaterial] = useState([]);
    const [confirmstate , setConfirmState] = useState('0');

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
                
            }
        })
        .catch(e=>{
            console.log(e);
        })
    }

    // 모달
    let onDetail = ()=>{
        let modal = document.querySelector('.modal');
        modal.style.display = 'block';
    }
    
    let outDetail = ()=>{
        let backModal = document.querySelector('.backModal');
        backModal.style.display = 'none';
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
                                            {r.udate}
                                        </td>
                                        <td>
                                            {
                                                r.mipstate == 0 ? '검사대기' : r.mipstate == 1 ? '검사불합격' : r.mipstate == 2 ? '검사합격' : '-'
                                            }
                                        </td>
                                        <td>
                                            <button onClick={onDetail} type="button">상세보기</button>
                                        </td>
                                    </tr>
                                    <div className="modal">
                                        <p>생산계획 번호 : {r.workPlanDto.wno}</p>
                                        <p>제품명 : {r.productDto.pname}</p>
                                        <p>제품수량 : {r.workPlanDto.wcount}</p>
                                        
                                        <p>날짜 : {r.cdate}</p>
                                        <p>담당자 : {r.inputmemberDto.mname}</p>
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
                                        <button type="button">x</button>
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