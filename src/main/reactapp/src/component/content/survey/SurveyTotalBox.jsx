import { useEffect, useState } from "react"
import axios from "axios";

export default function SurveyTotalBox(props){
    const [previous , setPrevious] = useState(0);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get("/survey/workplaninfo.do");
                const filteredData = response.data.filter((result) => result.wstate === 0);
                setPrevious(filteredData.length);
            } catch (error) {
                console.log(error);
            }
        };
    
        fetchData();
      }, []);

    return(
        <div className="statistics">
            <h3>통계</h3>
            <div className="statisticsWrap">
                <div className="statisticsBox">
                    진행전 {previous}개
                </div>
                <div className="statisticsBox">
                    진행중 {previous}개
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