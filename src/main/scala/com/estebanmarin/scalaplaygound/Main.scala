package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 100)

    {

      def method1: String = {

        var currentIteration = 1

        @scala.annotation.tailrec
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

      def method2: String = {
        @scala.annotation.tailrec
        def loop(currentIteration: Int): String =
          if (currentIteration % 5 != 0) {
            println(currentIteration)

            loop(currentIteration + 1)
          }
          else
            "done"

        loop(1)
      }

      def method3 = {

        var currentIteration = 1

        while (currentIteration % 5 != 0) {
          println(currentIteration)

          currentIteration += 1
        }
        "done"
      }

      println(method3)
    }

    println("─" * 100)
  }
}
