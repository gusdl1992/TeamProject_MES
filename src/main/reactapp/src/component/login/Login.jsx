import styles from './login.css';
export default function header(props){
    return(
        <div id='loginWrap'>
            <h2>로그인</h2>
            <form>
                전화번호 : <input type='text' />
                비밀번호 : <input type='password'/>
            </form>
            <button type='button'>로그인</button>
        </div>
    )
}