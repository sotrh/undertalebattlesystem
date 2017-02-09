package sotrh.libgdx.undertalebattlesystem

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Disposable

/**
 * Created by benjamin on 2/7/17
 */
class Player(val texture: Texture, var w: Float = PLAYER_SIZE, var h: Float = PLAYER_SIZE) : Disposable {
    var x = 0f
    var y = 0f

    fun draw(spriteBatch: SpriteBatch) {
        spriteBatch.draw(texture, x, y, w, h)
    }

    fun center() {
        x = Gdx.graphics.width / 2 + x - w / 2
        y = Gdx.graphics.height / 2 + y - h / 2
    }

    override fun dispose() {
        texture.dispose()
    }
}