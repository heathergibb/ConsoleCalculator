enum class Equation(
//    Enum class holding all the available equations for the calculator.
//    Each equation contains:
//    - Display name for showing in the menu
//    - List of input prompts with optional validation logic and error messages
//    - Category type used to group equations in the menu (e.g. BASIC, GEOMETRY, CONVERSION)
//    - Calculation function to compute the result based on inputs
//    - Formatting function to create a string to display the equation and result (used in View History)
//
//    NOTE: Equations are displayed in the order they are listed in this enum (filtered by category)
//    To add new equation, insert it where you'd like it to appear in the menu.

    val displayName: String,
    val prompts: List<InputPrompts>, // Prompts contains input prompts(s) and logic to handle validation
    val category: EquationCategory,
    val calculate: (List<Double>) -> Double,
    val formatResult: (List<Double>, Double) -> String
    ) {
    // Basic Calculator Equations
        ADD(
            "Add",
            listOf(
                InputPrompts("Enter number:"),
                InputPrompts("Enter number to add:")
            ),
            EquationCategory.BASIC,
            { inputs -> inputs[0] + inputs[1] },
            { inputs, result -> "${inputs[0]} + ${inputs[1]} = $result" }
        ),
        SUBTRACT(
            "Subtract",
            listOf(
                InputPrompts("Enter number:"),
                InputPrompts("Enter number to subtract:"),
            ),
            EquationCategory.BASIC,
            { inputs -> inputs[0] - inputs[1] },
            { inputs, result -> "${inputs[0]} - ${inputs[1]} = $result" }
        ),
        MULTIPLY(
            "Multiply",
            listOf(
                InputPrompts("Enter number:"),
                InputPrompts("Multiply by:")
            ),
            EquationCategory.BASIC,
            { inputs -> inputs[0] * inputs[1] },
            { inputs, result -> "${inputs[0]} x ${inputs[1]} = $result" }
        ),
        DIVIDE(
            "Divide",
            listOf(
                InputPrompts("Enter numerator:"),
                InputPrompts("Enter denominator:",
                    { it != 0.0 },  // input must not be 0
                    "Cannot divide by zero. Try again.")
            ),
            EquationCategory.BASIC,
            { inputs -> inputs[0] / inputs[1] },
            { inputs, result -> "${inputs[0]} ÷ ${inputs[1]} = $result" }
        ),
        SQUARE_ROOT(
            "Square Root",
            listOf(
                InputPrompts("Enter number:",
                { it >= 0.0 }, // input must not be negative
                "Number cannot be negative. Try again.")
            ),
            EquationCategory.BASIC,
            { inputs -> kotlin.math.sqrt(inputs[0]) },
            { inputs, result -> "√${inputs[0]} = $result" }
        ),
    // Geometry Calculator Options
        AREA_OF_CIRCLE(
            "Area of Circle",
            listOf(
                InputPrompts("Enter radius:",
                { it > 0.0 }, // input must be positive
                "Radius must be greater than zero. Try again.")
            ),
            EquationCategory.GEOMETRY,
            { inputs -> kotlin.math.PI * inputs[0] * inputs[0] },
            { inputs, result -> "Area of Circle: π(${inputs[0]})² = $result units²" }
        ),
        CIRCUMFERENCE_OF_CIRCLE(
            "Circumference of Circle",
            listOf(
                InputPrompts("Enter radius:",
                    { it > 0.0 }, // input must be positive
                    "Radius must be greater than zero. Try again.")
            ),
            EquationCategory.GEOMETRY,
            { inputs -> 2 * kotlin.math.PI * inputs[0] },
            { inputs, result -> "Circumference: 2π(${inputs[0]}) = $result" }
        ),
        AREA_OF_RECTANGLE(
            "Area of Rectangle/Square",
            listOf(
                InputPrompts("Enter length:",
                    { it > 0.0 }, // input must be positive
                    "Length must be greater than zero. Try again."),
                InputPrompts("Enter width:",
                    { it > 0.0 }, // input must be positive
                    "Width must be greater than zero. Try again.")
                ),
            EquationCategory.GEOMETRY,
            { inputs -> inputs[0] * inputs[1] },
            { inputs, result -> "Area of Rectangle: ${inputs[0]} x ${inputs[1]} = $result units²" }
        ),
        AREA_OF_TRAPEZOID(
            "Area of Trapezoid",
            listOf(
                InputPrompts("Enter base 1:",
                    { it > 0.0 }, // input must be positive
                    "Base 1 must be greater than zero. Try again."),
                InputPrompts("Enter base 2:",
                    { it > 0.0 }, // input must be positive
                    "Base 2 must be greater than zero. Try again."),
                InputPrompts("Enter height:",
                    { it > 0.0 }, // input must be positive
                    "Height must be greater than zero. Try again.")
            ),
            EquationCategory.GEOMETRY,
            { inputs -> 0.5 * (inputs[0] + inputs[1]) * inputs[2] },
            { inputs, result -> "Area of Trapezoid: 1/2 x (${inputs[0]} + ${inputs[1]}) x ${inputs[2]} = $result units²" }
        ),
        AREA_OF_TRIANGLE(
            "Area of Triangle",
            listOf(
                InputPrompts("Enter base:",
                { it > 0.0 }, // base must be positive
                "Base must be greater than zero. Try again."),
                InputPrompts("Enter height:",
                    { it > 0.0 }, // height must be positive
                    "Height must be greater than zero. Try again.")
                ),
            EquationCategory.GEOMETRY,
            { inputs -> 0.5 * inputs[0] * inputs[1] },
            { inputs, result -> "Area of Triangle: 1/2(${inputs[0]} x ${inputs[1]} = $result units²"}
        ),
        C_TO_F(
            "Celsius to Fahrenheit",
            listOf(InputPrompts("Enter temp in °C:")),
            EquationCategory.CONVERSION,
            { inputs -> (inputs[0] * 1.8) + 32 },
            { inputs, result -> "Convert ${inputs[0]}°C to °F: (${inputs[0]} x 9/5) + 32 = $result°F"}
            ),
        F_TO_C(
            "Fahrenheit to Celsius",
            listOf(InputPrompts("Enter temp in °F:")),
            EquationCategory.CONVERSION,
            { inputs -> (inputs[0] - 32) * 1.8 },
            { inputs, result -> "Convert ${inputs[0]}°F to °C: (${inputs[0]} - 32) x 9/5 = $result°C"}
        ),
        MILES_TO_KILOMETERS(
            "Miles to Kilometers",
            listOf(InputPrompts("Enter miles:")),
            EquationCategory.CONVERSION,
            { inputs -> inputs[0] * 1.60934 },
            { inputs, result -> "Convert ${inputs[0]}m to km: ${inputs[0]} x 1.60934km = $result"}
        ),
        KILOMETERS_TO_MILES(
            "Kilometers to Miles",
            listOf(InputPrompts("Enter km:")),
            EquationCategory.CONVERSION,
            { inputs -> inputs[0] / 1.60934 },
            { inputs, result -> "Convert ${inputs[0]}km to m: ${inputs[0]} ÷ 1.60934km = $result"}
        )
    }
