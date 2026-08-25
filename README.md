# DevOps CI Calculator

Student: **Kaushiik A**  
Roll number: **23BCS068**

This repository contains a small Java command-line calculator created to demonstrate version control, branching, conflict resolution, Pull Requests, and Continuous Integration with Jenkins.

## Features

- Addition
- Subtraction
- Division
- Automated tests without external dependencies

## Project structure

```text
src/       Application source code
tests/     Executable tests
```

## Build

```bash
rm -rf build
mkdir build
javac -d build src/Calculator.java tests/CalculatorTest.java
```

## Test

```bash
java -cp build CalculatorTest
```

The test command prints an individual PASS line for each operation and exits with a non-zero status if any assertion fails. This behaviour allows Jenkins to mark a failing test stage automatically.

## Run

```bash
java -cp build Calculator
```
