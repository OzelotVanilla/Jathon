User Guide for `builtin`
=======================================

![](https://img.shields.io/badge/status-able_to_be_used-fcc800?logoColor=4c6473)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/aTool/bug:%20builtin?color=f09199&label=bug)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/aTool/warning:%20builtin?color=F08300&label=warn)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/todo:%20builtin?color=38a1db&label=todo)
![](https://img.shields.io/github/size/OzelotVanilla/Jathon/src/main/java/org/ceslang/jathon/builtin.java?color=CEE4AE&logoColor=4c6473)

### Document Version: v0.1.0.0

### Is your language available?

<a href="./builtin-jpa.md">
Japanese (Academic)</a> [Working on first version]

<br /><br />

Brief Description
---------------------------------------

A Java utility class which helps shortern your code,
and make what you see is what it is.

<br />

How it works
---------------------------------------

This class contains 

<br />

Functions List
---------------------------------------

### 1. `print` family

### \> `print() -> none` 

<!--print(): void print(void): void->

<!-- Search Keyword: no-arg print -->

Usage: Print one blank line in console.

Example:

```java
print();    // Give a blank line
```

### \> `print(args: object...) -> none`

<!--print(Object...): void -->

<!-- Search Keyword: print function -->

Usage: Print the object one by one, and use comma to separate them.
After printing, start a new line.

Example:

```java
int   a  =  5;
int[] l  =  new int[]{1, 2, 3};
print(a, l);    // Give "5, [1, 2, 3]", go to next line
```

### \> `printx(args: object...) -> none`

<!--printx(Object...): void -->

<!-- Search Keyword: printx function print in same line -->

Usage: Print the object one by one, and use comma to separate them.
After printing, stay in the same line.

Example: See [Example in `print(args: object...)` function](#-printargs-object---none)

### \> `printf(format: string，obj: object...) -> none`

<!--printf(): void printf(void): void->

<!-- Search Keyword: print format print with format -->

