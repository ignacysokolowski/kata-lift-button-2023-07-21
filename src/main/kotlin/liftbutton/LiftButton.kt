package liftbutton

class LiftButton {
    private var areLiftDoorsOpen: Boolean = false
    var isLit: Boolean = false
        private set

    fun press() {
        if (!areLiftDoorsOpen) {
            isLit = true
        }
    }

    fun liftDoorsOpened() {
        areLiftDoorsOpen = true
        isLit = false
    }
}
