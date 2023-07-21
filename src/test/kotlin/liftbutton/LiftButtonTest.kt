package liftbutton

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LiftButtonTest {
    private val lamp = Lamp()
    private val button = LiftButton(lamp)

    @Test fun `turns the lamp on when pressed`() {
        button.press()
        assertTrue(lamp.isOn)
    }

    @Test fun `does not lit before pressed`() {
        assertFalse(lamp.isOn)
    }

    @Test fun `turns the lamp off when the doors open`() {
        button.press()
        button.liftDoorsOpened()
        assertFalse(lamp.isOn)
    }

    @Test fun `does not turn the lamp on when pressed while the doors are open`() {
        button.liftDoorsOpened()
        button.press()
        assertFalse(lamp.isOn)
    }
}
