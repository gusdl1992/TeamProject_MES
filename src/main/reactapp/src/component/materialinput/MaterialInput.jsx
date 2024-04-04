import axios from "axios";
import { useCallback, useEffect, useRef, useState } from "react";
import { useSearchParams } from "react-router-dom";
import SurveyList from "./SurveyList";

export default function MaterialInput(props){
    // 1. 컨텍스트 가져오기 (로그인 정보)
//     const { logininfo, setLogin } = useContext(LoginInfoContext);
// console.log(logininfo);

    // 쿼리스트링 값 가져오기 sno
    let [query, setQuery] = useSearchParams();

    const [ surveyB , setSurveyB ] = useState([]);

    console.log(query.get("sno"))

    useEffect (() => { survey() } , [])
    const survey =
     () =>{
     axios.get('/material/input/info/get.do', { params :{ sno :query.get("sno") }} )
    .then((response)=>{
    console.log(response);
    setSurveyB(response.data);

})
}


    return(<>
        <SurveyList />
        <div id="surveyCssBox">
            <form>
            <div>

                        {/* {console.log(workPlanInfo.wendtime)} */}
                    </div>
            </form>
        </div>
        </>)
}


// let [test,setTest] = useState([{pname:"" , wcount:"" , wendtime:"" }]);

// let [test1,setTest1] = useState([]);

// // 워크플랜 객체
// const [ workPlanInfo , setWorkPlanInfo] = useState({
//     wcount:0,
//     wendtime:"2024-03-30T10:00:12.123456"
// });

// // 레시피리스트
// const [ recipeDtoList , setRecipeDtoList] = useState( [
//     { pname : '' }// 최초 렌더링 할때 오류 발생 : 초기임의의 값을 넣어줌
// ] );

// const [ survey , setSurvey ] = useState([]);

// useEffect( ( ) => {
//     axios.get("/material/surveyinfo.do")
//     .then( (r) => {
//         console.log(r);
//         const result = r.data.map((survey) => {return survey;})
//         setSurvey(result)
//     })
// },[])

// //
// const infoGet =  useCallback ( () => {
//     axios.get('/material/input/info/get.do', query.get("sno"))
//     .then((response)=>{
//         console.log(response);
//         if(response.data != []){
//             setTest(response.data);

//         }
//     })
// } , [ test] )


// useEffect(  ()=>{
//     const formData = new FormData();
//     formData.append("wno",query.get("sno")); // 바꿔야함
//     axios.post("/survey/workplan/clilck.do",formData)
//     .then((response)=>{
//         console.log(response);
//         setWorkPlanInfo(response.data.workPlanDto);
//         const result = response.data.recipeDto.map( (re) =>{return re;})// 레시피 dto state 추가하기
//         setRecipeDtoList(result);
//     })
//     .catch(re =>{console.log(re)})
// },[])



// useEffect(()=>{ infoGet()  },[  ])

// const [confirmstate , setConfirmState] = useState('0');

// const confirmStateChange = (e)=>{
//     setConfirmState(e.target.value);
//     e.preventDefault();
// }

// let materialConfirmForm = useRef();
// let confirmStatePrint = '';

// let onMaterialConfirm = ()=>{
//     axios.put('/materialinput/confirm.do',materialConfirmForm.current)
//     .then(r=>{
//         console.log(r);
//         if(r.data){
//             infoGet()
//         }
//     })
//     .catch(e=>{
//         console.log(e);
//     })
// }
// const test12 =
//      () =>{
//      axios.get('/material/input/info/get.do', query )
// .then((response)=>{
//     console.log(response);
//     if(response.data != []){
//         setTest1(response.data);
//     }
// })
// }
// useEffect( () => {test12()} , [])
// console.log(test)
// useEffect( () => {test12()} , [])
// console.log(test)
