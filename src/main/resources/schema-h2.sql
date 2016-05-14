insert into Board (name, create_at) values ('notice', now());
insert into Board (name, create_at) values ('random', now());

CREATE TABLE cnu_board (
  post_id int(10) NOT NULL AUTO_INCREMENT,
  author varchar(32) NOT NULL,
  password varchar(32) NOT NULL,
  title varchar(255) NOT NULL,
  content text NOT NULL DEFAULT '',
  create_time datetime NOT NULL,
  is_del tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (post_id)
);

CREATE TABLE cnu_board_comment (
  comment_id int(10) NOT NULL AUTO_INCREMENT,
  board_id int(10) NOT NULL,
  author varchar(32) NOT NULL,
  password varchar(32) NOT NULL,
  comment text NOT NULL DEFAULT '',
  create_time datetime NOT NULL,
  is_del tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (comment_id)
);
