package argoko

class RateTimer {

    var lastMsgs = 0L;
    var lastTIme = 0L;

    fun tick(msgs : Long) : Long {
        val time = System.nanoTime()
        if (lastMsgs>0) {
            val numMessages = msgs - lastMsgs;
            val timeDiff = time - lastTIme;
        }
    }
t
}