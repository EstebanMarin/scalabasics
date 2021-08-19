package com.estebanmarin
package scalaplaygound

object Main {
  def main(args: Array[String]): Unit = {
    println("─" * 50)

    code(args)

    println("─" * 50)

  }

  def code(args: Array[String]): Unit = {

    trait DataStructure {
      val length: Int
      def +(second: Word): Word
    }

    final case class Word(string: String) extends DataStructure {
      val length = string.length
      def +(second: Word): Word =
        new Word(s"${this.string}${second.string}")
    }

    final case class Person(
        name: String,
        age: Int,
        phone: String,
        email: String,
      )

    val result: Word = Word("Hello ") + Word("World")

    println(result)
    println(result.string)

    val bob: Person =
      Person(
        name = "bob",
        age = 35,
        phone = "121564",
        email = "bob@bob.com",
      )

    println(bob)

  }
}
