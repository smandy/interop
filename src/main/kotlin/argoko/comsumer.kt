package argoko

import argoko.RbCommon.ringBuffer
import org.agrona.MutableDirectBuffer
import org.agrona.concurrent.MessageHandler

fun main(args : Array<String>) {
    var msgCount = 0
    val MASK = (1 shl 24) - 1;
    while (true) {
        val readCount = ringBuffer.read( object : MessageHandler {
            override fun onMessage(msgTypeId: Int, buffer: MutableDirectBuffer?, index: Int, length: Int) {
                if ( (msgTypeId and MASK) == 0) {
                    println("msgType is $msgTypeId")
                }
            }
        })
        if (0 == readCount) {
            Thread.yield()
        }
        msgCount += readCount
    }


    fun doit(x : String, y : Int) : Boolean {
        println("Doit $x $y")
        return true
    }

    val x2= SamInterface( ::doit )
    x2.handle("foo", 42)

}