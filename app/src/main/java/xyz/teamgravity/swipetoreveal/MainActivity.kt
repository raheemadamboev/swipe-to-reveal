package xyz.teamgravity.swipetoreveal

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.teamgravity.swipetoreveal.ui.theme.SwipeToRevealTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SwipeToRevealTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { padding ->
                    var contacts by remember { mutableStateOf(ContactProvider.VALUE) }

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                    ) {
                        itemsIndexed(
                            items = contacts,
                            key = { _, contact ->
                                contact.id
                            }
                        ) { index, contact ->
                            SwipeToRevealItem(
                                revealed = contact.revealed,
                                onExpanded = {
                                    contacts = contacts.changeRevealed(
                                        index = index,
                                        revealed = true
                                    )
                                },
                                onCollapsed = {
                                    contacts = contacts.changeRevealed(
                                        index = index,
                                        revealed = false
                                    )
                                },
                                actions = {
                                    ActionButton(
                                        onClick = {
                                            Toast.makeText(this@MainActivity, "Contact ${contact.name} was deleted.", Toast.LENGTH_SHORT).show()
                                            contacts = contacts.remove(index)
                                        },
                                        color = Color.Red,
                                        icon = Icons.Default.Delete
                                    )
                                    ActionButton(
                                        onClick = {
                                            contacts = contacts.changeRevealed(
                                                index = index,
                                                revealed = false
                                            )
                                            Toast.makeText(this@MainActivity, "Contact ${contact.name} was sent an email.", Toast.LENGTH_SHORT).show()
                                        },
                                        color = Color.Blue,
                                        icon = Icons.Default.Email
                                    )
                                    ActionButton(
                                        onClick = {
                                            contacts = contacts.changeRevealed(
                                                index = index,
                                                revealed = false
                                            )
                                            Toast.makeText(this@MainActivity, "Contact ${contact.name} was shared", Toast.LENGTH_SHORT).show()
                                        },
                                        color = Color.Magenta,
                                        icon = Icons.Default.Share
                                    )
                                }
                            ) {
                                Text(
                                    text = contact.name,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}