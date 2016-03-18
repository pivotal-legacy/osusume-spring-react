all: build run

build:
	pushd src/main/resources/static/ && webpack && popd
	./gradlew build

migrate:
	DATABASE_URL=jdbc:postgresql://localhost:5432/osusume-dev ./gradlew flywayMigrate
	DATABASE_URL=jdbc:postgresql://localhost:5432/osusume-test ./gradlew flywayMigrate

run:
	java -jar build/libs/osusume-spring-react-0.0.1-SNAPSHOT.jar

clean:
	pushd src/main/resources/static/ && rm -rf build/ && popd
	./gradlew clean

.PHONY: build

