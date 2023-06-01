CREATE TABLE public.role
(
    id          BIGSERIAL PRIMARY KEY,
    name        TEXT NOT NULL,
    description TEXT
);

INSERT INTO public.role(name, description)
VALUES ('Admin', 'Администратор системы');
INSERT INTO public.role(name, description)
VALUES ('Top Manager', 'Менеджер высшего звена');
INSERT INTO public.role(name, description)
VALUES ('Manager', 'Менеджер');
INSERT INTO public.role(name, description)
VALUES ('Senior Engineer', 'Старший инжинер');
INSERT INTO public.role(name, description)
VALUES ('Engineer', 'Инжинер');
INSERT INTO public.role(name, description)
VALUES ('User', 'Обычный пользователь');
