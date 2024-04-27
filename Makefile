# Makefile

.PHONY: up db-setup

up:
	docker-compose up -d
	sleep 10 # Da tiempo a que los servicios se levanten correctamente
	make db-setup

db-setup:
	@echo "Setting up the database..."
	docker exec -i your_postgres_container bash -c "psql -U developer -d rickandmorty" < ./path/to/your/script.sql
