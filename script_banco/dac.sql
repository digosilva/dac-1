--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.2
-- Dumped by pg_dump version 9.2.0
-- Started on 2013-01-20 04:59:51

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 7 (class 2615 OID 16394)
-- Name: dac; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA dac;


ALTER SCHEMA dac OWNER TO postgres;

SET search_path = dac, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 16564)
-- Name: atividade_chamado; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE atividade_chamado (
    sequencia integer NOT NULL,
    observacao character varying(1000),
    data_atividade date,
    chamado_id bigint NOT NULL
);


ALTER TABLE dac.atividade_chamado OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 16613)
-- Name: campanha; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE campanha (
    id integer NOT NULL,
    valor_disponivel double precision,
    data_inicio date,
    data_fim date,
    nome_campanha character varying(100),
    tipo_campanha_id integer,
    usuario_id bigint
);


ALTER TABLE dac.campanha OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 16611)
-- Name: campanha_id_seq; Type: SEQUENCE; Schema: dac; Owner: postgres
--

CREATE SEQUENCE campanha_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dac.campanha_id_seq OWNER TO postgres;

--
-- TOC entry 2055 (class 0 OID 0)
-- Dependencies: 190
-- Name: campanha_id_seq; Type: SEQUENCE OWNED BY; Schema: dac; Owner: postgres
--

ALTER SEQUENCE campanha_id_seq OWNED BY campanha.id;


--
-- TOC entry 183 (class 1259 OID 16532)
-- Name: chamado; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE chamado (
    id integer NOT NULL,
    descricao character varying(1000),
    data_abertura date,
    data_fechamento date,
    cliente_id bigint,
    tipo_chamado_id bigint,
    usuario_id bigint
);


ALTER TABLE dac.chamado OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 16530)
-- Name: chamado_id_seq; Type: SEQUENCE; Schema: dac; Owner: postgres
--

CREATE SEQUENCE chamado_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dac.chamado_id_seq OWNER TO postgres;

--
-- TOC entry 2056 (class 0 OID 0)
-- Dependencies: 182
-- Name: chamado_id_seq; Type: SEQUENCE OWNED BY; Schema: dac; Owner: postgres
--

ALTER SEQUENCE chamado_id_seq OWNED BY chamado.id;


--
-- TOC entry 169 (class 1259 OID 16400)
-- Name: cliente; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE cliente (
    cpf character varying(15),
    email character varying(50),
    data_nascimento date,
    recebe_campanha boolean,
    pessoa_id bigint NOT NULL
);


ALTER TABLE dac.cliente OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 16457)
-- Name: compra; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE compra (
    id integer NOT NULL,
    valor_total double precision,
    fornecedor_id bigint
);


ALTER TABLE dac.compra OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16455)
-- Name: compra_id_seq; Type: SEQUENCE; Schema: dac; Owner: postgres
--

CREATE SEQUENCE compra_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dac.compra_id_seq OWNER TO postgres;

--
-- TOC entry 2057 (class 0 OID 0)
-- Dependencies: 173
-- Name: compra_id_seq; Type: SEQUENCE OWNED BY; Schema: dac; Owner: postgres
--

ALTER SEQUENCE compra_id_seq OWNED BY compra.id;


--
-- TOC entry 193 (class 1259 OID 16690)
-- Name: endereco; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE endereco (
    id integer NOT NULL,
    cep character varying(9),
    logradouro character varying(200),
    complemento character varying(50),
    bairro character varying(50),
    pessoa_id bigint,
    cidade character varying(50),
    estado character varying(50)
);


ALTER TABLE dac.endereco OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 16688)
-- Name: endereco_id_seq; Type: SEQUENCE; Schema: dac; Owner: postgres
--

CREATE SEQUENCE endereco_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dac.endereco_id_seq OWNER TO postgres;

--
-- TOC entry 2058 (class 0 OID 0)
-- Dependencies: 192
-- Name: endereco_id_seq; Type: SEQUENCE OWNED BY; Schema: dac; Owner: postgres
--

ALTER SEQUENCE endereco_id_seq OWNED BY endereco.id;


--
-- TOC entry 170 (class 1259 OID 16410)
-- Name: fornecedor; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE fornecedor (
    ativo boolean,
    cnpj character varying(20),
    pessoa_id bigint NOT NULL
);


ALTER TABLE dac.fornecedor OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 16473)
-- Name: nota_fiscal; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE nota_fiscal (
    id integer NOT NULL,
    observacao character varying(1000),
    compra_id bigint,
    venda_id bigint
);


