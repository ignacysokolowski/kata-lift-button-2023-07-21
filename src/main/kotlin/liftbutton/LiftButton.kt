package liftbutton

class LiftButton(private val lamp: Lamp) {
    private var areLiftDoorsOpen: Boolean = false

    fun press() {
        if (!areLiftDoorsOpen) {
            lamp.turnOn()
        }
    }

    fun liftDoorsOpened() {
        areLiftDoorsOpen = true
        lamp.turnOff()
    }
}
