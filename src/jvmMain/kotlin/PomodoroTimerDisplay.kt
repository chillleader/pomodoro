import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PomodoroTimerDisplay(
    timer: PomodoroTimer,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = timer.state.formattedName,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Next: ${timer.state.getNextState(timer.focusCount).formattedName}"
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = timer.formattedTimer,
            fontWeight = FontWeight.Bold,
            fontSize = 48.sp
        )
        Spacer(Modifier.height(16.dp))
        Row {
            Button(
                onClick = { timer.start() },
                enabled = !timer.isRunning
            ) {
                Text("Start")
            }
            Spacer(Modifier.width(16.dp))
            Button(
                onClick = { timer.stop() },
                enabled = timer.isRunning
            ) {
                Text("Stop")
            }
            Spacer(Modifier.width(16.dp))
            Button(onClick = { timer.reset() }) {
                Text("Reset")
            }
        }
        Spacer(Modifier.height(16.dp))
        Text(
            text = "Pomodoros completed: ${timer.focusCount}"
        )
    }
}
