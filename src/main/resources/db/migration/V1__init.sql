create table favorite
(
    id      int auto_increment
        primary key,
    user_id  int not null,
    image_id int not null
);



create table gallery
(
    id   int auto_increment
        primary key,
    title varchar(255) not null,
    sub_title varchar(255) not null,
     url varchar(255) not null
);


create table image
(
    id        int auto_increment
        primary key,
    url     varchar(255) not null,
    gallery_id int          null,
        foreign key (gallery_id) references gallery (id)
);


create table user
(
    id          int auto_increment
        primary key,
    name        varchar(50)  not null,
    email       varchar(255) not null,
    password    varchar(255) not null,
    phone       varchar(20)  not null,
    enabled boolean NOT NULL

);

CREATE TABLE `verification_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `expiry_date` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `profile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)

  );

