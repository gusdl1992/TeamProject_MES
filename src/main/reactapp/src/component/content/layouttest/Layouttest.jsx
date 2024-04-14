import { useRef, useState } from "react";
import PrintBox from "../layouts/PrintBox";
import TotalBox from "../layouts/TotalBox";



export default function LayoutTest(props){
    const [msgInput, setMsgInput] = useState("");
    let clientSocket = useRef(null);
    if(!clientSocket.current){
        clientSocket.current = new WebSocket("ws://192.168.17.10:80/safety");
        //onmclose // onerror // onmessage // onopen : 웹소켓 객체네 포함된 메소드들
            //2.각 메소드 정의
                //1.클라이언트 소켓이 close발생했을때 콜백함수 정의 
        clientSocket.current.onclose = (e) =>{console.log(e); console.log("닫힘")}
                //2.클라이언트 소켓이 error 발생했을때 콜백함수 정의(에러는 이미 발생했고 그 다음 행동 정의)
        clientSocket.current.onerror = (e) =>{console.log(e); console.log("에러")}
                //3.클라이언트 소켓이 메세지를 받았을 경우 콜백함수 정의
        clientSocket.current.onmessage = (e)=>{
            setMsgInput(JSON.parse(e.data));
        } 
                //4.클라이언트 소켓이 open 발생했을때 콜백함수 정의
        clientSocket.current.onopen = (e)=>{console.log(e); console.log("서버 소켓연결")}
        console.log(clientSocket);
        
        //2. 연결된 소켓에게 메세지 보내기
        
        //3. 서버 소켓으로부터 메세지받기
    
        //4.연결 종료
    }

    return(
        <div className="contentWrap">
        
        <div className="statistics">
            <marquee behavior="scroll" direction="right" scrollamount="10" style={msgInput >= 50 ? {backgroundColor: 'rgba(255, 99, 132, 0.2)'} : (msgInput > 10 ? {backgroundColor: 'rgba(75, 192, 192, 0.2)'} : {backgroundColor: 'rgba(54, 162, 235, 0.2)'})}>
                <span>{msgInput >=50&& "위기상황발생!!!" } 현재 온도는: {msgInput} {msgInput >=50&& "위기상황발생!!!" }</span>
            </marquee>
            <h3>통계</h3>
            <div className="statisticsWrap">
                <div className="statisticsBox">
                    진행전 0개
                </div>
                <div className="statisticsBox">
                    진행중 0개
                </div>
                <div className="statisticsBox">
                    완료 0개
                </div>
                <div className="statisticsBox">
                    불합격 0개
                </div>
            </div>
        </div>
            <div className="AinputBox">
                <h3>작성</h3>
                {props.insert}
            </div>
            <div className="AcontentBox">
                <h3>목록</h3>
                {props.list}
            </div>
        </div>
    )
}