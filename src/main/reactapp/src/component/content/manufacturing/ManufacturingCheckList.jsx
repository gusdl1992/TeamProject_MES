import axios from "axios";
import { useEffect, useRef, useState } from "react";

export default function ManufacturingCheckList(props){

    // select 박스 선택한거
    const [confirmstate , setConfirmState] = useState('0');

    let [confirmmembername , setConfirmMemberName] = useState('');

    // 투입 리스트
    const [ manufacturing , setManufacturing] = useState([]);
    

    // 검사 sclect BOX
    const confirmStateChange = (e)=>{
        setConfirmState(e.target.value);
        e.preventDefault();
    }


    useEffect(() => {
        // 투입리스트 가져오기
        const fetchData = async () => {
            try {
                // 벌크제조 리스트 가져오기
                const response = await axios.get("/manufacturing/manufacturingInfo.do");
                setManufacturing(response.data);

            } catch (error) {console.log(error);}
        };
        fetchData();
    }, [confirmstate]);


    let timecalculator = (response) => {
        const newFermentDate = new Date(response.cdate.split('T')[0]);
        const newFermentedDate = new Date(newFermentDate.setDate(newFermentDate.getDate() + response.materialInputDto.productDto.ferment));
        return newFermentedDate;
        
    }

    

    // 검사 상태 등록버튼
    function completeBtn(r){
        console.log(r);
        let state = document.querySelector(`.stateSelect${r.mfno}`).value;
        axios.post("/manufacturing/updateState.do",{ params: { mfno: r.mfno , state : state}})
        .then((response)=>{
            // 0보다 크면 성공
            if(response>0){ alert("안내) 검사 내용 등록 성공")}
            else{ alert("안내) 검사 내용 등록 실패")}
        })
        .catch((error)=>{console.log(error)})
    }
    


    
    return(<>
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
                            벌크 제조 번호
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
                        manufacturing.map((r,index)=>{
                            return(
                                <>
                                    <tr>
                                        <td>
                                            {r.mfno}
                                        </td>
                                        <td>
                                            {r.materialInputDto.productDto.pname}
                                        </td>
                                        <td>
                                            {r.inputmemberDto.mname}
                                        </td>
                                        <td>
                                            {r.udate.split('T')[0]}
                                        </td>
                                        <td>
                                            {
                                                r.mfstate == 0 ? '검사대기' : r.mfstate == 1 ? '검사불합격' : r.mfstate == 2 ? '검사합격' : '-'
                                            }
                                        </td>
                                        <td>
                                            <button onClick={()=>{document.querySelector('.modal'+r.mfno).style.display = 'block'}} type="button">상세보기</button>
                                        </td>
                                    </tr>
                                    <div style={{display:'none'}} className={"modal"+r.mfno}>
                                        <p>벌크제조계획 번호 : {r.mfno}</p>
                                        <p>벌크명 : {r.materialInputDto.productDto.pname}벌크</p>
                                        <p>벌크수량 : {r.mfcount}</p>
                                        <p>벌크제조 완료 날짜 : {r.cdate.split('T')[0]}</p>
                                        <p>벌크숙성 완료 날짜 : { timecalculator(r).getFullYear() }년{ timecalculator(r).getMonth()+1}월{ timecalculator(r).getDate()}일</p>
                                        <p>담당자 : {r.inputmemberDto.mname}</p>
                                        <form className={"confirmForm"+index} >
                                            검사자 : <input disabled={r.checkmemberDto.mname == null ? false : true }  value={r.checkmemberDto.mname == null ? "" : r.checkmemberDto.mname } className="checkMemberInput" type="text"/> 
                                            검사상태
                                            <select name="state" className={"stateSelect"+r.mfno} value={confirmstate} onChange={confirmStateChange}>
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
                                            <button disabled={r.checkmemberDto.mname == null ? false : false } type="button" onClick={()=>{completeBtn(r)}}>검사 완료</button>
                                        </form>
                                        <button onClick={()=>{document.querySelector('.modal'+r.mfno).style.display = 'none'}} type="button">x</button>
                                    </div>
                                </>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    </>);
}