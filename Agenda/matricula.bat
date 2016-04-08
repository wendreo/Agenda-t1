


@echo off 
start "LOCAL HOST:8080" "http://localhost:8080/"

d:
cd D:\Guilherme\matricula
mvn  -DskipTests=true spring-boot:run 