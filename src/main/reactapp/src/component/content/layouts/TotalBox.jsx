export default function TotalBox(props){
    return(
        <div className="statistics">
            <h3>통계</h3>
            <div className="statisticsWrap">
                <div className="statisticsBox">
                    진행전 0개
                </div>
                <div className="statisticsBox">
                    진행중 0개
                </div>
                <div className="statisticsBox">
                    완료 0개
                </div>
                <div className="statisticsBox">
                    불합격 0개
                </div>
            </div>
        </div>
    )
}