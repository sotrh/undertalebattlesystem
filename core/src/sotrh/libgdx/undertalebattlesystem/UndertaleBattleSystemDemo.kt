package sotrh.libgdx.undertalebattlesystem

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Graphics
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class UndertaleBattleSystemDemo : ApplicationAdapter() {
    lateinit var batch: SpriteBatch
    lateinit var player: Player

    override fun create() {
        batch = SpriteBatch()
        player = Player(Texture("sprites/heart.png"))
        player.center()
    }

    override fun render() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) Gdx.app.exit()

        val delta = Gdx.graphics.deltaTime
        val speed = delta.toPixels()
        if (Gdx.input.isKeyPressed(Input.Keys.W)) player.y += speed
        if (Gdx.input.isKeyPressed(Input.Keys.A)) player.x -= speed
        if (Gdx.input.isKeyPressed(Input.Keys.S)) player.y -= speed
        if (Gdx.input.isKeyPressed(Input.Keys.D)) player.x += speed

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.begin()
        player.draw(batch)
        batch.end()
    }

    override fun dispose() {
        batch.dispose()
        player.dispose()
    }
}
