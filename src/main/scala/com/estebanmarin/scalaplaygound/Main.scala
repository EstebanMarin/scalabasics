package com.estebanmarin
package scalaplaygound

import java.sql.Time

object main {
  def main(args: Array[String]): Unit = {
    println("-" * 50)
    code(args)
    println("-" * 50)
  }

  def code(args: Array[String]): Unit = {
    class Animal
    trait Pet {
      def allowedToSleepInBed: Boolean
    }

    class Cat extends Animal with Pet {
      val allowedToSleepInBed: Boolean = true
    }

    class Turtle extends Pet {
      def allowedToSleepInBed: Boolean = false
    }

    def show(pet: Pet): Unit =
      println(pet.allowedToSleepInBed)

    val path =
      "/Users/marinest/adidas/scala/dev/scalaplaygound/src/main/scala/com/estebanmarin/scalaplaygound/Main.scala"

    // show(pet = new Cat)
    // show(pet = new Turtle)

    trait Timestamp {
      val creationTime: String = {
        val formater =
          java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")

        java.time.LocalDateTime.now.format(formater)
      }
    }

    // class FileWithTimestamp(path: String) extends java.io.File(path) with Timestamp

    // val file = new FileWithTimestamp(path)
    val file = new java.io.File(path) with Timestamp

    def showName(file: java.io.File): Unit =
      println(file.getName)

    def showCreationTime(timeStamp: Timestamp) =
      println(timeStamp.creationTime)

    print(showName(file))
    print(showCreationTime(file))

  }
}