ALTER TABLE dac.nota_fiscal OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 16471)
-- Name: nota_fiscal_id_seq; Type: SEQUENCE; Schema: dac; Owner: postgres
--

CREATE SEQUENCE nota_fiscal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dac.nota_fiscal_id_seq OWNER TO postgres;

--
-- TOC entry 2059 (class 0 OID 0)
-- Dependencies: 177
-- Name: nota_fiscal_id_seq; Type: SEQUENCE OWNED BY; Schema: dac; Owner: postgres
--

ALTER SEQUENCE nota_fiscal_id_seq OWNED BY nota_fiscal.id;


--
-- TOC entry 172 (class 1259 OID 16439)
-- Name: pessoa; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE pessoa (
    id integer NOT NULL,
    nome character varying(100)
);


ALTER TABLE dac.pessoa OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 16437)
-- Name: pessoa_id_seq; Type: SEQUENCE; Schema: dac; Owner: postgres
--

CREATE SEQUENCE pessoa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dac.pessoa_id_seq OWNER TO postgres;

--
-- TOC entry 2060 (class 0 OID 0)
-- Dependencies: 171
-- Name: pessoa_id_seq; Type: SEQUENCE OWNED BY; Schema: dac; Owner: postgres
--

ALTER SEQUENCE pessoa_id_seq OWNED BY pessoa.id;


--
-- TOC entry 180 (class 1259 OID 16494)
-- Name: produto; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE produto (
    id integer NOT NULL,
    descricao character varying(50),
    valor_compra double precision,
    valor_venda double precision,
    fornecedor_id bigint
);


ALTER TABLE dac.produto OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 16492)
-- Name: produto_id_seq; Type: SEQUENCE; Schema: dac; Owner: postgres
--

CREATE SEQUENCE produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dac.produto_id_seq OWNER TO postgres;

--
-- TOC entry 2061 (class 0 OID 0)
-- Dependencies: 179
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: dac; Owner: postgres
--

ALTER SEQUENCE produto_id_seq OWNED BY produto.id;


--
-- TOC entry 181 (class 1259 OID 16505)
-- Name: produto_nota_fiscal; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE produto_nota_fiscal (
    nota_fiscal_id bigint NOT NULL,
    produto_id bigint NOT NULL,
    quantidade double precision,
    valor_acrescimo double precision,
    valor_desconto double precision
);


ALTER TABLE dac.produto_nota_fiscal OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 16606)
-- Name: tipo_campanha; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_campanha (
    id integer NOT NULL,
    descricao character varying(50)
);


ALTER TABLE dac.tipo_campanha OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16548)
-- Name: tipo_chamado; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_chamado (
    id integer NOT NULL,
    descricao character varying(100)
);


ALTER TABLE dac.tipo_chamado OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 16546)
-- Name: tipo_chamado_id_seq; Type: SEQUENCE; Schema: dac; Owner: postgres
--

CREATE SEQUENCE tipo_chamado_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dac.tipo_chamado_id_seq OWNER TO postgres;

--
-- TOC entry 2062 (class 0 OID 0)
-- Dependencies: 184
-- Name: tipo_chamado_id_seq; Type: SEQUENCE OWNED BY; Schema: dac; Owner: postgres
--

ALTER SEQUENCE tipo_chamado_id_seq OWNED BY tipo_chamado.id;


--
-- TOC entry 188 (class 1259 OID 16580)
-- Name: usuario; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario (
    id integer NOT NULL,
    matricula character varying(10),
    senha character varying(100),
    pessoa_id bigint
);


ALTER TABLE dac.usuario OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16578)
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: dac; Owner: postgres
--

CREATE SEQUENCE usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dac.usuario_id_seq OWNER TO postgres;

--
-- TOC entry 2063 (class 0 OID 0)
-- Dependencies: 187
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: dac; Owner: postgres
--

ALTER SEQUENCE usuario_id_seq OWNED BY usuario.id;


--
-- TOC entry 176 (class 1259 OID 16465)
-- Name: venda; Type: TABLE; Schema: dac; Owner: postgres; Tablespace: 
--

CREATE TABLE venda (
    id integer NOT NULL,
    valor_total double precision,
    cliente_id bigint
);


ALTER TABLE dac.venda OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16463)
-- Name: venda_id_seq; Type: SEQUENCE; Schema: dac; Owner: postgres
--

CREATE SEQUENCE venda_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dac.venda_id_seq OWNER TO postgres;

