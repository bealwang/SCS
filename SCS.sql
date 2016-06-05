create database SCS;

use SCS;

create table user (
    phone_number VARCHAR(20) PRIMARY KEY NOT NULL,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user (phone_number,username,password) values 
("18810374823","王彪你好","123456"),
("18810374822","孟轲","123456"),
("18810374824","张云尧","123456");
("18810374825","刘晓丽","123456");
("18810374826","刘志升","123456");

create table message (
    ms_id int(11) NOT NULL AUTO_INCREMENT,
    owner VARCHAR(20),
    ms_title VARCHAR(20) NOT NULL,
    ms_body  VARCHAR(500) NOT NULL,
 	 ms_time timestamp NOT NULL default CURRENT_TIMESTAMP,
    PRIMARY KEY(ms_id),
    FOREIGN KEY(owner) REFERENCES user(phone_number) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into message (owner,ms_title,ms_body) values 
("18810374823","wangbiao","Hello World!"),
("18810374823","wangbiao","Hello Worl!"),
("18810374823","wangbiao","Hello Wor!"),
("18810374822","孟轲","孟轲你好"),
("18810374824","张云尧","王彪你好"),
("18810374824","张云尧","张云尧你好"),
("18810374824","张云尧","孟轲你好");

