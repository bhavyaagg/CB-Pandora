fun sayHello(getName: (Int) -> String) {
    println("Hello " + getName(10))
}

fun main(args: Array<String>) {
    sayHello({ i ->
        "Bhavya " + i
    })
}