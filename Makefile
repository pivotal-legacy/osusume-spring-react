all: jasmine-ci build run

build:
	pushd src/main/resources/static/ && webpack && popd
	./gradlew build

javascript:
	pushd src/main/resources/static/ && webpack && popd
	cp src/main/resources/static/build/osusume.js* build/resources/main/static/build/

migrate:
	DATABASE_URL=jdbc:postgresql://localhost:5432/osusume-dev ./gradlew flywayMigrate
	DATABASE_URL=jdbc:postgresql://localhost:5432/osusume-test ./gradlew flywayMigrate

run:
	java -jar build/libs/osusume-spring-react-0.0.1-SNAPSHOT.jar

clean:
	pushd src/main/resources/static/ && rm -rf build/ && popd
	./gradlew clean

jasmine-ci:
	pushd src/main/resources/static/ && webpack --config webpack.jasmine.config.js && phantomjs spec/support/jasmine-runner.js http://localhost:63342/osusume-spring-react/static/spec/spec.html && popd


.PHONY: build

