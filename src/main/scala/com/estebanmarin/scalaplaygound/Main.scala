package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 50)

    code(args)

    println("─" * 50)

  }

  def code(args: Array[String]): Unit = {

    // Higher order because produces another function
    // as it result but put type to trhe bound variable
    def closeTerm(freeVariable: Int)(boundVariable: Int): Int =
      freeVariable + boundVariable

    println(closeTerm(freeVariable = 3)(boundVariable = 3))

  }
}
