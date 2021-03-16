DROP TABLE IF EXISTS USER;

create table user (
    id varchar(40) not null,
    name varchar(40) not null,
    password varchar(40) not null,
    PRIMARY KEY (_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
