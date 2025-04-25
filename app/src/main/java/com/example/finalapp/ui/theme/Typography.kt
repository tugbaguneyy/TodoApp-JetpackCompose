package com.example.finalapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.finalapp.R

// Font ailesini tanımla
val SourGummy = FontFamily(
    Font(R.font.sour_gummy_regular, FontWeight.Normal),
    Font(R.font.sour_gummy_semi_bold, FontWeight.SemiBold),
    Font(R.font.sour_gummy_thin_italic, FontWeight.Thin, FontStyle.Italic)
)

// Typography ayarları
val AppTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = SourGummy,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = SourGummy,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodySmall = TextStyle(
        fontFamily = SourGummy,
        fontWeight = FontWeight.Thin,
        fontStyle = FontStyle.Italic,
        fontSize = 12.sp
    )
    // Diğer stilleri de ekleyebilirsin
)
