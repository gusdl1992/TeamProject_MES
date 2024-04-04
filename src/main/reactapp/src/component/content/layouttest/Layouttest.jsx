import PrintBox from "../layouts/PrintBox";
import TotalBox from "../layouts/TotalBox";



export default function LayoutTest(props){
    return(
        <div style={{maxWidth:'66%',minWidth:'1100px',margin:'0 auto',border:'1px solid red'}}>
            <TotalBox/>

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