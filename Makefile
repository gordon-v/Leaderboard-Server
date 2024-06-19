build-jar:
	./gradlew build

build-docker: build-jar
	docker build -t leaderboard-api .

run-docker: build-docker
	 docker compose up
