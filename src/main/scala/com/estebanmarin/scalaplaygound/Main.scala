package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 50)

    {
      var cycle = 360

      350 to 370 foreach { i =>
        println(i % cycle)
      }
    }

    println("─" * 50)
  }
}
