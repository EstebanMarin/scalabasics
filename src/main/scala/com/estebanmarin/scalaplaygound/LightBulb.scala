package com.estebanmarin.scalaplaygound

class LightBulb extends Device {

  override val wattsperSecond: Int = 100
  private[this] var _isOn: Boolean = false

  def isOn: Boolean = _isOn
  private[this] def isOn_=(newValue: Boolean): Unit = _isOn = newValue

  def isOff: Boolean = !isOn
  private[this] def isOff_=(newValue: Boolean): Unit = _isOn = !newValue

  override def turnOn(): Unit =
    if (isOff) {
      isOn = true

      println("Turn LightBulb ON")
    }
    else
      sys.error("already on")

  override def turnOff(): Unit =
    if (isOn) {
      isOff = true

      println("Turn LightBulb OFF")
    }
    else
      sys.error("already off")
}
