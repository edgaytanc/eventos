toc.dat                                                                                             0000600 0004000 0002000 00000037512 14437513717 0014463 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP       :                    {            eventos    15.1    15.1 7    6           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         7           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false         8           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false         9           1262    16850    eventos    DATABASE     ~   CREATE DATABASE eventos WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Guatemala.1252';
    DROP DATABASE eventos;
                postgres    false         �            1259    16886    asientos    TABLE     �   CREATE TABLE public.asientos (
    id integer NOT NULL,
    fila character varying(2) NOT NULL,
    numero integer NOT NULL,
    seccion_id integer NOT NULL,
    estado character varying(50) NOT NULL
);
    DROP TABLE public.asientos;
       public         heap    postgres    false         �            1259    16885    asientos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.asientos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.asientos_id_seq;
       public          postgres    false    221         :           0    0    asientos_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.asientos_id_seq OWNED BY public.asientos.id;
          public          postgres    false    220         �            1259    16898    boletos    TABLE       CREATE TABLE public.boletos (
    id integer NOT NULL,
    evento_id integer NOT NULL,
    usuario_id integer NOT NULL,
    seccion_id integer NOT NULL,
    asiento_id integer NOT NULL,
    fecha_hora_evento timestamp without time zone NOT NULL,
    direccion_venue text NOT NULL
);
    DROP TABLE public.boletos;
       public         heap    postgres    false         �            1259    16897    boletos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.boletos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.boletos_id_seq;
       public          postgres    false    223         ;           0    0    boletos_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.boletos_id_seq OWNED BY public.boletos.id;
          public          postgres    false    222         �            1259    16852    eventos    TABLE     �  CREATE TABLE public.eventos (
    id integer NOT NULL,
    nombre character varying(255) NOT NULL,
    sinopsis text,
    fecha_inicio timestamp without time zone NOT NULL,
    fecha_fin timestamp without time zone NOT NULL,
    imagen_publicitaria text,
    responsable character varying(255) NOT NULL,
    fecha_hora_publicacion timestamp without time zone,
    fecha_hora_ocultar timestamp without time zone
);
    DROP TABLE public.eventos;
       public         heap    postgres    false         �            1259    16851    eventos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.eventos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.eventos_id_seq;
       public          postgres    false    215         <           0    0    eventos_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.eventos_id_seq OWNED BY public.eventos.id;
          public          postgres    false    214         �            1259    16927    precios    TABLE     �   CREATE TABLE public.precios (
    id integer NOT NULL,
    evento_id integer NOT NULL,
    seccion_id integer NOT NULL,
    precio numeric(10,2) NOT NULL
);
    DROP TABLE public.precios;
       public         heap    postgres    false         �            1259    16926    precios_id_seq    SEQUENCE     �   CREATE SEQUENCE public.precios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.precios_id_seq;
       public          postgres    false    225         =           0    0    precios_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.precios_id_seq OWNED BY public.precios.id;
          public          postgres    false    224         �            1259    16872 	   secciones    TABLE     �   CREATE TABLE public.secciones (
    id integer NOT NULL,
    nombre character varying(50) NOT NULL,
    evento_id integer NOT NULL
);
    DROP TABLE public.secciones;
       public         heap    postgres    false         �            1259    16871    secciones_id_seq    SEQUENCE     �   CREATE SEQUENCE public.secciones_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.secciones_id_seq;
       public          postgres    false    219         >           0    0    secciones_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.secciones_id_seq OWNED BY public.secciones.id;
          public          postgres    false    218         �            1259    16861    usuarios    TABLE     G  CREATE TABLE public.usuarios (
    id integer NOT NULL,
    nombre character varying(255) NOT NULL,
    apellido character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    telefono character varying(20) NOT NULL,
    "contraseña" character varying(255) NOT NULL,
    rol character varying(50) NOT NULL
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false         �            1259    16860    usuarios_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuarios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.usuarios_id_seq;
       public          postgres    false    217         ?           0    0    usuarios_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;
          public          postgres    false    216         �           2604    16889    asientos id    DEFAULT     j   ALTER TABLE ONLY public.asientos ALTER COLUMN id SET DEFAULT nextval('public.asientos_id_seq'::regclass);
 :   ALTER TABLE public.asientos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    221    220    221         �           2604    16901 
   boletos id    DEFAULT     h   ALTER TABLE ONLY public.boletos ALTER COLUMN id SET DEFAULT nextval('public.boletos_id_seq'::regclass);
 9   ALTER TABLE public.boletos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    223    222    223         ~           2604    16855 
   eventos id    DEFAULT     h   ALTER TABLE ONLY public.eventos ALTER COLUMN id SET DEFAULT nextval('public.eventos_id_seq'::regclass);
 9   ALTER TABLE public.eventos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215         �           2604    16930 
   precios id    DEFAULT     h   ALTER TABLE ONLY public.precios ALTER COLUMN id SET DEFAULT nextval('public.precios_id_seq'::regclass);
 9   ALTER TABLE public.precios ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    225    224    225         �           2604    16875    secciones id    DEFAULT     l   ALTER TABLE ONLY public.secciones ALTER COLUMN id SET DEFAULT nextval('public.secciones_id_seq'::regclass);
 ;   ALTER TABLE public.secciones ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    219    219                    2604    16943    usuarios id    DEFAULT     j   ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);
 :   ALTER TABLE public.usuarios ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217         /          0    16886    asientos 
   TABLE DATA           H   COPY public.asientos (id, fila, numero, seccion_id, estado) FROM stdin;
    public          postgres    false    221       3375.dat 1          0    16898    boletos 
   TABLE DATA           x   COPY public.boletos (id, evento_id, usuario_id, seccion_id, asiento_id, fecha_hora_evento, direccion_venue) FROM stdin;
    public          postgres    false    223       3377.dat )          0    16852    eventos 
   TABLE DATA           �   COPY public.eventos (id, nombre, sinopsis, fecha_inicio, fecha_fin, imagen_publicitaria, responsable, fecha_hora_publicacion, fecha_hora_ocultar) FROM stdin;
    public          postgres    false    215       3369.dat 3          0    16927    precios 
   TABLE DATA           D   COPY public.precios (id, evento_id, seccion_id, precio) FROM stdin;
    public          postgres    false    225       3379.dat -          0    16872 	   secciones 
   TABLE DATA           :   COPY public.secciones (id, nombre, evento_id) FROM stdin;
    public          postgres    false    219       3373.dat +          0    16861    usuarios 
   TABLE DATA           ]   COPY public.usuarios (id, nombre, apellido, email, telefono, "contraseña", rol) FROM stdin;
    public          postgres    false    217       3371.dat @           0    0    asientos_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.asientos_id_seq', 1, false);
          public          postgres    false    220         A           0    0    boletos_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.boletos_id_seq', 1, false);
          public          postgres    false    222         B           0    0    eventos_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.eventos_id_seq', 4, true);
          public          postgres    false    214         C           0    0    precios_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.precios_id_seq', 4, true);
          public          postgres    false    224         D           0    0    secciones_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.secciones_id_seq', 4, true);
          public          postgres    false    218         E           0    0    usuarios_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuarios_id_seq', 4, true);
          public          postgres    false    216         �           2606    16891    asientos asientos_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.asientos
    ADD CONSTRAINT asientos_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.asientos DROP CONSTRAINT asientos_pkey;
       public            postgres    false    221         �           2606    16905    boletos boletos_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.boletos
    ADD CONSTRAINT boletos_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.boletos DROP CONSTRAINT boletos_pkey;
       public            postgres    false    223         �           2606    16859    eventos eventos_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.eventos
    ADD CONSTRAINT eventos_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.eventos DROP CONSTRAINT eventos_pkey;
       public            postgres    false    215         �           2606    16932    precios precios_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.precios
    ADD CONSTRAINT precios_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.precios DROP CONSTRAINT precios_pkey;
       public            postgres    false    225         �           2606    16879    secciones secciones_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.secciones
    ADD CONSTRAINT secciones_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.secciones DROP CONSTRAINT secciones_pkey;
       public            postgres    false    219         �           2606    16870    usuarios usuarios_email_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_email_key UNIQUE (email);
 E   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_email_key;
       public            postgres    false    217         �           2606    16868    usuarios usuarios_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public            postgres    false    217         �           2606    16892 !   asientos asientos_seccion_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.asientos
    ADD CONSTRAINT asientos_seccion_id_fkey FOREIGN KEY (seccion_id) REFERENCES public.secciones(id);
 K   ALTER TABLE ONLY public.asientos DROP CONSTRAINT asientos_seccion_id_fkey;
       public          postgres    false    3211    219    221         �           2606    16921    boletos boletos_asiento_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.boletos
    ADD CONSTRAINT boletos_asiento_id_fkey FOREIGN KEY (asiento_id) REFERENCES public.asientos(id);
 I   ALTER TABLE ONLY public.boletos DROP CONSTRAINT boletos_asiento_id_fkey;
       public          postgres    false    221    223    3213         �           2606    16906    boletos boletos_evento_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.boletos
    ADD CONSTRAINT boletos_evento_id_fkey FOREIGN KEY (evento_id) REFERENCES public.eventos(id);
 H   ALTER TABLE ONLY public.boletos DROP CONSTRAINT boletos_evento_id_fkey;
       public          postgres    false    223    3205    215         �           2606    16916    boletos boletos_seccion_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.boletos
    ADD CONSTRAINT boletos_seccion_id_fkey FOREIGN KEY (seccion_id) REFERENCES public.secciones(id);
 I   ALTER TABLE ONLY public.boletos DROP CONSTRAINT boletos_seccion_id_fkey;
       public          postgres    false    219    223    3211         �           2606    16911    boletos boletos_usuario_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.boletos
    ADD CONSTRAINT boletos_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id);
 I   ALTER TABLE ONLY public.boletos DROP CONSTRAINT boletos_usuario_id_fkey;
       public          postgres    false    217    223    3209         �           2606    16933    precios precios_evento_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.precios
    ADD CONSTRAINT precios_evento_id_fkey FOREIGN KEY (evento_id) REFERENCES public.eventos(id);
 H   ALTER TABLE ONLY public.precios DROP CONSTRAINT precios_evento_id_fkey;
       public          postgres    false    3205    225    215         �           2606    16938    precios precios_seccion_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.precios
    ADD CONSTRAINT precios_seccion_id_fkey FOREIGN KEY (seccion_id) REFERENCES public.secciones(id);
 I   ALTER TABLE ONLY public.precios DROP CONSTRAINT precios_seccion_id_fkey;
       public          postgres    false    3211    219    225         �           2606    16880 "   secciones secciones_evento_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.secciones
    ADD CONSTRAINT secciones_evento_id_fkey FOREIGN KEY (evento_id) REFERENCES public.eventos(id);
 L   ALTER TABLE ONLY public.secciones DROP CONSTRAINT secciones_evento_id_fkey;
       public          postgres    false    219    3205    215                                                                                                                                                                                              3375.dat                                                                                            0000600 0004000 0002000 00000000005 14437513717 0014262 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           3377.dat                                                                                            0000600 0004000 0002000 00000000005 14437513717 0014264 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        \.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           3369.dat                                                                                            0000600 0004000 0002000 00000001765 14437513717 0014303 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Concierto Musica clasica	Concierto a veneficio de todas aquellas personas amantes de la buena musica que estan cansadas del regueton.	2023-06-17 00:00:00	2023-06-17 00:00:00	c:/imagen.png	David Gaytan	2023-06-04 00:00:00	2023-06-16 00:00:00
