use pedidos_m;
create table pedido(RefPed char(5) primary key,FecPed date not null);
show tables;
desc articulo;
create table articulo(CodArt char(5) primary key,DesArt varchar(30) not null,PVPArt float not null constraint ch_PVPArt check (PVPART>0));

create table lineapedido(RefPed char(5),CodArt char(5),CantArt int not null default 1 constraint ch_CantArt check (CantArt>0),
constraint fk_RefPed_LineaPedido foreign key (RefPed) references Pedido(RefPed) on update cascade,
constraint fk_CodArt_LineaPedido foreign key (CodArt) references Articulo(CodArt) on update cascade,
constraint pk_LineaPedido primary key (CodArt,RefPed));

