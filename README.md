# proze-experiments
Data and scripts for experiments with [proze](https://github.com/ASSERT-KTH/proze)

## Notes for experiments:
It can be useful to work with two copies of a target project:
1. Copy#1 (original clone): use for `proze-select` and `proze-generate`, add `javaagent` to record production and test workload data
2. Copy#2: add and run generated parameterized tests here, (e.g., in a new module called `proze-tests` and `proze-tests-mutation` for the mutation analysis of the tests that pass)
