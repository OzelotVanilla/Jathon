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

### \> `printcx() -> none`

<!-- printcx(): void -->

<!-- Colour printing clear colour settings -->

Usage: Clear previous colour or format settings,
and stay in the same line.

Warning: **Do not** use it with [printSet](#-printsethex_colour-int---none)

Example:

```javascript
// Suppose you have global colour settings before this line
printcx();
// After printcx(), colour will be set back to default
```

### \> `printc() -> none`

<!-- printc(): void -->

<!-- Colour printing -->

Usage: Clear previous colour or format settings, and go to next line.

Example: See example in [printcx() -> none](#-printcx---none).



See Also: [printc(option: string,
args: object...)](#printcoption-string-args-object---none)

<br />

### \> `printcx(option: string, args: object...) -> none`

<!-- printc(String, Object...): void -->

* Usage

When you want to print one line with colour,
and then go back to default colour settings.

* Arguments

> `option`: the option of colour settings.
 
It is combination of colour code and style.

First, the colour code, next, the style code.

Regular expression: `(0x|#)?[0-9a-fA-F]{6}[buif]{0,4}`

Acceptable form of **colour code**: `0xffffff`, `FFFFFF`, `#ffffff`

Meaning of **style code**:

Please note that they may not work on your terminal.
Different terminal support different style.

| Symbol | Meaning   |
| ------ | --------- |
| `b`    | bold      |
| `u`    | underline |
| `i`    | italian   |
| `f`    | flashing  |

> `args`: the object you want to print

As same as the argument of [printx(args: object...)](#-printxargs-object---none)
for detail.

* Example

```javascript
// Print the string in colour #f4b3c2
printcx("0xf4b3c2", "Hallo Welt.");
```

<br />

### \> `printc(format: string, args: object...) -> none`

<!-- printc(): void -->

<!-- Colour printing -->

* Usage

Print objects in given format, and go to next line
and **set the colour to default colour**.
See [printcx(option: string, args: object...)](#-printcxoption-string-args-object---none)
for detail usage and examples.

* Caution

This function is not suggested to use with `printSet`.


### \> `printSet(hex_colour: int) -> none`

<!-- printSet(int): void -->

<!-- global colour settings -->

* Usage


* Caution

<br />

### \> `printSet(r: int, g: int, b: int) -> none`

* Usage

Set the colour for comming printing function.
Until you encounter some function that set back your colour after it works.

* Caution

Please **do not** use this function with the function start with **printc**.

<br />
