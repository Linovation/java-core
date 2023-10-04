This repository contains modules about core Java.

---

### Java 21

JDK 21 released this September 19th. It contains many new capabilities, including virtual threads, pattern matching for switch, record
patterns, and sequenced collections.

There are also some interesting preview features, such as string templates, scoped values, structured concurrency, and unnamed classes and
instance main methods.

https://openjdk.org/projects/jdk/21/

#### SequencedCollection

Sequenced collection provides us with methods having a defined encounter order for accessing first and last elements and iterating in
reverse order.
It means we can add, retrieve, or remove elements at both ends of the collection.

<img alt="Sequenced Collections" height="300" src="/Users/minarashidi/Documents/sequenced-collection-type-hierarchy.png" width="800"/>


[//]: # (![]&#40;/Users/minarashidi/Documents/sequenced-collection-type-hierarchy.png&#41;)

#### String Templates

Some techniques for composing strings before String Templates:

* The + (plus) operator: The biggest downside is that a new String gets created each time we use the + operator.
* StringBuffer and StringBuilder:
  StringBuffer is thread-safe, whereas StringBuilder was added in Java 5 and more performant but not thread-safe alternative.
  Their major downside is their verbosity, especially for simpler Strings:
  ```
  var greeting = new StringBuilder()
  .append("Hello, welcome ")
  .append(name)
  .toString();```

* String::format and String::formatted: They allow for reusable templates, but they require us to specify format and provide the variables
  in the correct order.
  ```
  var format = "Good morning %s, It's a beautiful day!";
  var text = String.format(format, name);

  // Java 15+
  var text = format.formatter(name);
  ```
  Even though we save on the number of String allocations, now the JVM has to parse/validate the template String.
* java.text.MessageFormat: The same as String format, but more verbose
  ```
  var format = new MessageFormat("Good morning {0}, It's a beautiful day!");
  var greeting = format.format(name);
  ```

#### String Templates to rescue
It is simple and concise

The new way to work with strings is called template expression. They can perform interpolation but also provide us with the flexibility to compose the Strings, and convert structured text into any object, not just a String.

There are three components to a template expression:
* A template processor: Java provides two template processors for performing string interpolation: STR and FMT
* A template containing wrapped expressions like \{name}
* A dot (.) character
  ```
  String name    = "Mina";
  String phone = "112233";
  String json = STR."""
  {
  "name":    "\{name}",
  "phone":   "\{phone}"
  }
  """;
  ```

---

### Java 17

---
