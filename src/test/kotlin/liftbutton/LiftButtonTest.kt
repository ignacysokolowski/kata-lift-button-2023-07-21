package liftbutton

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LiftButtonTest {

    @Test fun `turns the lamp on when pressed`() {
        val button = LiftButton()
        button.press()
        assertTrue(button.isLit)
    }
}
