select * from pg_catalog.pg_tables where schemaname not in ('public', 'pg_catalog', 'information_schema');

set search_path to "hb_01_one_to_one_uni", public;

select distinct schemaname from pg_catalog.pg_tables;

select * from instructor;

