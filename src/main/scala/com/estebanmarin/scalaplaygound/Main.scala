package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 50)

    code(args)

    println("─" * 50)

  }

  def code(args: Array[String]): Unit = {

    def openTerm(freeVariable: Int): Int => Int =
      boundVariable => freeVariable + boundVariable

    println(openTerm(freeVariable = 3)(0))

  }
}
