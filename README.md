# proze-experiments
Data and scripts for experiments with proze

## Notes for experiments:
It can be useful to work with two copies of a target project:
1. Copy#1 (original clone): use for `proze-select` and `proze-generate`, add `javaagent` to record production and test workload data
2. Copy#2: add and run generated parameterized tests here, (e.g., in a new module called `proze-tests` and `proze-tests-mutation` for the mutation analysis of the tests that pass)

Descartes analysis:
- Copy#1: Descartes analysis for original test suite. NOTE: remove / comment out `javaagent` from `pom.xml` because we don't want to record data for these test executions
- Copy#2: Descartes analysis for test suite with new parameterized tests added. NOTE: add passing parameterized tests within the original module(s) directly.
- For both cases, configure [Descartes](https://github.com/STAMP-project/pitest-descartes) as follows:

```
<plugin>
  <groupId>org.pitest</groupId>
  <artifactId>pitest-maven</artifactId>
  <version>1.7.0</version>
  <configuration>
    <outputFormats>
      <value>JSON</value>
      <value>METHODS</value>
      <value>ISSUES</value>
    </outputFormats>
    <mutationEngine>descartes</mutationEngine>
  </configuration>
  <dependencies>
    <dependency>
      <groupId>eu.stamp-project</groupId>
      <artifactId>descartes</artifactId>
      <version>1.3.2</version>
    </dependency>
    <!-- for JUnit5 -->
    <dependency>
      <groupId>org.pitest</groupId>
      <artifactId>pitest-junit5-plugin</artifactId>
      <version>0.12</version>
    </dependency>
  </dependencies>
</plugin>
``` 