2	Camponato de Judo	Para los amantes de las artes marciales tradicionales, El judo el deporte de contacto mas popular de japon y de muchas paises en todo el mundo.	2023-06-10 00:00:00	2023-06-11 00:00:00	file:/D:/Users/David/Pictures/3D/macOS.jpg	David Gaytan	2023-06-04 00:00:00	2023-06-02 00:00:00
3	Concierto de Nirvana	concierto de HardRock con el lejendario grupo Nirvana en su reencuentro	2023-06-09 00:00:00	2023-06-09 00:00:00	file:/D:/Users/David/Pictures/3D/vsta.png	Carlos	2023-06-06 00:00:00	2023-06-08 00:00:00
4	Concierto  de Guitarra	concierto acustico de guitarra de la mana de la orquestina de Antigua guatemala	2023-06-30 00:00:00	2023-06-30 00:00:00	file:/D:/Users/David/Pictures/Screenshots/greeco01.png		2023-06-06 00:00:00	2023-06-29 00:00:00
\.


           3379.dat                                                                                            0000600 0004000 0002000 00000000071 14437513717 0014271 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	1	1	300.00
2	1	2	250.00
3	1	3	200.00
4	1	4	150.00
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                       3373.dat                                                                                            0000600 0004000 0002000 00000000062 14437513717 0014263 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	VIP+M&G	1
2	VIP	1
3	Platea A	1
4	PlateaB	1
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                              3371.dat                                                                                            0000600 0004000 0002000 00000000426 14437513717 0014265 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        2	Aracely	Gomez	aracelygbatres@gmail.com	55554444	-463193062	cliente
3	Alejandro	Morales	1992alejandro@gmail.com	44445555	1147887826	cliente
4	Ruby	Morales	rubymorgo@gmail.com	11112222	-463193062	cliente
1	David	Gaytan	edgaytanc@gmail.com	55117730	-463193062	Administrador
\.


                                                                                                                                                                                                                                          restore.sql                                                                                         0000600 0004000 0002000 00000031333 14437513717 0015403 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

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

