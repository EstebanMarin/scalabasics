package com.estebanmarin.scalaplaygound

object Core {
  class OrdinaryCar(override val model: String) extends Base.Car {
    println("Ordinary Car")

    override def brand: String = ""

    override def topSpeedKmPerHour: Int = 220

    override def topAccelerationInRpm: Int = 8000

  }

  class SportCar(override val model: String) extends Base.Car {
    println("Sport Car")

    override def brand: String = ""

    override def topSpeedKmPerHour: Int = 300

    override def topAccelerationInRpm: Int = 11000

  }
}
