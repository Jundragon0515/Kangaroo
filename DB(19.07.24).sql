select * from members;
update members set member_class = '플래티넘' where id = 'kjjmmm123@naver.com';
update members set point = 1000000000 where id = 'kjjmmm123@naver.com';
commit;
select nvl(sum(money),0) from point_charging;

select * from point_charging;

select * from auctionboard;

select * from AUCTION_BOARD;