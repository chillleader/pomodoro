import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    val timer = remember { PomodoroTimer() }

    MaterialTheme {
        PomodoroTimerDisplay(
            timer = timer,
            modifier = Modifier.fillMaxSize()
        )
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Pomodoro Timer") {
        App()
    }
}
