# spring_security_oauth_github
<a href="https://github.com/vincenttuan/micro-servicce-2022/tree/master/spring_security_oauth2_github">段老師 Github(github google oauth)</a><br/>
<a href="https://github.com/vincenttuan/micro-servicce-2022/tree/master/spring_security_csrf_client">段老師 Github(CRSF client)</a><br/>
<a href="https://github.com/vincenttuan/micro-servicce-2022/tree/master/spring_security_csrf_attack">段老師 Github(CRSF attack)</a><br/>
<pre>
MySQL 資料庫建立：
CREATE DATABASE springbatch DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci

pom.xml：
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-batch</artifactId>
</dependency>
<!-- 使用 Spring Batch 加入  MySQL 資料庫依賴 -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>

application.yml：
spring:
  datasource:
    username: root
    url: jdbc:mysql://localhost:3306/springbatch
    driverClassName: com.mysql.cj.jdbc.Driver
    password: '12345678'
  batch:
    jdbc:
      initialize-schema: always
  sql:
    init:
      schema-locations: classpath:/org/springframework/batch/core/schema-mysql.sql
</pre>
