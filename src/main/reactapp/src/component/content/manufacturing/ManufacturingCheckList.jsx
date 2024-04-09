import axios from "axios";
import { useEffect, useRef, useState } from "react";

export default function ManufacturingCheckList(props){

    const [confirmstate , setConfirmState] = useState('0');
    let [confirmmembername , setConfirmMemberName] = useState('');

    // 투입 리스트
    const [ manufacturing , setManufacturing] = useState([]);
    
    // 레시피 리스트
    const [ recipeDtoList , setRecipeDtoList] = useState( [
        { pname : '' }// 최초 렌더링 할때 오류 발생 : 초기임의의 값을 넣어줌
    ] );


    useEffect(() => {
        // 투입리스트 가져오기
        const fetchData = async () => {
            try {
                // 벌크제조 리스트 가져오기
                const response = await axios.get("/manufacturing/manufacturingInfo.do");
                setManufacturing(response.data);

                // 투입했던 레시피 찾아오기
                const formData = new FormData();
                formData.append("wno",response.data.materialInputDto.workPlanDto.wno);
                const response2 = await axios.post("/survey/workplan/clilck.do",formData);
                const result = response2.data.recipeDto.map( (re) =>{return re;})// 레시피 dto state 추가하기
                setRecipeDtoList(result);
                
            } catch (error) {
                console.log(error);
            }
        };
    
        fetchData();
    }, []);

    // 검사 sclect BOX
    const confirmStateChange = (e)=>{
        setConfirmState(e.target.value);
        e.preventDefault();
    }
    
    // let onMaterialConfirm = (index)=>{
    //     const confirmForm = document.querySelector(`.confirmForm${index}`);
    //     console.log(confirmForm);
        

    //     const confirmFormData = new FormData(confirmForm);
    //     console.log("confirmFormData")
    //     console.log(confirmFormData)
    //     axios.put('/survey/check/complete/put.do',confirmFormData)
    //     .then(r=>{
    //         console.log("35");
    //         console.log(r);
    //         if(r.data){
    //             window.location.href='/survey/survey';
    //         }
    //     })
    //     .catch(e=>{
    //         console.log(e);
    //     })
    // }

    // let checkMemberNameInput = (e)=>{
    //     setConfirmMemberName(e.target.value);
    // }
    
    // return(<>
    //     <div className="AcontentBox">
    //         <h3>목록</h3>
    //         <table>
    //             <colgroup>
    //                 <col width="10%"/>
    //                 <col width="20%"/>
    //                 <col width="30%"/>
    //                 <col width="15%"/>
    //                 <col width="25%"/>
    //             </colgroup>
    //             <thead>
    //                 <tr>
    //                     <th>
    //                         벌크 제조 번호
    //                     </th>
    //                     <th>
    //                         상품명
    //                     </th>
    //                     <th>
    //                         담당자
    //                     </th>
    //                     <th>
    //                         날짜
    //                     </th>
    //                     <th>
    //                         상태
    //                     </th>
    //                     <th>
    //                         비고
    //                     </th>
    //                 </tr>
    //             </thead>
    //             <tbody>
    //                 {
    //                     manufacturing.map((r,index)=>{
    //                         return(
    //                             <>
    //                                 <tr>
    //                                     <td>
    //                                         {r.mfno}
    //                                     </td>
    //                                     <td>
    //                                         {r.materialInputDto.productDto.pname}
    //                                     </td>
    //                                     <td>
    //                                         {r.inputmemberDto.mname}
    //                                     </td>
    //                                     <td>
    //                                         {r.udate.split('T')[0]}
    //                                     </td>
    //                                     <td>
    //                                         {
    //                                             r.mfstate == 0 ? '검사대기' : r.mfstate == 1 ? '검사불합격' : r.mfstate == 2 ? '검사합격' : '-'
    //                                         }
    //                                     </td>
    //                                     <td>
    //                                         <button onClick={()=>{document.querySelector('.modal'+r.mfno).style.display = 'block'}} type="button">상세보기</button>
    //                                     </td>
    //                                 </tr>
    //                                 <div style={{display:'none'}} className={"modal"+r.mfno}>
    //                                     <p>벌크제조계획 번호 : {r.mfno}</p>
    //                                     <p>벌크명 : {r.materialInputDto.productDto.pname}벌크</p>
    //                                     <p>제품수량 : {""}</p>
    //                                     <p>날짜 : {cdate}</p>
    //                                     <p>담당자 : {r.inputmname}</p>
    //                                     <form className={"confirmForm"+index} >
    //                                         <input type="text" style={{display:'none'}} value={r.sno} name="sno"/>
    //                                         검사자 : <input onChange={checkMemberNameInput} disabled={r.checkmname != null ? true : false }  value={r.checkmname != null ? r.checkmname : confirmmembername} className="checkMemberInput" type="text"/> 
    //                                         검사상태
    //                                         <select name="sstate" value={confirmstate} onChange={confirmStateChange}>
    //                                             <option value="0">
    //                                                 검사대기
    //                                             </option>
    //                                             <option value="1">
    //                                                 검사불합격
    //                                             </option>
    //                                             <option value="2">
    //                                                 검사합격
    //                                             </option>
    //                                         </select>
    //                                         <button disabled={r.checkmname != null ? true : false } type="button" onClick={()=>{onMaterialConfirm(index)}}>검사 완료</button>
    //                                     </form>
    //                                     <button onClick={()=>{document.querySelector('.modal'+r.sno).style.display = 'none'}} type="button">x</button>
    //                                 </div>
    //                             </>
    //                         )
    //                     })
    //                 }
    //             </tbody>
    //         </table>
    //     </div>
    // </>);
}