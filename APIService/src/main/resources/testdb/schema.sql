drop table projects if exists;

create table projects (ID bigint PRIMARY KEY, STATUS varchar(19),
                        NAME varchar(50) not null, unique(NAME));

drop table users if exists;

create table users (ID bigint PRIMARY KEY, FULL_NAME varchar(50),
                    LOGIN_NAME varchar(50) not null, PASSWORD varchar(50), PROJECTS varchar(50), unique(LOGIN_NAME));





