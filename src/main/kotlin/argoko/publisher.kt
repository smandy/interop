package argoko

import argoko.RbCommon.ringBuffer
import org.agrona.BitUtil
import org.agrona.concurrent.UnsafeBuffer
import org.agrona.concurrent.ringbuffer.RingBufferDescriptor.TRAILER_LENGTH

fun main( a : Array<String>) {

    val length = BitUtil.SIZE_OF_INT * 2
    val repsValueOffset = BitUtil.SIZE_OF_INT
    val srcBuffer = UnsafeBuffer(ByteArray(2048 + TRAILER_LENGTH))
    val producerId = 1023

    srcBuffer.putInt(0, producerId)

    for (i in 1..200000000) {
        srcBuffer.putInt(repsValueOffset, i)
        while (!ringBuffer.write(i, srcBuffer, 0, length)) {
            Thread.yield()
        }
    }

}