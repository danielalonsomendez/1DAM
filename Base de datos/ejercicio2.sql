use ejercicio2_m;

create table Proveedor(
CodProv int primary key constraint ch_Código check(CodProv>0),
NomProv varchar(15) unique not null,
DirProv varchar(30) not null
);
create table MateriaPrima(
CodMP char(7) primary key constraint ch_CodMP check(CodMP>0),
NomMP varchar(15) unique not null,
CodProv int not null,
constraint fk_CodProv_materiaprima foreign key (CodProv) references Proveedor(CodProv) on update cascade
);

create table Componente(
CodComp char(4) primary key,
NomComp varchar(15) unique not null,
StockComp int not null constraint ch_StockComp check(StockComp>0),
StockMinComp int not null default 5 constraint ch_StockMinComp check(StockMinComp>0)
);

create table Composición(
CodCompSup char(4),
CodCompInf char(4),
Cant int not null default 1 constraint ch_Cant check(Cant>0),
constraint pk_CodCompSupCodCompInf primary key(CodCompSup, CodCompInf),
constraint fk_CodCompSup_composicion foreign key (CodCompSup) references Componente(CodComp) on update cascade on delete restrict,
constraint fk_CodCompInf_composicion foreign key (CodCompInf) references Componente(CodComp) on update cascade on delete restrict
);

create table Fabricación(
CodMP char(4),
CodComp char(4),
constraint pk_CodMPCodComp primary key(CodMP, CodComp),
constraint fk_CodMP_composicion foreign key (CodMP) references MateriaPrima(CodMP) on update cascade on delete restrict,
constraint fk_CodComp_composicion foreign key (CodComp) references Componente(CodComp) on update cascade on delete restrict
);