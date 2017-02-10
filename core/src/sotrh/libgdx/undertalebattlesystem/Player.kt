package sotrh.libgdx.undertalebattlesystem

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Disposable

/**
 * Created by benjamin on 2/7/17
 */
class Player(val texture: Texture, var w: Float = PLAYER_SIZE, var h: Float = PLAYER_SIZE) : Disposable {
    var x = 0f
    var y = 0f

    fun update(delta: Float) {
        val speed = delta.toPixels()
        if (Gdx.input.isKeyPressed(Input.Keys.W)) y += speed
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x -= speed
        if (Gdx.input.isKeyPressed(Input.Keys.S)) y -= speed
        if (Gdx.input.isKeyPressed(Input.Keys.D)) x += speed
    }

    fun draw(spriteBatch: SpriteBatch) {
        spriteBatch.draw(texture, x, y, w, h)
    }

    override fun dispose() {
        texture.dispose()
    }
}