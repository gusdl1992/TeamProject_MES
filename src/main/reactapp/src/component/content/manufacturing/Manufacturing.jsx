import axios from "axios";
import { useContext, useEffect, useState } from "react";
import { Await, useSearchParams } from "react-router-dom";
import { LoginInfoContext } from "../../Index";
import "./manufacturingCSS.css"

// 다른 컴포넌트
import SurveyCheckList from "../surveyCheck/SurveyCheckList";
import TotalBox from "../layouts/TotalBox";
import MaterialinputList from "./MaterialinputList";



export default function Manufacturing(props){
    // 1. 컨텍스트 가져오기 (로그인 정보)
    const { logininfo, setLogin } = useContext(LoginInfoContext);
    // 쿼리스트링 값 가져오기 mipno
    const [query , setQuery] = useSearchParams();

    //  MaterialInput 객체(전체)
    const [ materialInputInfo , setMaterialInputInfo ] = useState({
        mipno:0
    })
    
    // 워크플랜 객체
    const [ workPlanInfo , setWorkPlanInfo] = useState({
        wcount:0,
        wendtime:"2024-03-30T10:00:12.123456"
    });
    


    

    useEffect(  ()=>{
        axios.get("/manufacturing/MaterialInput/click.do",{ params :{ mipno :query.get("mipno") }})
        .then((response)=>{
            console.log(response);
            setWorkPlanInfo(response.data.workPlanDto);
            setMaterialInputInfo(response.data);
            
        })
        .catch(re =>{console.log(re)})
    },[query])
    
// =============================================================
    let succeseInfo = [false];
    // function onClickEvent(){
    //     console.log("버튼눌림");
    //     console.log(succeseInfo)
    //     for(let i = 0; i<succeseInfo.length; i++){
    //         if(!succeseInfo[i]){alert("안내) 입력값을 확인해주세요"); return;}
    //     }

    //     // ul 요소 가져오기
    //     const ulElement = document.getElementById('surveyUl');
    //     // ul 요소 안의 li 요소 개수 파악(li개수 = 입력해야하는 레시피 수)
    //     const listItemCount = ulElement.getElementsByTagName('li').length;
        
    //     // 전송할 객체만들기
    //     let recipeInputList = [];
    //     for(let i = 0 ; i<listItemCount; i++){
    //         let recipeClass = document.querySelector(`.recipe${i}`).value; // 입력값
    //         let recipeId = document.querySelector(`.recipe${i}`).id // 이거 rmno로 쓰는중(객체 생성용)
            
    //         if(isNaN(recipeClass)){alert("계량) 숫자로 입력해주세요!"); return;}
    //         else if(recipeClass==""){alert("계량) 값을 입력해주세요!"); return;}
            
    //         // 객체생성해서 리스트에 저장
    //         let test = {"rmno":recipeId,
    //                     "sbcount":recipeClass
    //                     }
    //         recipeInputList.push(test);
    //     }// for END
        
    //     // 전송용 객체
    //     let form ={
    //         "wno":query.get("wno"),
    //         "surveyBDto":recipeInputList
    //     };
    //     console.log(form);

    //     // 등록 요청하기
    //     axios.post("/survey/insert.do",form,{
    //         headers: {
    //           'Content-Type': 'application/json' // 예: JSON 데이터 전송
    //         }
    //     })
    //     .then((r)=>{// int 'sno' 반환함 => r.data
    //         // -1 로그인 정보가 없음
    //         // -2 Survey 저장실패
    //         // -3 해당 원자재 레코드가 없음
    //         // -4 검사 단계 진행됨 (수정불가능)
    //         console.log(r.data);
    //         if(r.data>0){alert("안내) 계량내용 등록성공 하였습니다."); window.location.href='/survey/survey';}
    //         else if(r.data==-1){alert("안내) 로그인 정보가 없습니다.");}
    //         else if(r.data==-2){alert("안내) 등록실패.");}
    //         else if(r.data==-3){alert("안내) 해당 원자제가 등록되어있지 않습니다..");}
    //         else if(r.data==-4){alert("안내) 검사단계가 진행되었습니다.(수정불가)");}
            
    //     })
    //     .catch((re)=>{console.log(re);})
    // }
    
    // function onChangeEvent(index,inputCount){
        
    //     let recipeClass = document.querySelector(`.recipe${index}`).value; // 입력값 가져오기
    
    //     if(parseInt(inputCount-inputCount*0.01)<=parseInt(recipeClass)&&parseInt(recipeClass)<=parseInt(inputCount+inputCount*0.01)){
    //         // 입력값이 투입해야하는 양보다 1% 이상 오차가 없다면 (성공)
    //         document.querySelector(`.validation${index}`).innerHTML="";
    //         succeseInfo[0]= true;
    //     }else{
    //         document.querySelector(`.validation${index}`).innerHTML=`+-${(inputCount+inputCount*0.01).toLocaleString()} 이내로 투입해주세요`;
    //         succeseInfo[0] = false;
    //     }
    // }

    if(logininfo!=null){ // 로그인 정보가 로딩되지 않았다면 return 안함
        return(<>
            <TotalBox/>
            <MaterialinputList/>
            
            {materialInputInfo.mipno!=""?
            <div id="surveyCssBox">
                {console.log(materialInputInfo)}
                <form>
                    <h3>
                        <span>생산제품 : {workPlanInfo.pname}</span>
                        <span>생산수량 : {workPlanInfo.wcount.toLocaleString()} EA</span>
                        <span>생산기한 : {workPlanInfo.wendtime.split('T')[0]} 까지</span>
                        <div>숙성 소요 기한 : {materialInputInfo.productDto.ferment} 일</div>
                        <div>예상 완료 기한 : </div>
                    </h3>
                    {/* <div>
                        <ul id="surveyUl">
                        {
                            recipeDtoList.map((r,index)=>{
                                return(<>
                                    <li>투입재료 : {r.rmname} 투입 해야하는 양 = {(r.reamount*workPlanInfo.wcount).toLocaleString()}g</li>
                                    <div>
                                        입력된 양 : <input type="text" onChange={()=>{onChangeEvent(index , r.reamount*workPlanInfo.wcount)}} className={"recipe"+index} id={r.rmno} { ...(logininfo.pno === 1 || logininfo.pno === 0? { disabled: false }: { disabled: true })} />
                                        <span className={"validation"+index}></span>
                                    </div>
                                </>
                                );
                            })
                        }
                        </ul>
                        <button id="surveyBtn" type="button" onClick={onClickEvent}>버튼</button>
                    </div> */}
                </form>
            </div>
            :""}
            {/* <SurveyCheckList/> */}
            
        </>);
    }
}