-- init SQL
-- create database app;
-- use app;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS question;


CREATE TABLE users
(
    id                bigint       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nickname          varchar(20)  NOT NULL,
    musseukgi_name    varchar(20)  NOT NULL,
    icon_emoji        varchar(20)  NOT NULL,
    channel           varchar(30)  NOT NULL,
    slack_webhook_url varchar(255) NOT NULL,
    generator_type    varchar(20)  NOT NULL,
    sender_name       varchar(20)  NOT NULL,
    notification_time time         NOT NULL,
    deleted           boolean      NOT NULL default false
);

CREATE TABLE question
(
    id      bigint       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    subject varchar(255) NOT NULL,
    content text         NOT NULL,
    deleted boolean      NOT NULL default false
);
