all: build run

build:
	pushd src/main/resources/static/; webpack; popd
	./gradlew build

run:
	java -jar build/libs/osusume-spring-react-0.0.1-SNAPSHOT.jar

clean:
	pushd src/main/resources/static/; rm -rf build/; popd
	./gradlew clean

.PHONY: build

