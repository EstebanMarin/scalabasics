package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 100)

    {

      def method: String = {

        var currentIteration = 1

        def loop: String =
          if (currentIteration % 5 != 0) {
            println(currentIteration)

            currentIteration += 1

            loop
          }
          else
            "done"

        loop
      }

      println(method)
    }

    println("─" * 100)
  }
}
