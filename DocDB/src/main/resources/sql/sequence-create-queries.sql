CREATE SEQUENCE IF NOT EXISTS "DocDB".appointments_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY NONE;

ALTER SEQUENCE "DocDB".appointments_id_seq
    OWNER TO postgres;

-- ===========================================================

CREATE SEQUENCE IF NOT EXISTS "DocDB".doctors_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY NONE;

ALTER SEQUENCE "DocDB".doctors_id_seq
    OWNER TO postgres;

--======================================================

CREATE SEQUENCE IF NOT EXISTS "DocDB".patients_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY NONE;

ALTER SEQUENCE "DocDB".patients_id_seq
    OWNER TO postgres;

--======================================================

CREATE SEQUENCE IF NOT EXISTS "DocDB".specialities_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY NONE;

ALTER SEQUENCE "DocDB".specialities_id_seq
    OWNER TO postgres;


--======================================================


CREATE SEQUENCE IF NOT EXISTS "DocDB".users_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY NONE;

ALTER SEQUENCE "DocDB".users_id_seq
    OWNER TO postgres;


   INSERT INTO "DocDB".users(
    	email, username, password, status, account_type)
    	VALUES ('ira@gmail.com', 'ira', 'pswd', 'ACTIVE', 'PATIENT');