import javax.swing.SwingUtilities

sealed class Socket

object Disconnected : Socket()
data class Connected( val x : Int) : Socket()


fun acceptString( s : String) {
    println("Woot it works")
}



data class Foo(var x : Int) {
    operator fun plus(y : Int) : Foo {
        x += y
        return this;
    }
}

fun defString( s : String) = if (s.length>10) {
    (1 until 20)
            .map { it.toString() }
            .joinToString(",","[", "]")
} else {
    "Arse"
}

fun balance() = try {
    1
} catch (x : Throwable) {
    2
}

fun acceptSocket( s : Socket) = when (s) {
    is Disconnected -> println("Disconnected")
    is Connected -> println("Connected ${s.x}")
}

fun String.double( ) : String {
    val ret = listOf(this,this)
    return ret.joinToString(separator = "")
}

fun runOnSwing(f : () -> Unit)  {
    SwingUtilities.invokeAndWait {
        f()
        println( "Woot --> ${Thread.currentThread().name}" )
    }
}

fun main( args : Array<String>) {
    println("Hello world")
    println(defString("Bla"))
    println(defString("fjeifjiejfiejifjeifjeijfijefijeifj"))
    balance()

    val x5 = listOf(1,2,3,4,5)
    val x6 = mapOf( 1 to 10, 2 to 20)
    val x8 = mapOf( 1 to "Woot", 2 to "Goot")
    print(x6)
    print(x5)
    print(x8)

    println(x5.joinToString(",", "[", "]"))
    acceptSocket(Disconnected)
    acceptSocket(Connected(10))

    val x3 = if(x5.size > 19) {
        println("Bla")
        10
    } else {
        println("Goo")
        20
    }
    println("x is $x3");

    println("Woot".double())

    val x = runOnSwing {
        println("I am on the swing thread")
    }
    println("x is $x")

    var f = Foo(10)
    f += 20
    println("f is $f")

    val a = mapOf(1 to "one")
    val a2 = a + listOf(2 to "two", 3 to "three")

    println("a is $a")
    println("a2 is $a2")

    val l1 = emptyList<Int>()
    val l2 = l1 + 10
    val l3 = l2 + arrayOf(10,20,30,40)
    println("l1=$l1 l2=$l2 l3=$l3")

    for( x in l3) {
        println("x is $x")
    }

    val l4 = l3.flatMap { listOf(it to it) }

    println("l4 is $l4")
}