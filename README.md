## 1. 서울시 병의원 분석
### line package

- dao
  - HospitalDao
- domain
  - Hospital : 병원 정보 매핑
    - SQL 쿼리문 변경 메서드
- parser
  - HospitalParser : 서울시 병원 csv파일에서 파싱
  - Parser : 파싱 인터페이스
- LineReader
  - csv 파일 읽기
- Main
  1. 서울시 병의원 위치 정보 csv 읽기
  2. 특정 컬럼만 파싱해서 SQL 쿼리문으로 변경
  3. hospital_query 파일에 저장


# 2. DB 연동 실습
### dbexercise package
### dbexercise2 package