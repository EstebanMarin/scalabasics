package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 50)

    def signedBites(n: Long): Int =
      unsignedBits(n) + 1

    def unsignedBits(n: Long): Int =
      toBinary(n).size

    def toBinary(x: Long): String = {

      @scala.annotation.tailrec
      def loop(x: Long, acc: String): String =
        if (x <= 1)
          s"${(x % 2).toString()}${acc}"
        else
          loop(
            x = x / 2,
            acc = s"${(x % 2).toString()}${acc}",
          )

      loop(x, "")
    }

    println(toBinary(73))
    println(unsignedBits(73))

    println("─" * 50)
  }
}