DROP DATABASE eventos;
--
-- Name: eventos; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE eventos WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Guatemala.1252';


ALTER DATABASE eventos OWNER TO postgres;

\connect eventos

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: asientos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.asientos (
    id integer NOT NULL,
    fila character varying(2) NOT NULL,
    numero integer NOT NULL,
    seccion_id integer NOT NULL,
    estado character varying(50) NOT NULL
);


ALTER TABLE public.asientos OWNER TO postgres;

--
-- Name: asientos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.asientos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.asientos_id_seq OWNER TO postgres;

--
-- Name: asientos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.asientos_id_seq OWNED BY public.asientos.id;


--
-- Name: boletos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.boletos (
    id integer NOT NULL,
    evento_id integer NOT NULL,
    usuario_id integer NOT NULL,
    seccion_id integer NOT NULL,
    asiento_id integer NOT NULL,
    fecha_hora_evento timestamp without time zone NOT NULL,
    direccion_venue text NOT NULL
);


ALTER TABLE public.boletos OWNER TO postgres;

--
-- Name: boletos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.boletos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.boletos_id_seq OWNER TO postgres;

--
-- Name: boletos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.boletos_id_seq OWNED BY public.boletos.id;


--
-- Name: eventos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.eventos (
    id integer NOT NULL,
    nombre character varying(255) NOT NULL,
    sinopsis text,
    fecha_inicio timestamp without time zone NOT NULL,
    fecha_fin timestamp without time zone NOT NULL,
    imagen_publicitaria text,
    responsable character varying(255) NOT NULL,
    fecha_hora_publicacion timestamp without time zone,
    fecha_hora_ocultar timestamp without time zone
);


