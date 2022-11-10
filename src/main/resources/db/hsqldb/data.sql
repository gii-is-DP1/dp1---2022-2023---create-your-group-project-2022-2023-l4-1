
-- One admin user, named admin1 with passwor 4dm1n and authority admin
INSERT INTO users(username,password,enabled,nombre,foto_perfil,biografia) VALUES ('admin1','4dm1n',TRUE,'admin','nada','hola');
INSERT INTO authorities(id,username,authority) VALUES (1,'admin1','admin');
-- One owner user, named owner1 with passwor 0wn3r
INSERT INTO users(username,password,enabled,nombre,foto_perfil,biografia) VALUES ('owner1','0wn3r',TRUE,'owner','nada','hola');
INSERT INTO authorities(id,username,authority) VALUES (2,'owner1','owner');
-- One vet user, named vet1 with passwor v3t
INSERT INTO users(username,password,enabled,nombre,foto_perfil,biografia) VALUES ('vet1','v3t',TRUE,'vet','nada','hola');
INSERT INTO authorities(id,username,authority) VALUES (3,'vet1','veterinarian');
-- Another owner user, named davcorrom with password davcorrom
INSERT INTO users(username,password,enabled,nombre,foto_perfil,biografia) VALUES ('davcorrom','davcorrom',TRUE,'David','nada','hola');
INSERT INTO authorities(id,username,authority) VALUES (4,'davcorrom','owner');
-- Another owner user, named ignwarmur with password ignwarmur
INSERT INTO users(username,password,enabled,nombre,foto_perfil,biografia) VALUES ('ignwarmur','ignwarmur',TRUE,'Ignacio','nada','hola');
INSERT INTO authorities(id,username,authority) VALUES (5,'ignwarmur','owner');
-- Another owner user, named ignwarmur with password ignwarmur
INSERT INTO users(username,password,enabled,nombre,foto_perfil,biografia) VALUES ('danguepre','danguepre',TRUE,'Daniel','nada','hola');
INSERT INTO authorities(id,username,authority) VALUES (6,'danguepre','owner');
-- Another owner user, named ignwarmur with password ignwarmur
INSERT INTO users(username,password,enabled,nombre,foto_perfil,biografia) VALUES ('gabvacgoy','gabvacgoy',TRUE,'Gabriel','nada','hola');
INSERT INTO authorities(id,username,authority) VALUES (7,'gabvacgoy','owner');
-- Another owner user, named pabmarval with password pabmarval
INSERT INTO users(username,password,enabled,nombre,foto_perfil,biografia) VALUES ('pabmarval','pabmarval',TRUE,'Pablo','nada','hola');
INSERT INTO authorities(id,username,authority) VALUES (8,'pabmarval','owner');

INSERT INTO vets(id, first_name,last_name) VALUES (1, 'James', 'Carter');
INSERT INTO vets(id, first_name,last_name) VALUES (2, 'Helen', 'Leary');
INSERT INTO vets(id, first_name,last_name) VALUES (3, 'Linda', 'Douglas');
INSERT INTO vets(id, first_name,last_name) VALUES (4, 'Rafael', 'Ortega');
INSERT INTO vets(id, first_name,last_name) VALUES (5, 'Henry', 'Stevens');
INSERT INTO vets(id, first_name,last_name) VALUES (6, 'Sharon', 'Jenkins');


INSERT INTO specialties VALUES (1, 'radiology');
INSERT INTO specialties VALUES (2, 'surgery');
INSERT INTO specialties VALUES (3, 'dentistry');

INSERT INTO vet_specialties VALUES (2, 1);
INSERT INTO vet_specialties VALUES (3, 2);
INSERT INTO vet_specialties VALUES (3, 3);
INSERT INTO vet_specialties VALUES (4, 2);
INSERT INTO vet_specialties VALUES (5, 1);

