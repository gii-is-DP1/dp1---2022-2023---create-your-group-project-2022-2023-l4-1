-- Administrador del sistema.
INSERT INTO users(username,password,enabled,nombre,apellidos,foto_perfil,biografia,email) VALUES ('admin1', '4dm1n', TRUE, 'Administrador', 'del sistema', 'nada', 'hola', 'nada');
INSERT INTO authorities(id,username,authority) VALUES (1, 'admin1', 'admin');

-- Usuario asociado al desarrollador David Cortabarra Romero. Username: davcorrom. Contraseña: davcorrom.
INSERT INTO users(username,password,enabled,nombre,apellidos,foto_perfil,biografia,email) VALUES ('davcorrom', 'davcorrom', TRUE, 'David', 'Cortabarra Romero', 'nada', 'hola', 'davcorrom@alum.us.es');
INSERT INTO authorities(id,username,authority) VALUES (2, 'davcorrom', 'player');

-- Usuario asociado al desarrollador Daniel Guedes Preciados. Username: danguepre. Contraseña: danguepre.
INSERT INTO users(username,password,enabled,nombre,apellidos,foto_perfil,biografia,email) VALUES ('danguepre', 'danguepre', TRUE, 'Daniel', 'Guedes Preciados', 'https://i1.sndcdn.com/avatars-DF0Bde0hu41IBzdH-vMBNsQ-t500x500.jpg', 'hola', 'danguepre@alum.us.es');
INSERT INTO authorities(id,username,authority) VALUES (4, 'danguepre', 'player');

-- Usuario asociado al desarrollador Pablo Martínez Valladares. Username: pabmarval. Contraseña: pabmarval.
INSERT INTO users(username,password,enabled,nombre,apellidos,foto_perfil,biografia,email) VALUES ('pabmarval', 'pabmarval', TRUE, 'Pablo', 'Martínez Valladares', 'nada', 'hola', 'pabmarval@alum.us.es');
INSERT INTO authorities(id,username,authority) VALUES (6, 'pabmarval', 'player');

-- Usuario asociado al desarrollador Manuel Palacios Pineda. Username: manpalpin. Contraseña: manpalpin.
INSERT INTO users(username,password,enabled,nombre,apellidos,foto_perfil,biografia,email) VALUES ('Manpalpin02', 'Manpalpin02', TRUE, 'Manuel', 'Palacios Pineda', 'nada', 'hola', 'manpalpin@alum.us.es');
INSERT INTO authorities(id,username,authority) VALUES (7, 'Manpalpin02', 'player');

-- Usuario asociado al desarrollador Gabriel María Vacaro Goytia. Username: gabvacgoy. Contraseña: gabvacgoy.
INSERT INTO users(username,password,enabled,nombre,apellidos,foto_perfil,biografia,email) VALUES ('gabvacgoy', 'gabvacgoy', TRUE, 'Gabriel', 'Vacaro Goytia', 'https://upload.wikimedia.org/wikipedia/commons/8/8c/Cristiano_Ronaldo_2018.jpg', 'a oa oa la la la', 'gabvacgoy@alum.us.es');
INSERT INTO authorities(id,username,authority) VALUES (5, 'gabvacgoy', 'player');

-- Usuario asociado al desarrollador Ignacio Warleta Murcia. Username: ignwarmur. Contraseña: ignwarmur.
INSERT INTO users(username,password,enabled,nombre,apellidos,foto_perfil,biografia,email) VALUES ('ignwarmur', 'ignwarmur', TRUE, 'Ignacio', 'Warleta Murcia', 'https://lastfm.freetls.fastly.net/i/u/300x300/6d8a8ff92b706d445650a5efa88a3dfa.jpg', 'Soy Leroy Wilkinson y estoy en la cárcel por fraude fiscal. Me dedico a hacer lindo lazos para ramos de novias.', 'ignwarmur@alum.us.es');
INSERT INTO authorities(id,username,authority) VALUES (3, 'ignwarmur', 'player');


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



-- Logros.

INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (1,'¡A ganar, a ganar, pollo para cenar!','Consigues este logro si ganas <THRESHOLD> partidas o más.',10.0,'https://bit.ly/proGamer');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (2,'¿No tienes nada mejor que hacer?','Consigues este logro si juegas <THRESHOLD> partidas o  más.',10.0,'https://bit.ly/certifiedGamer');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (3,'Para ti solo existe Dwarf','Consigues este logro si juegas durante <THRESHOLD> minutos o  más.',4000.0,'/resources/images/logro_tiempo.jpg');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (4,'Estudiante de la condición humana','Consigues este logro si agregas a tu pirmer amigo.',0.0,'/resources/images/logro_amistad.jpg');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (5,'Mejor juega a otra cosa','Consigues este logro si pierdes <THRESHOLD> partidas o  más.',10.0,'/resources/images/logro_loser.jpg');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (6,'La leyenda aumenta','Consigues este logro si consigues derrotar a El Draco.',0.0,'https://bit.ly/proGamer');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (7,'Experto en herreria','Consigues este logro si ganas tu primera partida habiendo fabricado 4 objetos.',0.0,'/resources/images/logro_herreria.jpg');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (8,'Mi tesoro...','Consigues este logro si consigues poseer todos los tipos de recurso a la vez.',0.0,'/resources/images/logro_tesoro.png');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (9,'Acaparador','Consigues este logro si consigues poseer <THRESHOLD> recursos o  más.',50.0,'/resources/images/logro_riqueza.jpg');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (10,'El enano legendario','Consigues este logro si consigues obtener todos los logros de Dwarf.',0.0,'/resources/images/logro_enano.jpg');


INSERT INTO jugador(username, es_administrador, es_ganador, avatar_url) VALUES ('pabmarval', 'False', 'True','https://cdn-icons-png.flaticon.com/512/747/747969.png' );
INSERT INTO jugador(username, es_administrador, es_ganador, avatar_url) VALUES ('ignwarmur', 'False', 'False','https://cdn-icons-png.flaticon.com/512/747/747969.png' );
INSERT INTO jugador(username, es_administrador, es_ganador, avatar_url) VALUES ('davcorrom', 'False', 'False', 'https://cdn-icons-png.flaticon.com/512/747/747969.png');

-- Partidas de ejemplo.

INSERT INTO partida(id, nombre_sala, duracion, num_ronda, tiempo_rest_ronda, jugador_activo, siguiente_jugador, jugador0, jugador1, jugador2, ganador, rondas, fase_actual) VALUES (1, 'prueba', 20, 3, 2, 1, 2, 1, 2, 3, 1, 'RONDAS_LIMITADAS', 'FIN');
INSERT INTO partida(id, nombre_sala, duracion, num_ronda, tiempo_rest_ronda, jugador_activo, siguiente_jugador, jugador0, jugador1, jugador2, ganador, rondas, fase_actual) VALUES (2, 'prueba2', 20, 3, 2, 1, 2, 1,2, 3, 1, 'SIN_LIMITE', 'FIN');

-- relacion logros-usuario

INSERT INTO users_achievements(user_username, achievements_id) VALUES ('pabmarval', 2);
INSERT INTO users_achievements(user_username, achievements_id) VALUES ('pabmarval', 3);
INSERT INTO users_achievements(user_username, achievements_id) VALUES ('davcorrom', 3);
