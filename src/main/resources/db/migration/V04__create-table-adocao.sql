CREATE TABLE t_adocao (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_pet BIGINT NOT NULL,
    id_tutor BIGINT NOT NULL,
    data VARCHAR(10) NOT NULL,

    FOREIGN KEY (id_pet) REFERENCES t_pet(id),
    FOREIGN KEY (id_tutor) REFERENCES t_tutor(id)
);