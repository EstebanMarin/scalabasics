package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 100)

    {
      def factorial(n: Int) = {

        var iterations = 0

        @scala.annotation.tailrec
        def loop(n: Int, acc: Int): Int = {

          iterations += 1
          if (n == 0)
            acc
          else
            loop(
              n = n - 1,
              acc = acc * n,
            )

        }

        val result = loop(n, 1)
        println(s"iterations: $iterations \n")
        result
      }

      println(factorial(5))
      println(factorial(99999))

    }

    println("─" * 100)
  }
}
