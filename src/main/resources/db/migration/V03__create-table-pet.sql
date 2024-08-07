CREATE TABLE t_pet (

	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    idade VARCHAR(50) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    adotado BOOLEAN NOT NULL,
    porte VARCHAR(50) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    uf CHAR(2) NOT NULL,
    imagem VARCHAR(300) NOT NULL,
    id_abrigo BIGINT NOT NULL,

    FOREIGN KEY (id_abrigo) REFERENCES t_abrigo(id)

);