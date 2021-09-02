package com.estebanmarin.scalaplaygound

object Modification {
  trait Spoiler extends Base.Car {
    println("Spoiler")
    abstract override def topSpeedKmPerHour: Int =
      (super.topSpeedKmPerHour * 1.02).toInt
  }

  trait EngineControlUnit extends Core.OrdinaryCar {
    println("Engine Control")
    override def topSpeedKmPerHour: Int =
      (super.topSpeedKmPerHour * 1.5).toInt
  }

  trait TurboCharger extends Core.OrdinaryCar {
    println("Turbo Charger")
    override def topSpeedKmPerHour: Int =
      (super.topSpeedKmPerHour * 1.25).toInt
  }

  trait CaseIgnorance extends java.util.Set[String] {
    abstract override def add(element: String) =
      super.add(element.toLowerCase())

    abstract override def contains(element: Any) =
      super.contains(element.asInstanceOf[String].toLowerCase())

    abstract override def remove(element: Any) =
      super.remove(element.asInstanceOf[String].toLowerCase())

    trait Logging extends java.util.Set[String] {
      abstract override def add(element: String) =
        println(s"Add: $element")
      super.add(e)
    }
  }
}