--
-- TOC entry 2064 (class 0 OID 0)
-- Dependencies: 175
-- Name: venda_id_seq; Type: SEQUENCE OWNED BY; Schema: dac; Owner: postgres
--

ALTER SEQUENCE venda_id_seq OWNED BY venda.id;


--
-- TOC entry 2002 (class 2604 OID 16616)
-- Name: id; Type: DEFAULT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY campanha ALTER COLUMN id SET DEFAULT nextval('campanha_id_seq'::regclass);


--
-- TOC entry 1999 (class 2604 OID 16535)
-- Name: id; Type: DEFAULT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY chamado ALTER COLUMN id SET DEFAULT nextval('chamado_id_seq'::regclass);


--
-- TOC entry 1995 (class 2604 OID 16460)
-- Name: id; Type: DEFAULT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY compra ALTER COLUMN id SET DEFAULT nextval('compra_id_seq'::regclass);


--
-- TOC entry 2003 (class 2604 OID 16693)
-- Name: id; Type: DEFAULT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY endereco ALTER COLUMN id SET DEFAULT nextval('endereco_id_seq'::regclass);


--
-- TOC entry 1997 (class 2604 OID 16476)
-- Name: id; Type: DEFAULT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY nota_fiscal ALTER COLUMN id SET DEFAULT nextval('nota_fiscal_id_seq'::regclass);


--
-- TOC entry 1994 (class 2604 OID 16442)
-- Name: id; Type: DEFAULT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY pessoa ALTER COLUMN id SET DEFAULT nextval('pessoa_id_seq'::regclass);


--
-- TOC entry 1998 (class 2604 OID 16497)
-- Name: id; Type: DEFAULT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY produto ALTER COLUMN id SET DEFAULT nextval('produto_id_seq'::regclass);


--
-- TOC entry 2000 (class 2604 OID 16551)
-- Name: id; Type: DEFAULT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY tipo_chamado ALTER COLUMN id SET DEFAULT nextval('tipo_chamado_id_seq'::regclass);


--
-- TOC entry 2001 (class 2604 OID 16583)
-- Name: id; Type: DEFAULT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY usuario ALTER COLUMN id SET DEFAULT nextval('usuario_id_seq'::regclass);


--
-- TOC entry 1996 (class 2604 OID 16468)
-- Name: id; Type: DEFAULT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY venda ALTER COLUMN id SET DEFAULT nextval('venda_id_seq'::regclass);


--
-- TOC entry 2025 (class 2606 OID 16571)
-- Name: atividade_chamado_pk; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY atividade_chamado
    ADD CONSTRAINT atividade_chamado_pk PRIMARY KEY (sequencia, chamado_id);


--
-- TOC entry 2031 (class 2606 OID 16618)
-- Name: campanha_pk; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY campanha
    ADD CONSTRAINT campanha_pk PRIMARY KEY (id);


--
-- TOC entry 2021 (class 2606 OID 16540)
-- Name: chamado_pk; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY chamado
    ADD CONSTRAINT chamado_pk PRIMARY KEY (id);


--
-- TOC entry 2005 (class 2606 OID 16404)
-- Name: cliente_pkey; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (pessoa_id);


--
-- TOC entry 2011 (class 2606 OID 16462)
-- Name: compra_pk; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY compra
    ADD CONSTRAINT compra_pk PRIMARY KEY (id);


--
-- TOC entry 2033 (class 2606 OID 16695)
-- Name: endereco_pk; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT endereco_pk PRIMARY KEY (id);


--
-- TOC entry 2007 (class 2606 OID 16414)
-- Name: fornecedor_pk; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY fornecedor
    ADD CONSTRAINT fornecedor_pk PRIMARY KEY (pessoa_id);


--
-- TOC entry 2015 (class 2606 OID 16481)
-- Name: nota_fiscal_id; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY nota_fiscal
    ADD CONSTRAINT nota_fiscal_id PRIMARY KEY (id);


--
-- TOC entry 2009 (class 2606 OID 16444)
-- Name: pessoa_fk; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT pessoa_fk PRIMARY KEY (id);


--
-- TOC entry 2019 (class 2606 OID 16509)
-- Name: prod_nf_pk; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY produto_nota_fiscal
    ADD CONSTRAINT prod_nf_pk PRIMARY KEY (nota_fiscal_id, produto_id);


--
-- TOC entry 2017 (class 2606 OID 16499)
-- Name: produto_pk; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_pk PRIMARY KEY (id);


