package com.estebanmarin.scalaplaygound

trait Device {
  def wattsperSecond: Int
  private[this] var _isOn: Boolean = false

  def isOn: Boolean = _isOn
  protected[this] def isOn_=(newValue: Boolean): Unit = _isOn = newValue

  def isOff: Boolean = !isOn
  protected[this] def isOff_=(newValue: Boolean): Unit = _isOn = !newValue

  final def turnOn(): Unit =
    if (isOff) {
      isOn = true
    }
    else
      sys.error("already on")

  final def turnOff(): Unit =
    if (isOn) {
      isOff = true
    }
    else
      sys.error("already off")

  protected[this] def actuallyTurnOn(): Unit
  protected[this] def actuallyTurnOff(): Unit
}
