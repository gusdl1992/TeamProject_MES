export default function WorkPlan(props){
    
    return(
        <div style={{maxWidth:'66%',minWidth:'1100px',margin:'0 auto',border:'1px solid red'}}>
            <form>
                거래처 : <input type="text"/>
                제품 : <input type="text" name="pname"/>
                수량 : <input type="text" name="wcount"/>
                납기 일 : <input type="text" name="wendtime"/>
                <button type="button">등록</button>
            </form>
        </div>
    )
}