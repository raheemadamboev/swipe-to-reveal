package xyz.teamgravity.swipetoreveal

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

fun ImmutableList<ContactModel>.remove(id: String): ImmutableList<ContactModel> {
    val values = toMutableList()
    val index = values.indexOfFirst { it.id == id }
    if (index != -1) values.removeAt(index)
    return values.toImmutableList()
}

fun ImmutableList<ContactModel>.changeRevealed(
    id: String,
    revealed: Boolean
): ImmutableList<ContactModel> {
    val values = toMutableList()
    val index = values.indexOfFirst { it.id == id }

    if (index != -1) {
        val value = values[index]
        values[index] = value.copy(revealed = revealed)
    }

    return values.toImmutableList()
}