package com.estebanmarin
package scalaplaygound

object main {
  def main(args: Array[String]): Unit = {
    println("-" * 50)
    code(args)
    println()
    println("-" * 50)
  }

  def code(args: Array[String]): Unit = {

    println("Hello")
    val person = Person(name = "Bob", age = 27, isMale = true)

    println(person)
    println(Console.MAGENTA + ("-" * 50) + Console.RESET)

    val human = Human(name = "Bob", age = 27, isMale = true)

    println(human.isMale)
    println(Human)
  }

}
