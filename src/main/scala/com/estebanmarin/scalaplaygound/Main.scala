package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 50)

    def signedBites(n: Long): Int =
      unsignedBits(n) + 1

    def unsignedBits(n: Long): Int =
      n.toBinaryString.size

    def rendered(
        `type`: String,
        min: Long,
        max: Long,
        bits: Int,
      ) = {
      val bytes = bits / 8
      s"${`type`}\thas $bits\t binary digits (bits), which is $bytes bytes with \tpossible values: $min .. $max"
    }

    def renderedSigned(
        `type`: String,
        min: Long,
        max: Long,
      ): String =
      rendered(`type`, min, max, signedBites(max))

    def renderedUnsigned(
        `type`: String,
        min: Long,
        max: Long,
      ): String =
      rendered(`type`, min, max, unsignedBits(max))

    def renderFloating(
        `type`: String,
        min: Double,
        max: Double,
      ): String =
      s"${renderFirstHalf(`type`)} $min .. $max"

    def renderFirstHalf(`type`: String): String =
      s"${`type`}\t\t\t\t\t\t\t\tpossible values:"
    println(renderedSigned("Byte", Byte.MinValue, Byte.MaxValue))
    println()

    println(renderedSigned("Short", Short.MinValue, Short.MaxValue))
    println(renderedUnsigned("Chart", Char.MinValue, Char.MaxValue))
    println()

    println(renderedSigned("Int", Int.MinValue, Int.MaxValue))
    println(renderedSigned("Long", Long.MinValue, Long.MaxValue))
    println()

    println(renderFloating("Float", Float.MinValue, Float.MaxValue))
    println(renderFloating("Double", Double.MinValue, Double.MaxValue))
    println()

    println(s"${renderFirstHalf("Boolean")}, ${true} and ${false}")
    println()

    println(s"${renderFirstHalf("Unit")}, ${()} and ${{}}")

    println("─" * 50)
  }
}
