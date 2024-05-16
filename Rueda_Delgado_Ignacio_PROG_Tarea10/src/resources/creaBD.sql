DROP TABLE IF EXISTS Disponible_en ;
DROP TABLE IF EXISTS Plataformas ;
DROP TABLE IF EXISTS Peliculas ;

--
-- Estructura de las tablas
--
CREATE TABLE Peliculas(
   codigo INT NOT NULL PRIMARY KEY,
   titulo  VARCHAR NOT NULL,
   sinopsis VARCHAR NOT NULL,
   fEstreno DATE NOT NULL
);

CREATE TABLE Plataformas(
   codigo INT NOT NULL PRIMARY KEY,
   nombre VARCHAR NOT NULL,
   urlLogotipo VARCHAR NOT NULL
);

CREATE TABLE Disponible_en(
   codPlataforma INT NOT NULL,   
   codPelicula INT NOT NULL,   
   fDisponibilidad DATE NOT NULL,
   PRIMARY KEY(codPlataforma,codPelicula), 
   FOREIGN KEY (codPlataforma) REFERENCES Public.Plataformas(codigo),
   FOREIGN KEY(codPelicula) REFERENCES Public.Peliculas(codigo)
);