# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table catalog (
  id                            bigint auto_increment not null,
  price                         integer,
  name                          varchar(255),
  intro                         varchar(255),
  img_url                       varchar(255),
  constraint pk_catalog primary key (id)
);


# --- !Downs

drop table if exists catalog;

