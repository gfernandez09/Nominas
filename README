# Nominas
El software está programado con JDK 16, en el IDE Apache Netbeans, asi que sería recomendable
abrir el software desde el IDE indicado anteriormente para evitar posibles problemas.

Si hubiera algún problema de librerias, en la carpeta \Nominas\lib del proyecto están todas las librerias
utilizadas, habrá que ir a: Clic derecho en el proyecto (Nominas) -> Propiedades -> Librerias y allí
las añadimos.

A la hora de sincronizarnos con la base de datos, nos situaremos en \Nominas\src\nominas\conexion\db.java
y allí cambiaremos las credenciales para entrar en su gestor de bases de datos, en este caso MySQL.
(Préviamente habrá que añadir las líneas de código SQL para la creación de la base de datos.)

A la hora de iniciar sesión, disponemos de estos 5 usuarios:
NOMBRE DE USUARIO   CONTRASEÑA          ROL

xsastref            xsastref1234        Admin
jfernandezc         jfernandezc1234     Admin
gmuletf             gmuletf1234         Admin
gsalvac             gsalvac1234         Admin
lmatasp             lmatasp1234         Usuario

Donde como podemos ver, los cuatro primeros son Administradores, y el último es de tipo Usuario.

-SQL
Código a ejecutar en la base de datos (IMPORTANTE que la base de datos se llame Nominas)

------------------------------------------------------------------------------------------------
DROP DATABASE IF EXISTS Nominas;
CREATE DATABASE Nominas;
USE Nominas;

-- Creacion de la tabla de los convenios.
CREATE TABLE Convenio(
    idConvenio NVARCHAR(3) PRIMARY KEY NOT NULL,
    nombreConvenio NVARCHAR(40),
    irpf DOUBLE,
    contingenciasComunes DOUBLE,
    paro DOUBLE,
    formacionProfesional DOUBLE,
    horasExtraordinarias DOUBLE,
    horasExtraordinariasPorFuerzaMayor DOUBLE,
    salarioBase DOUBLE
);

-- Inserts de la tabla de los convenios.
INSERT INTO Convenio(idConvenio, nombreConvenio, irpf, contingenciasComunes, paro, formacionProfesional, horasExtraordinarias, horasExtraordinariasPorFuerzaMayor, salarioBase) 
VALUES('far', 'Farmacia', 11.38, 4.70, 1.55, 0.10, 4.70, 2, 1200);

-- Creacion de la tabla de los trabajadores
CREATE TABLE Trabajador(
    NIF NVARCHAR(9) PRIMARY KEY UNIQUE NOT NULL,
    nombreTrabajador NVARCHAR(40),
    primerApellido NVARCHAR(40),
    segundoApellido NVARCHAR(40),
    numeroAfiliacion NVARCHAR(12),
    puesto NVARCHAR(40),
    hijos NVARCHAR(2),
    grupoCotizacion NVARCHAR(40),
    idConvenio NVARCHAR(3),
    fechaAntiguedad NVARCHAR(30),
    FOREIGN KEY (idConvenio) REFERENCES Convenio(idConvenio) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Inserts de la tabla de los trabajadores.
INSERT INTO Trabajador(NIF, nombreTrabajador, primerApellido, segundoApellido, numeroAfiliacion, puesto, hijos, grupoCotizacion, idConvenio, fechaAntiguedad)
VALUES('12345678A', 'Xavier', 'Sastre', 'Flexas', 'XSF1234', 'Profesor', '2','XSF4321', 'far', '28-09-2016'),
      ('12345678B', 'Juan Manuel', 'Fernández', 'Córdoba', 'JFC1234', 'Programador', '0','JFC4321', 'far', '27-05-2018'),
      ('12345678C', 'Gustavo', 'Mulet', 'Fernández', 'GMF1234', 'Programador', '0','GMF4321', 'far', '09-04-2019'),
      ('12345678D', 'Gonzalo', 'Salvà', 'Corral', 'GSC1234', 'Programador', '0','GSC4321', 'far', '16-07-2020'),
      ('12345678E', 'Lluc', 'Matas', 'Pomar', 'LMP1234', 'Programador', '0','LMP4321', 'far', '16-07-2020');

-- Creacion de la tabla de los usuarios
CREATE TABLE Usuarios(
    id INT AUTO_INCREMENT UNIQUE PRIMARY KEY NOT NULL,
    nombreUsuario NVARCHAR(40),
    password NVARCHAR(40),
    rol NVARCHAR(20),
    NIF NVARCHAR(9) UNIQUE,
    FOREIGN KEY (NIF) REFERENCES Trabajador(NIF) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Inserts de la tabla de los usuarios
INSERT INTO Usuarios(nombreUsuario, Password, rol, NIF) 
VALUES ('xsastref', 'xsastref1234', 'Admin', '12345678A'),
       ('jfernandezc', 'jfernandezc1234', 'Admin', '12345678B'),
       ('gmuletf', 'gmuletf1234', 'Admin', '12345678C'),
       ('gsalvac', 'gsalvac1234', 'Admin', '12345678D'),
       ('lmatasp', 'lmatasp1234', 'Usuario', '12345678E');

-- Creacion de la tabla de las nominas.
CREATE TABLE Nomina(
    idNomina INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    NIF NVARCHAR(9),
    fechaInicio NVARCHAR(15),
    fechaFin NVARCHAR(15),
    horasExtra NVARCHAR(15),
    horasExtraMayor NVARCHAR(15),
    horasComplementarias NVARCHAR(15),
    ccInfo NVARCHAR(15),
    paroInfo NVARCHAR(15),
    fpInfo NVARCHAR(15),
    irpfInfo NVARCHAR(15),
    totalDevengado NVARCHAR(15),
    contingenciasComunes NVARCHAR(15),
    paro NVARCHAR(15),
    formacionProfesional NVARCHAR(15),
    irpf NVARCHAR(15),
    totalAportaciones NVARCHAR(15),
    totalReducir NVARCHAR(15),
    idConvenio NVARCHAR(3),
    importeTotalAPercibir NVARCHAR(255),
    FOREIGN KEY (NIF) REFERENCES Trabajador(NIF) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (idConvenio) REFERENCES Convenio(idConvenio) ON DELETE CASCADE ON UPDATE CASCADE
);
------------------------------------------------------------------------------------------------
