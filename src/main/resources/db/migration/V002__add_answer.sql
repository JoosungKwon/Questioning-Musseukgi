CREATE TABLE answer
(
    id        bigint       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    channel_id varchar(255) NOT NULL,
    content   text         NOT NULL,
    deleted   boolean      NOT NULL default false
);