INSERT INTO types VALUES (1, 'cat');
INSERT INTO types VALUES (2, 'dog');
INSERT INTO types VALUES (3, 'lizard');
INSERT INTO types VALUES (4, 'snake');
INSERT INTO types VALUES (5, 'bird');
INSERT INTO types VALUES (6, 'hamster');
INSERT INTO types VALUES (7, 'turtle');

INSERT INTO owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023', 'owner1');
INSERT INTO owners VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749', 'owner1');
INSERT INTO owners VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763', 'owner1');
INSERT INTO owners VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198', 'owner1');
INSERT INTO owners VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765', 'owner1');
INSERT INTO owners VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654', 'owner1');
INSERT INTO owners VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387', 'owner1');
INSERT INTO owners VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683', 'owner1');
INSERT INTO owners VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435', 'owner1');
INSERT INTO owners VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487', 'owner1');
INSERT INTO owners VALUES (11, 'David', 'Cortabarra', '1402 Shakira St.', 'Seattle', '6085555497', 'davcorrom');
INSERT INTO owners VALUES (12, 'Ignacio', 'Warleta', '73472 Lady Gaga St.', 'Zihuatanejo', '6084555497', 'ignwarmur');
INSERT INTO owners VALUES (13, 'Daniel', 'Guedes', '777 Rosalia St.', 'Monona', '6084555497', 'danguepre');
INSERT INTO owners VALUES (14, 'Gabriel', 'Vacaro', '50 Cent St.', 'Salamanca', '6084555836', 'gabvacgoy');
INSERT INTO owners VALUES (15, 'Pablo', 'Martinez', '33 ZapsMarcos Ave.', 'Bollullos', '6084555963', 'pabmarval');

INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (1, 'Leo', '2010-09-07', 1, 1);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (2, 'Basil', '2012-08-06', 6, 2);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (3, 'Rosy', '2011-04-17', 2, 3);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (4, 'Jewel', '2010-03-07', 2, 3);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (5, 'Iggy', '2010-11-30', 3, 4);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (6, 'George', '2010-01-20', 4, 5);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (7, 'Samantha', '2012-09-04', 1, 6);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (8, 'Max', '2012-09-04', 1, 6);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (9, 'Lucky', '2011-08-06', 5, 7);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (10, 'Mulligan', '2007-02-24', 2, 8);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (11, 'Freddy', '2010-03-09', 5, 9);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (12, 'Lucky', '2010-06-24', 2, 10);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (13, 'Sly', '2012-06-08', 1, 10);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (14, 'Paco', '2022-04-16', 2, 11);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (15, 'Anaxagoras', '2022-02-21', 2, 12);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (16, 'Tambor', '2011-12-20', 2, 13);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (17, 'Tambor', '2011-12-22', 2, 14);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (18, 'Adolfo', '2010-10-27', 5, 15);

INSERT INTO visits(id,pet_id,visit_date,description) VALUES (1, 7, '2013-01-01', 'rabies shot');
INSERT INTO visits(id,pet_id,visit_date,description) VALUES (2, 8, '2013-01-02', 'rabies shot');
INSERT INTO visits(id,pet_id,visit_date,description) VALUES (3, 8, '2013-01-03', 'neutered');
<<<<<<< HEAD
INSERT INTO visits(id,pet_id,visit_date,description) VALUES (4, 7, '2013-01-04', 'spayed');
=======
INSERT INTO visits(id,pet_id,visit_date,description) VALUES (4, 7, '2013-01-04', 'spayed');

//AÑADIR AQUI LOS LOGROS
INSERT INTO achievement(id,name,description,threshold,badge_image) 
VALUES (1,'Viciado','Si juegas <THRESHOLD> partidas o más, consideramos que ya estás enganchado.',10.0,'https://bit.ly/certifiedGamer'),
(2,'Triunfador','Si ganas <THRESHOLD> o  más partidas es que eres todo un triunfador.',20.0,'https://bit.ly/proGamer');
>>>>>>> def82102091597abe0da67dc68cfb8f200721215
