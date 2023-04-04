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

INSERT INTO app.users (nickname, musseukgi_name, icon_emoji, channel, slack_webhook_url, generator_type, sender_name,
                       notification_time, deleted)
VALUES ('테스트 중', '테스트하는 머쓱이', ':thx_mussg:', 'test_kwon',
        'https://hooks.slack.com/services/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', 'random', 'slack',
        '2023-04-04 16:20:37', DEFAULT)