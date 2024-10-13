-- USER INSERT
INSERT INTO USERS (user_id, user_name)
VALUES
    (1, '홍길동'),
    (2, '이순신'),
    (3, '김삿갓'),
    (4, '박문수'),
    (5, '최영'),
    (6, '강감찬'),
    (7, '유관순'),
    (8, '윤봉길'),
    (9, '안중근'),
    (10, '김구'),
    (11, '신사임당'),
    (12, '세종대왕'),
    (13, '정약용'),
    (14, '이황'),
    (15, '이이'),
    (16, '김좌진'),
    (17, '이성계'),
    (18, '장영실'),
    (19, '이방원'),
    (20, '문익점'),
    (21, '정몽주'),
    (22, '최무선'),
    (23, '이순근'),
    (24, '박연'),
    (25, '허준'),
    (26, '장희빈'),
    (27, '유비'),
    (28, '관우'),
    (29, '장비'),
    (30, '조조')
;

insert into TOKEN (TOKEN_ID,USER_ID,EXPIRED_DATE,TOKEN_STATUS,CREATE_DATE,UPDATE_DATE)
values
    (RANDOM_UUID(),1,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),2,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),3,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),4,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),5,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),6,TIMESTAMPADD(MINUTE, 5, now()),'ACTIVE',now(),now()),
    (RANDOM_UUID(),7,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),8,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),9,TIMESTAMPADD(MINUTE, 5, now()),'ACTIVE',now(),now()),
    (RANDOM_UUID(),10,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),11,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),12,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),13,TIMESTAMPADD(MINUTE, 5, now()),'ACTIVE',now(),now()),
    (RANDOM_UUID(),14,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),15,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),16,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),17,TIMESTAMPADD(MINUTE, 5, now()),'ACTIVE',now(),now()),
    (RANDOM_UUID(),18,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),19,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),20,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),21,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),22,TIMESTAMPADD(MINUTE, 5, now()),'WAITING',now(),now()),
    (RANDOM_UUID(),23,TIMESTAMPADD(MINUTE, 5, now()),'ACTIVE',now(),now()),
    (RANDOM_UUID(),24,TIMESTAMPADD(MINUTE, 5, now()),'ACTIVE',now(),now()),
    (RANDOM_UUID(),25,TIMESTAMPADD(MINUTE, 5, now()),'ACTIVE',now(),now())
;

insert into CONCERT (CONCERT_ID,CONCERT_NAME)
values
    (1,'드림캐쳐'),
    (2, '김영흠 소극장');

insert into CONCERT_SCHEDULE (SCHEDULE_ID,CONCERT_ID,START_TIME,RESERVATION_TIME,CURRENT_SEAT_COUNT,TOTAL_SEAT_COUNT)
values
    (1,1,'2024-12-17 12:00:00.000000','2024-11-17 00:00:00.000000',10,0),
    (2,1,'2024-12-18 13:00:00.000000','2024-11-17 00:00:00.000000',10,0),
    (3,2,'2024-12-17 12:00:00.000000','2024-11-17 00:00:00.000000',10,0),
    (4,2,'2024-12-18 13:00:00.000000','2024-11-17 00:00:00.000000',10,0)
;

insert into CONCERT_SEAT (SEAT_ID,SCHEDULE_ID,SEAT_POSITION,SEAT_PRICE,SEAT_STATUS)
values
    (1 ,1 ,'A1',30000 ,'EMPTY'),
    (2 ,1 ,'A2',30000 ,'EMPTY'),
    (3 ,1 ,'A3',30000 ,'EMPTY'),
    (4 ,1 ,'A4',30000 ,'EMPTY'),
    (5 ,1 ,'A5',30000 ,'EMPTY'),
    (6 ,1 ,'B1',50000 ,'EMPTY'),
    (7 ,1 ,'B2',50000 ,'EMPTY'),
    (8 ,1 ,'B3',50000 ,'EMPTY'),
    (9 ,1 ,'B4',50000 ,'EMPTY'),
    (10 ,1 ,'B5',50000 ,'EMPTY'),

    (11 ,2 ,'A1',30000 ,'EMPTY'),
    (12 ,2 ,'A2',30000 ,'EMPTY'),
    (13 ,2 ,'A3',30000 ,'EMPTY'),
    (14 ,2 ,'A4',30000 ,'EMPTY'),
    (15 ,2 ,'A5',30000 ,'EMPTY'),
    (16 ,2 ,'B1',50000 ,'EMPTY'),
    (17 ,2 ,'B2',50000 ,'EMPTY'),
    (18 ,2 ,'B3',50000 ,'EMPTY'),
    (19 ,2 ,'B4',50000 ,'EMPTY'),
    (110 ,2 ,'B5',50000 ,'EMPTY')
;
