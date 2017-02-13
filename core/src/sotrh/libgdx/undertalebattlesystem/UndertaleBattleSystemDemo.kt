package sotrh.libgdx.undertalebattlesystem

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import sotrh.libgdx.undertalebattlesystem.entity.Arena
import sotrh.libgdx.undertalebattlesystem.entity.Player

class UndertaleBattleSystemDemo : ApplicationAdapter() {
    lateinit var batch: SpriteBatch
    lateinit var shapeRenderer: ShapeRenderer
    lateinit var arena: Arena

    override fun create() {
        batch = SpriteBatch()
        shapeRenderer = ShapeRenderer()

        arena = Arena(Gdx.graphics.width / 2f, Gdx.graphics.height / 2f, 200f, 200f)
        arena.addPlayer(Player(Texture("sprites/heart.png"), Color.RED).apply {
            keyMap[Input.Keys.W] = Player.Commands.MOVE_UP
            keyMap[Input.Keys.A] = Player.Commands.MOVE_LEFT
            keyMap[Input.Keys.S] = Player.Commands.MOVE_DOWN
            keyMap[Input.Keys.D] = Player.Commands.MOVE_RIGHT
        })
        arena.addPlayer(Player(Texture("sprites/heart.png"), Color.BLUE).apply {
            keyMap[Input.Keys.UP] = Player.Commands.MOVE_UP
            keyMap[Input.Keys.LEFT] = Player.Commands.MOVE_LEFT
            keyMap[Input.Keys.DOWN] = Player.Commands.MOVE_DOWN
            keyMap[Input.Keys.RIGHT] = Player.Commands.MOVE_RIGHT
        })
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
