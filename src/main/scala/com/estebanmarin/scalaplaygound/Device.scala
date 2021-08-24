package com.estebanmarin.scalaplaygound

trait Device {
  def wattsperSecond: Int

  def turnOn(): Unit
  def turnOff(): Unit
}
