import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.awt.Dimension

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Wanna Have",
    ) {
        window.minimumSize = Dimension(512,512)
        App()
    }
}