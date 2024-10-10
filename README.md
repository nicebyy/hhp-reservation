# [항해+] Concert Reservation Service

## 기술스택
- Language: java18
- Framework: SpringBoot 3.2
- DB: H2DB (ORM: JPA)
- Architecture: Clean Layered Architecture

## Project MileStone
### https://github.com/nicebyy/hhp-reservation/milestone/1
### https://github.com/users/nicebyy/projects/3/views/1

## Sequance Diagram

### 1.유저 토큰 발급

![1 유저토큰발급](https://github.com/user-attachments/assets/2f949836-65d6-420d-b3aa-fe80cdade7d2)

### 2.예약 가능 날짜 조회
![2 예약가능날짜 조회](https://github.com/user-attachments/assets/c6558efb-f0bd-42e8-9caf-7085ae0a1a3a)

### 3.콘서트 좌석 조회
![3  콘서트 좌석 조회](https://github.com/user-attachments/assets/589d512b-b04c-4c96-86f5-f0b7de4cd3ef)

### 4.콘서트 좌석 임시 배정
![4  콘서트 좌석 임시배정](https://github.com/user-attachments/assets/a47cd74a-1cf6-4d19-880d-7a80a01b59bc)

### 5.잔액 충전 요청
![5  잔액 충전 요청](https://github.com/user-attachments/assets/27381626-037f-4d82-bf91-e29e53b1be09)

### 6.잔액 조회 결과 반환
![6  잔액 조회 결과 반환](https://github.com/user-attachments/assets/49d9ccae-63e9-4897-95d4-983ed014fb93)

### 7.좌석 결제
![7  좌석 결제](https://github.com/user-attachments/assets/9b4edae7-2a2d-4cb6-97eb-a7b7d1591840)

## ERD
![image](https://github.com/user-attachments/assets/ad49b307-09b4-4a24-8104-09d7e81c571a)

1. User: 좌석을 예약할 주최인 사용자. 예약에 필요한 결제금액인 point 를 가지고 있음 
2. Token: User 값을 기반으로 생성되며 추가로 대기열에 대한 정보와 토큰 상태값을 가지고 있음
3. Concert: 이번 프로젝트 오브젝트인 콘서트 테이블 
4. ConcertSchedule: 하나의 콘서트는 여러개의 스케쥴을 만들 수 있으며 1:N 관계. 예약가능한 날짜와 콘서트 시작 시간 정보를 가지고 있음.
5. ConcertSeat: 하나의 콘서트 타임에 속한 여러개의 좌석을 가질 수 있으며 1:N 관계. 위치와 가격 정보를 가지고 있음
6. Reservation: 좌석 정보와 유저 정보를 조합하여 하나의 예약을 나타낼 수 있음. 추가로 임시배정, 예약완료 등의 상태를 나타낼 수 있음
7. Payment: 예약이 완료되면 해당 예약에 대한 결제정보를 생성하여 나타낼 수 있음.  

## API 명세
https://www.postman.com/science-technologist-19645978/my-workspace/documentation/et34weu/hhp-reservationservice?workspaceId=4f108718-9872-44b3-8026-8b88d8ac42a4
