CREATE TABLE t_users_roles (

	id_user BIGINT NOT NULL,
	id_role BIGINT NOT NULL,

    FOREIGN KEY(id_user) REFERENCES t_users(id),
    FOREIGN KEY(id_role) REFERENCES t_roles(id),
    PRIMARY KEY(id_user, id_role)

);