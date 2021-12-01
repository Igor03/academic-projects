/*CREATE DATABASE dbjogodavelha;
USE dbjogodavelha;*/

use dbjogodavelha;

SET SQL_SAFE_UPDATES = 0;

CREATE TABLE jogador(
	nome_jogador varchar(50) NOT NULL,
    id_jogador integer NOT NULL auto_increment,
    qtd_vitorias integer,
    qtd_derrotas integer,
    primary key(id_jogador)

);
CREATE TABLE partidas(
	id_partida integer NOT NULL auto_increment,
	nome_jogador1 varchar(50) NOT NULL,
    nome_jogador2 varchar(50) NOT NULL,
    id_jogador1 integer,
    id_jogador2 integer,
    nome_vencedor varchar(50),
    data_partida varchar(10),
    hora_partida varchar(10),
    primary key (id_partida),
    foreign key (id_jogador1) references jogador (id_jogador),
    foreign key (id_jogador2) references jogador (id_jogador)
);

drop table jogador;
drop table partidas;

/*select * from jogador order by qtd_vitorias DESC limit 10;*/

DELETE FROM partidas;
DELETE FROM jogador;


insert into jogador values('Igor', 1, 12, 5);
insert into jogador values('Pedro', 2, 3, 2);