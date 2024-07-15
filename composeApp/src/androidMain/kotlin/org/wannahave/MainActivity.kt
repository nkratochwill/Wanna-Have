package org.wannahave

import App
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            enableEdgeToEdge()
        } else {
            val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            val systemBarStyle = when (currentNightMode) {
                Configuration.UI_MODE_NIGHT_NO -> SystemBarStyle.light(Color.Transparent.toArgb(), Color.Transparent.toArgb())
                Configuration.UI_MODE_NIGHT_YES -> SystemBarStyle.dark(Color.Transparent.toArgb())
                else -> error("Illegal State, current mode is $currentNightMode")
            }
            enableEdgeToEdge(statusBarStyle = systemBarStyle, navigationBarStyle = systemBarStyle)
        }

        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}