
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
INSERT INTO visits(id,pet_id,visit_date,description) VALUES (4, 7, '2013-01-04', 'spayed');

-- Cartas iniciales.
INSERT INTO cartas_iniciales(id,nombre,descripcion,posicion,imagen) VALUES (1, 'Iron_Seam', 'Take 3 iron from the supply.', 1, 'imagen');
INSERT INTO cartas_iniciales(id,nombre,descripcion,posicion,imagen) VALUES (2, 'Iron_Seam', 'Take 3 iron from the supply.', 2, 'imagen');
INSERT INTO cartas_iniciales(id,nombre,descripcion,posicion,imagen) VALUES (3, 'Iron_Seam', 'Take 3 iron from the supply.', 3, 'imagen');
INSERT INTO cartas_iniciales(id,nombre,descripcion,posicion,imagen) VALUES (4, 'Iron_Seam', 'Take 3 iron from the supply.', 4, 'imagen');
INSERT INTO cartas_iniciales(id,nombre,descripcion,posicion,imagen) VALUES (5, 'Iron_Seam', 'Take 3 iron from the supply.', 5, 'imagen');
INSERT INTO cartas_iniciales(id,nombre,descripcion,posicion,imagen) VALUES (6, 'Iron_Seam', 'Take 3 iron from the supply.', 6, 'imagen');
INSERT INTO cartas_iniciales(id,nombre,descripcion,posicion,imagen) VALUES (7, 'Gold_Seam', 'Take 1 gold from the supply.', 7, 'imagen');
INSERT INTO cartas_iniciales(id,nombre,descripcion,posicion,imagen) VALUES (8, 'Iron_Seam', 'Take 3 iron from the supply.', 8, 'imagen');
INSERT INTO cartas_iniciales(id,nombre,descripcion,posicion,imagen) VALUES (9, 'Gold_Seam', 'Take 1 gold from the supply.', 9, 'imagen');

