import { useContext, useEffect } from 'react';
import styles from './header.css';
import { LoginInfoContext } from '../Index';
import axios from 'axios';
import { Link } from 'react-router-dom';

export default function Header(props){
    const clickMenu = (event) => {
        const clickedItem = event.currentTarget;
        const subMenu = clickedItem.querySelector(".subMenu");
    
        // 모든 subMenu를 닫음
        const allSubMenus = document.querySelectorAll('.subMenu');
        allSubMenus.forEach((menu) => {
            if (menu !== subMenu && menu.classList.contains('active')) {
                menu.classList.remove('active');
            }
        });
    
        // 클릭된 subMenu만 토글
        if (subMenu) {
            subMenu.classList.toggle('active');
        }
    };


    // 로그인 정보 저장
    const { logininfo, setLogin } = useContext(LoginInfoContext);
    useEffect(()=>{
        axios.get("/member/login/info/get.do")
            .then( (r)=>{console.log(r)
                    setLogin(r.data)
                    
            } )
            .catch( (e) => {console.log(e)})


    } ,[])

    const logoutHandler = ()=>{
        axios.get("/member/logout/get.do").then( (r)=>{ if(r.data){
            alert("로그아웃 성공")
            window.location.href = "/"
        } } ).catch( e=>{})
    }

    const checklogin = logininfo ? <li>{logininfo.mname}님 환영합니다! <span onClick={logoutHandler}> 로그아웃</span> </li>:<li> <a href='/member/login'> 로그인</a></li>

    return (
        <div id='menuWrap'>
            <div id='logoBox'>
                로고
            </div>
            <div id='sideNav'>
                <ul>
                    {checklogin}
                    <li onClick={clickMenu}>
                        <a className='topMenu' href='#'>
                            자재관리
                        </a>
                        <div className='subMenu'>
                            <ul>
                                <li>
                                    <Link to="/RM">원자재리스트</Link>
                                </li>
                                <li>
                                    <Link to ="/RM/write">원자재등록</Link>
                                </li>
                                <li>
                                <Link to ="/product">제품리스트</Link>
                                </li>
                                <li>
                                <Link to ="/product/write"> 제품 등록</Link>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li onClick={clickMenu}>
                        생산관리
                        <div className='subMenu'>
                            <ul>
                                <li>
                                <Link to="/survey/survey">원료계량</Link>
                                </li>
                                <li>
                                    <Link to="/material/input">원료투입</Link>
                                </li>
                                <li>
                                    메뉴3
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        로그
                    </li>
                    <li>
                        경영통계
                    </li>
                    <li onClick={clickMenu} >
                        관리자페이지
                        <div className='subMenu'>
                            <ul>
                                <li>
                                <Link to="/member/test">사원등록</Link>
                                </li>
                                <li>
                                    메뉴99
                                </li>

                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    )
}

/*

    <li>
        <a class="collapsible-header">Dropdown<i class="material-icons">arrow_drop_down</i></a>
        <div class="collapsible-body">
            <ul>
            <li><a href="#!">First</a></li>
            <li><a href="#!">Second</a></li>
            <li><a href="#!">Third</a></li>
            <li><a href="#!">Fourth</a></li>
            </ul>
        </div>
    </li>

      $('.button-collapse').sideNav({
      menuWidth: 300, // Default is 300
      edge: 'left', // Choose the horizontal origin
      closeOnClick: false, // Closes side-nav on <a> clicks, useful for Angular/Meteor
      draggable: true // Choose whether you can drag to open on touch screens,
    }
  ); 
*/