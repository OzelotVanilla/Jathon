Jathon - Try to Make things Clearer and Easier
==============================================

![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/OzelotVanilla/aTool?color=A0D8EF&include_prereleases&logoColor=44617B)

What is Jathon
--------------

Jathon is a library which contains some Java classes to help Java developers write programs with clearer and easier
grammar.

Jathon has many functions that compress original Java functions in one place. For example, you can use `print()`
or `len()` to print or calculate the data length. You only need to think about your steps, we can help you with the part
like this <!-- Some example of Jathon needed -->.

<br />

----

<br />

What does Jathon have
---------------------

Please go to `/src/main/java/org/ceslang/jathon/` to find file.

<br />

### builtin (`jathon`)

![](https://img.shields.io/badge/status-able_to_be_used-fcc800?logoColor=4c6473)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/bug:%20builtin?color=f09199&label=bug)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/warning:%20builtin?color=F08300&label=warn)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/todo:%20builtin?color=38a1db&label=todo)
![](https://img.shields.io/github/size/OzelotVanilla/Jathon/src/main/java/org/ceslang/jathon/builtin.java?color=CEE4AE&logoColor=4c6473)

What is this: Idea got from Python. Make your code pretty.

How we make: Use functions to make long or multiple statements shorter and clearer.

How to use: import it in the head of file `import static org.ceslang.jathon.builtin.*`.

Note: `builtin` is **not** a class that can be initialized.
To follow the original name in Python, and **avoid people to use it to create instance**,
this class's name is "`builtin`", but not "*BuiltIn*" or "*Builtin*".

<br />

### Fecha (`jathon.time`)

![](https://img.shields.io/badge/status-under_development-eebbcb?logoColor=4c6473)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/bug:%20Fecha?color=f09199&label=bug)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/warning:%20Fecha?color=F08300&label=warn)
![](https://img.shields.io/github/issues-raw/OzelotVanilla/Jathon/todo:%20Fecha?color=38a1db&label=todo)
![](https://img.shields.io/github/size/OzelotVanilla/Jathon/src/main/java/org/ceslang/jathon/time/Fecha.java?color=CEE4AE&logoColor=4c6473)

What is this: Can save time point or period, can be formatted easier.
You can transfer the object about classes into this.



<br />

### IntList (`jathon`)

![](https://img.shields.io/badge/status-may_change_structure-d91e10?logoColor=4c6473)
![](https://img.shields.io/github/size/OzelotVanilla/Jathon/src/main/java/org/ceslang/jathon/IntList.java?color=CEE4AE&logoColor=4c6473)

If you want to have a list like thing saving int in Java, try this
(Considering, a bit like repeat work (Java already has ArrayList\<Integer\>))

<br />

----

<br />

Jathon Suggest You
------------------

### Let's make identifier-naming more explicit

* Var: start with lower case, connect with underscore, and no upper case.
* Function or method: lower case start, upper case to connect.
* Class: start with upper case and try to be short.
* Constant: start with dollar sign, then do as `var`.
* System reserved consonant: do as upper cased `consonant`.

For example (in Java):

```java
final String $VERSION  =  "1.0.0.0";
final int    $short_e  =  2.718;

class Cell
{
    int test_var = 0;

    public boolean isTestClass()
    {
        return true;
    }
}
```

What is other files in this folder
----------------------------------

Version Guide:
You can see the description of the difference versions.

updater:
Save it in the folder which contains these three modules, and fetch the latest version **in repo** (**not
releases**) (**Missing in this repo**).
