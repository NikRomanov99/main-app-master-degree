CREATE TABLE public.available_equipment
(
    id                        BIGSERIAL PRIMARY KEY,
    r_equipment_id            BIGINT NOT NULL,
    description               TEXT,
    last_tech_inspection_date TIMESTAMP,
    r_last_inspection_user_id BIGINT NOT NULL,
    r_factory_id              BIGINT NOT NULL,
    CONSTRAINT fk_aequipment_equipment_id
        FOREIGN KEY (r_equipment_id)
            REFERENCES equipment (id)
            ON DELETE CASCADE,
    CONSTRAINT fk_aequipment_user_id
        FOREIGN KEY (r_last_inspection_user_id)
            REFERENCES app_user (id)
            ON DELETE SET NULL ,
    CONSTRAINT fk_aequipment_factory_id
        FOREIGN KEY (r_factory_id)
            REFERENCES factory (id)
            ON DELETE CASCADE
);

INSERT INTO public.available_equipment(r_equipment_id, description, last_tech_inspection_date,
                                       r_last_inspection_user_id, r_factory_id)
VALUES (1, null, '01-02-2023', 6, 1);