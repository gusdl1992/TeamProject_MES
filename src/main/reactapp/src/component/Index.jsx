import styles from "./main.css";
import Header from "./header/Header";
import Login from "./login/Login";
import Mensuration from "./content/Mensuration";

//
import WorkPlanList from "./content/survey/WorkPlanList";
import Survey from "./content/survey/Survey";

export default function Index(props){
    return(
        <div id="wrap">
            {/* <Header/> */}
            {/* <Mensuration/> */}
            {/* <WorkPlanList/> */}
            <Survey/>
        </div>
    )
}