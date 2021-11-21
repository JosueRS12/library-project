# Build image postgres as base
# Is not finished
FROM postgres:14.1-alpine

ENV POSTGRES_PASSWORD=admin

COPY ["scripts/create.sql", "./"]

WORKDIR ./

RUN ["psql", "-U", "postgres", "--file", "create.sql"]

EXPOSE 5432

# next build spring image 


