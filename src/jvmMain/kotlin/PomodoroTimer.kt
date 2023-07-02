import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.*

class PomodoroTimer {

    var isRunning by mutableStateOf(false)
    private var lastTimestamp: Long = 0
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    var state by mutableStateOf(TimerState.FOCUS)

    private var timerMillis = state.durationMinutes * 60 * 1000L
    var formattedTimer by mutableStateOf(formatTime(timerMillis))

    var focusCount by mutableStateOf(0);

    init {
        coroutineScope.launch {
            lastTimestamp = System.currentTimeMillis()
            while (true) {
                if (isRunning) {
                    val currentTimestamp = System.currentTimeMillis()
                    val delta = currentTimestamp - lastTimestamp
                    lastTimestamp = currentTimestamp
                    timerMillis -= delta
                    formattedTimer = formatTime(timerMillis);
                    checkTimer()
                }
                lastTimestamp = System.currentTimeMillis()
                delay(100)
            }
        }
    }

    fun start() {
        isRunning = true
    }

    fun stop() {
        isRunning = false
    }

    fun reset() {
        isRunning = false
        timerMillis = state.durationMinutes * 60 * 1000L
        formattedTimer = formatTime(timerMillis)
    }

    private fun formatTime(timerMillis: Long): String {
        val minutes = timerMillis / 60 / 1000
        val seconds = timerMillis / 1000 % 60
        val formattedMinutes = if (minutes < 10) "0$minutes" else "$minutes"
        val formattedSeconds = if (seconds < 10) "0$seconds" else "$seconds"
        return "$formattedMinutes:$formattedSeconds"
    }


    private fun checkTimer() {
        if (timerMillis <= 0) {
            if (state == TimerState.FOCUS) {
                focusCount++
            }
            state = state.getNextState(focusCount)
            reset()
        }
    }
}