// RHS is returned from this function
fun snakeCase(origString: String): String =
        origString.toLowerCase().replace(" ", "_")

// Adding a function to the String class
fun String.makeSnakeCase(): String =
        this.toLowerCase().replace(" ", "_")

fun main(args: Array<String>) {
    println(
            snakeCase("This is a sentence")
    )

    println("This is a sentence".makeSnakeCase())
}