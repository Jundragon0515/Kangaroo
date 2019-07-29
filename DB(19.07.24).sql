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
<<<<<<< HEAD
create table members( --È¸¿ø°¡ÀÔ Å×ÀÌºí
=======
create table members( --íšŒì›ê°€ìž… í…Œì´ë¸”
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
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
<<<<<<< HEAD
    member_class varchar(20) default 'º¸Åë',
    blacklist char(1) default 'n',
    admin char(1) default 'n'
);
create table title_img( --¸ÞÀÎÈ­¸é ÀÌ¹ÌÁö
=======
    member_class varchar(20) default 'ë³´í†µ',
    blacklist char(1) default 'n',
    admin char(1) default 'n'
);
create table title_img( --ë©”ì¸í™”ë©´ ì´ë¯¸ì§€
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
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

<<<<<<< HEAD
create table notice( --°øÁö»çÇ× Å×ÀÌºí
=======
create table notice( --ê³µì§€ì‚¬í•­ í…Œì´ë¸”
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
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

<<<<<<< HEAD
create table message( --ÂÊÁö Å×ÀÌºí
=======
create table message( --ìª½ì§€ í…Œì´ë¸”
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
    id varchar(50) not null,
    receiver varchar(50) not null,
    title varchar(100) not null,
    contents varchar(3000) not null,
     joindate timestamp default sysdate
);

<<<<<<< HEAD
create table payments( --°áÁ¦ Å×ÀÌºí
=======
create table payments( --ê²°ì œ í…Œì´ë¸”
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
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

<<<<<<< HEAD
create table inquiring( --´ñ±Û Å×ÀÌºí
=======
create table inquiring( --ëŒ“ê¸€ í…Œì´ë¸”
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
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

<<<<<<< HEAD
create table report( --½Å°í Å×ÀÌºí
=======
create table report( --ì‹ ê³  í…Œì´ë¸”
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
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

<<<<<<< HEAD
create table point_using( --Æ÷ÀÎÆ® »ç¿ë³»¿ª
=======
create table point_using( --í¬ì¸íŠ¸ ì‚¬ìš©ë‚´ì—­
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
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
<<<<<<< HEAD
create table point_charging( --Æ÷ÀÎÆ® ÃæÀü³»¿ª
=======
create table point_charging( --í¬ì¸íŠ¸ ì¶©ì „ë‚´ì—­
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
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

<<<<<<< HEAD
create table auction_board( --°æ¸Å °Ô½ÃÆÇ
=======
create table auction_board( --ê²½ë§¤ ê²Œì‹œíŒ
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
    no number primary key,
    id varchar(50) not null,
    title varchar(100) not null,
    title_img varchar(300) not null,
    phone varchar(20) not null,
    contents varchar(3000) not null,
    viewCount number default 0,
<<<<<<< HEAD
    start_date varchar(50) default to_char(sysdate,'YY-MM-DD HH:mi:ss'),   -- ½ÃÀÛÀÏ
    end_date varchar(50) not null,  -- Á¾·áÀÏ
    starting_price number not null, -- ½ÃÀÛ°¡
    min_price number not null,      -- ÃÖ¼Ò ÀÔÂû ´ÜÀ§
    present_price number default 0, -- ÇöÀç°¡
    member_class varchar(20) not null, -- È¸¿øµî±Þ
    account varchar(30) not null,      --°èÁÂ
    bid_count number default 0, --¸î¸íÀÎ ÀÔÂûÇß´ÂÁö
    category varchar(20) not null,
    trade_type varchar(30) not null, --¾î¶² Á¾·ù °Å·¡ÀÎÁö
    delivery varchar(30) default '¹«·á¹è¼Û', -- ¼±ºÒ/ ÂøºÒ/ ¹«·á¹è¼Û
    delivery_cost number default 0 ,-- ÅÃ¹èºñ¿ë
    onGoing char(1) default 'y' --ÁøÇàÁßÀÎÁö?
=======
    start_date varchar(50) default to_char(sysdate,'YY-MM-DD HH:mi:ss'),   -- ì‹œìž‘ì¼
    end_date varchar(50) not null,  -- ì¢…ë£Œì¼
    starting_price number not null, -- ì‹œìž‘ê°€
    min_price number not null,      -- ìµœì†Œ ìž…ì°° ë‹¨ìœ„
    present_price number default 0, -- í˜„ìž¬ê°€
    member_class varchar(20) not null, -- íšŒì›ë“±ê¸‰
    bid_count number default 0, --ëª‡ëª…ì¸ ìž…ì°°í–ˆëŠ”ì§€
    category varchar(20) not null,
    delivery varchar(30) default 'ë¬´ë£Œë°°ì†¡', -- ì„ ë¶ˆ/ ì°©ë¶ˆ/ ë¬´ë£Œë°°ì†¡
    delivery_cost number default 0 ,-- íƒë°°ë¹„ìš©
    onGoing char(1) default 'y' --ì§„í–‰ì¤‘ì¸ì§€?
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
);

create sequence a_no_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

<<<<<<< HEAD
create table auction_img_board( --°æ¸Å °Ô½ÃÆÇ ÀÌ¹ÌÁö Å×ÀÌºí
=======
create table auction_img_board( --ê²½ë§¤ ê²Œì‹œíŒ ì´ë¯¸ì§€ í…Œì´ë¸”
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
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

<<<<<<< HEAD
create table used_transaction_board( --Áß°í°Å·¡ °Ô½ÃÆÇ Å×ÀÌºí
=======
create table used_transaction_board( --ì¤‘ê³ ê±°ëž˜ ê²Œì‹œíŒ í…Œì´ë¸”
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
    no number primary key,
    id varchar(50),
    title varchar(100) not null,
    title_img varchar(300) not null,
    phone varchar(20) not null,
    contents varchar(3000) not null,
    viewCount number default 0,
    price number not null,
    member_class varchar(20) not null,
<<<<<<< HEAD
    account varchar(20) not null,
    category varchar(20) not null,
    trade_type varchar(30) not null,       -- Á÷°Å·¡? ¾È½É°Å·¡?
    delivery varchar(30) default '¹«·á¹è¼Û',  -- ¼±ºÒ/ ÂøºÒ/ ¹«·á¹è¼Û
    delivery_cost number default 0   ,      -- ÅÃ¹èºñ¿ë
=======
    category varchar(20) not null,
    trade_type varchar(30) not null,       -- ì§ê±°ëž˜? ì•ˆì‹¬ê±°ëž˜?
    delivery varchar(30) default 'ë¬´ë£Œë°°ì†¡',  -- ì„ ë¶ˆ/ ì°©ë¶ˆ/ ë¬´ë£Œë°°ì†¡
    delivery_cost number default 0   ,      -- íƒë°°ë¹„ìš©
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
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

<<<<<<< HEAD
create table used_transaction_img_board( --Áß°í°Å·¡ °Ô½ÃÆÇ ÀÌ¹ÌÁö Å×ÀÌºí
=======
create table used_transaction_img_board( --ì¤‘ê³ ê±°ëž˜ ê²Œì‹œíŒ ì´ë¯¸ì§€ í…Œì´ë¸”
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
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

<<<<<<< HEAD
create table tender(--ÀÔÂû 
=======
create table tender(--ìž…ì°° 
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
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

<<<<<<< HEAD
create table comments(-- ´ñ±Û
=======
create table comments(-- ëŒ“ê¸€
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
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
<<<<<<< HEAD
    situation varchar(100) default 'ÀÔ±Ý¿Ï·á' not null
=======
    situation varchar(100) default 'ìž…ê¸ˆì™„ë£Œ' not null
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
);
create sequence order_seq
start with 1
increment by 1
nocache
nomaxvalue;

<<<<<<< HEAD
create table admin(		      -- °ü¸®ÀÚ(¹æ¹®ÀÚ ¼ö) Å×ÀÌºí
=======
create table admin(		      -- ê´€ë¦¬ìž(ë°©ë¬¸ìž ìˆ˜) í…Œì´ë¸”
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
no number primary key,
visitDate varchar2(50) default to_char(sysdate,'YY-MM-DD HH:mi:ss'),
visitCount number not null
);

<<<<<<< HEAD
create sequence admin_seq	      -- °ü¸®ÀÚ(¹æ¹®ÀÚ ¼ö) ½ÃÄö½º
=======
create sequence admin_seq	      -- ê´€ë¦¬ìž(ë°©ë¬¸ìž ìˆ˜) ì‹œí€€ìŠ¤
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

<<<<<<< HEAD
create table delivery( --¹è¼Û Á¤º¸ t
=======
create table delivery( --ë°°ì†¡ ì •ë³´ t
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
	seq number primary key,
	product_num number not null,
	company_code number not null,
	waybill_num varchar(200) not null,
	sender varchar(100) not null,
	recipient varchar(100) not null
);
<<<<<<< HEAD
create sequence delivery_seq	      --¹è¼Û seq 
=======
create sequence delivery_seq	      --ë°°ì†¡ seq 
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

<<<<<<< HEAD
create table trade_cart(   --Âò ¸ñ·Ï
=======
create table trade_cart(   --ì°œ ëª©ë¡
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
    id varchar(50),
    no number not null,
    title_img varchar(300) not null,
    title varchar(100) not null,
<<<<<<< HEAD
    trade_type varchar(30) not null,       -- Á÷°Å·¡? ¾È½É°Å·¡?
    delivery varchar(30) not null, -- ¼±ºÒ/ ÂøºÒ/ ¹«·á¹è¼Û
=======
    trade_type varchar(30) not null,       -- ì§ê±°ëž˜? ì•ˆì‹¬ê±°ëž˜?
    category varchar(50) not null,
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
    price number not null
);

create table auction_cart(
    id varchar(50),
    no number not null,
    title_img varchar(300) not null,
    title varchar(100) not null,
    end_date varchar(50) not null,
<<<<<<< HEAD
    delivery varchar(30) not null,
    price number not null
);  
create table comments2(-- ´ñ±Û
=======
    category varchar(30) not null,
    price number not null
);  
create table comments2(-- ëŒ“ê¸€
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
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


<<<<<<< HEAD
update members set point = 1000000;
insert into members values('admin@admin.com','13a95c75b44f95ead23f47f0bf10667e57b44ec5150180c8a39a39361cf56169','admin',null,default,null,null,null,default,'a','admin','¿ì¼ö','n','y');
=======

insert into members values('admin@admin.com','13a95c75b44f95ead23f47f0bf10667e57b44ec5150180c8a39a39361cf56169','admin',null,default,null,null,null,default,'a','admin','ìš°ìˆ˜','n','y');
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
commit;
