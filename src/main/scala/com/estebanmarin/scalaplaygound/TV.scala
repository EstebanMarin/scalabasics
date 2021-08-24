package com.estebanmarin.scalaplaygound

class TV extends Device {
  override val wattsperSecond: Int = 500

  override def turnOn(): Unit =
    println("Turn TV ON")

  override def turnOff(): Unit =
    println("Turn TV OFF")
}
