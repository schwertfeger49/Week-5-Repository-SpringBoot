use birds;
insert into bird_names(type_id, bird_name) values (22, 'American Robin');
insert into locations(city, state) values ('Missoula', 'Montana');
insert into users(username) values ('schwertfeger49');
insert into sightings(bird_id, location_id, user_id, date_time) values (1, 1, 1, '2021-06-01 12:00:00');

INSERT into bird_names(type_id, bird_name) values (type_names.type_id, 'Osprey') JOIN type_names on type_id WHERE type_names.type_name = 'Falconiformes';
INSERT into bird_names(type_id, bird_name) values ((SELECT type_id FROM type_names WHERE type_name = 'Falconiformes'), 'Osprey');