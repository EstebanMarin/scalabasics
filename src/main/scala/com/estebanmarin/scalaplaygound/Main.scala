package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 50)

    code(args)

    println("─" * 50)

  }

  def code(args: Array[String]): Unit = {

    def show(
        fName: String,
        f: Int => Int,
        arg: Int,
      ): String =
      s"""|Function: ${fName}\tArgument: ${arg}\tResult: ${f(arg)}""".stripMargin

    def showRange(
        fName: String,
        arguments: Range,
        f: Int => Int,
      ): Unit =
      arguments foreach { argument =>
        println(
          show(fName, f, argument)
        )
      }

    def factorial(n: Int): Int = {
      @scala.annotation.tailrec
      def loop(acc: Int, n: Int): Int =
        if (n <= 1)
          acc
        else
          loop(n * acc, n - 1)
      loop(1, n)
    }

    def fibonacci(n: Int): Int = {
      @scala.annotation.tailrec
      def loop(
          n: Int,
          a: Int,
          b: Int,
        ): Int = n match {
        case 0 => a
        case _ => loop(n - 1, b, a + b)
      }
      loop(n, 0, 1)
    }

    showRange(fName = " + 5", 1 to 10, f = _ + 5)
    showRange(fName = "Factorial", 1 to 10, f = factorial)
    showRange(fName = "Fibonacci", 1 to 10, f = fibonacci)

  }
}
