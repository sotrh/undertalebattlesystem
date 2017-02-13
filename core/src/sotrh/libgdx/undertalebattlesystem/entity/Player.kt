package sotrh.libgdx.undertalebattlesystem.entity

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Disposable
import sotrh.libgdx.undertalebattlesystem.common.PLAYER_SIZE
import sotrh.libgdx.undertalebattlesystem.common.toPixels
import sotrh.libgdx.undertalebattlesystem.input.Input

/**
 * Created by benjamin on 2/7/17
 */
class Player(val texture: Texture, val color: Color, var w: Float = PLAYER_SIZE, var h: Float = PLAYER_SIZE) : Disposable {
    var x = 0f
    var y = 0f

    enum class Commands {
        MOVE_UP, MOVE_DOWN, MOVE_LEFT, MOVE_RIGHT
    }

    val keyMap = hashMapOf<Int, Commands>()

    fun update(delta: Float) {
        val speed = delta.toPixels()
        keyMap.filter { it.key in Input.keysPressed }.forEach {
            when (it.value) {
                Commands.MOVE_UP -> y += speed
                Commands.MOVE_LEFT -> x -= speed
                Commands.MOVE_DOWN -> y -= speed
                Commands.MOVE_RIGHT -> x += speed
            }
        }
    }

    fun draw(spriteBatch: SpriteBatch) {
        spriteBatch.color = color
        spriteBatch.draw(texture, x, y, w, h)
    }

    override fun dispose() {
        texture.dispose()
    }
}