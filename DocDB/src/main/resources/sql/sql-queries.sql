-- here will be all SQLs

--appointments create query :

CREATE TABLE IF NOT EXISTS "DocDB".appointments
(
    id integer NOT NULL DEFAULT nextval('"DocDB".appointments_id_seq'::regclass),
    patient_id bigint NOT NULL,
    doctor_id bigint NOT NULL,
    date date NOT NULL,
    details character varying COLLATE pg_catalog."default",
    observations character varying COLLATE pg_catalog."default",
    CONSTRAINT appointments_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "DocDB".appointments
    OWNER to postgres;



--doctors create query
CREATE TABLE IF NOT EXISTS "DocDB".doctors
(
    id integer NOT NULL DEFAULT nextval('"DocDB".doctors_id_seq'::regclass),
    user_id bigint NOT NULL,
    firstname character varying COLLATE pg_catalog."default" NOT NULL,
    lastname character varying COLLATE pg_catalog."default" NOT NULL,
    speciality character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT doctors_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "DocDB".doctors
    OWNER to postgres;




--patients create query
CREATE TABLE IF NOT EXISTS "DocDB".patients
(
    id integer NOT NULL DEFAULT nextval('"DocDB".patients_id_seq'::regclass),
    user_id bigint NOT NULL,
    firstname character varying COLLATE pg_catalog."default" NOT NULL,
    lastname character varying COLLATE pg_catalog."default" NOT NULL,
    phone_number character varying COLLATE pg_catalog."default" NOT NULL,
    cnp character varying COLLATE pg_catalog."default" NOT NULL,
    birth_day date NOT NULL,
    gender character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT patients_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "DocDB".patients
    OWNER to postgres;




--users create query
CREATE TABLE IF NOT EXISTS "DocDB".users
(
    id integer NOT NULL DEFAULT nextval('"DocDB".users_id_seq'::regclass),
    email character varying COLLATE pg_catalog."default" NOT NULL,
    username character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    status character varying COLLATE pg_catalog."default" NOT NULL,
    account_type character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "DocDB".users
    OWNER to postgres;