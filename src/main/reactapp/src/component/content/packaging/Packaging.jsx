import PackagingLayOut from "./PackagingLayOut";
import PackagingPrintBox from "./PackagingPrintBox";
import PackagingTotatBox from "./PackagingTotalBox";
import PackagingWrite from "./PackagingWrite";


export default function Packaging(props){

    return(
        <div className="contentWrap">
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