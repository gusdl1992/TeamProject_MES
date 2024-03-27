import styles from './header.css';
import Test from '../content/Test';

export default function header(props){
    return (
        <div>
            <div id='headerWrap'>
                <div id='logoBox'>
                    로고
                </div>
                <div id='gnv'>
                    <GnvContent/>
                </div>
                <div id='loginBox'>
                    로그인
                </div>
            </div>
            <Test/>
        </div>
    )
}

function GnvContent(props){
    return(
        <ul id='gnvMenu'>
            <li>
                자재관리
            </li>
            <li>
                생산관리
            </li>
            <li>
                로그
            </li>
            <li>
                경영통계
            </li>
            <li>
                관리자페이지
            </li>
        </ul>
    )
}