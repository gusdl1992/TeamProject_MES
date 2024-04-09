import PackagingLayOut from "./PackagingLayOut";
import PackagingPrintBox from "./PackagingPrintBox";
import PackagingTotatBox from "./PackagingTotalBox";
import PackagingWrite from "./PackagingWrite";


export default function Packaging(props){

    return(
        <div style={{maxWidth:'66%',minWidth:'1100px',margin:'0 auto',border:'1px solid red'}}>
            <PackagingTotatBox />
            <div id="workplanCssBox">
                <PackagingLayOut />
            </div>
            <div id="workplanCssBox">
                <PackagingWrite />
            </div>
            <PackagingPrintBox />
        </div>
    )
}