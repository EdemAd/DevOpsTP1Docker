FROM postgres:17.2-alpine

ENV POSTGRES_DB=db \
    POSTGRES_USER=usr \
    POSTGRES_PASSWORD=pwd

# Copier les scripts SQL pour l'initialisation
COPY ./init-scripts/ /docker-entrypoint-initdb.d/

# Exposer le port par défaut de PostgreSQL
EXPOSE 5432
