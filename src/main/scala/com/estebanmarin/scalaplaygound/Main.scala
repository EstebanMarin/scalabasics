package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 50)

    code(args)

    println("─" * 50)

  }

  def code(args: Array[String]): Unit = {

    var freeVariable: Int = 1337

    def openTerm(boundVariable: Int): Int = freeVariable + boundVariable
    def closeTerm(boundVariable: Int): Int = boundVariable

    // val addToX: Int => Int = y => x + y

    freeVariable = 7
    println(openTerm(boundVariable = 0))
    println(closeTerm(boundVariable = 1))

    freeVariable = 10
    println(openTerm(boundVariable = 1))

    freeVariable = 20
    println(openTerm(boundVariable = 2))

    freeVariable = 30
    println(openTerm(boundVariable = 3))

  }
}
