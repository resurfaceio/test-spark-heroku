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
	@docker logs -f test_spark_app

ping:
	@curl "http://localhost/hello"

restart:
	@docker-compose stop
	@docker-compose up
