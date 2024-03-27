import styles from "./main.css";
import Header from "./header/Header";
import Login from "./login/Login";
import Mensuration from "./content/Mensuration";

export default function Index(props){
    return(
        <div id="wrap">
            <Header/>
            <Mensuration/>
        </div>
    )
}