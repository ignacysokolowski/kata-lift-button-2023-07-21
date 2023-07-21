package liftbutton

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LiftButtonTest {
    private val button = LiftButton()

    @Test fun `turns the lamp on when pressed`() {
        button.press()
        assertTrue(button.isLit)
    }
}
