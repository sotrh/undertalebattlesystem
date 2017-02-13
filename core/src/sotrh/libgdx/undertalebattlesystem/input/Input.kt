package sotrh.libgdx.undertalebattlesystem.input

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputProcessor

/**
 * Created by benjamin on 2/12/17
 */
object Input {

    val keysPressed = hashSetOf<Int>()

    private val inputProcessor = object : InputProcessor {

        override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
            return false
        }

        override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
            return false
        }

        override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
            return false
        }

        override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
            return false
        }

        override fun keyTyped(character: Char): Boolean {
            return false
        }

        override fun keyDown(keycode: Int): Boolean {
            return keysPressed.add(keycode)
        }

        override fun keyUp(keycode: Int): Boolean {
            return keysPressed.remove(keycode)
        }

        override fun scrolled(amount: Int): Boolean {
            return false
        }
    }

    init {
        Gdx.input.inputProcessor = inputProcessor
    }
}