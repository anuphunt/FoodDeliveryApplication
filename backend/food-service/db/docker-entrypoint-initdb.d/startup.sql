CREATE USER 'demo_java' IDENTIFIED BY 'java';
grant all on *.* to 'demo_java'@'%' identified by '1234';
FLUSH PRIVILEGES;

CREATE DATABASE hello_java CHARACTER SET utf8 COLLATE utf8_general_ci;

