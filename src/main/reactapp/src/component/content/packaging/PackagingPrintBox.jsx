import axios from "axios";
import { useEffect, useState } from "react";

export default function PackagingPrintBox(props){
    let [subdivision,setSubDivision] = useState([]);
    const [confirmstate , setConfirmState] = useState('0');
    let [confirmmembername , setConfirmMemberName] = useState('');

    // 출력
    useEffect(() =>{
        axios.get('/subdivision/allinfo/get.do')
        .then((r)=>{
            console.log(r);
        if(r.data != []){
            setSubDivision(r.data);
        }
    })
    } , [])

    // 검사
    const confirmStateChange = (e)=>{
        setConfirmState(e.target.value);
        e.preventDefault();
    }

    let onMaterialConfirm = (index)=>{
        const confirmForm = document.querySelector(`.confirmForm${index}`);

        const confirmFormData = new FormData(confirmForm);

        axios.put('/subdivision/confirm.do',confirmFormData)
        .then(r=>{
            console.log(r);
            if(r.data){
                window.location.href='/subdivision';
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
                            포장 계획 번호
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
                        subdivision.map((r,index)=>{
                            let cdate = r.cdate.split('T')[0];
                            let udate = r.udate.split('T')[0];

                            return(
                                <>
                                    <tr>
                                        <td>
                                            {r.manufacturingDto.materialInputDto.workPlanDto.wno}
                                        </td>
                                        <td>
                                            {r.inputmemberDto.mname}
                                        </td>
                                        <td>
                                            {udate}
                                        </td>
                                        <td>
                                            {
                                                r.sdstate == 0 ? '검사대기' : r.sdstate == 1 ? '검사불합격' : r.sdstate == 2 ? '검사합격' : '-'
                                            }
                                        </td>
                                        <td>
                                            <button onClick={()=>{document.querySelector('.modal'+r.sdno).style.display = 'block'}} type="button">상세보기</button>
                                        </td>
                                    </tr>
                                    <div style={{display:'none'}} className={"modal"+r.sdno}>
                                        <p>포장계획 번호 : {r.manufacturingDto.materialInputDto.workPlanDto.wno}</p>
                                        <p>제품명 : {r.manufacturingDto.materialInputDto.productDto.pname}</p>
                                        <p>수주량 : {r.manufacturingDto.materialInputDto.workPlanDto.wcount}</p>
                                        <p>소분제품량 : {r.successcount}</p>
                                        <p>불량품량 : {r.failcount}</p>
                                        <p>날짜 : {cdate}</p>
                                        <p>담당자 : {r.inputmemberDto.mname}</p>                                        
                                        <button onClick={()=>{document.querySelector('.modal'+r.sdno).style.display = 'none'}} type="button">x</button>
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