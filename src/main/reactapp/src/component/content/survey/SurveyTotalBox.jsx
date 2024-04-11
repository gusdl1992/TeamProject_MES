import { useEffect, useState } from "react"
import axios from "axios";

export default function SurveyTotalBox(props){
    const [previous , setPrevious] = useState(0);
    const [success , setSuccess] = useState(0);
    const [fail , setFail] = useState(0);

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

        const fetchData2 = async () => {
            try {
                const response2 = await axios.get('/survey/check/survey/get.do');
                const successlength = response2.data.filter((result) => result.sstate === 2);
                const faillength = response2.data.filter((result) => result.sstate === 1);
                setSuccess(successlength.length);
                setFail(faillength.length);
            } catch (error) {
                console.log(error);
            }
        };
    
        fetchData();
        fetchData2();
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
                    완료 {success}개
                </div>
                <div className="statisticsBox">
                    불합격 {fail}개
                </div>
            </div>
        </div>
    )
}