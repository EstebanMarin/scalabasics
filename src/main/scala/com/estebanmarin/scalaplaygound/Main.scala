package com.estebanmarin
package scalaplaygound

import java.sql.Time

object main {
  def main(args: Array[String]): Unit = {
    println("-" * 50)
    code(args)
    println("-" * 50)
  }

  def code(args: Array[String]): Unit = {
    final class Lamborghini(override val model: String)
        extends Core.SportCar(model)
           with Modification.Spoiler {
      override def brand = "Lamborghini"
    }

    final class BMW(override val model: String)
        extends Core.OrdinaryCar(model)
           with Modification.Spoiler
           with Modification.EngineControlUnit
           with Modification.TurboCharger {

      override def brand = "BMW"
    }

    println(new Lamborghini("Murcielago"))
    println(new BMW("M3-GTR"))

  }
}
