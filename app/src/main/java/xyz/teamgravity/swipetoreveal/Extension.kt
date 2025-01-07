package xyz.teamgravity.swipetoreveal

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

fun ImmutableList<ContactModel>.remove(index: Int): ImmutableList<ContactModel> {
    val values = toMutableList()
    values.removeAt(index)
    return values.toImmutableList()
}

fun ImmutableList<ContactModel>.changeRevealed(
    index: Int,
    revealed: Boolean
): ImmutableList<ContactModel> {
    val values = toMutableList()
    values[index] = values[index].copy(revealed = revealed)
    return values.toImmutableList()
}