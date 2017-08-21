package argoko

fun acceptString(s : String) {
    println("It works $s")
    val xs = listOf(1,2,3)
    val c = xs.map { it to it + 10 }.toMap()
    val d = xs.associate { it to it+10 }
    println("C is $c d is $d")
}
