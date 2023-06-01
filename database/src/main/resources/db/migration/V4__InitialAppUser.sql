CREATE TABLE public.app_user
(
    id          BIGSERIAL PRIMARY KEY,
    name        TEXT   NOT NULL,
    surname     TEXT   NOT NULL,
    r_role_id   BIGINT NOT NULL,
    description TEXT,
    tg_user_name TEXT,
    CONSTRAINT fk_user_role_id
        FOREIGN KEY (r_role_id)
            REFERENCES role (id)
            ON DELETE CASCADE
);

INSERT INTO public.app_user(name, surname, r_role_id, description, tg_user_name)
VALUES ('Admin', 'Admin', 1, null, null);
INSERT INTO public.app_user(name, surname, r_role_id, description, tg_user_name)
VALUES ('Иван', 'Иванов', 2, null, null);
INSERT INTO public.app_user(name, surname, r_role_id, description, tg_user_name)
VALUES ('Петр', 'Петров', 3, null, null);
INSERT INTO public.app_user(name, surname, r_role_id, description, tg_user_name)
VALUES ('Елена', 'Сидорова', 4, null, null);
INSERT INTO public.app_user(name, surname, r_role_id, description, tg_user_name)
VALUES ('Ольга', 'Кузнецова', 5, null, null);
INSERT INTO public.app_user(name, surname, r_role_id, description, tg_user_name)
VALUES ('Алексей', 'Смирнов', 6, null, null);
INSERT INTO public.app_user(name, surname, r_role_id, description, tg_user_name)
VALUES ('Анастасия', 'Новикова', 6, null, null);
INSERT INTO public.app_user(name, surname, r_role_id, description, tg_user_name)
VALUES ('Дмитрий', 'Гаврилов', 6, null, null);
INSERT INTO public.app_user(name, surname, r_role_id, description, tg_user_name)
VALUES ('Никита', 'Романов', 6, null, 'pepperoni_dog');