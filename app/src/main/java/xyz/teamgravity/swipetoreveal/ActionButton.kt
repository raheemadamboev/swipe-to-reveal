package xyz.teamgravity.swipetoreveal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ActionButton(
    onClick: () -> Unit,
    color: Color,
    icon: ImageVector
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxHeight()
            .background(color)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White
        )
    }
}