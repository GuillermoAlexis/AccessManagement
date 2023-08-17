--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4
-- Dumped by pg_dump version 12.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: uuid-ossp; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;


--
-- Name: EXTENSION "uuid-ossp"; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: acceso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.acceso (
    id_acceso integer NOT NULL,
    id_usuario uuid,
    "timestamp" timestamp without time zone
);


ALTER TABLE public.acceso OWNER TO postgres;

--
-- Name: acceso_idacceso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.acceso_idacceso_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.acceso_idacceso_seq OWNER TO postgres;

--
-- Name: acceso_idacceso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.acceso_idacceso_seq OWNED BY public.acceso.id_acceso;


--
-- Name: permiso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.permiso (
    id_permiso integer NOT NULL,
    id_usuario uuid,
    permiso character varying(50)
);


ALTER TABLE public.permiso OWNER TO postgres;

--
-- Name: permiso_idpermiso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.permiso_idpermiso_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.permiso_idpermiso_seq OWNER TO postgres;

--
-- Name: permiso_idpermiso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.permiso_idpermiso_seq OWNED BY public.permiso.id_permiso;


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id_usuario uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    nombre_completo character varying(100),
    email character varying(100),
    contrasena character varying(100)
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- Name: acceso id_acceso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.acceso ALTER COLUMN id_acceso SET DEFAULT nextval('public.acceso_idacceso_seq'::regclass);


--
-- Name: permiso id_permiso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permiso ALTER COLUMN id_permiso SET DEFAULT nextval('public.permiso_idpermiso_seq'::regclass);


--
-- Restored data
--

-- Restored data

-- Insertar en la tabla "usuario"
INSERT INTO public.usuario (id_usuario, nombre_completo, email, contrasena) VALUES
    ('647c29fc-e937-47c4-80dd-b65600c09a44', 'Usuario 1', 'usuario1@example.com', 'contrasena1'),
    ('9d0530c3-de56-484a-893d-264c3f8403e6', 'Usuario 2', 'usuario2@example.com', 'contrasena2');

-- Insertar en la tabla "permiso"
INSERT INTO public.permiso (id_permiso, id_usuario, permiso) VALUES
    (1, '647c29fc-e937-47c4-80dd-b65600c09a44', 'VISUALIZACION_DASHBOARDS'),
    (2, '647c29fc-e937-47c4-80dd-b65600c09a44', 'ADMIN'),
    (3, '647c29fc-e937-47c4-80dd-b65600c09a44', 'AUDITORIA');

-- Insertar en la tabla "acceso"
INSERT INTO public.acceso (id_acceso, id_usuario, "timestamp") VALUES
    (1, '647c29fc-e937-47c4-80dd-b65600c09a44', '2023-08-15 15:09:12.283205'),
    (2, '647c29fc-e937-47c4-80dd-b65600c09a44', '2023-09-15 15:09:12.283');

-- PostgreSQL database dump complete