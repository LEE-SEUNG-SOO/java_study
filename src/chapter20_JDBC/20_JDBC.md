# 20. JDBC(Java DataBase Connectivity) - java.sql.*

### 1. JDBC API를 이용한 연결 단계!!!  - JDBC driver 4번째 타입 : thin 형태
	0. 드라이버 설치		: mysql-connector~.jar 파일 bulid path에 추가
	1. 드라이버 로딩		: DriverManager
	2. Connection 생성	: Connection
	3. Statement 생성	: Statement, PrepareStatement(보안에 강함. 주로 사용)
	4. ResultSet 생성	: ResultSet
	5. SQL 실행 및 결과 생성 : 3번,4번 객체 사용	(executeQuery, executeUpdate)
	6. Close	: 사용한 모든 객체 종료

JAVA(JVM) <-------------------Driver------------------> MySQL

### 2. 