package liftbutton

class LiftButton {
    var isLit: Boolean = false
        private set

    fun press() {
        isLit = true
    }
}
