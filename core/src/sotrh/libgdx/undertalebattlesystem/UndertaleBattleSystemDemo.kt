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
    }

    override fun render() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) Gdx.app.exit()

        val delta = Gdx.graphics.deltaTime
        if (Gdx.input.isKeyPressed(Input.Keys.W)) player.sprite.y += delta.toPixels()
        if (Gdx.input.isKeyPressed(Input.Keys.A)) player.sprite.x -= delta.toPixels()
        if (Gdx.input.isKeyPressed(Input.Keys.S)) player.sprite.y -= delta.toPixels()
        if (Gdx.input.isKeyPressed(Input.Keys.D)) player.sprite.x += delta.toPixels()

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.begin()
        player.sprite.draw(batch)
        batch.end()
    }

    override fun dispose() {
        batch.dispose()
        player.dispose()
    }
}
