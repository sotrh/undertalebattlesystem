package sotrh.libgdx.undertalebattlesystem

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class UndertaleBattleSystemDemo : ApplicationAdapter() {
    lateinit var batch: SpriteBatch
    lateinit var shapeRenderer: ShapeRenderer
    lateinit var arena: Arena

    override fun create() {
        batch = SpriteBatch()
        shapeRenderer = ShapeRenderer()

        arena = Arena(Gdx.graphics.width / 2f, Gdx.graphics.height / 2f, 200f, 200f)
        arena.addPlayer(Player(Texture("sprites/heart.png")))
    }

    override fun render() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) Gdx.app.exit()

        val delta = Gdx.graphics.deltaTime
        arena.update(delta)

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        arena.draw(batch, shapeRenderer)
    }

    override fun dispose() {
        batch.dispose()
        arena.dispose()
    }
}
