# osusume-spring-react

## Getting Started

1. **Create local Postgres databases**
  - Create local `dev` and `test` databases.
    * `createdb osusume-dev`
    * `createdb osusume-test`
    * Note: The code expects a user with the role of `pivotal`. Use `psql` and the `\du` command to list all roles. If there's no existing `pivotal` role, create one using `CREATE ROLE pivotal WITH login createdb;`

  - Migrate the databases using flyway. (See the Makefile for reference)
    * `make migrate`

2. **Build the Backend**
  - `./gradlew build && java -jar build/libs/osusume-spring-react-0.0.1-SNAPSHOT.jar`
  - a curl or browser request to `http://localhost:8080/api/restaurants` should return an empty array `[]`.

3. **Build the Frontend** 
  - install globall dependencies
    * `brew install phantomjs`
    * `npm install -g jasmine`
  - Install local dependencies in `resources/static`.
    * `cd src/main/resources/static`
    * `npm install`
    * `npm install jasmine` (This step should be removed once the relative paths in spec.html are updated)
    * `webpack` should return without errors.
    * `webpack --config webpack.jasmine.config.js && phantomjs spec/support/jasmine-runner.js http://localhost:63342/osusume-spring-react/static/spec/spec.html`.
    * You should see a passing jasmine test at `http://localhost:63342/osusume-spring-react/static/spec/spec.html`
    * `cd -` (Don't forget to go back to the root directory before proceeding below.)

4. **Rebuild and run the app** (both frontend(webpack) and backend(gradlew))
  - `make all` (This runs `make jasmine-ci`, `make build` and `make run`)
  - You should see an empty page at `http://localhost:8080` with no console errors.
  - You should see an empty array at `http://localhost:8080/api/restaurants`
  - You should see a passing test at `http://localhost:63342/osusume-spring-react/static/spec/spec.html`

You're All Set!
