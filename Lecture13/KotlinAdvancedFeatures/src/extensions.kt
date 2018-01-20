// RHS is returned from this function
fun snakeCase(origString: String): String =
        origString.toLowerCase().replace(" ", "_")

// Adding a function to the String class
// Function's binding is static but is not run in static scope that is why
// using this is allowed
// Can not be called using class name is className.function()
fun String.makeSnakeCase(): String =
        this.toLowerCase().replace(" ", "_")

fun main(args: Array<String>) {
    println(
            snakeCase("This is a sentence")
    )

    println("This is a sentence".makeSnakeCase())
}


// Having both dynamic function and extension
class C {
    // Dynamic Function
    fun foo() {
        println("member") // This will be printed
    }
}

// Static Binding
// Has no value since dynamic functions are checked first
// Only when the function signatures are same
fun C.foo() {
    println("Extension") // This will not be printed
}