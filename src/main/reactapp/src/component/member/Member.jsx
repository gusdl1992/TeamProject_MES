import { useContext, useEffect } from "react";
import { LoginInfoContext } from "../Index";
import { Axios } from "axios";
import styles from './member.css'; // CSS 모듈을 불러옵니다.


export default function Test(props){
        // 1. 컨텍스트 가져오기 (로그인 정보)
        const { logininfo, setLogin } = useContext(LoginInfoContext);

        // 관리자 페이지 회원 유효성 검사 ( url 로 들어왔을시.. )
        function loginCheck(){
            // 회원값이 없거나 null 일경우(새로고침할떄) 로그인 페이지 이동
            if(logininfo === '' || logininfo == null){           
                window.location.href='/';
                // http://localhost:3000/member/test
            }
            // pno 가 관리자가 아닐경우 메인페이지 이동
            else if(logininfo.pno !== -1){
                window.location.href='/c';
            }
        }
        loginCheck();
        console.log(logininfo);
        console.log('데이터가져오기');

        

        

    

    return(<>
    <div id='memberWrap'>
        
    </div>
    </>)
}