ALTER TABLE public.eventos OWNER TO postgres;

--
-- Name: eventos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.eventos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.eventos_id_seq OWNER TO postgres;

--
-- Name: eventos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.eventos_id_seq OWNED BY public.eventos.id;


--
-- Name: precios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.precios (
    id integer NOT NULL,
    evento_id integer NOT NULL,
    seccion_id integer NOT NULL,
    precio numeric(10,2) NOT NULL
);


ALTER TABLE public.precios OWNER TO postgres;

--
-- Name: precios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.precios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.precios_id_seq OWNER TO postgres;

--
-- Name: precios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.precios_id_seq OWNED BY public.precios.id;


--
-- Name: secciones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.secciones (
    id integer NOT NULL,
    nombre character varying(50) NOT NULL,
    evento_id integer NOT NULL
);


ALTER TABLE public.secciones OWNER TO postgres;

--
-- Name: secciones_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.secciones_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.secciones_id_seq OWNER TO postgres;

--
-- Name: secciones_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.secciones_id_seq OWNED BY public.secciones.id;


--
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    id integer NOT NULL,
    nombre character varying(255) NOT NULL,
    apellido character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    telefono character varying(20) NOT NULL,
    "contraseña" character varying(255) NOT NULL,
    rol character varying(50) NOT NULL
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- Name: usuarios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuarios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuarios_id_seq OWNER TO postgres;

--
-- Name: usuarios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;


--
-- Name: asientos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asientos ALTER COLUMN id SET DEFAULT nextval('public.asientos_id_seq'::regclass);


--
-- Name: boletos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.boletos ALTER COLUMN id SET DEFAULT nextval('public.boletos_id_seq'::regclass);


--
-- Name: eventos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eventos ALTER COLUMN id SET DEFAULT nextval('public.eventos_id_seq'::regclass);


--
-- Name: precios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.precios ALTER COLUMN id SET DEFAULT nextval('public.precios_id_seq'::regclass);


--
-- Name: secciones id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secciones ALTER COLUMN id SET DEFAULT nextval('public.secciones_id_seq'::regclass);


