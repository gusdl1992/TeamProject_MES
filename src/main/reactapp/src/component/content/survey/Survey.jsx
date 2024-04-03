import axios from "axios";
import { useContext, useEffect, useState } from "react";
import { Await, useSearchParams } from "react-router-dom";
import WorkPlanList from "./WorkPlanList";
import { LoginInfoContext } from "../../Index";

export default function Survey(props){
    // 1. 컨텍스트 가져오기 (로그인 정보)
    const { logininfo, setLogin } = useContext(LoginInfoContext);
console.log(logininfo);

    
    // 쿼리스트링 값 가져오기 wno
    const [query , setQuery] = useSearchParams();
    // console.log(query.get("wno"));

    // 워크플랜 객체
    const [ workPlanInfo , setWorkPlanInfo] = useState({
        wcount:0,
        wendtime:"2024-03-30T10:00:12.123456"
    });
    // 레시피리스트
    const [ recipeDtoList , setRecipeDtoList] = useState( [
        { pname : '' }// 최초 렌더링 할때 오류 발생 : 초기임의의 값을 넣어줌
    ] );
    

    useEffect(  ()=>{
        const formData = new FormData();
        formData.append("wno",query.get("wno")); // 바꿔야함
        axios.post("/survey/workplan/clilck.do",formData)
        .then((response)=>{
            console.log(response);
            setWorkPlanInfo(response.data.workPlanDto);
            const result = response.data.recipeDto.map( (re) =>{return re;})// 레시피 dto state 추가하기
            setRecipeDtoList(result);
            
        })
        .catch(re =>{console.log(re)})
    },[query])
    
    // console.log(recipeDtoList);

    function onClickEvent(){
        console.log("버튼눌림");

        // ul 요소 가져오기
        const ulElement = document.getElementById('surveyUl');
        // ul 요소 안의 li 요소 개수 파악(li개수 = 입력해야하는 레시피 수)
        const listItemCount = ulElement.getElementsByTagName('li').length;
// console.log(listItemCount);
        
        // 전송할 객체만들기
        let recipeInputList = [];
        for(let i = 0 ; i<listItemCount; i++){
            let recipeClass = document.querySelector(`.recipe${i}`).value; // 입력값
            let recipeId = document.querySelector(`.recipe${i}`).id // 이거 rmno로 쓰는중(객체 생성용)
// console.log(recipeId);
            // 객체생성해서 리스트에 저장
            let test = {"rmno":recipeId,
                        "sbcount":recipeClass
                        }
            recipeInputList.push(test);
        }
// console.log(recipeInputList);
        let form ={
            "wno":query.get("wno"),
            "surveyBDto":recipeInputList
        };
// console.log(from);
        
// const formData = new FormData();// 데이터폼 으로 변환
// formData.append('surveyInsertDto', form);

        // 등록 요청하기
        axios.post("/survey/insert.do",form,{
            headers: {
              'Content-Type': 'application/json' // 예: JSON 데이터 전송
            }
          })
        .then((r)=>{// int 'sno' 반환함 => r.data
            console.log(r);
        })
        
    
    }
    
    if(logininfo!=null){ // 로그인 정보가 로딩되지 않았다면 return 안함
        return(<>
            {/* {console.log(workPlanInfo)} */}
            <WorkPlanList/>
            <div id="surveyCssBox">
                <form>
                    <div>
                        <span>생산제품 : {recipeDtoList[0].pname}</span>
                        <span>생산수량 : {workPlanInfo.wcount.toLocaleString()} EA</span>
                        <span>생산기한 : {workPlanInfo.wendtime.split('T')[0]} 까지</span>
                        {/* {console.log(workPlanInfo.wendtime)} */}
                    </div>
                    <div>
                        <ul id="surveyUl">
                        {
                            recipeDtoList.map((r,index)=>{
                                return(<>
                                {/* {console.log(index)} */}
                                    <li>투입재료 : {r.rmname} 투입 해야하는 양 = {(r.reamount*workPlanInfo.wcount).toLocaleString()}g</li>
                                    <div><input type="text" className={"recipe"+index} id={r.rmno} { ...(logininfo.pno !== 1 && { disabled: true }) } /></div>
                                </>
                                );
                            })
                        }
                        </ul>
                        <button type="button" onClick={onClickEvent}>버튼</button>
                    </div>
                </form>

            </div>
        </>);
    }
}