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
  user_id       integer REFERENCES diary_user
  ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
OIDS = FALSE
);
ALTER TABLE public.diary_page
  OWNER TO test_user;

CREATE TABLE IF NOT EXISTS public.file
(
  file_id       SERIAL NOT NULL PRIMARY KEY,
  filename      character varying,
  data          bytea,
  diary_page_id integer REFERENCES diary_page
  ON UPDATE NO ACTION ON DELETE NO ACTION
);
ALTER TABLE public.file
  OWNER TO test_user;