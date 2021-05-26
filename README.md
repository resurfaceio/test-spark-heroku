# test-spark
Example REST app built with Spark Web Framework

Forked from Heroku's [Getting Started with Java on Heroku](https://github.com/heroku/java-getting-started) app.

## Requirements

* docker
* docker-compose

## Ports Used

* 80 - REST API
* 4002 - Resurface API Explorer
* 4001 - Resurface microservice
* 4000 - Trino database UI

## Deploy Locally

```
make start     # rebuild and start containers
make ping      # make simple ping request
make bash      # open shell session
make logs      # follow container logs
make stop      # halt and remove containers
```
