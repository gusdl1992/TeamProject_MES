import axios from "axios";
import { useEffect, useRef, useState } from "react";

export default function SurveyCheckList(props){
    let [surveyb,setSurveyb] = useState([]);
    const [confirmstate , setConfirmState] = useState('0');
    let [confirmmembername , setConfirmMemberName] = useState('');

    // 출력
    useEffect(() =>{
        axios.get('/survey/check/survey/get.do')
        .then((response)=>{
            console.log(response);
        if(response.data != []){
            setSurveyb(response.data);
        }
    })
    } , [])

    // 검사
    const confirmStateChange = (e)=>{
        setConfirmState(e.target.value);
        console.log('23번줄')
        console.log(e.target.value)
        e.preventDefault();
    }
    
    let onMaterialConfirm = (index)=>{
        const confirmForm = document.querySelector(`.confirmForm${index}`);
        console.log(confirmForm);
        

        const confirmFormData = new FormData(confirmForm);
        console.log("confirmFormData")
        console.log(confirmFormData)
        axios.put('/survey/check/complete/put.do',confirmFormData)
        .then(r=>{
            console.log("35");
            console.log(r);
            if(r.data){
                window.location.href='/survey/survey';
            }
        })
        .catch(e=>{
            console.log(e);
        })
    }

    let checkMemberNameInput = (e)=>{
        setConfirmMemberName(e.target.value);
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
                            상품명
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
                        surveyb.map((r,index)=>{
                            let cdate = r.cdate?.split('T')[0];
                            let udate = r.udate?.split('T')[0];

                            return(
                                <>
                                    <tr>
                                        <td>
                                            {r.wno}
                                        </td>
                                        <td>
                                            {r.pname}
                                        </td>
                                        <td>
                                            {r.inputmname}
                                        </td>
                                        <td>
                                            {udate}
                                        </td>
                                        <td>
                                            {
                                                r.sstate == 0 ? '검사대기' : r.sstate == 1 ? '검사불합격' : r.sstate == 2 ? '검사합격' : '-'
                                            }
                                        </td>
                                        <td>
                                            <button onClick={()=>{document.querySelector('.modal'+r.sno).style.display = 'block'}} type="button">상세보기</button>
                                        </td>
                                    </tr>
                                    <div style={{display:'none'}} className={"modal"+r.sno}>
                                        <p>생산계획 번호 : {r.wno}</p>
                                        <p>제품명 : {r.pname}</p>
                                        <p>제품수량 : {r.wcount}</p>
                                        {/* <p>{r.data.surveybList.rmname}투입량 : {r.surveyBDto.sbcount}</p> */}
                                        <p>날짜 : {cdate}</p>
                                        <p>담당자 : {r.inputmname}</p>
                                        <form className={"confirmForm"+index} >
                                            <input type="text" style={{display:'none'}} value={r.sno} name="sno"/>
                                            검사자 : <input onChange={checkMemberNameInput} disabled={r.checkmname != null ? true : false }  value={r.checkmname != null ? r.checkmname : confirmmembername} className="checkMemberInput" type="text"/> 
                                            검사상태
                                            <select name="sstate" value={confirmstate} onChange={confirmStateChange}>
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
                                            <button disabled={r.checkmname != null ? true : false } type="button" onClick={()=>{onMaterialConfirm(index)}}>검사 완료</button>
                                        </form>
                                        <button onClick={()=>{document.querySelector('.modal'+r.sno).style.display = 'none'}} type="button">x</button>
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