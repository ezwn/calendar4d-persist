#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE USER c4d WITH PASSWORD 'c4d';
	CREATE DATABASE c4d;
	GRANT ALL PRIVILEGES ON DATABASE c4d TO c4d;
EOSQL
