fun sayHello(getName: (Int) -> String) {
    println("Hello " + getName(10))
}

fun sayHello2(getFirstName: () -> String, getLastName: () -> String) {
    println("Hello " + getFirstName() + getLastName())
}


fun main(args: Array<String>) {
    // In Anonymous Functions, last line is returned automatically
    sayHello({ i ->
        "Bhavya " + i
    })


    // Lambda Functions
    sayHello2({ "Bhavya" }, { "Aggarwal" })

}