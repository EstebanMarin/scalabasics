package com.estebanmarin.scalaplaygound

class EnergyMeter(device: Device) {
  private[this] var turnedOnAtMillis: Long = 0
  private[this] var _wattsConsumedInTotal: Double = 0
  def wattsConsumedInTotal: Double = _wattsConsumedInTotal
  private[this] def wattsConsumedInTotal_=(newValue: Double): Unit =
    _wattsConsumedInTotal = newValue

  def startMeasuring(): Unit = {
    device.turnOn()
    turnedOnAtMillis = System.currentTimeMillis
  }
  def stopMeasuring(): Unit = {

    device.turnOff()
    val durationInMillis = System.currentTimeMillis() - turnedOnAtMillis
    val durationInSeconds = durationInMillis.toDouble / 1000

    wattsConsumedInTotal += device.wattsperSecond * durationInSeconds
  }
}
