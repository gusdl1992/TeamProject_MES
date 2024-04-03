import axios from "axios";
import { useCallback, useEffect, useRef, useState } from "react";
import MaterialInputPrintBox from "./MaterialInputPrintBox";

export default function MaterialInput(props){

    const [confirmstate , setConfirmState] = useState('0');

    const confirmStateChange = (e)=>{
        setConfirmState(e.target.value);
        e.preventDefault();
    }

    let materialConfirmForm = useRef();

    let onMaterialConfirm = ()=>{
        axios.put('/materialinput/confirm.do',materialConfirmForm.current)
        .then(r=>{
            console.log(r);
            if(r.data){
                
            }
        })
        .catch(e=>{
            console.log(e);
        })
    }

    return(
        <div style={{maxWidth:'66%',minWidth:'1100px',margin:'0 auto',border:'1px solid red'}}>
            <div className="searchBox">
                <h3>검색</h3>
            </div>
            <div className="statistics">
                <h3>통계</h3>
                <div className="statisticsWrap">
                    <div className="statisticsBox">
                        
                    </div>
                    <div className="statisticsBox">
                        
                    </div>
                    <div className="statisticsBox">
                        
                    </div>
                    <div className="statisticsBox">
                        
                    </div>
                </div>
            </div>
            <div className="AinputBox">
                <h3>작성</h3>
                <form ref={materialConfirmForm}>
                    <input type="text" value="1" style={{display:'none'}} name="mipno"/>
                    검사자 : <input type="text" name="mname"/>
                    검사상태
                    <select name="mipstate" value={confirmstate} onChange={confirmStateChange}>
                        <option value="0">
                            검사대기
                        </option>
                        <option value="1">
                            검사불합격
                        </option>
                        <option value="2">
                            검사합격
                        </option>
                    </select>
                    <button type="button" onClick={onMaterialConfirm}>검사 완료</button>
                </form>
            </div>
            <MaterialInputPrintBox/>
        </div>
    )
}