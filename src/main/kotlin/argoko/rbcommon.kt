package argoko

import org.agrona.IoUtil
import org.agrona.concurrent.UnsafeBuffer
import org.agrona.concurrent.ringbuffer.OneToOneRingBuffer
import java.io.File
import org.agrona.concurrent.ringbuffer.RingBufferDescriptor.TRAILER_LENGTH

object RbCommon {
    val cncByteBuffer = IoUtil.mapNewFile(File("/tmp/andy.dat"), 2048L + TRAILER_LENGTH)
    val buf = UnsafeBuffer(cncByteBuffer)
    val ringBuffer = OneToOneRingBuffer(buf)
}