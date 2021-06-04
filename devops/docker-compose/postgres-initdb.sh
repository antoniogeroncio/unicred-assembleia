#!/bin/sh -e

psql --variable=ON_ERROR_STOP=1 --username "postgres" <<-EOSQL
    CREATE ROLE unicred WITH LOGIN PASSWORD 'unicred';
    CREATE DATABASE "unicred" OWNER = unicred;
    GRANT ALL PRIVILEGES ON DATABASE "unicred" TO unicred;
EOSQL