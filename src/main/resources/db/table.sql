create table if not exists FEED_DATA (
id int not null primary key auto_increment,
title varchar(225) not null,
description clob,
link varchar(225),
author VARCHAR(50) not null,
pubdate VARCHAR(50),
creator VARCHAR(50));