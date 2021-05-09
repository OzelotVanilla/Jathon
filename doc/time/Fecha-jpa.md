`Fecha`の使用説明書
=======================================

![](https://img.shields.io/badge/status-under_development-eebbcb?logoColor=4c6473)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/bug:%20Fecha?color=c53d43&label=bug)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/warning:%20Fecha?color=f08300&label=warn)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/todo:%20Fecha?color=38a1db&label=todo)
![](https://img.shields.io/github/size/OzelotVanilla/Jathon/src/main/java/org/cesno/jathon/time/Fecha.java?color=cee4ae&logoColor=4c6473)

### Document Version: v0.1.1.0-notdone

### Is your language available?

<a href="./Fecha-en.md">
English</a> [0.0.1.0 Ahead]

<br /><br />

紹介
---------------------------------------

Fechaは，Java中でよく使われている時間と日付に関する類(Class)を統合し，
より使いやすいと機能が多い型(Type (data type))です。

Fechaの日付単位の既定値はグレゴリオ暦ですか，ほかの暦法も使える。
Fecha

It works on gregorian calendar by default.
You can also make it use any other calender you want.
Fecha provides most often used calenders.
If there isn't the calender you want, you can also build your calender by your own.

<br />

How it works
---------------------------------------

In the daily life, people use the word "time" to describe a special point of time,
a period of time (elapsed time), or the time for now. 
That is where Fecha's design of game comes.

First, Fecha saves the type that user want. It uses an enumeration `type`,
which contains `point`, `period`, `now`, and `custom`.
Users can decide which type they want. By default, it is `point`.

Second, Fecha will save a value of the "time" you entered in `value`.
If you save point of time (`point`), Fecha will use timestamp to save it.
If you want to save `period`, `value` will be the counted time.

<br />


Initialization
---------------------------------------

### no-arg (default)

Usage: fast initialize Fecha with the time it is initialized.

### full-arg (value, type, )


<br />

Functions 
---------------------------------------

