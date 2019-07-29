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
<<<<<<< HEAD
create table members( --»∏ø¯∞°¿‘ ≈◊¿Ã∫Ì
=======
create table members( --ÌöåÏõêÍ∞ÄÏûÖ ÌÖåÏù¥Î∏î
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table members( --ÌöåÏõêÍ∞ÄÏûÖ ÌÖåÏù¥Î∏î
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
    member_class varchar(20) default '∫∏≈Î',
    blacklist char(1) default 'n',
    admin char(1) default 'n'
);
create table title_img( --∏ﬁ¿Œ»≠∏È ¿ÃπÃ¡ˆ
=======
=======
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
    member_class varchar(20) default 'Î≥¥ÌÜµ',
    blacklist char(1) default 'n',
    admin char(1) default 'n'
);
create table title_img( --Î©îÏù∏ÌôîÎ©¥ Ïù¥ÎØ∏ÏßÄ
<<<<<<< HEAD
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
create table notice( --∞¯¡ˆªÁ«◊ ≈◊¿Ã∫Ì
=======
create table notice( --Í≥µÏßÄÏÇ¨Ìï≠ ÌÖåÏù¥Î∏î
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table notice( --Í≥µÏßÄÏÇ¨Ìï≠ ÌÖåÏù¥Î∏î
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
create table message( --¬ ¡ˆ ≈◊¿Ã∫Ì
=======
create table message( --Ï™ΩÏßÄ ÌÖåÏù¥Î∏î
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table message( --Ï™ΩÏßÄ ÌÖåÏù¥Î∏î
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
    id varchar(50) not null,
    receiver varchar(50) not null,
    title varchar(100) not null,
    contents varchar(3000) not null,
     joindate timestamp default sysdate
);

<<<<<<< HEAD
<<<<<<< HEAD
create table payments( --∞·¡¶ ≈◊¿Ã∫Ì
=======
create table payments( --Í≤∞Ï†ú ÌÖåÏù¥Î∏î
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table payments( --Í≤∞Ï†ú ÌÖåÏù¥Î∏î
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
create table inquiring( --¥Ò±€ ≈◊¿Ã∫Ì
=======
create table inquiring( --ÎåìÍ∏Ä ÌÖåÏù¥Î∏î
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table inquiring( --ÎåìÍ∏Ä ÌÖåÏù¥Î∏î
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
create table report( --Ω≈∞Ì ≈◊¿Ã∫Ì
=======
create table report( --Ïã†Í≥† ÌÖåÏù¥Î∏î
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table report( --Ïã†Í≥† ÌÖåÏù¥Î∏î
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
create table point_using( --∆˜¿Œ∆Æ ªÁøÎ≥ªø™
=======
create table point_using( --Ìè¨Ïù∏Ìä∏ ÏÇ¨Ïö©ÎÇ¥Ïó≠
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table point_using( --Ìè¨Ïù∏Ìä∏ ÏÇ¨Ïö©ÎÇ¥Ïó≠
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
create table point_charging( --∆˜¿Œ∆Æ √Ê¿¸≥ªø™
=======
create table point_charging( --Ìè¨Ïù∏Ìä∏ Ï∂©Ï†ÑÎÇ¥Ïó≠
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table point_charging( --Ìè¨Ïù∏Ìä∏ Ï∂©Ï†ÑÎÇ¥Ïó≠
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
create table auction_board( --∞Ê∏≈ ∞‘Ω√∆«
=======
create table auction_board( --Í≤ΩÎß§ Í≤åÏãúÌåê
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table auction_board( --Í≤ΩÎß§ Í≤åÏãúÌåê
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
    no number primary key,
    id varchar(50) not null,
    title varchar(100) not null,
    title_img varchar(300) not null,
    phone varchar(20) not null,
    contents varchar(3000) not null,
    viewCount number default 0,
<<<<<<< HEAD
<<<<<<< HEAD
    start_date varchar(50) default to_char(sysdate,'YY-MM-DD HH:mi:ss'),   -- Ω√¿€¿œ
    end_date varchar(50) not null,  -- ¡æ∑·¿œ
    starting_price number not null, -- Ω√¿€∞°
    min_price number not null,      -- √÷º“ ¿‘¬˚ ¥‹¿ß
    present_price number default 0, -- «ˆ¿Á∞°
    member_class varchar(20) not null, -- »∏ø¯µÓ±ﬁ
    account varchar(30) not null,      --∞Ë¡¬
    bid_count number default 0, --∏Ó∏Ì¿Œ ¿‘¬˚«ﬂ¥¬¡ˆ
    category varchar(20) not null,
    trade_type varchar(30) not null, --æÓ∂≤ ¡æ∑˘ ∞≈∑°¿Œ¡ˆ
    delivery varchar(30) default 'π´∑·πËº€', -- º±∫“/ ¬¯∫“/ π´∑·πËº€
    delivery_cost number default 0 ,-- ≈√πË∫ÒøÎ
    onGoing char(1) default 'y' --¡¯«‡¡ﬂ¿Œ¡ˆ?
=======
=======
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
    start_date varchar(50) default to_char(sysdate,'YY-MM-DD HH:mi:ss'),   -- ÏãúÏûëÏùº
    end_date varchar(50) not null,  -- Ï¢ÖÎ£åÏùº
    starting_price number not null, -- ÏãúÏûëÍ∞Ä
    min_price number not null,      -- ÏµúÏÜå ÏûÖÏ∞∞ Îã®ÏúÑ
    present_price number default 0, -- ÌòÑÏû¨Í∞Ä
    member_class varchar(20) not null, -- ÌöåÏõêÎì±Í∏â
    bid_count number default 0, --Î™áÎ™ÖÏù∏ ÏûÖÏ∞∞ÌñàÎäîÏßÄ
    category varchar(20) not null,
    delivery varchar(30) default 'Î¨¥Î£åÎ∞∞ÏÜ°', -- ÏÑ†Î∂à/ Ï∞©Î∂à/ Î¨¥Î£åÎ∞∞ÏÜ°
    delivery_cost number default 0 ,-- ÌÉùÎ∞∞ÎπÑÏö©
    onGoing char(1) default 'y' --ÏßÑÌñâÏ§ëÏù∏ÏßÄ?
<<<<<<< HEAD
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
);

create sequence a_no_seq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

<<<<<<< HEAD
<<<<<<< HEAD
create table auction_img_board( --∞Ê∏≈ ∞‘Ω√∆« ¿ÃπÃ¡ˆ ≈◊¿Ã∫Ì
=======
create table auction_img_board( --Í≤ΩÎß§ Í≤åÏãúÌåê Ïù¥ÎØ∏ÏßÄ ÌÖåÏù¥Î∏î
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table auction_img_board( --Í≤ΩÎß§ Í≤åÏãúÌåê Ïù¥ÎØ∏ÏßÄ ÌÖåÏù¥Î∏î
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
create table used_transaction_board( --¡ﬂ∞Ì∞≈∑° ∞‘Ω√∆« ≈◊¿Ã∫Ì
=======
create table used_transaction_board( --Ï§ëÍ≥†Í±∞Îûò Í≤åÏãúÌåê ÌÖåÏù¥Î∏î
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table used_transaction_board( --Ï§ëÍ≥†Í±∞Îûò Í≤åÏãúÌåê ÌÖåÏù¥Î∏î
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
    account varchar(20) not null,
    category varchar(20) not null,
    trade_type varchar(30) not null,       -- ¡˜∞≈∑°? æ»Ω…∞≈∑°?
    delivery varchar(30) default 'π´∑·πËº€',  -- º±∫“/ ¬¯∫“/ π´∑·πËº€
    delivery_cost number default 0   ,      -- ≈√πË∫ÒøÎ
=======
=======
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
    category varchar(20) not null,
    trade_type varchar(30) not null,       -- ÏßÅÍ±∞Îûò? ÏïàÏã¨Í±∞Îûò?
    delivery varchar(30) default 'Î¨¥Î£åÎ∞∞ÏÜ°',  -- ÏÑ†Î∂à/ Ï∞©Î∂à/ Î¨¥Î£åÎ∞∞ÏÜ°
    delivery_cost number default 0   ,      -- ÌÉùÎ∞∞ÎπÑÏö©
<<<<<<< HEAD
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
create table used_transaction_img_board( --¡ﬂ∞Ì∞≈∑° ∞‘Ω√∆« ¿ÃπÃ¡ˆ ≈◊¿Ã∫Ì
=======
create table used_transaction_img_board( --Ï§ëÍ≥†Í±∞Îûò Í≤åÏãúÌåê Ïù¥ÎØ∏ÏßÄ ÌÖåÏù¥Î∏î
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table used_transaction_img_board( --Ï§ëÍ≥†Í±∞Îûò Í≤åÏãúÌåê Ïù¥ÎØ∏ÏßÄ ÌÖåÏù¥Î∏î
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
create table tender(--¿‘¬˚ 
=======
create table tender(--ÏûÖÏ∞∞ 
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table tender(--ÏûÖÏ∞∞ 
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
create table comments(-- ¥Ò±€
=======
create table comments(-- ÎåìÍ∏Ä
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table comments(-- ÎåìÍ∏Ä
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
    situation varchar(100) default '¿‘±›øœ∑·' not null
=======
    situation varchar(100) default 'ÏûÖÍ∏àÏôÑÎ£å' not null
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
    situation varchar(100) default 'ÏûÖÍ∏àÏôÑÎ£å' not null
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
);
create sequence order_seq
start with 1
increment by 1
nocache
nomaxvalue;

<<<<<<< HEAD
<<<<<<< HEAD
create table admin(		      -- ∞¸∏Æ¿⁄(πÊπÆ¿⁄ ºˆ) ≈◊¿Ã∫Ì
=======
create table admin(		      -- Í¥ÄÎ¶¨Ïûê(Î∞©Î¨∏Ïûê Ïàò) ÌÖåÏù¥Î∏î
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table admin(		      -- Í¥ÄÎ¶¨Ïûê(Î∞©Î¨∏Ïûê Ïàò) ÌÖåÏù¥Î∏î
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
no number primary key,
visitDate varchar2(50) default to_char(sysdate,'YY-MM-DD HH:mi:ss'),
visitCount number not null
);

<<<<<<< HEAD
<<<<<<< HEAD
create sequence admin_seq	      -- ∞¸∏Æ¿⁄(πÊπÆ¿⁄ ºˆ) Ω√ƒˆΩ∫
=======
create sequence admin_seq	      -- Í¥ÄÎ¶¨Ïûê(Î∞©Î¨∏Ïûê Ïàò) ÏãúÌÄÄÏä§
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create sequence admin_seq	      -- Í¥ÄÎ¶¨Ïûê(Î∞©Î¨∏Ïûê Ïàò) ÏãúÌÄÄÏä§
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

<<<<<<< HEAD
<<<<<<< HEAD
create table delivery( --πËº€ ¡§∫∏ t
=======
create table delivery( --Î∞∞ÏÜ° Ï†ïÎ≥¥ t
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table delivery( --Î∞∞ÏÜ° Ï†ïÎ≥¥ t
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
	seq number primary key,
	product_num number not null,
	company_code number not null,
	waybill_num varchar(200) not null,
	sender varchar(100) not null,
	recipient varchar(100) not null
);
<<<<<<< HEAD
<<<<<<< HEAD
create sequence delivery_seq	      --πËº€ seq 
=======
create sequence delivery_seq	      --Î∞∞ÏÜ° seq 
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create sequence delivery_seq	      --Î∞∞ÏÜ° seq 
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

<<<<<<< HEAD
<<<<<<< HEAD
create table trade_cart(   --¬Ú ∏Ò∑œ
=======
create table trade_cart(   --Ï∞ú Î™©Î°ù
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
create table trade_cart(   --Ï∞ú Î™©Î°ù
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
    id varchar(50),
    no number not null,
    title_img varchar(300) not null,
    title varchar(100) not null,
<<<<<<< HEAD
<<<<<<< HEAD
    trade_type varchar(30) not null,       -- ¡˜∞≈∑°? æ»Ω…∞≈∑°?
    delivery varchar(30) not null, -- º±∫“/ ¬¯∫“/ π´∑·πËº€
=======
    trade_type varchar(30) not null,       -- ÏßÅÍ±∞Îûò? ÏïàÏã¨Í±∞Îûò?
    category varchar(50) not null,
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
    trade_type varchar(30) not null,       -- ÏßÅÍ±∞Îûò? ÏïàÏã¨Í±∞Îûò?
    category varchar(50) not null,
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
    price number not null
);

create table auction_cart(
    id varchar(50),
    no number not null,
    title_img varchar(300) not null,
    title varchar(100) not null,
    end_date varchar(50) not null,
<<<<<<< HEAD
<<<<<<< HEAD
    delivery varchar(30) not null,
    price number not null
);  
create table comments2(-- ¥Ò±€
=======
=======
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
    category varchar(30) not null,
    price number not null
);  
create table comments2(-- ÎåìÍ∏Ä
<<<<<<< HEAD
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
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
<<<<<<< HEAD
update members set point = 1000000;
insert into members values('admin@admin.com','13a95c75b44f95ead23f47f0bf10667e57b44ec5150180c8a39a39361cf56169','admin',null,default,null,null,null,default,'a','admin','øÏºˆ','n','y');
=======

insert into members values('admin@admin.com','13a95c75b44f95ead23f47f0bf10667e57b44ec5150180c8a39a39361cf56169','admin',null,default,null,null,null,default,'a','admin','Ïö∞Ïàò','n','y');
>>>>>>> f5ac47c307626585a93715a9fe3db152f37b2db1
=======

insert into members values('admin@admin.com','13a95c75b44f95ead23f47f0bf10667e57b44ec5150180c8a39a39361cf56169','admin',null,default,null,null,null,default,'a','admin','Ïö∞Ïàò','n','y');
>>>>>>> 14142d8e3e049b241370c33bbb8d6f94789ff56c
commit;
