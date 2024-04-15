import axios from "axios";
import { useEffect, useState } from "react"
import { Link } from "react-router-dom";
/* global $ */




export default function SurveyList(props){

    // 계량
    const [ survey , setSurvey ] = useState([]);

    useEffect( ( ) => {
        axios.get("/material/surveyinfo.do")
        .then( (r) => {
            console.log(r);
            const result = r.data.map((survey) => {return survey;})
            setSurvey(result)
        })
    },[])

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
                <div className="item" id="workPlanListBox">
                    {survey.map((s) => {
                    if(s.workPlanDto.wstate == 2 && s.sstate == 2){
                        return(
                            <div>
                                <Link to={`/material/input?sno=${s.sno}`}>
                                    <span>작업계획 {s.sno}</span>
                                    <span>등록일자 : {s.cdate.split('T')[0]}까지</span>
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