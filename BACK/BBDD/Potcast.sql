create table usuario (
id_usuario number generated  ALWAYS AS IDENTITY PRIMARY KEY not null,
nombre varchar2 (30),
email varchar2 (30)
);

create table potcast (
id_potcast number GENERATED ALWAYS AS IDENTITY PRIMARY KEY not null ,
titulo varchar2 (30),
valoracion number (4,2)
);

create table comentarios (
    id_valoracion NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY not null ,
    id_usuario NUMBER NOT NULL,
    id_podcast NUMBER NOT NULL,
    valoracion NUMBER(4,2),
    descripcion varchar2 (30),
    
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_podcast) REFERENCES potcast(id_potcast) ON DELETE CASCADE
    
);


insert into usuario(nombre , email) values ('paco293','paquito@gmail.com');
insert into usuario(nombre , email) values ('diego','diegopro@gmail.com');
insert into usuario(nombre , email) values ('mohamed','elmoha@gmail.com');
insert into usuario(nombre , email) values ('laura','lauriti@gmail.com');


insert into potcast (titulo , valoracion) values ('mitologia griega',09.50);
insert into potcast (titulo , valoracion) values ('mitologia japonesa',07.50);
insert into potcast (titulo , valoracion) values ('mi experiencia en la carcel ',06.50);
insert into potcast (titulo , valoracion) values ('como hacer tradin ',07.00);


insert into comentarios (id_usuario , id_podcast,valoracion,descripcion) values (1,1,06.58,'increible me ha encantado ');
insert into comentarios (id_usuario , id_podcast,valoracion,descripcion) values (2,2,07.85,'tiene todo lo q necesitaba');
insert into comentarios (id_usuario , id_podcast,valoracion,descripcion) values (2,2,04.99,'mejorable ');
insert into comentarios (id_usuario , id_podcast,valoracion,descripcion) values (2,2,09.60,'me volvere millonario por esto');


select titulo ,valoracion from potcast;

select nombre ,email from usuario;

select usuario.nombre ,potcast.titulo,comentarios.valoracion 
from comentarios 
join usuario on comentarios.id_usuario = usuario.id_usuario
join potcast on comentarios.id_podcast = potcast.id_potcast;























