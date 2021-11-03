create database if not exists birds;
use birds;
drop table if exists sightings;
drop table if exists bird_names;
drop table if exists type_names;
drop table if exists locations;
drop table if exists users;
create table type_names(
	type_id int(10) not null auto_increment,
	type_name varchar(25) not null,
	type_description varchar(150) not null,
	primary key(type_id)
);
create table bird_names(
	bird_id int(10) not null auto_increment,
	type_id int(10) not null,
	bird_name varchar(25) not null,
	primary key(bird_id),
	foreign key(type_id) references type_names(type_id)
);
create table locations(
	location_id int(10) not null auto_increment,
	city varchar(25) not null,
	state varchar(25) not null,
	primary key(location_id)
);
create table users(
	user_id int(10) not null auto_increment,
	username varchar(25) not null,
	primary key(user_id)
);
create table sightings(
	sighting_id int(10) not null auto_increment,
	bird_id int(10) not null,
	location_id int(10) not null,
	user_id int(10) not null,
	date_time datetime not null,
	primary key(sighting_id),
	foreign key(bird_id) references bird_names(bird_id),
	foreign key(location_id) references locations(location_id),
	foreign key(user_id) references users(user_id)
);