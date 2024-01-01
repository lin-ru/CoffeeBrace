INSERT INTO users (id, status, password, username) VALUES (1, 'ACTIVE','', 'admin');
INSERT INTO users (id, status, password, username) VALUES (2, 'ACTIVE','', 'user');

INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);