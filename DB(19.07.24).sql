--Final----------------------------------------------------------------------------------
drop table admin;
drop sequence admin_seq;
drop table members;
drop table title_img;
drop table notice;
drop table message;
drop table payments;
drop table inquiring;
drop table report;
drop table point_using;
drop table point_charging;
drop table auction_board;
drop table auction_img_board;
drop table used_transaction_board;
drop table used_transaction_img_board;
drop table tender;
drop table comments;
drop table order_t;
drop table delivery;
drop table trade_cart;
drop table auction_cart;
drop table comments2;
drop sequence tender_seq;
drop sequence comments_seq;
drop sequence t_no_seq;
drop sequence n_no_seq;
drop sequence p_no_seq;
drop sequence e_no_seq;
drop sequence r_no_seq;
drop sequence a_no_seq;
drop sequence a_i_seq;
drop sequence u_no_seq;
drop sequence u_t_i_no_seq;
drop sequence p_u_no_seq;
drop sequence p_c_no_seq;
drop sequence order_seq;
drop sequence delivery_seq;
drop sequence comments_seq2;
create table members( --회원가입 테이블
    id varchar(30) primary key,
    pw varchar(100) ,
    name varchar(20),
    phone varchar(20),
    point number default 0,
    zipcode varchar(100) ,
    address1 varchar(100) ,
    address2 varchar(100) ,
    joindate timestamp default sysdate,
    ipaddress varchar(20) not null,
    logintype varchar(20) not null,
    member_class varchar(20) default '보통',
    blacklist char(1) default 'n',
    admin char(1) default 'n'
);
create table title_img( --메인화면 이미지
    no number not null,
    filename varchar(300) not null,
    oriflename varchar(300) not null,
    filepath varchar(300) not null,
    filesize number not null
);

create sequence t_no_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

create table notice( --공지사항 테이블
    no number not null,
    title varchar(100) not null,
    contents varchar(3000) not null,
    image varchar(300),
   viewcount number default 0,
     joindate timestamp default sysdate
);

create sequence n_no_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

create table message( --쪽지 테이블
    id varchar(50) not null,
    receiver varchar(50) not null,
    title varchar(100) not null,
    contents varchar(3000) not null,
     joindate timestamp default sysdate
);

create table payments( --결제 테이블
    no number not null,
    name varchar(20) not null ,
    id varchar(50) not null,
    phone varchar(20) not null,
    price number not null,
    joindate timestamp default sysdate
);

create sequence p_no_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

create table inquiring( --댓글 테이블
    no number not null,
    id varchar(50) not null,
    name varchar(20) ,
    contents varchar(3000) not null,
    joindate timestamp default sysdate,
    seller varchar(1) check (seller in ('n','y'))
);

create sequence e_no_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

create table report( --신고 테이블
    no number not null,
    title varchar(1000) not null,
    sender varchar(50) not null,
    reason varchar(100)not null, 
    contents varchar(1000) not null
);

create sequence r_no_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

create table point_using( --포인트 사용내역
no number primary key,
    id varchar(50) not null,
    title varchar(100) not null,
    payment number not null,
     joindate timestamp default sysdate
);
create sequence p_u_no_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;
create table point_charging( --포인트 충전내역
       no number primary key,
    id varchar(50) not null,
    money number not null,
     joindate timestamp default sysdate
);
create sequence p_c_no_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

create table auction_board( --경매 게시판
    no number primary key,
    id varchar(50) not null,
    title varchar(100) not null,
    title_img varchar(300) not null,
    phone varchar(20) not null,
    contents varchar(3000) not null,
    viewCount number default 0,
    start_date varchar(50) default to_char(sysdate,'YY-MM-DD HH:mi:ss'),   -- 시작일
    end_date varchar(50) not null,  -- 종료일
    starting_price number not null, -- 시작가
    min_price number not null,      -- 최소 입찰 단위
    present_price number default 0, -- 현재가
    member_class varchar(20) not null, -- 회원등급
    account varchar(30) not null,      --계좌
    bid_count number default 0, --몇명인 입찰했는지
    category varchar(20) not null,
    trade_type varchar(30) not null, --어떤 종류 거래인지
    delivery varchar(30) default '무료배송', -- 선불/ 착불/ 무료배송
    delivery_cost number default 0 ,-- 택배비용
    onGoing char(1) default 'y' --진행중인지?
);

create sequence a_no_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

