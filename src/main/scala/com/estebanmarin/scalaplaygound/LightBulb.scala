package com.estebanmarin.scalaplaygound

class LightBulb extends Device {
  override val wattsperSecond: Int = 100

  override protected[this] def actuallyTurnOn(): Unit =
    println("lightbulb on")

  override protected[this] def actuallyTurnOff(): Unit =
    println("lightbulb off")
}
