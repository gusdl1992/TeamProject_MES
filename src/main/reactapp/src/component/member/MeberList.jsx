import { useEffect, useState } from "react"
import axios from "axios";
import Member from "./Member"
export default function MeberList(props){


    let [memberList,setMemberList] = useState([]);

    // 모든 사원 데이터 가져오기
    useEffect( ()=>{
        axios.get('/member/all/get.do')
        .then((response)=>{
            // console.log(response); console.log('여기1')
            if(response.data != []){
                setMemberList(response.data);
                // console.log(response.data); console.log('여기2')
            }
        })
    } , [])

    console.log(memberList); console.log('여기3')

    const [member, setMember] = useState(false);

    const handleClick = () => {
      // 버튼 클릭 시 showComponent2의 값을 토글합니다.
      setMember(!member);
    };


    return(<>
        {/* 버튼 클릭 시 showComponent2 값에 따라 Component2를 렌더링합니다. */}
        {member && <Member/>}
        <div style={{display: member ? 'none' : 'block'}} className="AcontentBox">
            <span style={{marginLeft:600}}><button type="button" onClick={handleClick}>사원등록</button></span>
            <h3>사원 목록</h3> 
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
                            사원ID
                        </th>
                        <th>
                            사원 이름
                        </th>
                        <th>
                            파트
                        </th>
                        <th>
                            입사일
                        </th>
                        <th>
                            비고
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {
                        memberList.map((r,index)=>{
                            let cdate = r.cdate?.split('T')[0];
                            return(
                                <>
                                    <tr>
                                        <td>
                                            {r.mid}
                                        </td>
                                        <td>
                                            {r.mname}
                                        </td>
                                        <td>
                                            {r.part}
                                        </td>
                                        <td>
                                            {cdate}
                                        </td>
                                        <td>
                                            <button onClick={()=>{document.querySelector('.modal'+r.sno).style.display = 'block'}} type="button">상세보기</button>
                                        </td>
                                    </tr>
                                    
                                </>
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    </>)
}