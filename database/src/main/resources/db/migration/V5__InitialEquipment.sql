CREATE TABLE public.equipment
(
    id                  BIGSERIAL PRIMARY KEY,
    name                TEXT   NOT NULL,
    r_equipment_type_id BIGINT NOT NULL,
    service_life_year   INT,
    manufacture        TEXT,
    manufacture_date    TIMESTAMP,
    serial_number       TEXT,
    CONSTRAINT fk_equipment_equipment_type_id
        FOREIGN KEY (r_equipment_type_id)
            REFERENCES equipment_type (id)
            ON DELETE CASCADE
);

INSERT INTO public.equipment(name, r_equipment_type_id, service_life_year,
                             manufacture, manufacture_date, serial_number)
VALUES ('АЗТ-90 ', 8, 10, 'ООО "Нефтетранспорт"', '01.01.2021', 'АЗТ-90-001');