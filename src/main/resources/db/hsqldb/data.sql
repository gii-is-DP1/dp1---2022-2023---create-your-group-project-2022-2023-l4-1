-- Administrador del sistema.
INSERT INTO users(username,password,enabled,nombre,apellidos,foto_perfil,biografia,email) VALUES ('admin1', '4dm1n', TRUE, 'Administrador', 'del sistema', 'nada', 'hola', 'nada@gmail,com');
INSERT INTO estadistica(tiempo_jugado, partidas_jugadas, partidas_ganadas, hierro_total, oro_total, acero_total, objetos_total, medallas_total, username) VALUES (1234000000000, 2, 1, 15, 10, 7, 2, 7, 'admin1');
INSERT INTO authorities(id,username,authority) VALUES (1, 'admin1', 'admin');

-- Usuario asociado al desarrollador David Cortabarra Romero. Username: davcorrom. Contraseña: davcorrom.
INSERT INTO users(username,password,enabled,nombre,apellidos,foto_perfil,biografia,email) VALUES ('davcorrom', 'davcorrom', TRUE, 'David', 'Cortabarra Romero', 'https://i.pinimg.com/originals/30/8d/79/308d795c3cac0f8f16610f53df4e1005.jpg', 'Jugador profesional de Dwarf (el mejor del mundo). Palmarés: vacío.', 'davcorrom@alum.us.es');
INSERT INTO authorities(id,username,authority) VALUES (2, 'davcorrom', 'player');

-- Usuario asociado al desarrollador Daniel Guedes Preciados. Username: danguepre. Contraseña: danguepre.
INSERT INTO users(username,password,enabled,nombre,apellidos,foto_perfil,biografia,email) VALUES ('danguepre', 'danguepre', TRUE, 'Daniel', 'Guedes Preciados', 'https://i1.sndcdn.com/avatars-DF0Bde0hu41IBzdH-vMBNsQ-t500x500.jpg', 'hola', 'danguepre@alum.us.es');
INSERT INTO authorities(id,username,authority) VALUES (4, 'danguepre', 'player');

-- Usuario asociado al desarrollador Pablo Martínez Valladares. Username: pabmarval. Contraseña: pabmarval.
INSERT INTO users(username,password,enabled,nombre,apellidos,foto_perfil,biografia,email) VALUES ('pabmarval', 'pabmarval', TRUE, 'Pablo', 'Martínez Valladares', 'https://pbs.twimg.com/media/EgY_O3EWsAUgv5S.jpg', 'Amante de Dwarf, amante de la vida', 'pabmarval@alum.us.es');
INSERT INTO authorities(id,username,authority) VALUES (6, 'pabmarval', 'player');

-- Usuario asociado al desarrollador Manuel Palacios Pineda. Username: manpalpin. Contraseña: manpalpin.
INSERT INTO users(username,password,enabled,nombre,apellidos,foto_perfil,biografia,email) VALUES ('Manpalpin02', 'Manpalpin02', TRUE, 'Manuel', 'Palacios Pineda', 'nada', 'hola', 'manpalpin@alum.us.es');
INSERT INTO authorities(id,username,authority) VALUES (7, 'Manpalpin02', 'player');

-- Usuario asociado al desarrollador Gabriel María Vacaro Goytia. Username: gabvacgoy. Contraseña: gabvacgoy.
INSERT INTO users(username,password,enabled,nombre,apellidos,foto_perfil,biografia,email) VALUES ('gabvacgoy', 'gabvacgoy', TRUE, 'Gabriel', 'Vacaro Goytia', 'https://upload.wikimedia.org/wikipedia/commons/8/8c/Cristiano_Ronaldo_2018.jpg', 'kichiano kichino, eresh de malaga?', 'gabvacgoy@alum.us.es');
INSERT INTO authorities(id,username,authority) VALUES (5, 'gabvacgoy', 'player');

