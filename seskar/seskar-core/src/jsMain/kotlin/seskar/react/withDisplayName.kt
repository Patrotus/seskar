@file:Suppress(
    "NOTHING_TO_INLINE",
)

package seskar.react

internal inline fun <T : Any> withDisplayName(
    target: T,
    displayName: String,
): T {
    target.asDynamic().displayName = displayName
    return target
}