--
-- TOC entry 2029 (class 2606 OID 16610)
-- Name: tipo_campanha_pk; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_campanha
    ADD CONSTRAINT tipo_campanha_pk PRIMARY KEY (id);


--
-- TOC entry 2023 (class 2606 OID 16553)
-- Name: tipo_chamado_pk; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_chamado
    ADD CONSTRAINT tipo_chamado_pk PRIMARY KEY (id);


--
-- TOC entry 2027 (class 2606 OID 16585)
-- Name: usuario_id; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_id PRIMARY KEY (id);


--
-- TOC entry 2013 (class 2606 OID 16470)
-- Name: venda_pk; Type: CONSTRAINT; Schema: dac; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY venda
    ADD CONSTRAINT venda_pk PRIMARY KEY (id);


--
-- TOC entry 2049 (class 2606 OID 16683)
-- Name: campanha_usuario; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY campanha
    ADD CONSTRAINT campanha_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id);


--
-- TOC entry 2043 (class 2606 OID 16663)
-- Name: chamado_cliente; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY chamado
    ADD CONSTRAINT chamado_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(pessoa_id);


--
-- TOC entry 2046 (class 2606 OID 16572)
-- Name: chamado_fk; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY atividade_chamado
    ADD CONSTRAINT chamado_fk FOREIGN KEY (chamado_id) REFERENCES chamado(id);


--
-- TOC entry 2044 (class 2606 OID 16668)
-- Name: chamado_tipo_chamado; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY chamado
    ADD CONSTRAINT chamado_tipo_chamado FOREIGN KEY (tipo_chamado_id) REFERENCES tipo_chamado(id);


--
-- TOC entry 2045 (class 2606 OID 16673)
-- Name: chamado_usuario; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY chamado
    ADD CONSTRAINT chamado_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id);


--
-- TOC entry 2036 (class 2606 OID 16520)
-- Name: compra_fornecedor; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY compra
    ADD CONSTRAINT compra_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(pessoa_id);


--
-- TOC entry 2050 (class 2606 OID 16714)
-- Name: endereco_pessoa; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT endereco_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);


--
-- TOC entry 2041 (class 2606 OID 16510)
-- Name: nf_fk; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY produto_nota_fiscal
    ADD CONSTRAINT nf_fk FOREIGN KEY (nota_fiscal_id) REFERENCES nota_fiscal(id);


--
-- TOC entry 2038 (class 2606 OID 16482)
-- Name: nota_fiscal_compra; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY nota_fiscal
    ADD CONSTRAINT nota_fiscal_compra FOREIGN KEY (compra_id) REFERENCES compra(id);


--
-- TOC entry 2039 (class 2606 OID 16487)
-- Name: nota_fiscal_venda; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY nota_fiscal
    ADD CONSTRAINT nota_fiscal_venda FOREIGN KEY (venda_id) REFERENCES venda(id);


--
-- TOC entry 2034 (class 2606 OID 16445)
-- Name: pessoa_cliente; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT pessoa_cliente FOREIGN KEY (pessoa_id) REFERENCES cliente(pessoa_id);


--
-- TOC entry 2035 (class 2606 OID 16450)
-- Name: pessoa_fornecedor; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY fornecedor
    ADD CONSTRAINT pessoa_fornecedor FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);


--
-- TOC entry 2042 (class 2606 OID 16515)
-- Name: produto_fk; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY produto_nota_fiscal
    ADD CONSTRAINT produto_fk FOREIGN KEY (produto_id) REFERENCES produto(id);


--
-- TOC entry 2040 (class 2606 OID 16500)
-- Name: produto_fornecedor; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(pessoa_id);


--
-- TOC entry 2048 (class 2606 OID 16678)
-- Name: tipo_campanha_fk; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY campanha
    ADD CONSTRAINT tipo_campanha_fk FOREIGN KEY (tipo_campanha_id) REFERENCES tipo_chamado(id);


--
-- TOC entry 2047 (class 2606 OID 16586)
-- Name: usuario_pessoa; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id);


--
-- TOC entry 2037 (class 2606 OID 16525)
-- Name: venda_cliente; Type: FK CONSTRAINT; Schema: dac; Owner: postgres
--

ALTER TABLE ONLY venda
    ADD CONSTRAINT venda_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(pessoa_id);


-- Completed on 2013-01-20 04:59:52

--
-- PostgreSQL database dump complete
--

