object MyObj {
    val x = 10
}

// By default all classes in Kotlin are final so can not be inherited from
// Therefore we use open class
open class X {
    val a = 10
}

object MyObj2 : X() {
    val b = 20
}

fun main(args: Array<String>) {
    println(MyObj.x)
    println(MyObj2.b)
}