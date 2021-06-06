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

<!-- print(): void print(void): void->

<!-- Search Keyword: no-arg print -->

Usage: Print one blank line in console.

Example:

```java
print();    // Give a blank line
```

<br />

### \> `print(args: object...) -> none`

<!-- print(Object...): void -->

<!-- Search Keyword: print function -->

Usage: Print the object one by one, and use comma to separate them.
After printing, start a new line.

Example:

```java
int   a  =  5;
int[] l  =  new int[]{1, 2, 3};
print(a, l);    // Give "5, [1, 2, 3]", go to next line
```

<br />

### \> `printx(args: object...) -> none`

<!-- printx(Object...): void -->

<!-- Search Keyword: printx function print in same line -->

Usage: Print the object one by one, and use comma to separate them.
After printing, stay in the same line.

Example: See [Example in `print(args: object...)` function](#-printargs-object---none)

<br />

### \> `printf(format: string，obj: object...) -> none`

<!-- printf(): void printf(void): void->

<!-- Search Keyword: print format print with format -->

Usage: As same as the `printf()` method in Java. Create new line after printing.
Put the anchors in `format`, and put things you want to format in `obj`.

Example:

```java
printf("%s, %d", "String", 100); // Give "String, 100" and move to next line
```

<br />

### \> `printfx(format: string，obj: object...) -> none`

<!-- printfx(): void printf(void): void->

<!-- Search Keyword: print format print with format no return -->

Usage: As same as the `printf()` method in Java. After printing, stay in the same line.
Put the anchors in `format`, and put things you want to format in `obj`.

Example: See [Example in `printfx(format: string，obj: object...) -> none`
function](#-printfformat-stringobj-object---none)

<br />

### \> `printc() -> none`

<!-- printc(): void -->

<!-- Colour printing -->

Usage: Clear previous colour or format settings, and go to next line.

Example:

```javascript
// Suppose you have global colour settings before this line
printc();
// After printc(), colour will be set back to default
```

See Also: [printc(option: string,
args: object...)](#printcoption-string-args-object---none)

<br /><br />

### \> `printc(option: string, args: object...) -> none`

Usage: When you want to print one line with colour,
and then go back to default colour settings.

Arguments:

> `option`: the option of colour settings.
 
It is combination of colour code and style.

First, the colour code, next, the style code.

Regular expression: `(0x|#)?[0-9a-fA-F]{6}[buif]{0,4}`

Acceptable form of colour code: `0xffffff`, `FFFFFF`, `#ffffff`


Example:

```javascript
printc("0xf4b3c2")
```