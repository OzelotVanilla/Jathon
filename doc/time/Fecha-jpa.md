`Fecha`の使用説明書
=======================================

![](https://img.shields.io/badge/status-under_development-eebbcb?logoColor=4c6473)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/bug:%20Fecha?color=c53d43&label=bug)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/warning:%20Fecha?color=f08300&label=warn)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/todo:%20Fecha?color=38a1db&label=todo)
![](https://img.shields.io/github/size/OzelotVanilla/Jathon/src/main/java/org/ceslang/jathon/time/Fecha.java?color=cee4ae&logoColor=4c6473)

### Document Version: v0.1.1.0-notdone

### Is your language available?

<a href="./Fecha-en.md">
English</a> [0.0.2.0 Ahead]

<br /><br />

紹介
---------------------------------------

Fechaは，Java中でよく使われている時間と日付に関する類(Class)を統合し，
より使いやすいと機能が多い型(Type (data type))です。

Fechaの日付単位の既定値はグレゴリオ暦ですか，ほかの暦法も使える。
Fechaは，農歴(中国)など最も頻繁に使用される暦法を提供している，さらに，使用者が定義されたものも対応します。


<br />

How it works
---------------------------------------

日常生活の中で、人々は「時間」という言葉を使って，時点、期間 (経過時間)、
または"<span title="英語では，&quot;What time is it&quot;で今の時間を尋ねる" style="color: #83ccd2">今</span>"
を表します。そこで、`Fecha`が登場します。

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


Annotation
---------------------------------------
[1]: 