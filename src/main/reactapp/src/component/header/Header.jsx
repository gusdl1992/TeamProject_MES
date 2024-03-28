import styles from './header.css';

export default function header(props){
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

    return (
        <div id='menuWrap'>
            <div id='logoBox'>
                로고
            </div>
            <div id='sideNav'>
                <ul>
                    <li onClick={clickMenu}>
                        <a className='topMenu' href='#'>
                            자재관리
                        </a>
                        <div className='subMenu'>
                            <ul>
                                <li>
                                    메뉴1
                                </li>
                                <li>
                                    메뉴2
                                </li>
                                <li>
                                    메뉴3
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li onClick={clickMenu}>
                        생산관리
                        <div className='subMenu'>
                            <ul>
                                <li>
                                    메뉴1
                                </li>
                                <li>
                                    메뉴2
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
                    <li>
                        관리자페이지
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