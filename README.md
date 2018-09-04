# csv-benchmark
Project for benchmarking popular open source CSV parsers using [JMH].

  * [SimpleFlatMapper]
  * [univocity-parsers]
  * [sesseltjonna-csv]

Bugs, feature suggestions and help requests can be filed with the [issue-tracker].
## License
[Apache 2.0]

# Obtain
The project is based on [Gradle].

# Usage
Modify the build version to your current snapshot, and potentially change the include expression in [jmh-benchmark/build.gradle](jmh-benchmark/build.gradle) and/or the [CsvParam](jmh-benchmark/src/jmh/java/com/github/skjolber/csv/param/CsvParam.java) to scope your tests.  

Then run 

```
./gradlew clean jmhClasses jmh --info
```

If the JMH plugin seems to have trouble refreshing the project, restart the Gradle deamon before running:

```
./gradlew --stop && ./gradlew clean jmhClasses jmh --info
```

And also optionally refresh the dependencies using

```
./gradlew --stop && ./gradlew clean jmhClasses jmh --refresh-dependencies --info
```

Open the file `./jmh-benchmark/build/reports/jmh/index.html` to view a visualization of the results.

# Benchmarks

Inputs:
  * World cities
  * GTFS Trips
   
Modes:

  * plain or quoted
  * rows from 1 to 1 million
  * single-shot and sample time   

# Results

## Single-shot
What is measured is the 'cold start', which is how long the parsing take the first time,. This does not however include things like class-loading, only whatever configuration can be done ahead of being passed a Reader. 

The results [1](https://skjolber.github.io/csv-benchmark/single-shot-1/index.html), [100](https://skjolber.github.io/csv-benchmark/single-shot-100/index.html), [1000](https://skjolber.github.io/csv-benchmark/single-shot-1000/index.html), [100000](https://skjolber.github.io/csv-benchmark/single-shot-100000/index.html), [500000](https://skjolber.github.io/csv-benchmark/single-shot-500000/index.html), [1000000](https://skjolber.github.io/csv-benchmark/single-shot-1000000/index.html) must be taken with a grain of salt. Most of these will differ quite a lot from run to run, but the current results give a ballpark picture of the performance.

The results show that the [SimpleFlatMapper] seems to excel at World Cities while the [univocity-parsers] excel at GTFS Trips. However [sesseltjonna-csv] performs best for both inputs. 

## Sample time
What is measured here is the 'warm start', which is how long the parsing takes after an initial warmup. The warmup here referes to the Just-in-time-compilator to do its optimizations, which takes place after something like a second of back to back invocation of the code. Basically these optimizations usually mean inlining methods and compiling the bytecode to platform-specific code.

The results [1](https://skjolber.github.io/csv-benchmark/sample-time-1/index.html), [100](https://skjolber.github.io/csv-benchmark/sample-time-100/index.html), [1000](https://skjolber.github.io/csv-benchmark/sample-time-1000/index.html), [100000](https://skjolber.github.io/csv-benchmark/sample-time-100000/index.html), [500000](https://skjolber.github.io/csv-benchmark/sample-time-500000/index.html), [1000000](https://skjolber.github.io/csv-benchmark/sample-time-1000000/index.html)

show that [SimpleFlatMapper] actually is faster for very small documents, but as size grows, [sesseltjonna-csv] performs best for both inputs.

# History

 - 1.0.0: Initial version

[Apache 2.0]:          		http://www.apache.org/licenses/LICENSE-2.0.html
[issue-tracker]:       		https://github.com/skjolber/csv-benchmark/issues
[Gradle]:              		https://gradle.org/
[JMH]:							http://openjdk.java.net/projects/code-tools/jmh/
[visualization]:				https://skjolber.github.io/csv-benchmark/jmh/index.html
[univocity-parsers]: 			https://github.com/uniVocity/univocity-parsers
[SimpleFlatMapper]: 			http://simpleflatmapper.org/
[sesseltjonna-csv]:			https://github.com/skjolber/sesseltjonna-csv

