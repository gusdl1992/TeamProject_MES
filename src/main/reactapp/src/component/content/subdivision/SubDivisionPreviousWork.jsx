export default function SubDivisionPreviousWork(props){

    // 계량
    const [ previousWork , setPreviousWork ] = useState([]);

    useEffect( ( ) => {
        axios.get("/subdivision/manufacturing/get.do")
        .then( (r) => {
            console.log(r);
            const result = r.data.map((survey) => {return survey;})
            setSurvey(result)
        })
    },[])

   


    return(<>
        <div id="workPlanListBox">
            {survey.map((s) => {
                
                return(
                    <div>
                        <Link to={`/material/input?sno=${s.sno}`}>
                            <span>작업계획 {s.sno}</span>
                            <span>등록일자 : {s.cdate}</span>
                        </Link>
                    </div>
                )
            })}
        </div>    
    </>)
}