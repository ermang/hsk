INSERT INTO city(id, version, name) VALUES (1, 0, 'ISTANBUL');
INSERT INTO facility(id, version, city_id, name) VALUES (1, 0, 1, 'OSMAN SPOR TESISLERI');
INSERT INTO pitch (id, version, pitch_type, facility_id) VALUES (1, 0, 'FOOTBALL', 1);