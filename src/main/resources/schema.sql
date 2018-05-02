CREATE TABLE IF NOT EXISTS persistent_logins (
  username  VARCHAR(64) NOT NULL,
  series    VARCHAR(64) NOT NULL,
  token     VARCHAR(64) NOT NULL,
  last_used TIMESTAMP   NOT NULL,
  PRIMARY KEY (series)
);

CREATE TABLE IF NOT EXISTS public.diary_user
(
  user_id       SERIAL            NOT NULL PRIMARY KEY,
  username      character varying NOT NULL,
  hash_password character varying NOT NULL,
  role          character varying NOT NULL,
  state         character varying NOT NULL
)
WITH (
OIDS = FALSE
);
ALTER TABLE public.diary_user
  OWNER TO test_user;

-- Index: public.user_login_uindex

-- DROP INDEX public.user_login_uindex;

CREATE UNIQUE INDEX IF NOT EXISTS user_login_uindex
  ON public.diary_user
  USING btree
  (username
   COLLATE pg_catalog."default");

CREATE TABLE IF NOT EXISTS public.diary_page
(
  diary_page_id SERIAL NOT NULL PRIMARY KEY,
  date          date   NOT NULL,
  butt          double precision,
  biceps        double precision,
  chest         double precision,
  waist         double precision,
  hip           double precision,
  calf          double precision,
  weight        double precision,
  note          character varying,
  data          bytea,
  user_id       integer,
  filename      character varying,
  CONSTRAINT diary_page_user_user_id_fk FOREIGN KEY (user_id)
  REFERENCES public.diary_user (user_id) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
OIDS = FALSE
);
ALTER TABLE public.diary_page
  OWNER TO test_user;

