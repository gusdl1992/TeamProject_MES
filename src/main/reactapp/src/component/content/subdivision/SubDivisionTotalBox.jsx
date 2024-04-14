import { useEffect, useState } from "react"
import axios from "axios";

export default function SubdivisionTotalBox(props){
    const [previous , setPrevious] = useState(0);
    const [now , setNow] = useState(0);
    const [success , setSuccess] = useState(0);
    const [fail , setFail] = useState(0);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get("/wp/list/get.do");
                const filteredData = response.data.filter((result) => result.wstate <= 6);
                setPrevious(filteredData.length);
            } catch (error) {
                console.log(error);
            }
        };

        const fetchData2 = async () => {
            try {
                const response2 = await axios.get('/subdivision/allinfo/get.do');
                const nowlength = response2.data.filter((result) => result.sdstate === 0);
                const successlength = response2.data.filter((result) => result.sdstate === 2);
                const faillength = response2.data.filter((result) => result.sdstate === 1);
                setNow(nowlength.length);
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
                    진행전 
                    <div id="statisticsBoxFont">{previous}개</div>
                </div>
                <div className="statisticsBox">
                    진행중 
                    <div id="statisticsBoxFont">{now}개</div>
                </div>
                <div className="statisticsBox">
                    완료 
                    <div id="statisticsBoxFont">{success}개</div>
                </div>
                <div className="statisticsBox">
                    불합격 
                    <div id="statisticsBoxFont">{fail}개</div>
                </div>
            </div>
        </div>
    )
}