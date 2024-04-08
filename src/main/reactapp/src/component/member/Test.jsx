import { useContext } from "react";
import { LoginInfoContext } from "../Index";


export default function Test(props){
        // 1. 컨텍스트 가져오기 (로그인 정보)
        const { logininfo, setLogin } = useContext(LoginInfoContext);
        console.log(logininfo);
        console.log('데이터가져오기'); console.log(logininfo.pno);

        
    
    const test1 = ()=>{
        if(logininfo === ''){
            // 로그인 안했을 시 로그인창 으로 보내기
            window.location.href='/'
        }
    }
    test1();

    return(<>
        <h1>테스트 테스트 테스트 테스트 테스트 테스트</h1>
    </>)
}