CREATE TABLE public.factory
(
    id           BIGSERIAL PRIMARY KEY,
    name         TEXT NOT NULL,
    company_name TEXT,
    address      TEXT
);

INSERT INTO public.factory(name, company_name, address)
VALUES ('ОАО "Газпромнефть-Хантос"', 'Газпром нефть', 'ул. Ленина, 12, г. Ханты-Мансийск');
INSERT INTO public.factory(name, company_name, address)
VALUES ('ОАО "Сургутнефтегаз"', ' Сургутнефтегаз', 'ул. Ленина, 1, г. Сургут');
INSERT INTO public.factory(name, company_name, address)
VALUES ('ОАО "Роснефть"', 'Роснефть', 'ул. Ленина, 12, г. Ханты-Мансийск');
INSERT INTO public.factory(name, company_name, address)
VALUES ('ОАО "ЛУКОЙЛ-Западная Сибирь"', 'ЛУКОЙЛ', 'ул. Победы, 1, г. Когалым');
INSERT INTO public.factory(name, company_name, address)
VALUES ('ОАО "Татнефть"', 'Татнефть', 'ул. Ленина, 16, г. Альметьевск');