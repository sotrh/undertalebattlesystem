package sotrh.libgdx.undertalebattlesystem

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.utils.Disposable

/**
 * Created by benjamin on 2/7/17
 */
class Player(val texture: Texture) : Disposable {
    val sprite = Sprite(texture).apply { scale(0.5f) }

    override fun dispose() {
        texture.dispose()
    }
}