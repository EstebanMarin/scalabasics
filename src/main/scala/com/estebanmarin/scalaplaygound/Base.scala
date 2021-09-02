package com.estebanmarin.scalaplaygound

object Base {
  abstract class Car {
    println("Car")
    def model: String
    def topSpeedKmPerHour: Int
    def topAccelerationInRpm: Int
    def brand: String

    override def toString: String =
      //   val brand = getClass.getSimpleName()
      s"${brand} ${model} ${topSpeedKmPerHour} ${topAccelerationInRpm}"
  }
}
