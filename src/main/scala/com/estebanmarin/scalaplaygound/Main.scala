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

      def fibonacci(n: Int): Int = {
        var iterations = 0

        @scala.annotation.tailrec
        def loop(
            n: Int,
            acc1: Int,
            acc2: Int,
          ): Int = {
          iterations += 1
          if (n == 0)
            acc1
          else if (n == 1)
            acc2
          else
            loop(n = n - 1, acc1 = acc2, acc2 = acc2 + acc1)
        }
        val result = loop(n, 0, 1)
        println(s"iterations: $iterations \n")
        result
      }

      // println(factorial(5))
      // println(factorial(99999))

      println(s" 3 => ${fibonacci(50)}")

    }

    println("─" * 100)
  }
}
