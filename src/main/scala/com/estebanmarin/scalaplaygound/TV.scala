package com.estebanmarin.scalaplaygound

class TV extends Device {
  override val wattsperSecond: Int = 500

  override protected[this] def actuallyTurnOn(): Unit =
    println("tv on")

  override protected[this] def actuallyTurnOff(): Unit =
    println("tv off")
}
