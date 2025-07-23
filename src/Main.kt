val history = mutableListOf<String>()

fun main() {
//    Start program with Main Menu display and keep returning to Main Menu until the user chooses to Exit

    history.add("=== HISTORY ===\n") // add a title to the history list

    var selection = 0 // default selection to an invalid number

    // redisplay the menu until the user chooses to exit - 5)
    while (selection != 5) {

        displayMainMenu()
        selection = getMenuSelection(5) // Main menu has 5 options
        handleMainMenuSelection(selection) // perform actions based on selection
    }
}

fun displayMainMenu() {
//    Main Menu Display

    println("=== Calculator ===")
    println()
    println("1. Basic Calculator")
    println("2. Geometry Calculator")
    println("3. Conversion")
    println("4. View History")
    println("5. Exit")
    println()
}

fun handleMainMenuSelection(selection : Int) {
//    Call functions based on menu selection

    when (selection) {
        1 -> runCalc(EquationCategory.BASIC)
        2 -> runCalc(EquationCategory.GEOMETRY)
        3 -> runCalc(EquationCategory.CONVERSION)
        4 -> viewHistory()
    }
}

fun runCalc(eqCat : EquationCategory) {
//    load the calculator menu (based on selected type) and handle calculations

    // load the equation information into a collection filtered by the equation category
    val equations = Equation.entries.filter { it.category == eqCat }
    val menuMap = equations.mapIndexed { index, equation -> index + 1 to equation }.toMap()

    var selection = 0

    val exitNum = menuMap.count() + 1 // Create the menu number for the return to main menu option

    // redisplay the calc menu until user selects the option to return to main menu
    while (selection != exitNum) {
        println("=== $eqCat CALCULATOR ===")
        println()
        createCalcMenu(menuMap) // add the equation options to the menu list
        println("$exitNum. Return to Main Menu") // add an exit option to the menu list
        println()

        selection = getMenuSelection(exitNum) // get and validate user input

        // if the selected equation exists, call the function that will handle the equation inputs/outputs
        if (menuMap.containsKey(selection)) {
            handleCalcEquation(menuMap.getValue(selection))
        }
    }
}

fun createCalcMenu(menuMap: Map<Int, Equation>) {
//    Create the menu for the selected calculator type, using the map created for this purpose

    // create the menu using the index number and the displayName associated with each Equation
    menuMap.forEach { (num, eq) ->
        println("$num. ${eq.displayName}")
    }
}

fun handleCalcEquation(equation: Equation) {
//    Given an Equation, get the user inputs, calculate the result, display the result and save result to history

    val inputs = getEquationsInputs(equation)
    val result = equation.calculate(inputs)
    val resultString = equation.formatResult(inputs, result)
    history.add(resultString) // add formatted result to history list
    println("\n$resultString\n")  // display the result

    println("Press Enter to continue...")
    readln()
}

fun viewHistory() {
//    Displays the history of all calculations performed during this session.

    history.forEach{ println(it) }

    println("\nPress Enter to continue...")
    readln()
}