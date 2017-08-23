import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame
import javax.swing.JPanel

data class Person(val first: String, val second: String)

data class MyPair<K, V>(val x: K, val y: V)

fun main(args: Array<String>) {
    println("Hello World from kotlin")

    val x = mapOf(
            1 to "foo",
            2 to "bar")

    println("x is $x")
    val andy = Person("andy", "smith")
    val (first, last) = andy
    println("$first $last in the area")

    val pair = MyPair("andy", 10)
    println(pair.javaClass)
    for ( (q,v) in x) {
        println( "$q $v")
    }
    val foos = x.map { me -> Pair(me.key, me.key) }

    foos.first()

    println("Foos are $foos")

    val frame = JFrame("Vortex")
    frame.setSize(800, 800)

    val x5 = if ( 10 < 20 ) 2 else 3

    val panel = object : JPanel() {
        override fun paintComponent(p0: Graphics?) {
            super.paintComponent(p0)
            if (p0 is Graphics2D) {

                p0.paint = Color.BLACK
                p0.fillRect(0, 0, width, height)
                p0.paint = Color.CYAN

                //p0.stroke = BasicStroke(10.0f)
                //p0.drawLine( 0,0, 50, 50)
                var x0 = 0.0
                var y0 = 0.0
                var sz = width.toDouble()
                val d_theta = 90.4 * (2 * Math.PI) / 360

                var theta = 0.0

                while (sz > 5) {
                    val newX = x0 + sz * Math.cos(theta)
                    val newY = y0 + sz * Math.sin(theta)

                    p0.drawLine(x0.toInt(), y0.toInt(), newX.toInt(), newY.toInt())

                    x0 = newX
                    y0 = newY

                    sz *= 0.99
                    theta += d_theta
                }
            }
        }
    }
    frame.add(panel)
    frame.isVisible = true
}
