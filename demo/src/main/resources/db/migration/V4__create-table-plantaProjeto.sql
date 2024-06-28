-- Criando tabela PlantaProjeto
CREATE TABLE PlantaProjeto (
    idPlanta INT NOT NULL,
    idProjeto INT NOT NULL,
    PRIMARY KEY (idPlanta, idProjeto),
    FOREIGN KEY (idPlanta) REFERENCES Planta(idPlanta) ON DELETE CASCADE,
    FOREIGN KEY (idProjeto) REFERENCES Projeto(idProjeto) ON DELETE CASCADE
);