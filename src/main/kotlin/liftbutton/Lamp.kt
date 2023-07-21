package liftbutton

class Lamp {
    var isOn: Boolean = false
        private set

    fun turnOn() {
        isOn = true
    }

    fun turnOff() {
        isOn = false
    }
}
