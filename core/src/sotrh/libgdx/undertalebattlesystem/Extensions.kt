package sotrh.libgdx.undertalebattlesystem

/**
 * Created by benjamin on 2/7/17
 */

fun Int.toMeters() = this.toFloat() / PIXELS_TO_METERS
fun Float.toMeters() = this / PIXELS_TO_METERS

fun Int.toPixels() = this.toFloat() * PIXELS_TO_METERS
fun Float.toPixels() = this * PIXELS_TO_METERS