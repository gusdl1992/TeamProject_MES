import axios from "axios";
import { useContext, useEffect, useState } from "react"
import { Link } from "react-router-dom";
import { RenderContext } from "./MaterialInput";
/* global $ */




export default function SurveyList(props){
    // 재 랜더링용
    // - provider 컴포넌트의 value 호출
    const { render ,setRender } = useContext(RenderContext);

    // 계량
    const [ survey , setSurvey ] = useState([]);

    useEffect( ( ) => {
        axios.get("/material/surveyinfo.do")
        .then( (r) => {
            console.log(r);
            const result = r.data.map((survey) => {return survey;})
            setSurvey(result)
        })
    },[render])

    // $('.owl-carousel').owlCarousel({
    //     loop: true,
    //     margin: 10,
    //     nav: true,
    //     navText: [
    //       "<i class='fa fa-caret-left'></i>",
    //       "<i class='fa fa-caret-right'></i>"
    //     ],
    //     autoplay: true,
    //     autoplayHoverPause: true,
    //     responsive: {
    //       0: {
    //         items: 1
    //       },
    //       600: {
    //         items: 3
    //       },
    //       1000: {
    //         items: 5
    //       }
    //     }
    //   }) 
    

   


    return(<>
        <div className="carousel-wrap">
            <div className="owl-carousel">
                <div className="item" id="cssBox">
                    {survey.map((s) => {
                    if(s.workPlanDto.wstate == 2 && s.sstate == 2){
                        return(
                            <div className="previosList">
                                <Link to={`/material/input?sno=${s.sno}`}>
                                    <h4>작업계획 {s.sno}</h4>
                                    <p>등록일자 : {s.cdate.split('T')[0]}까지</p>
                                </Link>
                            </div>
                        )
                    }
                })}
                </div>                
            </div>
        </div>
          
    </>)
}