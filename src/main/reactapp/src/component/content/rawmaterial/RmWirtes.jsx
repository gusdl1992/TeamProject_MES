import RmLogWrite from "./RmLogWrite";
import RmWrite from "./RmWrite";

export default function RmWrites(props){
    
    return(<>
        <RmWrite setrerender ={props.setrerender} rerender={props.rerender}/>
        <RmLogWrite setrerender ={props.setrerender} rerender={props.rerender}/>
    </>)
}