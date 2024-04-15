
insert into member (mno , part , cdate , udate , mid , mpw , mname ) values (1,-1,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','admin' , '1234' , "이민형" );
insert into member (mno , part , cdate , udate , mid , mpw , mname ) values (2,1,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id1' , '1234' , "김건우" );
insert into member (mno , part , cdate , udate , mid , mpw , mname ) values (3,2,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id2' , '1234' , "박시현" );
insert into member (mno , part , cdate , udate , mid , mpw , mname ) values (4,3,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id3' , '1234' , "심재훈" );
insert into member (mno , part , cdate , udate , mid , mpw , mname ) values (5,10,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id4' , '1234', "전승호" );
insert into member (mno , part , cdate , udate , mid , mpw , mname ) values (6,1,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id5' , '1234', "유재석" );
insert into member (mno , part , cdate , udate , mid , mpw , mname ) values (7,2,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id6' , '1234', "박명수" );
insert into member (mno , part , cdate , udate , mid , mpw , mname ) values (8,3,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id7' , '1234', "강호동" );
insert into member (mno , part , cdate , udate , mid , mpw , mname ) values (9,10,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id8' , '1234', "이수근" );
insert into member (mno , part , cdate , udate , mid , mpw , mname ) values (10,1,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456','id9' , '1234', "신동엽" );


insert into product ( pno , cdate , udate , pname , ferment , standard , packagingcount , period ) values ( 1 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '촉촉촉촉한 수분크림' , 30 , 30 , 15 , 365);
insert into product ( pno , cdate , udate , pname , ferment , standard , packagingcount , period) values ( 2 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '칙칙 뿌리는 페브리즈' , 20 , 20 , 10 , 30);
insert into product ( pno , cdate , udate , pname , ferment , standard , packagingcount , period) values ( 3 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '남자다잉 로션' , 0 , 10 , 5 , 7);


insert into rawmaterial ( rmno , cdate , udate , rmname ) values ( 1 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '로션원액' );
insert into rawmaterial ( rmno , cdate , udate , rmname ) values ( 2 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '물' );
insert into rawmaterial ( rmno , cdate , udate , rmname ) values ( 3 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '알로애' );
insert into rawmaterial ( rmno , cdate , udate , rmname ) values ( 4 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '민트향원액' );
insert into rawmaterial ( rmno , cdate , udate , rmname ) values ( 5 , '2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' , '에탄올' );



insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 1 , 90 , 1 , 3 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 1 , 10 , 2 , 2 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 2 , 70 , 3 , 5 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 2 , 20 , 4 , 2 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 2 , 10 , 5 , 4 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 3 , 70 , 6 , 1 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 3 , 10 , 7 , 2 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );
insert into recipe ( pno , reamount , reno , rmno , cdate , udate ) values ( 3 , 20 , 8 , 5 ,'2024-03-12 10:00:12.123456','2024-03-12 10:00:12.123456' );


insert into workplan (wno , wcount , wendtime , wstate , pno , client) values (1 , 1200 , '2024-05-02T10:00:12.123456' , 0 , 1 , '삼성'),
(2 , 560 , '2024-05-02T12:00:12.123456' , 0 , 2, 'LG'),
(3 , 3750 , '2024-05-03T10:00:12.123456' , 0 , 3, '현대'),
(4 , 210 , '2024-05-04T10:00:12.123456' , 0 , 1, '롯데'),
(5 , 640 , '2024-05-05T10:00:12.123456' , 0 , 2, '신한은행'),
(6 , 790 , '2024-05-06T10:00:12.123456' , 0 , 3, '국민은행'),
(7 , 2450 , '2024-05-07T10:00:12.123456' , 0 , 1, '농심'),
(8 , 2910 , '2024-05-08T10:00:12.123456' , 0 , 2, '오뚜기'),
(9 , 1730 , '2024-05-09T10:00:12.123456' , 0 , 3, '이젠');

/* 샘플데이터 END */