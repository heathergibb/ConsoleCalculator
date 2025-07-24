# Overview

This project is a console-based calculator written in Kotlin. 
It allows the user to perform basic arithmetic calculations, plus has the option to calculate some geometry equations and unit conversions. 
The calculator is coded in a way that allows it to be easily scalable. 
New equations can be added to the Equation enum class that will be dynamically added to one of the menu lists (Basic, Geometry, or Conversion).

My purpose for writing this program was to learn the basics of Kotlin and to practice using IntelliJ IDEA. 
I wanted something easy enough to make quickly but complex enough that I gained experience with different types of classes, loops and user interactions.

[Software Demo Video](https://www.youtube.com/watch?v=Zym8ZNHW3DI)

# Development Environment

- **IDE:** IntelliJ IDEA Community Edition
- **Version Control:** GitHub
- **Programming Language:** Kotlin

# Useful Websites

- [Kotlin](https://kotlinlang.org/)
- [Kotlin Tutorials](https://kotlinlang.org/docs/kotlin-tour-welcome.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

# Future Work

- To make the program even more scalable, I'd like to make the Main Menu load dynamically using categories from the EquationCategory enum class. Right now, there are only 3 calculator options; Basic, Geometry, and Conversion, but a dynamic main menu would allow a coder to easily add equations of a new category type. 
- I'd also like to make a visual version with buttons rather than console prompts.
- At some point, I'd also like to add an option for the user to enter an expression (e.g. 3 x (4 + 2) / 8^2) ) and have it calculate the result.