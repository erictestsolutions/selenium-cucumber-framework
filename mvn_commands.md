## Test Options in Maven

- `mvn clean test`: Basic command to clean the project and run tests.
- `mvn test -Dtest=MyTest`: Run a specific test class.
- `mvn test -Dtest=MyTest#myTestMethod`: Run a specific test method.

## Parallel Test Execution

- `mvn test -Dparallel=methods -DthreadCount=4`: Run test methods in parallel using 4 threads.
- `mvn test -Dparallel=classes -DthreadCount=4`: Run test classes in parallel using 4 threads.
- `mvn test -Dcucumber.execution.parallel.enabled=true -Dcucumber.execution.parallel.config.strategy=fixed -Dcucumber.execution.parallel.config.fixed.parallelism=3`: Run Cucumber tests in parallel with a fixed parallelism of 3.
- `mvn clean test -Denv=PROD`: Clean the project and run tests with a specific environment profile (e.g., production).
- `mvn clean test -Dbrowser=chrome`: Clean the project and run tests with a specific environment profile (e.g., production).
- `mvn clean test -Dcucumber.filter.tags=@cart`: Clean the project and run tests tagged with `@cart`.
- `mvn clean test -Dcucumber.plugin=pretty,html:target/cucumber-reports.html`: Clean the project and run tests with specified Cucumber plugins for reporting.
- `mvn clean test -Dcucumber.options="--tags @cart --plugin pretty --plugin html:target/cucumber-reports.html"`: Clean the project and run tests with specific Cucumber options for tags
