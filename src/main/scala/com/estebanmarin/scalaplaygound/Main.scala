package com.estebanmarin
package scalaplaygound

import Helpers._
import com.estebanmarin.scalaplaygound.Write.Success
import com.estebanmarin.scalaplaygound.Write.Warning
object main {
  def main(args: Array[String]): Unit = {
    println("-" * 50)
    code(args)
    println()
    println("-" * 50)
  }

  def code(args: Array[String]): Unit = {

    println("Hello")

    {
      val file = new File(
        location = "/src/emm/Main.scala",
        name = "Main",
        extention = ".scala",
        content = "Hello world",
      )
      val optionalCase: Write.Result = file.write()

      optionalCase match {
        case Write.Error(message) => println(s"Error: $message")
        case Success(size)        => println(s"Happy Days: $size")
        case Warning(message)     => println(s"warning: $message")
      }
    }

    println("End")
  }

}