--
-- Name: usuarios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);


--
-- Data for Name: asientos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.asientos (id, fila, numero, seccion_id, estado) FROM stdin;
\.
COPY public.asientos (id, fila, numero, seccion_id, estado) FROM '$$PATH$$/3375.dat';

--
-- Data for Name: boletos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.boletos (id, evento_id, usuario_id, seccion_id, asiento_id, fecha_hora_evento, direccion_venue) FROM stdin;
\.
COPY public.boletos (id, evento_id, usuario_id, seccion_id, asiento_id, fecha_hora_evento, direccion_venue) FROM '$$PATH$$/3377.dat';

--
-- Data for Name: eventos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.eventos (id, nombre, sinopsis, fecha_inicio, fecha_fin, imagen_publicitaria, responsable, fecha_hora_publicacion, fecha_hora_ocultar) FROM stdin;
\.
COPY public.eventos (id, nombre, sinopsis, fecha_inicio, fecha_fin, imagen_publicitaria, responsable, fecha_hora_publicacion, fecha_hora_ocultar) FROM '$$PATH$$/3369.dat';

--
-- Data for Name: precios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.precios (id, evento_id, seccion_id, precio) FROM stdin;
\.
COPY public.precios (id, evento_id, seccion_id, precio) FROM '$$PATH$$/3379.dat';

--
-- Data for Name: secciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.secciones (id, nombre, evento_id) FROM stdin;
\.
COPY public.secciones (id, nombre, evento_id) FROM '$$PATH$$/3373.dat';

--
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (id, nombre, apellido, email, telefono, "contraseña", rol) FROM stdin;
\.
COPY public.usuarios (id, nombre, apellido, email, telefono, "contraseña", rol) FROM '$$PATH$$/3371.dat';

--
-- Name: asientos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.asientos_id_seq', 1, false);


--
-- Name: boletos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.boletos_id_seq', 1, false);


--
-- Name: eventos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.eventos_id_seq', 4, true);


--
-- Name: precios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.precios_id_seq', 4, true);


--
-- Name: secciones_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.secciones_id_seq', 4, true);


--
-- Name: usuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_id_seq', 4, true);


--
-- Name: asientos asientos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asientos
    ADD CONSTRAINT asientos_pkey PRIMARY KEY (id);


--
-- Name: boletos boletos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.boletos
    ADD CONSTRAINT boletos_pkey PRIMARY KEY (id);


--
-- Name: eventos eventos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eventos
    ADD CONSTRAINT eventos_pkey PRIMARY KEY (id);


--
-- Name: precios precios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.precios
    ADD CONSTRAINT precios_pkey PRIMARY KEY (id);


--
-- Name: secciones secciones_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secciones
    ADD CONSTRAINT secciones_pkey PRIMARY KEY (id);


--
-- Name: usuarios usuarios_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_email_key UNIQUE (email);


--
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);


--
-- Name: asientos asientos_seccion_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asientos
    ADD CONSTRAINT asientos_seccion_id_fkey FOREIGN KEY (seccion_id) REFERENCES public.secciones(id);


--
-- Name: boletos boletos_asiento_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.boletos
    ADD CONSTRAINT boletos_asiento_id_fkey FOREIGN KEY (asiento_id) REFERENCES public.asientos(id);


--
-- Name: boletos boletos_evento_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.boletos
    ADD CONSTRAINT boletos_evento_id_fkey FOREIGN KEY (evento_id) REFERENCES public.eventos(id);


--
-- Name: boletos boletos_seccion_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.boletos
    ADD CONSTRAINT boletos_seccion_id_fkey FOREIGN KEY (seccion_id) REFERENCES public.secciones(id);


--
-- Name: boletos boletos_usuario_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.boletos
    ADD CONSTRAINT boletos_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id);


--
-- Name: precios precios_evento_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.precios
    ADD CONSTRAINT precios_evento_id_fkey FOREIGN KEY (evento_id) REFERENCES public.eventos(id);


--
-- Name: precios precios_seccion_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.precios
    ADD CONSTRAINT precios_seccion_id_fkey FOREIGN KEY (seccion_id) REFERENCES public.secciones(id);


--
-- Name: secciones secciones_evento_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secciones
    ADD CONSTRAINT secciones_evento_id_fkey FOREIGN KEY (evento_id) REFERENCES public.eventos(id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     