package com.example.test.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val NavyBlue = Color(0xFF1B2541)
private val White = Color(0xFFFFFFFF)
private val LightGray = Color(0xFFF8F9FA)
private val CoralOrange = Color(0xFFFF6B6B)
private val MediumGray = Color(0xFF6C757D)

private val DarkColorScheme = darkColorScheme(
    primary = CoralOrange,
    secondary = White,
    tertiary = MediumGray,
    background = NavyBlue,
    surface = Color(0xFF2A3550),
    onPrimary = White,
    onSecondary = NavyBlue,
    onTertiary = White,
    onBackground = White,
    onSurface = White
)

private val LightColorScheme = lightColorScheme(
    primary = CoralOrange,
    secondary = NavyBlue,
    tertiary = MediumGray,
    background = LightGray,
    surface = White,
    onPrimary = White,
    onSecondary = White,
    onTertiary = White,
    onBackground = NavyBlue,
    onSurface = NavyBlue
)

@Composable
fun TestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false, // Cambiado a false para usar nuestra paleta personalizada
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}