-- Cartas de la montaña.
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (1, 'Alloy_Steel', 'Extraccion', 'A', 'Return 3 iron to the supply then take 2 steel.', 1, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (2, 'Orc_Raiders', 'Defensa', 'A', 'If undefended at the end of the round, players cannot take any extraction actions.', 2, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (3, 'Forge_Sword', 'Forja', 'B', 'Return 3 steel to the supply then take 1 item.', 3, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (4, 'Great_Dragon', 'Defensa', 'A', 'If undefended at the end of the round, each player must return all gold they possess to the supply.', 4, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (5, 'Knockers', 'Defensa', 'B', 'If undefended at the end of the round, each player must return 1 iron to the supply.', 5, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (6, 'Alloy_Steel', 'Extraccion', 'B', 'Return 3 iron to the supply then take 2 steel.', 6, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (7, 'Forge_Mace', 'Forja', 'A', 'Return 2 steel and 1 gold to the supply then take 1 item.', 7, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (8, 'Gold_Seam', 'Extraccion', 'A', 'Take 1 gold from the supply.', 8, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (9, 'Iron_Seam', 'Extraccion', 'A', 'Take 3 iron from the supply.', 9, 'imagen');

INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (10, 'Alloy_Steel', 'Extraccion', 'B', 'Return 3 iron to the supply then take 2 steel.', 1, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (11, 'Orc_Raiders', 'Defensa', 'B', 'If undefended at the end of the round, players cannot resolve any extraction actions.', 2, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (12, 'Alloy_Steel', 'Extraccion', 'A', 'Return 3 iron to the supply then take 2 steel.', 3, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (13, 'Dragon', 'Defensa', 'B', 'If undefended at the end of the round, each player must return 1 gold to the supply.', 4, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (14, 'Alloy_Steel', 'Extraccion', 'B', 'Return 3 iron to the supply then take 2 steel.', 5, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (15, 'Get_Help', 'Ayuda', 'B', 'You may place 2 additional workers this round. If you are 1st player, pass the 1st player marker to your left.', 6, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (16, 'Forge_Diadem', 'Forja', 'B', 'Return 1 iron, 1 steel and 1 gold to the supply then take 1 item.', 7, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (17, 'Forge_Helm', 'Forja', 'B', 'Return 1 steel and 2 gold to the supply then take 1 item.', 8, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (18, 'Dragon', 'Defensa', 'B', 'If undefended at the end of the round, each player must return 1 gold to the supply.', 9, 'imagen');

INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (19, 'Gold_Seam', 'Extraccion', 'A', 'Take 1 gold from the supply.', 1, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (20, 'Alloy_Steel', 'Extraccion', 'A', 'Return 3 iron to the supply then take 2 steel.', 2, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (21, 'Orc_Raiders', 'Defensa', 'A', 'If undefended at the end of the round, players cannot resolve any extraction actions.', 3, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (22, 'Forge_Axe', 'Forja', 'A', 'Return 2 steel to the supply then take 1 item.', 4, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (23, 'Get_Help', 'Ayuda', 'A', 'You may place 2 additional workers this round. If you are 1st player, pass the 1st player marker to your left.', 5, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (24, 'Forge_Crown', 'Forja', 'A', 'Return 3 gold to the supply then take 1 item.', 6, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (25, 'Iron_Seam', 'Extraccion', 'B', 'Take 3 iron from the supply.', 7, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (26, 'Dragon', 'Defensa', 'A', 'If undefended at the end of the round, each player must return 1 gold to the supply.', 8, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (27, 'Iron_Seam', 'Extraccion', 'B', 'Take 3 iron from the supply.', 9, 'imagen');
  
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (28, 'Sidhe', 'Defensa', 'A', 'If undefended at the end of the round, each player must replace two gold they possess with two iron.', 1, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (29, 'Sidhe', 'Defensa', 'A', 'If undefended at the end of the round, each player must replace two gold they possess with two iron.', 2, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (30, 'Get_Help', 'Ayuda', 'B', 'You may place 2 additional workers this round. If you are 1st player, pass the 1st player marker to your left.', 3, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (31, 'Gold_Seam', 'Extraccion', 'B', 'Take 1 gold from the supply.', 4, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (32, 'Gold_Seam', 'Extraccion', 'A', 'Take 1 gold from the supply.', 5, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (33, 'Knockers', 'Defensa', 'A', 'If undefended at the end of the round, each player must return 1 iron to the supply.', 6, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (34, 'Knockers', 'Defensa', 'A', 'If undefended at the end of the round, each player must return 1 iron to the supply.', 7, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (35, 'Alloy_Steel', 'Extraccion', 'B', 'Return 3 iron to the supply then take 2 steel.', 8, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (36, 'Forge_Dagger', 'Forja', 'A', 'Return 1 iron and 2 steel to the supply then take 1 item.', 9, 'imagen');

INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (37, 'Gold_Seam', 'Extraccion', 'B', 'Take 1 gold from the supply.', 1, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (38, 'Sidhe', 'Defensa', 'B', 'If undefended at the end of the round, each player must replace two gold they possess with two iron.', 2, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (39, 'Great_Dragon', 'Defensa', 'B', 'If undefended at the end of the round, each player must return all gold they possess to the supply.', 3, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (40, 'Orc_Raiders', 'Defensa', 'A', 'If undefended at the end of the round, players cannot resolve any extraction actions.', 4, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (41, 'Gold_Seam', 'Extraccion', 'B', 'Take 1 gold from the supply.', 5, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (42, 'Forge_Armour', 'Forja', 'B', 'Return 2 steel and 1 gold to the supply then take 1 item.', 6, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (43, 'Get_Help', 'Ayuda', 'A', 'You may place 2 additional workers this round. If you are 1st player, pass the 1st player marker to your left.', 7, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (44, 'Knockers', 'Defensa', 'B', 'If undefended at the end of the round, each player must return 1 iron to the supply.', 8, 'imagen');
INSERT INTO cartas_de_la_montana(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (45, 'Alloy_Steel', 'Extraccion', 'A', 'Return 3 iron to the supply then take 2 steel.', 9, 'imagen');

-- Cartas especiales.
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen) VALUES (1, 'Muster_an_Army', 'When resolving actions this round, treat al defend locations as if they are occupied.', 'Iron_Seam', 'Take 3 iron from the supply.', 1, 'imagen');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen) VALUES (2, 'Hold_a_Council', 'Remove the top card from each location (leaving at least one card) and shuffle them back into The Mountain.', 'Iron_Seam', 'Take 3 iron from the supply.', 2, 'imagen');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen) VALUES (3, 'Sell_an_Item', 'Exchange 1 of your items for 5 resources of your choice.', 'Iron_Seam', 'Take 3 iron from the supply.', 3, 'imagen');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen) VALUES (4, 'Past Glories', 'Name a card previously on top in any location and return it to the top of that location.', 'Iron_Seam', 'Take 3 iron from the supply.', 4, 'imagen');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen) VALUES (5, 'Special_Order', 'Return 5 resources of your choice, including at least 1 of each type, to the supply and take 1 item.', 'Iron_Seam', 'Take 3 iron from the supply.', 5, 'imagen');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen) VALUES (6, 'Turn_Back', 'Remove the top card from 1 location and shuffle it back into the mountain. Inmediately place 1 meeple on that location.', 'Iron_Seam', 'Take 3 iron from the supply.', 6, 'imagen');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen) VALUES (7, 'Apprentice', 'Place one meeple on a location occupied by other player.', 'Gold_Seam', 'Take 1 gold from the supply.', 7, 'imagen');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen) VALUES (8, 'Collapse_the_Shafts', 'Remove the top card from each location and place it on the bottom of that stack.', 'Iron_Seam', 'Take 3 iron from the supply.', 8, 'imagen');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen) VALUES (9, 'Run_Amok', 'Collect all of the cards from each location, in turn, shuffle them and return them to that location.', 'Gold_Seam', 'Take 1 gold from the supply.', 9, 'imagen');



-- ejemplo logros

INSERT INTO achievement(id,name,description,threshold,badge_image) 
                VALUES (1,'Viciado','Si juegas <THRESHOLD> partidas o más, consideramos que ya estás enganchado.',10.0,'https://bit.ly/certifiedGamer'),
                        (2,'Triunfador','Si ganas <THRESHOLD> o  más partidas es que eres todo un triunfador.',20.0,'https://bit.ly/proGamer');



INSERT INTO jugador(usuario_username, es_administrador, es_espectador, es_jugador_inicial, es_ganador) VALUES ('pabmarval', 'False', 'False', 'True', 'True');
INSERT INTO jugador(usuario_username, es_administrador, es_espectador, es_jugador_inicial, es_ganador) VALUES ('ignwarmur', 'False', 'False', 'True', 'True');
INSERT INTO jugador(usuario_username, es_administrador, es_espectador, es_jugador_inicial, es_ganador) VALUES ('davcorrom', 'False', 'False', 'True', 'True');

-- partidas ejemplo

INSERT INTO partida(id, nombre_sala, duracion, num_ronda, tiempo_rest_ronda, jugador_activo, siguiente_jugador, ganador) VALUES (1, 'prueba', 20, 3, 2, 1, 2, 1);
INSERT INTO partida(id, nombre_sala, duracion, num_ronda, tiempo_rest_ronda, jugador_activo, siguiente_jugador, ganador) VALUES (2, 'prueba2', 20, 3, 2, 1, 2, 1);