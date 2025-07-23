data class InputPrompts(
//    This data class represents a single input prompt used in an equation.
//    It includes:
//    - A prompt message to ask the user for a number,
//    - An optional validation function, to check if the number is valid
//      (e.g. verify the number isn't 0 for the division equation),
//    - And an error message to display if the validation fails.

    val prompt: String,
    val validate: (Double) -> Boolean = { true },
    val errorMsg: String = "Invalid Input."
)
