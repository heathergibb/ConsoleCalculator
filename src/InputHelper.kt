fun getMenuSelection(listCount : Int) : Int {
//    listCount parameter refers to the max number in a numeric menu, starting at 1.
//    Prompt user to select a menu option, then validate user's input
//    User input must be an integer between 1 and listCount
//    Loop until a valid input is selected then return input

    while (true) {
        print("Choose an option [1-$listCount]: ")
        val input = readln().trim()
        val selectionNum = input.toIntOrNull()

        // if the selection is a valid integer between 1 and listCount
        if (selectionNum != null && selectionNum in 1..listCount) {
            return selectionNum
        } else {
            println("Invalid input. Please enter a valid number.")
        }
    }
}

fun getEquationsInputs(equation: Equation) : List<Double> {
//    Using an Equation object, prompt the user for the required numbers
//    Validate that the numbers, looping until a valid number is input
//    Return a list of the required inputs to be used in the equation

    val inputs = mutableListOf<Double>() // list of numbers to be used in the equation

    // loop through prompt(s) to get the required numbers for the equation
    equation.prompts.forEach { prompt ->

        while (true) {
            print("${prompt.prompt} ") // Display the prompt
            val number = readln().trim().toDoubleOrNull() // convert to Double or Null

            if (number != null) { // if input is a number
                if (prompt.validate(number)) { // if input meets custom validation criteria
                    inputs.add(number) // add number to input list
                    break
                } else {
                    println(prompt.errorMsg) // print custom error message
                }
            } else {
                println("Invalid input. Try again.")
            }
        }
    }
    return inputs
}

