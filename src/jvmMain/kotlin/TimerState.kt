enum class TimerState {
    FOCUS,
    SHORT_BREAK,
    LONG_BREAK;

    val durationMinutes: Int
        get() = when (this) {
            FOCUS -> 25
            SHORT_BREAK -> 5
            LONG_BREAK -> 15
        }

    fun getNextState(count: Int): TimerState {
        return when (this) {
            FOCUS -> if (count % 4 == 0 && count != 0) LONG_BREAK else SHORT_BREAK
            SHORT_BREAK -> FOCUS
            LONG_BREAK -> FOCUS
        }
    }

    val formattedName: String
        get() = when (this) {
            FOCUS -> "Focus"
            SHORT_BREAK -> "Short Break"
            LONG_BREAK -> "Long Break"
        }
}