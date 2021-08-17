package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 50)

    val i: (Int, Int) => Boolean = _ == _

    println(i(10, 11))
    println("─" * 50)
  }
}
