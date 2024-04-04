use reactteam1;
# 샘플데이터 Start #########################################################################
#select * from member;
# member sample
insert into member (mno , pno , cdate , udate , mid , mpw , mname ) values (1,0,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','admin' , 'admin' , "관리자" );
insert into member (mno , pno , cdate , udate , mid , mpw , mname ) values (2,1,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id1' , 'id1' , "계량담당" );
insert into member (mno , pno , cdate , udate , mid , mpw , mname ) values (3,2,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id2' , 'id2' , "투입담당" );
insert into member (mno , pno , cdate , udate , mid , mpw , mname ) values (4,3,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id3' , 'id3' , "사원1" );
insert into member (mno , pno , cdate , udate , mid , mpw , mname ) values (5,4,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id4' , 'id4', "사원1" );
insert into member (mno , pno , cdate , udate , mid , mpw , mname ) values (6,1,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id5' , 'id5', "사원2" );
insert into member (mno , pno , cdate , udate , mid , mpw , mname ) values (7,2,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id6' , 'id6', "사원3" );
insert into member (mno , pno , cdate , udate , mid , mpw , mname ) values (8,3,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id7' , 'id7', "사원4" );
insert into member (mno , pno , cdate , udate , mid , mpw , mname ) values (9,4,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id8' , 'id8', "사원5" );
insert into member (mno , pno , cdate , udate , mid , mpw , mname ) values (10,1,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id9' , 'id9', "사원6" );

#select * from product;
# product sample
insert into product ( pno , cdate , udate , pname ) values ( 1 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '수분크림' );
insert into product ( pno , cdate , udate , pname ) values ( 2 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '페브리즈' );
insert into product ( pno , cdate , udate , pname ) values ( 3 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '로션' );

#select * from rawmaterial;
#rawmaterial sample
insert into rawmaterial ( rmno , cdate , udate , rmname ) values ( 1 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '로션원액' );
insert into rawmaterial ( rmno , cdate , udate , rmname ) values ( 2 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '물' );
insert into rawmaterial ( rmno , cdate , udate , rmname ) values ( 3 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '알로애' );
insert into rawmaterial ( rmno , cdate , udate , rmname ) values ( 4 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '민트향원액' );
insert into rawmaterial ( rmno , cdate , udate , rmname ) values ( 5 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '에탄올' );


#select * from recipe;
# recipe sample # 레시피
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 1 , 90 , 1 , 3 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 1 , 10 , 2 , 2 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 2 , 70 , 3 , 5 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 2 , 20 , 4 , 2 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 2 , 10 , 5 , 4 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 3 , 70 , 6 , 1 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 3 , 10 , 7 , 2 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 3 , 20 , 8 , 5 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );


#select * from workplan;
#workplan sample # 업무계획
insert into workplan ( pno , wcount , wno , cdate , udate , wstarttime , wendtime , wstate ) values ( 1 , 1000 , 1 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '2024-03-20 10:00:12.123456' , '2024-03-30 10:00:12.123456' , 0 );
insert into workplan ( pno , wcount , wno , cdate , udate , wstarttime , wendtime , wstate ) values ( 2 , 500 , 2 ,'2024-03-20 10:00:12.123456','2024-03-20 10:00:12.123456' , '2024-03-20 10:00:12.123456' , '2024-03-30 10:00:12.123456' , 0 );
insert into workplan ( pno , wcount , wno , cdate , udate , wstarttime , wendtime , wstate ) values ( 3 , 800 , 3 ,'2024-03-20 10:00:12.123456','2024-03-20 10:00:12.123456' , '2024-03-20 10:00:12.123456' , '2024-03-30 10:00:12.123456' , 0 );


#select * from survey;
# survey sample
insert into survey ( sstate , sno , wno , cdate , udate , inputmno , checkmno ) values ( 0 , 1 , 1 , '2024-03-12 12:00:12.123456','2024-03-12 12:00:12.123456' , 2 , null );
insert into survey ( sstate , sno , wno , cdate , udate , inputmno , checkmno ) values ( 0 , 2 , 2 , '2024-03-20 12:00:12.123456','2024-03-20 12:00:12.123456' , 2 , null );
insert into survey ( sstate , sno , wno , cdate , udate , inputmno , checkmno ) values ( 0 , 3 , 3 , '2024-03-20 14:00:12.123456','2024-03-20 14:00:12.123456' , 2 , null );

select * from materialinput;
# materialinput sample # 투입공정
insert into materialinput ( mipno , sno , pno , inputmno , checkmembername , cdate , udate ) values ( 1 , 1 , 1 , 3 , null ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456');
insert into materialinput ( mipno , sno , pno , inputmno , checkmembername , cdate , udate ) values ( 2 , 2 , 2 , 3 , null ,'2024-03-20 12:30:12.123456','2024-03-20 12:30:12.123456');
insert into materialinput ( mipno , sno , pno , inputmno , checkmembername , cdate , udate ) values ( 3 , 3 , 3 , 3 , null ,'2024-03-20 14:30:12.123456','2024-03-20 14:30:12.123456');
# 샘플데이터 END ###########################################################################
select * from member;
select * from product;
select * from rawmaterial;
# select * from rawmateriallog;
select * from recipe;

select * from workplan;
select * from survey;

select * from materialinput;#



# 박시현 join 연습...
insert into surveyb ( rmno , sbcount , sbno , sno ) values ( 1 , 100 , 1 ,1 );
select * from survey join surveyb on survey.sno = surveyb.sno join rawmaterial on surveyb.rmno = rawmaterial.rmno join recipe on rawmaterial.rmno = recipe.rmno join product on recipe.pno = product.pno;
select * from product join recipe on product.pno = recipe.pno where product.pno = 1 union select * from rawmaterial join recipe on rawmaterial.rmno = recipe.rmno;
select * from survey join workplan on survey.wno = workplan.wno join recipe on workplan.pno = recipe.pno join rawmaterial on recipe.rmno = rawmaterial.rmno where recipe.pno = 1;