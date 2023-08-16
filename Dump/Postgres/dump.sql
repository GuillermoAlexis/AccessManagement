--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4
-- Dumped by pg_dump version 14.2

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
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2992 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 205 (class 1259 OID 24596)
-- Name: acceso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.acceso (
    id_acceso integer NOT NULL,
    id_usuario uuid,
    "timestamp" timestamp without time zone
);


ALTER TABLE public.acceso OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24594)
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
-- TOC entry 2993 (class 0 OID 0)
-- Dependencies: 204
-- Name: acceso_idacceso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.acceso_idacceso_seq OWNED BY public.acceso.id_acceso;


--
-- TOC entry 207 (class 1259 OID 24609)
-- Name: permiso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.permiso (
    id_permiso integer NOT NULL,
    id_usuario uuid,
    permiso character varying(50)
);


ALTER TABLE public.permiso OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 24607)
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
-- TOC entry 2994 (class 0 OID 0)
-- Dependencies: 206
-- Name: permiso_idpermiso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.permiso_idpermiso_seq OWNED BY public.permiso.id_permiso;


--
-- TOC entry 203 (class 1259 OID 24588)
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
-- TOC entry 2846 (class 2604 OID 24599)
-- Name: acceso id_acceso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.acceso ALTER COLUMN id_acceso SET DEFAULT nextval('public.acceso_idacceso_seq'::regclass);


--
-- TOC entry 2847 (class 2604 OID 24612)
-- Name: permiso id_permiso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permiso ALTER COLUMN id_permiso SET DEFAULT nextval('public.permiso_idpermiso_seq'::regclass);


--
-- TOC entry 2984 (class 0 OID 24596)
-- Dependencies: 205
-- Data for Name: acceso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.acceso (id_acceso, id_usuario, "timestamp") FROM stdin;
1	647c29fc-e937-47c4-80dd-b65600c09a44	2023-08-15 15:09:12.283205
2	647c29fc-e937-47c4-80dd-b65600c09a44	2023-09-15 15:09:12.283
\.


--
-- TOC entry 2986 (class 0 OID 24609)
-- Dependencies: 207
-- Data for Name: permiso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.permiso (id_permiso, id_usuario, permiso) FROM stdin;
1	647c29fc-e937-47c4-80dd-b65600c09a44	VISUALIZACION_DASHBOARDS
2	647c29fc-e937-47c4-80dd-b65600c09a44	ADMIN
3	647c29fc-e937-47c4-80dd-b65600c09a44	AUDITORIA
\.


--
-- TOC entry 2982 (class 0 OID 24588)
-- Dependencies: 203
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id_usuario, nombre_completo, email, contrasena) FROM stdin;
647c29fc-e937-47c4-80dd-b65600c09a44	Usuario 1	usuario1@example.com	contrasena1
9d0530c3-de56-484a-893d-264c3f8403e6	Usuario 2	usuario2@example.com	contrasena2
\.


--
-- TOC entry 2995 (class 0 OID 0)
-- Dependencies: 204
-- Name: acceso_idacceso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.acceso_idacceso_seq', 2, true);


--
-- TOC entry 2996 (class 0 OID 0)
-- Dependencies: 206
-- Name: permiso_idpermiso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.permiso_idpermiso_seq', 3, true);


--
-- TOC entry 2851 (class 2606 OID 24601)
-- Name: acceso acceso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.acceso
    ADD CONSTRAINT acceso_pkey PRIMARY KEY (id_acceso);


--
-- TOC entry 2853 (class 2606 OID 24614)
-- Name: permiso permiso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permiso
    ADD CONSTRAINT permiso_pkey PRIMARY KEY (id_permiso);


--
-- TOC entry 2849 (class 2606 OID 24593)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 2854 (class 2606 OID 24602)
-- Name: acceso acceso_idusuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.acceso
    ADD CONSTRAINT acceso_idusuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 2855 (class 2606 OID 24615)
-- Name: permiso permiso_idusuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permiso
    ADD CONSTRAINT permiso_idusuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


-- Completed on 2023-08-16 15:38:09

--
-- PostgreSQL database dump complete
--

