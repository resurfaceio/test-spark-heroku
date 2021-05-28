PROJECT_NAME=spark

start:
	@docker stop resurface || true
	@docker build -t test-spark --no-cache .
	@docker-compose up --detach

stop:
	@docker-compose stop
	@docker-compose down --volumes
	@docker image rmi -f test-spark

bash:
	@docker exec -it spark bash

logs:
	@docker logs -f spark

ping:
	@curl 'http://localhost/' -H 'Content-Type: application/json' --data-binary '{"message":"hi!"}'

restart:
	@docker-compose stop
	@docker-compose up --detach

test:
	@docker exec -it spark python3 test.py