-- Usuario asociado al desarrollador Ignacio Warleta Murcia. Username: ignwarmur. Contraseña: ignwarmur.
INSERT INTO users(username,password,enabled,nombre,apellidos,foto_perfil,biografia,email) VALUES ('ignwarmur', 'ignwarmur', TRUE, 'Ignacio', 'Warleta Murcia', 'https://lastfm.freetls.fastly.net/i/u/300x300/6d8a8ff92b706d445650a5efa88a3dfa.jpg', 'Soy Leroy Wilkinson y estoy en la cárcel por fraude fiscal. Me dedico a hacer lindo lazos para ramos de novias.', 'ignwarmur@alum.us.es');
INSERT INTO authorities(id,username,authority) VALUES (3, 'ignwarmur', 'player');


-- Cartas iniciales.
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (1, 'Iron_Seam', 'Extraccion', 'Inicial', 'Take 3 iron from the supply.', 1, '/resources/images/cartas/Carta 1.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (2, 'Iron_Seam', 'Extraccion', 'Inicial', 'Take 3 iron from the supply.', 2, '/resources/images/cartas/Carta 2.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (3, 'Iron_Seam', 'Extraccion', 'Inicial', 'Take 3 iron from the supply.', 3, '/resources/images/cartas/Carta 3.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (4, 'Iron_Seam', 'Extraccion', 'Inicial', 'Take 3 iron from the supply.', 4, '/resources/images/cartas/Carta 4.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (5, 'Iron_Seam', 'Extraccion', 'Inicial', 'Take 3 iron from the supply.', 5, '/resources/images/cartas/Carta 5.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (6, 'Iron_Seam', 'Extraccion', 'Inicial', 'Take 3 iron from the supply.', 6, '/resources/images/cartas/Carta 6.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (7, 'Gold_Seam', 'Extraccion', 'Inicial', 'Take 1 gold from the supply.', 7, '/resources/images/cartas/Carta 7.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (8, 'Iron_Seam', 'Extraccion', 'Inicial', 'Take 3 iron from the supply.', 8, '/resources/images/cartas/Carta 8.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (9, 'Gold_Seam', 'Extraccion', 'Inicial', 'Take 1 gold from the supply.', 9, '/resources/images/cartas/Carta 9.png');

-- Cartas de la montaña.
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (10, 'Alloy_Steel', 'Extraccion', 'A', 'Return 3 iron to the supply then take 2 steel.', 1, '/resources/images/cartas/Carta 10.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (11, 'Orc_Raiders', 'Defensa', 'A', 'If undefended at the end of the round, players cannot take any extraction actions.', 2, '/resources/images/cartas/Carta 11.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (12, 'Forge_Sword', 'Forja', 'B', 'Return 3 steel to the supply then take 1 item.', 3, '/resources/images/cartas/Carta 12.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (13, 'Great_Dragon', 'Defensa', 'A', 'If undefended at the end of the round, each player must return all gold they possess to the supply.', 4, '/resources/images/cartas/Carta 13.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (14, 'Knockers', 'Defensa', 'B', 'If undefended at the end of the round, each player must return 1 iron to the supply.', 5, '/resources/images/cartas/Carta 14.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (15, 'Alloy_Steel', 'Extraccion', 'B', 'Return 3 iron to the supply then take 2 steel.', 6, '/resources/images/cartas/Carta 15.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (16, 'Forge_Mace', 'Forja', 'A', 'Return 2 steel and 1 gold to the supply then take 1 item.', 7, '/resources/images/cartas/Carta 16.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (17, 'Gold_Seam', 'Extraccion', 'A', 'Take 1 gold from the supply.', 8, '/resources/images/cartas/Carta 17.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (18, 'Iron_Seam', 'Extraccion', 'A', 'Take 3 iron from the supply.', 9, '/resources/images/cartas/Carta 18.png');

INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (19, 'Alloy_Steel', 'Extraccion', 'B', 'Return 3 iron to the supply then take 2 steel.', 1, '/resources/images/cartas/Carta 19.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (20, 'Orc_Raiders', 'Defensa', 'B', 'If undefended at the end of the round, players cannot resolve any extraction actions.', 2, '/resources/images/cartas/Carta 20.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (21, 'Alloy_Steel', 'Extraccion', 'A', 'Return 3 iron to the supply then take 2 steel.', 3, '/resources/images/cartas/Carta 21.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (22, 'Dragon', 'Defensa', 'B', 'If undefended at the end of the round, each player must return 1 gold to the supply.', 4, '/resources/images/cartas/Carta 22.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (23, 'Alloy_Steel', 'Extraccion', 'B', 'Return 3 iron to the supply then take 2 steel.', 5, '/resources/images/cartas/Carta 23.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (24, 'Get_Help', 'Ayuda', 'B', 'You may place additional workers this round. If you are 1st player, pass the 1st player marker to your left.', 6, '/resources/images/cartas/Carta 24.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (25, 'Forge_Diadem', 'Forja', 'B', 'Return 1 iron, 1 steel and 1 gold to the supply then take 1 item.', 7, '/resources/images/cartas/Carta 25.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (26, 'Forge_Helm', 'Forja', 'B', 'Return 1 steel and 2 gold to the supply then take 1 item.', 8, '/resources/images/cartas/Carta 26.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (27, 'Dragon', 'Defensa', 'B', 'If undefended at the end of the round, each player must return 1 gold to the supply.', 9, '/resources/images/cartas/Carta 27.png');

INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (28, 'Gold_Seam', 'Extraccion', 'A', 'Take 1 gold from the supply.', 1, '/resources/images/cartas/Carta 28.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (29, 'Alloy_Steel', 'Extraccion', 'A', 'Return 3 iron to the supply then take 2 steel.', 2, '/resources/images/cartas/Carta 29.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (30, 'Orc_Raiders', 'Defensa', 'A', 'If undefended at the end of the round, players cannot resolve any extraction actions.', 3, '/resources/images/cartas/Carta 30.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (31, 'Forge_Axe', 'Forja', 'A', 'Return 2 steel to the supply then take 1 item.', 4, '/resources/images/cartas/Carta 31.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (32, 'Get_Help', 'Ayuda', 'A', 'You may place additional workers this round. If you are 1st player, pass the 1st player marker to your left.', 5, '/resources/images/cartas/Carta 32.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (33, 'Forge_Crown', 'Forja', 'A', 'Return 3 gold to the supply then take 1 item.', 6, '/resources/images/cartas/Carta 33.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (34, 'Iron_Seam', 'Extraccion', 'B', 'Take 3 iron from the supply.', 7, '/resources/images/cartas/Carta 34.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (35, 'Dragon', 'Defensa', 'A', 'If undefended at the end of the round, each player must return 1 gold to the supply.', 8, '/resources/images/cartas/Carta 35.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (36, 'Iron_Seam', 'Extraccion', 'B', 'Take 3 iron from the supply.', 9, '/resources/images/cartas/Carta 36.png');
  
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (37, 'Sidhe', 'Defensa', 'A', 'If undefended at the end of the round, each player must replace two gold they possess with two iron.', 1, '/resources/images/cartas/Carta 37.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (38, 'Sidhe', 'Defensa', 'A', 'If undefended at the end of the round, each player must replace two gold they possess with two iron.', 2, '/resources/images/cartas/Carta 38.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (39, 'Get_Help', 'Ayuda', 'B', 'You may place additional workers this round. If you are 1st player, pass the 1st player marker to your left.', 3, '/resources/images/cartas/Carta 39.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (40, 'Gold_Seam', 'Extraccion', 'B', 'Take 1 gold from the supply.', 4, '/resources/images/cartas/Carta 40.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (41, 'Gold_Seam', 'Extraccion', 'A', 'Take 1 gold from the supply.', 5, '/resources/images/cartas/Carta 41.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (42, 'Knockers', 'Defensa', 'A', 'If undefended at the end of the round, each player must return 1 iron to the supply.', 6, '/resources/images/cartas/Carta 42.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (43, 'Knockers', 'Defensa', 'A', 'If undefended at the end of the round, each player must return 1 iron to the supply.', 7, '/resources/images/cartas/Carta 43.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (44, 'Alloy_Steel', 'Extraccion', 'B', 'Return 3 iron to the supply then take 2 steel.', 8, '/resources/images/cartas/Carta 44.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (45, 'Forge_Dagger', 'Forja', 'A', 'Return 1 iron and 2 steel to the supply then take 1 item.', 9, '/resources/images/cartas/Carta 45.png');

INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (46, 'Gold_Seam', 'Extraccion', 'B', 'Take 1 gold from the supply.', 1, '/resources/images/cartas/Carta 46.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (47, 'Sidhe', 'Defensa', 'B', 'If undefended at the end of the round, each player must replace two gold they possess with two iron.', 2, '/resources/images/cartas/Carta 47.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (48, 'Great_Dragon', 'Defensa', 'B', 'If undefended at the end of the round, each player must return all gold they possess to the supply.', 3, '/resources/images/cartas/Carta 48.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (49, 'Orc_Raiders', 'Defensa', 'A', 'If undefended at the end of the round, players cannot resolve any extraction actions.', 4, '/resources/images/cartas/Carta 49.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (50, 'Gold_Seam', 'Extraccion', 'B', 'Take 1 gold from the supply.', 5, '/resources/images/cartas/Carta 50.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (51, 'Forge_Armour', 'Forja', 'B', 'Return 2 steel and 1 gold to the supply then take 1 item.', 6, '/resources/images/cartas/Carta 51.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (52, 'Get_Help', 'Ayuda', 'A', 'You may place additional workers this round. If you are 1st player, pass the 1st player marker to your left.', 7, '/resources/images/cartas/Carta 52.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (53, 'Knockers', 'Defensa', 'B', 'If undefended at the end of the round, each player must return 1 iron to the supply.', 8, '/resources/images/cartas/Carta 53.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (54, 'Alloy_Steel', 'Extraccion', 'A', 'Return 3 iron to the supply then take 2 steel.', 9, '/resources/images/cartas/Carta 54.png');

INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (55, 'Iron_Seam', 'Extraccion', 'Especial', 'Take 3 iron from the supply.', 1, '/resources/images/cartas_especiales/Trasera 1.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (56, 'Iron_Seam', 'Extraccion', 'Especial', 'Take 3 iron from the supply.', 2, '/resources/images/cartas_especiales/Trasera 2.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (57, 'Iron_Seam', 'Extraccion', 'Especial', 'Take 3 iron from the supply.', 3, '/resources/images/cartas_especiales/Trasera 3.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (58, 'Iron_Seam', 'Extraccion', 'Especial', 'Take 3 iron from the supply.', 4, '/resources/images/cartas_especiales/Trasera 4.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (59, 'Iron_Seam', 'Extraccion', 'Especial', 'Take 3 iron from the supply.', 5, '/resources/images/cartas_especiales/Trasera 5.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (60, 'Iron_Seam', 'Extraccion', 'Especial', 'Take 3 iron from the supply.', 6, '/resources/images/cartas_especiales/Trasera 6.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (61, 'Gold_Seam', 'Extraccion', 'Especial', 'Take 1 gold from the supply.', 7, '/resources/images/cartas_especiales/Trasera 7.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (62, 'Iron_Seam', 'Extraccion', 'Especial', 'Take 3 iron from the supply.', 8, '/resources/images/cartas_especiales/Trasera 8.png');
INSERT INTO cartas(id,nombre,tipo,rango,descripcion,posicion,imagen) VALUES (63, 'Gold_Seam', 'Extraccion', 'Especial', 'Take 1 gold from the supply.', 9, '/resources/images/cartas_especiales/Trasera 9.png');

-- Cartas especiales.
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen,imagen_especial) VALUES (1, 'Muster_an_Army', 'When resolving actions this round, treat al defend locations as if they are occupied.', 'Iron_Seam', 'Take 3 iron from the supply.', 1, '/resources/images/cartas_especiales/Trasera 1.png', '/resources/images/cartas_especiales/Especial 1.png');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen,imagen_especial) VALUES (2, 'Hold_a_Council', 'Remove the top card from each location (leaving at least one card) and shuffle them back into The Mountain.', 'Iron_Seam', 'Take 3 iron from the supply.', 2, '/resources/images/cartas_especiales/Trasera 2.png', '/resources/images/cartas_especiales/Especial 2.png');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen,imagen_especial) VALUES (3, 'Sell_an_Item', 'Exchange 1 random item that you won during teh game for 10 gold from the supply.', 'Iron_Seam', 'Take 3 iron from the supply.', 3, '/resources/images/cartas_especiales/Trasera 3.png', '/resources/images/cartas_especiales/Especial 3.png');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen,imagen_especial) VALUES (4, 'Past_Glories', 'Name a card previously on top in any location and return it to the top of that location.', 'Iron_Seam', 'Take 3 iron from the supply.', 4, '/resources/images/cartas_especiales/Trasera 4.png', '/resources/images/cartas_especiales/Especial 4.png');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen,imagen_especial) VALUES (5, 'Special_Order', 'Take a random item that you do not have yet.', 'Iron_Seam', 'Take 3 iron from the supply.', 5, '/resources/images/cartas_especiales/Trasera 5.png', '/resources/images/cartas_especiales/Especial 5.png');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen,imagen_especial) VALUES (6, 'Turn_Back', 'Remove the top card from 1 location and shuffle it back into the mountain. Inmediately place 1 meeple on that location.', 'Iron_Seam', 'Take 3 iron from the supply.', 6, '/resources/images/cartas_especiales/Trasera 6.png', '/resources/images/cartas_especiales/Especial 6.png');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen,imagen_especial) VALUES (7, 'Apprentice', 'Place one meeple on a location occupied by other player.', 'Gold_Seam', 'Take 1 gold from the supply.', 7, '/resources/images/cartas_especiales/Trasera 7.png', '/resources/images/cartas_especiales/Especial 7.png');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen,imagen_especial) VALUES (8, 'Collapse_the_Shafts', 'Remove the top card from each location and place it on the bottom of that stack.', 'Iron_Seam', 'Take 3 iron from the supply.', 8, '/resources/images/cartas_especiales/Trasera 8.png', '/resources/images/cartas_especiales/Especial 8.png');
INSERT INTO cartas_especiales(id,nombre,descripcion,accion_posterior,descripcion_trasera,posicion,imagen,imagen_especial) VALUES (9, 'Run_Amok', 'Collect all of the cards from each location, in turn, shuffle them and return them to that location.', 'Gold_Seam', 'Take 1 gold from the supply.', 9, '/resources/images/cartas_especiales/Trasera 9.png', '/resources/images/cartas_especiales/Especial 9.png');

-- Objetos.

INSERT INTO objeto(id, nombre) VALUES (1, 'Espada');
INSERT INTO objeto(id, nombre) VALUES (2, 'Mazo');
INSERT INTO objeto(id, nombre) VALUES (3, 'Diadema');
INSERT INTO objeto(id, nombre) VALUES (4, 'Timon');
INSERT INTO objeto(id, nombre) VALUES (5, 'Hacha');
INSERT INTO objeto(id, nombre) VALUES (6, 'Corona');
INSERT INTO objeto(id, nombre) VALUES (7, 'Daga');
INSERT INTO objeto(id, nombre) VALUES (8, 'Armadura');

-- Logros.

INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (1,'¡A ganar, a ganar, pollo para cenar!','Consigues este logro si ganas <THRESHOLD> partidas o más.',10.0,'https://bit.ly/proGamer');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (2,'¿No tienes nada mejor que hacer?','Consigues este logro si juegas <THRESHOLD> partidas o  más.',10.0,'https://bit.ly/certifiedGamer');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (3,'Para ti solo existe Dwarf','Consigues este logro si juegas durante <THRESHOLD> minutos o  más.',4000.0,'/resources/images/logro_tiempo.jpg');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (4,'Estudiante de la condición humana','Consigues este logro si agregas a tu pirmer amigo.',0.0,'/resources/images/logro_amistad.jpg');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (5,'Mejor juega a otra cosa','Consigues este logro si pierdes <THRESHOLD> partidas o  más.',10.0,'/resources/images/logro_loser.jpg');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (6,'La leyenda aumenta','Consigues este logro si consigues derrotar a El Draco.',0.0,'/resources/images/logro_leyenda.png');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (7,'Experto en herreria','Consigues este logro si ganas tu primera partida habiendo fabricado 4 objetos.',0.0,'/resources/images/logro_herreria.jpg');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (8,'Mi tesoro...','Consigues este logro si consigues poseer todos los tipos de recurso a la vez.',0.0,'/resources/images/logro_tesoro.png');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (9,'Acaparador','Consigues este logro si consigues poseer <THRESHOLD> recursos o  más.',50.0,'/resources/images/logro_riqueza.jpg');
INSERT INTO achievement(id,name,description,threshold,badge_image) VALUES (10,'El enano legendario','Consigues este logro si consigues obtener todos los logros de Dwarf.',0.0,'/resources/images/logro_enano.jpg');


-- Partidas de ejemplo.

INSERT INTO partida(id, nombre_sala, num_ronda, user0, user1, user2, ganador, rondas, fase_actual) VALUES (1, 'prueba', 3, 'pabmarval', 'ignwarmur', 'davcorrom', 'pabmarval', 'LIMITADAS', 'FINALIZADA');
INSERT INTO partida(id, nombre_sala, num_ronda, user0, user1, user2, ganador, rondas, fase_actual) VALUES (2, 'prueba2', 3, 'pabmarval', 'ignwarmur', 'davcorrom', 'pabmarval', 'ILIMITADAS', 'FINALIZADA');


-- Juadores de ejemplo.

INSERT INTO jugador(id, es_jugador_inicial, es_ganador, num_enanos_pico, num_enanos_mazo, cantidad_hierro, cantidad_acero, cantidad_oro, cantidad_medallas, username, partida) VALUES (1, TRUE, FALSE, 2, 2, 15, 5, 2, 1, 'pabmarval', 1);
INSERT INTO jugador(id, es_jugador_inicial, es_ganador, num_enanos_pico, num_enanos_mazo, cantidad_hierro, cantidad_acero, cantidad_oro, cantidad_medallas, username, partida) VALUES (2, TRUE, FALSE, 2, 2, 15, 5, 2, 1, 'ignwarmur', 1);
INSERT INTO jugador(id, es_jugador_inicial, es_ganador, num_enanos_pico, num_enanos_mazo, cantidad_hierro, cantidad_acero, cantidad_oro, cantidad_medallas, username, partida) VALUES (3, TRUE, FALSE, 2, 2, 15, 5, 2, 1, 'davcorrom', 1);
INSERT INTO jugador(id, es_jugador_inicial, es_ganador, num_enanos_pico, num_enanos_mazo, cantidad_hierro, cantidad_acero, cantidad_oro, cantidad_medallas, username, partida) VALUES (4, TRUE, FALSE, 2, 2, 15, 5, 2, 1, 'davcorrom', 2);
INSERT INTO jugador(id, es_jugador_inicial, es_ganador, num_enanos_pico, num_enanos_mazo, cantidad_hierro, cantidad_acero, cantidad_oro, cantidad_medallas, username, partida) VALUES (5, TRUE, FALSE, 2, 2, 15, 5, 2, 1, 'pabmarval', 2);
INSERT INTO jugador(id, es_jugador_inicial, es_ganador, num_enanos_pico, num_enanos_mazo, cantidad_hierro, cantidad_acero, cantidad_oro, cantidad_medallas, username, partida) VALUES (6, TRUE, FALSE, 2, 2, 15, 5, 2, 1, 'ignwarmur', 2);


-- relacion logros-usuario

INSERT INTO users_achievements(user_username, achievements_id) VALUES ('pabmarval', 2);
INSERT INTO users_achievements(user_username, achievements_id) VALUES ('pabmarval', 3);
INSERT INTO users_achievements(user_username, achievements_id) VALUES ('davcorrom', 3);


INSERT INTO Friends(friend_id, aux_friend_id) VALUES('ignwarmur', 'davcorrom');
INSERT INTO Friends(friend_id, aux_friend_id) VALUES('davcorrom', 'ignwarmur');

INSERT INTO Invitation(id, receiver_username, sender_username) VALUES(1, 'ignwarmur', 'gabvacgoy');


INSERT INTO tablero(id, background, width, height, partida) VALUES (1, 'resources/images/cueva-juego.png', 800, 800, 1);