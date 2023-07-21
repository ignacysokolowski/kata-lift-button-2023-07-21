package liftbutton

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LiftButtonTest {
    private val button = LiftButton()

    @Test fun `turns the lamp on when pressed`() {
        button.press()
        assertTrue(button.isLit)
    }

    @Test fun `does not lit before pressed`() {
        assertFalse(button.isLit)
    }

    @Test fun `turns the lamp off when the doors open`() {
        button.press()
        button.doorsOpened()
        assertFalse(button.isLit)
    }
}
