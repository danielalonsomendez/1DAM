use ejercicio1_m;
create table Vehículos(Matricula char(7) primary key,
MarcaModelo varchar(15) not null,
Impuesto float not null default 50 constraint ch_Impuesto check(Impuesto>=10)
);

create table Guardias(CódigoG char(5) primary key, 
CódigoGJefe char(5),
Nombre varchar(50) not null,
constraint fk_CódigoGJefe_guardias foreign key (CódigoGJefe) references Guardias(CódigoG) on update cascade
);

create table Multas(NMulta int auto_increment primary key, 
CódigoG char(5) not null,
Matrícula char(7) not null,
Fecha datetime not null default current_timestamp,
Lugar varchar(50) not null,
Descripción varchar(50) not null,
Pagada enum("Si","No") not null,
Importe int not null constraint ch_Importe check(Importe between 15 and 600),
constraint fk_CódigoG_multas foreign key (CódigoG) references Guardias(CódigoG) on update cascade,
constraint fk_Matricula_multas foreign key (Matrícula) references Vehículos(Matricula) on update cascade
);
