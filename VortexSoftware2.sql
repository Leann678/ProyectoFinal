create database VortexSoftware;
use VortexSoftware;

CREATE TABLE Cliente (
    cedula_cliente VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    cant_proyectos INT DEFAULT 0 CHECK (cant_proyectos <= 5)
);

CREATE TABLE Proyecto (
    nombre_proyecto VARCHAR(100) PRIMARY KEY
);

CREATE TABLE Trabajador (
    cedula_trab VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    direccion VARCHAR(75) NOT NULL,
    genero VARCHAR(15) NOT NULL,
    edad INT NOT NULL CHECK (edad >= 18),
    salario DECIMAL(12, 2) NOT NULL,
    proyecto VARCHAR(75),
    calificacion_anual VARCHAR(50),
    FOREIGN KEY (nombre_proyecto) REFERENCES Proyectos(nombre_proyecto)
);

-- Tabla Diseñador (extiende Trabajadores)
CREATE TABLE Diseñador (
    cedula_trab VARCHAR(20) PRIMARY KEY,
    FOREIGN KEY (cedula_trab) REFERENCES Trabajadores(cedula_trab)
);

-- Tabla Jefes de Proyecto (extiende Trabajadores)
CREATE TABLE JefesDeProyecto (
    cedula_trab VARCHAR(20) PRIMARY KEY,
    cant_trabajadores_proyecto INT NOT NULL DEFAULT 0,
    FOREIGN KEY (cedula_trab) REFERENCES Trabajadores(cedula_trab)
);

-- Tabla Planificador (extiende Trabajadores)
CREATE TABLE Planificador (
    cedula_trab VARCHAR(20) PRIMARY KEY,
    cant_dias_planificacion INT NOT NULL,
    FOREIGN KEY (cedula_trab) REFERENCES Trabajadores(cedula_trab)
);

-- Tabla Programador (extiende Trabajadores)
CREATE TABLE Programador (
    cedula_trab VARCHAR(20) PRIMARY KEY,
    lenguaje VARCHAR(50) NOT NULL,
    FOREIGN KEY (cedula_trab) REFERENCES Trabajadores(cedula_trab)
);

CREATE TABLE Contrato (
    id_contrato VARCHAR(50) PRIMARY KEY,
    f_inicio DATE NOT NULL,
    f_entrega DATE NOT NULL,
    cant_clientes_proyecto INT DEFAULT 0 CHECK (cant_clientes_proyecto <= 5),
    cedula_cliente VARCHAR(20) NOT NULL,
    nombre_proyecto VARCHAR(75) NOT NULL,
    FOREIGN KEY (cedula_cliente) REFERENCES Clientes(cedula_cliente),
    FOREIGN KEY (nombre_proyecto) REFERENCES Proyectos(nombre_proyecto)
);

ALTER TABLE Trabajadores DROP COLUMN tipo_trabajador;
ALTER TABLE proyectos RENAME TO proyecto;
ALTER TABLE Trabajador 
RENAME COLUMN nombre_proyecto TO proyecto;