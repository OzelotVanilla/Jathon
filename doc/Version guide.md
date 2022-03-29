Version Guide
=============

Ver 0.3.2.0 03/27/2022
----------------------

### What is new for `builtin`?

 * inted(String) can parse hex, bin, and oct (start with "0o", not "0") string now <br>
 * Now developing printc() function! Having colours in console! <br>
 * Change max() and min() not only accept number but all comparable<br>
 * readParam() function family <br>
 * booled() now support string <br>
 * Add native method getConsoleWidth() family (implemented by ANSI, may fail in IDE)<br>
 * Add sum() and average() <br>
 * Add logarithm() to calculate logarithm with any base. Add lg() also. <br>
 * Add queContains () to check whether a collection has a specific value.<br>
 * Making open() family <br>

### Important changes

* Now `builtin` have native method, it will extract dll file to your Java installation dir's `bin` folder,
  and it will name it as `org_ceslang_jathon_builtin.dll` <br>


Ver 0.2.6.0 05/04/2021
----------------------

### Module plan: `Fecha`
1. What is `Fecha`? `Fecha` is a module made to let the time calculation easier.
2. What `Fecha` will have? Support changing other Date or type to `Fecha`.

### What is new for `builtin`?
* Completing function len()
* New function booled()
* randint() fixed, using Java's function

### What is new for `IntList`?
* Add ArrayList&lt;Integer&gt; toArrayList()
* Add IntList(String)
* Change expression of some function 

Ver 0.2.5.1 04/18/2021
----------------------

### What is new for `builtin`?
* New function cls().
* Change some math function using Java component `StrictMath`.
* Delete deprecated printa() and println() function.
* doubled() String splits.
* deciFmt() function.
* Test version: reversed(E[])

Ver 0.2.4.0 04/06/2021
----------------------

### What is new?


#### For `builtin`
* Change print() to printx(). If you do not need line break, use printx().
* Fix printx with array cannot output bug.
* New function hex(), oct(), bin(), change radio (return int).
* Preview inputOneDouble()
* sqrt() add (Use java.Math's function)

#### For `IntList`
* Iterable IntList
* Delete confusing constructor IntList(String, String)


Ver 0.2.2.0 03/07/2021
----------------------
### What is new?

#### For `builtin`
* Change max() and min() return type to generics type

#### For `IntList`
* popIndex() and popObj()
 * popIndex(): Pop the element at the place you want (`index`)
 * popObj():   Pop the element if IntList have that
* append(): Append new data after old data
* setAllTo(): Set all element to what you want
* reset(): Reset the data to 0 length

Ver 0.2.1.0 03/03/2021
----------------------
### Important Notice

From this version, the filename of `./lib/built_in` will **pernamently
changed** to "**`builtin`**".
Python call it "builtin", and this author will do that as well.

### What is new?
* OK version of randint().
* Very first version of abs(), min() and max(), reversed().
* Shorter name for Math.pow -> pow(), Python already has that.

Ver 0.2.0.0 Alpha 03/02/2021
----------------------------

* First published version
* OK to use at the most case
* No complete fuction document