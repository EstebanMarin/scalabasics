package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 50)

    {
      val degreesInACircle = 360
      println("I am in modulo")

      350 until 370 foreach { i =>
        println(i % degreesInACircle)
      }
    }

    {

      val f: Int => Int = _ + 5
      val g: Int => Int = f

      println(f equals f)
      println(g equals f)
      println(g(10))

      println(f(g(10)))
      val composed = f compose g

      println(composed(10))
    }

    println("─" * 50)

  }
}