create table auction_img_board( --경매 게시판 이미지 테이블
    no number primary key,
    title_img varchar(300) not null,
    middle1_img varchar(300) not null,
    middle2_img varchar(300),
    middle3_img varchar(300),
    middle4_img varchar(300),
    middle5_img varchar(300),
    middle6_img varchar(300),
    middle7_img varchar(300),
    middle8_img varchar(300),
    middle9_img varchar(300),
    middle10_img varchar(300)
);

create sequence a_i_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

create table used_transaction_board( --중고거래 게시판 테이블
    no number primary key,
    id varchar(50),
    title varchar(100) not null,
    title_img varchar(300) not null,
    phone varchar(20) not null,
    contents varchar(3000) not null,
    viewCount number default 0,
    price number not null,
    member_class varchar(20) not null,
    account varchar(20) not null,
    category varchar(20) not null,
    trade_type varchar(30) not null,       -- 직거래? 안심거래?
    delivery varchar(30) default '무료배송',  -- 선불/ 착불/ 무료배송
    delivery_cost number default 0   ,      -- 택배비용
    joindate varchar(50) default to_char(sysdate,'YY-MM-DD HH:mi:ss'),
    onGoing char(1) default 'y'
);

create sequence u_no_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

create table used_transaction_img_board( --중고거래 게시판 이미지 테이블
    no number primary key,
    title_img varchar(300) not null,
    middle1_img varchar(300) not null,
    middle2_img varchar(300),
    middle3_img varchar(300),
    middle4_img varchar(300),
    middle5_img varchar(300),
    middle6_img varchar(300),
    middle7_img varchar(300),
    middle8_img varchar(300),
    middle9_img varchar(300),
    middle10_img varchar(300)
);

create sequence u_t_i_no_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

create table tender(--입찰 
    seq number ,
    board_num number not null,
    board_title varchar(100) not null,
    board_img varchar(100),
    id VARCHAR(100),
    point number,
    time timestamp default sysdate,
    ipaddress VARCHAR(20),
    onGoing char(1) default 'y'
);  

create sequence tender_seq
start with 1
increment by 1
nocache
nomaxvalue;

create table comments(-- 댓글
    seq number primary key,
    boardNum number not null,
    id varchar(30) not null,
    contents VARCHAR(500) not null,
    time timestamp default sysdate,
    ipaddress varchar(30) not null
);

create sequence comments_seq
start with 1
increment by 1
nocache
nomaxvalue;
create table order_t(
    seq number primary key,
    product_num number not null,
    product_title varchar(100) not null,
    product_img varchar(200) ,
    seller varchar(50) not null,
    buyer varchar (50)not null,
    price number not null,
    type varchar(50) not null,
    join_date timestamp default sysdate,
    situation varchar(100) default '입금완료' not null
);
create sequence order_seq
start with 1
increment by 1
nocache
nomaxvalue;

create table admin(		      -- 관리자(방문자 수) 테이블
no number primary key,
visitDate varchar2(50) default to_char(sysdate,'YY-MM-DD HH:mi:ss'),
visitCount number not null
);

create sequence admin_seq	      -- 관리자(방문자 수) 시퀀스
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

create table delivery( --배송 정보 t
	seq number primary key,
	product_num number not null,
	company_code number not null,
	waybill_num varchar(200) not null,
	sender varchar(100) not null,
	recipient varchar(100) not null
);
create sequence delivery_seq	      --배송 seq 
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

create table trade_cart(   --찜 목록
    id varchar(50),
    no number not null,
    title_img varchar(300) not null,
    title varchar(100) not null,
    trade_type varchar(30) not null,       -- 직거래? 안심거래?
    delivery varchar(30) not null, -- 선불/ 착불/ 무료배송
    price number not null
);

create table auction_cart(
    id varchar(50),
    no number not null,
    title_img varchar(300) not null,
    title varchar(100) not null,
    end_date varchar(50) not null,
    delivery varchar(30) not null,
    price number not null
);  
create table comments2(-- 댓글
    seq number primary key,
    boardNum number not null,
    id varchar(30) not null,
    contents VARCHAR(500) not null,
    time timestamp default sysdate,
    ipaddress varchar(30) not null
);

create sequence comments_seq2
start with 1
increment by 1
nocache
nomaxvalue;


update members set point = 1000000;
insert into members values('admin@admin.com','13a95c75b44f95ead23f47f0bf10667e57b44ec5150180c8a39a39361cf56169','admin',null,default,null,null,null,default,'a','admin','우수','n','y');
commit;
