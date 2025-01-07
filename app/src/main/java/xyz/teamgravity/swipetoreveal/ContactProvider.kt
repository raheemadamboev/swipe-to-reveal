package xyz.teamgravity.swipetoreveal

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlin.uuid.Uuid

object ContactProvider {
    val VALUE: ImmutableList<ContactModel> = buildList(
        capacity = 100
    ) {
        repeat(100) { index ->
            add(
                ContactModel(
                    id = Uuid.random().toString(),
                    name = "Contact - $index",
                    revealed = false
                )
            )
        }
    }.toImmutableList()
}