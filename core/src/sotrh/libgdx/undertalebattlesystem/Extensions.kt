package sotrh.libgdx.undertalebattlesystem

import com.badlogic.gdx.utils.Array

/**
 * Created by benjamin on 2/7/17
 */

fun Int.toMeters() = this.toFloat() / PIXELS_PER_METERS
fun Float.toMeters() = this / PIXELS_PER_METERS

fun Int.toPixels() = this.toFloat() * PIXELS_PER_METERS
fun Float.toPixels() = this * PIXELS_PER_METERS

inline fun <T> gdxArrayOf(vararg list: T) = Array<T>().apply { addAll(*list) }