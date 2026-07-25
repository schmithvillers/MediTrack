
# JVM Report

## Java Platform

Java follows the principle:

> Write Once, Run Anywhere

Compiled Java code is converted into bytecode (.class files), which is executed by the Java Virtual Machine (JVM).

---

## JVM Components

### 1. Class Loader

Loads Java classes into memory.

Responsibilities:

- Loading
- Linking
- Initialization

---

### 2. Runtime Data Areas

#### Heap

Stores objects and arrays.

#### Stack

Stores method calls and local variables.

Each thread has its own stack.

#### Method Area

Stores class metadata, static variables and bytecode.

#### Program Counter Register

Stores the address of the current instruction.

---

### 3. Execution Engine

Executes bytecode using:

- Interpreter
- JIT Compiler

---

### Interpreter

Reads bytecode instruction by instruction.

Advantages:

- Fast startup

Disadvantages:

- Slower execution

---

### JIT Compiler

Compiles frequently executed code into native machine code.

Advantages:

- Faster execution

---

## Garbage Collection

Automatically removes unused objects from heap memory.

Advantages:

- Prevents memory leaks
- Better memory management

---

## JVM Architecture

Java Source Code

↓

Compiler

↓

Bytecode (.class)

↓

Class Loader

↓

Runtime Data Areas

↓

Execution Engine

↓

Machine Code