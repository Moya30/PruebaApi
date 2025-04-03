PGDMP      :    
            }            prueba_moya    14.13    16.4 #               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16519    prueba_moya    DATABASE     }   CREATE DATABASE prueba_moya WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Peru.1252';
    DROP DATABASE prueba_moya;
                postgres    false                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                postgres    false                       0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    4            �            1259    16533    estado    TABLE     g   CREATE TABLE public.estado (
    id_estado integer NOT NULL,
    nomb_estado character varying(255)
);
    DROP TABLE public.estado;
       public         heap    postgres    false    4            �            1259    16532    estado_id_estado_seq    SEQUENCE     �   ALTER TABLE public.estado ALTER COLUMN id_estado ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.estado_id_estado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210    4            �            1259    16539    foto_usuario    TABLE     �   CREATE TABLE public.foto_usuario (
    id_foto_usua integer NOT NULL,
    nomb_foto character varying(100) NOT NULL,
    url_foto character varying(255),
    id_usuario integer
);
     DROP TABLE public.foto_usuario;
       public         heap    postgres    false    4            �            1259    16538    foto_usuario_id_foto_usua_seq    SEQUENCE     �   ALTER TABLE public.foto_usuario ALTER COLUMN id_foto_usua ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.foto_usuario_id_foto_usua_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    212    4            �            1259    16545    icono    TABLE     �   CREATE TABLE public.icono (
    id_icono integer NOT NULL,
    nomb_icono character varying(255),
    url_icono character varying(255)
);
    DROP TABLE public.icono;
       public         heap    postgres    false    4            �            1259    16544    icono_id_icono_seq    SEQUENCE     �   ALTER TABLE public.icono ALTER COLUMN id_icono ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.icono_id_icono_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    4    214            �            1259    16590    proyecto    TABLE     �  CREATE TABLE public.proyecto (
    id_proyecto character varying(255) NOT NULL,
    compartir boolean,
    desc_proyecto character varying(100) NOT NULL,
    fecha_fin timestamp without time zone NOT NULL,
    fecha_ini timestamp without time zone NOT NULL,
    nomb_proyecto character varying(100) NOT NULL,
    id_estado integer,
    id_icono integer,
    id_usuario integer NOT NULL
);
    DROP TABLE public.proyecto;
       public         heap    postgres    false    4            �            1259    16558    usuario    TABLE     f  CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    ape_usua character varying(100) NOT NULL,
    carg_emp_usua character varying(100),
    correo_usua character varying(100),
    nomb_emp_usua character varying(100),
    nomb_usua character varying(100) NOT NULL,
    pass_usua character varying(255),
    telf_usua character varying(255)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false    4            �            1259    16557    usuario_id_usuario_seq    SEQUENCE     �   ALTER TABLE public.usuario ALTER COLUMN id_usuario ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.usuario_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216    4                      0    16533    estado 
   TABLE DATA           8   COPY public.estado (id_estado, nomb_estado) FROM stdin;
    public          postgres    false    210   *                 0    16539    foto_usuario 
   TABLE DATA           U   COPY public.foto_usuario (id_foto_usua, nomb_foto, url_foto, id_usuario) FROM stdin;
    public          postgres    false    212   `*                 0    16545    icono 
   TABLE DATA           @   COPY public.icono (id_icono, nomb_icono, url_icono) FROM stdin;
    public          postgres    false    214   }*                 0    16590    proyecto 
   TABLE DATA           �   COPY public.proyecto (id_proyecto, compartir, desc_proyecto, fecha_fin, fecha_ini, nomb_proyecto, id_estado, id_icono, id_usuario) FROM stdin;
    public          postgres    false    217   �*                 0    16558    usuario 
   TABLE DATA           �   COPY public.usuario (id_usuario, ape_usua, carg_emp_usua, correo_usua, nomb_emp_usua, nomb_usua, pass_usua, telf_usua) FROM stdin;
    public          postgres    false    216   f+                  0    0    estado_id_estado_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.estado_id_estado_seq', 3, true);
          public          postgres    false    209                       0    0    foto_usuario_id_foto_usua_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.foto_usuario_id_foto_usua_seq', 1, false);
          public          postgres    false    211                       0    0    icono_id_icono_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.icono_id_icono_seq', 1, true);
          public          postgres    false    213                       0    0    usuario_id_usuario_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 20, true);
          public          postgres    false    215            p           2606    16537    estado estado_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.estado
    ADD CONSTRAINT estado_pkey PRIMARY KEY (id_estado);
 <   ALTER TABLE ONLY public.estado DROP CONSTRAINT estado_pkey;
       public            postgres    false    210            r           2606    16543    foto_usuario foto_usuario_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.foto_usuario
    ADD CONSTRAINT foto_usuario_pkey PRIMARY KEY (id_foto_usua);
 H   ALTER TABLE ONLY public.foto_usuario DROP CONSTRAINT foto_usuario_pkey;
       public            postgres    false    212            v           2606    16551    icono icono_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.icono
    ADD CONSTRAINT icono_pkey PRIMARY KEY (id_icono);
 :   ALTER TABLE ONLY public.icono DROP CONSTRAINT icono_pkey;
       public            postgres    false    214            |           2606    16617    proyecto proyecto_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.proyecto
    ADD CONSTRAINT proyecto_pkey PRIMARY KEY (id_proyecto);
 @   ALTER TABLE ONLY public.proyecto DROP CONSTRAINT proyecto_pkey;
       public            postgres    false    217            x           2606    16568 #   usuario uk3wayg8dhgsoxk1rnhvwnriori 
   CONSTRAINT     e   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT uk3wayg8dhgsoxk1rnhvwnriori UNIQUE (correo_usua);
 M   ALTER TABLE ONLY public.usuario DROP CONSTRAINT uk3wayg8dhgsoxk1rnhvwnriori;
       public            postgres    false    216            t           2606    16566 (   foto_usuario ukraghj7evih5v2v7ims4bb3p3m 
   CONSTRAINT     i   ALTER TABLE ONLY public.foto_usuario
    ADD CONSTRAINT ukraghj7evih5v2v7ims4bb3p3m UNIQUE (id_usuario);
 R   ALTER TABLE ONLY public.foto_usuario DROP CONSTRAINT ukraghj7evih5v2v7ims4bb3p3m;
       public            postgres    false    212            z           2606    16564    usuario usuario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    216            ~           2606    16595 $   proyecto fk3xh8ajx4vtv3ceecmyawvh2fs    FK CONSTRAINT     �   ALTER TABLE ONLY public.proyecto
    ADD CONSTRAINT fk3xh8ajx4vtv3ceecmyawvh2fs FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado);
 N   ALTER TABLE ONLY public.proyecto DROP CONSTRAINT fk3xh8ajx4vtv3ceecmyawvh2fs;
       public          postgres    false    3184    217    210            }           2606    16569 (   foto_usuario fk9ach0vpggycbq8lj43rpc7eef    FK CONSTRAINT     �   ALTER TABLE ONLY public.foto_usuario
    ADD CONSTRAINT fk9ach0vpggycbq8lj43rpc7eef FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);
 R   ALTER TABLE ONLY public.foto_usuario DROP CONSTRAINT fk9ach0vpggycbq8lj43rpc7eef;
       public          postgres    false    3194    212    216                       2606    16600 $   proyecto fkqarlvi6t5ols2wydq2weok6j4    FK CONSTRAINT     �   ALTER TABLE ONLY public.proyecto
    ADD CONSTRAINT fkqarlvi6t5ols2wydq2weok6j4 FOREIGN KEY (id_icono) REFERENCES public.icono(id_icono);
 N   ALTER TABLE ONLY public.proyecto DROP CONSTRAINT fkqarlvi6t5ols2wydq2weok6j4;
       public          postgres    false    217    3190    214            �           2606    16605 $   proyecto fktj8kcm1k1x2fllrsl94d02a6t    FK CONSTRAINT     �   ALTER TABLE ONLY public.proyecto
    ADD CONSTRAINT fktj8kcm1k1x2fllrsl94d02a6t FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);
 N   ALTER TABLE ONLY public.proyecto DROP CONSTRAINT fktj8kcm1k1x2fllrsl94d02a6t;
       public          postgres    false    3194    216    217               2   x�3�tL.�,��2�t�SH.-*��2��I��L�LNL�<�9�+F��� R            x������ � �         (   x�3��L���7�,//�K��O�I�K��Շ�r��qqq ޛ4         �   x�3�,�tI-N.�,H�<�9O!%5G!�(�25�$�����T��H��P����� � b&�F
�P1��NC�2���4� �\��
��"��JS��΁�mLC�M8��).(��KWH��/!�T�f���D���!������@���xS����� �<�            x����j�0���)�	B=����E[(��ݛ�d�ۢF%]ߨ��k���������|�+j����k�9+���fEJ��n�B����fpog�@��T�B�o�\�7���<�"A~$.U�*��d�`�ҙ��`M�V�|cV�[EB� ���#�t/��A����]^t��.��rY�`o���=��_�#��f{��%��n�P5�q*�S���0j1�ݴ)�9���u�6��Wc}12���6��}�g���O�p%U��,��]qAO���zw���c��}w��     