User's Guide of `Fecha`
=======================================

![](https://img.shields.io/badge/status-under_development-eebbcb?logoColor=4c6473)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/bug:%20Fecha?color=c53d43&label=bug)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/warning:%20Fecha?color=f08300&label=warn)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/todo:%20Fecha?color=38a1db&label=todo)
![](https://img.shields.io/github/size/OzelotVanilla/Jathon/src/main/java/org/ceslang/jathon/time/Fecha.java?color=cee4ae&logoColor=4c6473)

### Document Version: v0.1.4.0

### Is your language available?

<a href="./Fecha-jpa.md">
Japanese (Academic)</a> [0.0.2.0 Behind, Undone]

<br /><br />

Brief Description
---------------------------------------

A Java class which ensembles most needed time & data.

It works on gregorian calendar by default. You can also make it use any other calendar you want. Fecha provides most
often used calenders. If there isn't the calendar you want, you can also build your calendar by your own.

<br />

How it works
---------------------------------------

In the daily life, people use the word "time" to describe a special point of time, a period of time (elapsed time), or
the time for now. That is where Fecha's design of time comes.

First, Fecha saves the type that user want. It uses an enumeration `type`, which contains `point`, `period`, `now`,
and `custom`. Users can decide which type they want. By default, it is `point`.

Second, Fecha will save a value of the "time" you entered in `value`. If you save point of time (`point`), Fecha will
use timestamp to save it. If you want to save `period`, `value` will be the counted time.

Third, as a pure class which means time, it doesn't always have a calendar. Of course, you can also attach a default
calendar to make it easier to use, but you should remember that calendar isn't its property.

<br />


Initialization
---------------------------------------

### \> no-arg (default)

Usage: Fast initialize Fecha with the time it is initialized.

Equiv: [init(`type` point, `BigInteger` current, Timezone` local_tz)](#-full-arg-point-value-timezone-format)
<br /><br />

### \> full-arg: point (value, timezone, format)

**Caution**: Ensure you are init a `point` typed Fecha object.

Usage: Use either `long` or `BigInteger` as the value of Fecha, then use `Timezone`
(in the same package) to specify the timezone. Finally, give a `String` format-provider for the output of Fecha.
<br /><br />

### \> full-arg: period (value, format)

**Caution**: Ensure you are init a `period` typed Fecha object.
<br /><br />

### \> (`long` value)

Usage: Fast initialize Fecha as `point` typed with `long` given value.
<br /><br />

### \> (`BigInteger` value)

Usage: Same as using (`long` value).
<br /><br />

### \> (`java.util.Date` d)

Usage: Parse a `java.util.Date` object to Fecha.

Equiv: [init(`java.util.Date` d, `Timezone` tz)](#-javautildate-d-timezone-tz)
<br /><br />

### \> (`java.util.Date` d, `Timezone` tz)

Usage: Parse a `java.util.Date` object to Fecha, and specify the timezone for user.
<br /><br />

### \> (`java.sql.Date` d)

Usage: Parse a `java.sql.Date` object to Fecha.

Equiv: [init(`java.sql.Date` d, `Timezone` tz)](#-javasqldate-d-timezone-tz)
<br /><br />

### \> (`java.sql.Date` d, `Timezone` tz)

Usage: Parse a `java.sql.Date` object to Fecha, and specify the timezone for user.
<br /><br />

<br />

Methods
---------------------------------------

### \> `template(value: int...) -> int`

<!--Legacy signature here, like things below (this line should be removed) ->

<!-- template(int...): int -->

<!-- Put keywords for searching here -->

<br />

Functions
---------------------------------------