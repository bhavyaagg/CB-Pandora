fun sayHello(getName: () -> String) {
    println("Hello " + getName())
}

fun main(args: Array<String>) {
    sayHello({
        -> "Bhavya"
    })
}