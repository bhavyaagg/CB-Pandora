fun sayHello(getName: (String) -> String) {
    println("Hello " + getName("Bhavya"))
}

fun sayHello2(getFirstName: () -> String, getLastName: () -> String) {
    println("Hello " + getFirstName() + getLastName())
}


fun main(args: Array<String>) {
    // In Anonymous Functions, last line is returned automatically
    sayHello({ i ->
        "Bhavya $i"
    })

    // Lambda Functions
    sayHello2({ "Bhavya" }, { "Aggarwal" })

    // Use it when we want to access the first argument. Not possible if more that one
    // argument
    sayHello({it})

}