
// RHS is returned from this function
fun snakeCase(origString: String): String =
        origString.toLowerCase().replace(" ", "_")

fun main(args: Array<String>) {
    println(
            snakeCase("This is a sentence")
    )
}