package sotrh.libgdx.undertalebattlesystem

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

/**
 * Created by benjamin on 2/9/17
 */

class Arena(val cx: Float, val cy: Float, val width: Float, val height: Float) {
    val players = gdxArrayOf<Player>()

    fun addPlayer(player : Player) {
        centerPlayer(player)
        players.add(player)
    }

    private fun centerPlayer(player: Player) {
        player.x = cx - player.w
        player.y = cy - player.h
    }

    private fun confinePlayer(player : Player) {
        player.apply {
            val left = cx - width / 2
            val top = cy + height / 2 - h
            val right = cx + width / 2 - w
            val bottom = cy - height / 2

            if (x < left) x = left
            else if (x > right) x = right
            if (y > top) y = top
            else if (y < bottom) y = bottom
        }
    }

    fun update(delta: Float) {
        players.forEach {
            it.update(delta)
            confinePlayer(it)
        }
    }

    fun draw(spriteBatch : SpriteBatch, shapeRenderer: ShapeRenderer) {
        spriteBatch.begin()
        players.forEach { it.draw(spriteBatch) }
        spriteBatch.end()

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line)
        shapeRenderer.color = Color.WHITE
        shapeRenderer.rect(cx - width / 2, cy - height / 2, width, height)
        shapeRenderer.end()
    }

    fun dispose() {
        players.forEach(Player::dispose)
    }
}