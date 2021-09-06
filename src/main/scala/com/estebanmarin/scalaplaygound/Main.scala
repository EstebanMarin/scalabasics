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

      // val pf: PartialFunction[Throwable, Write.Result] = ???

      def safeCall(f: () => Write.Result): Write.Result =
        try f()
        catch {
          case _: Throwable => Write.Error("Not enough space in Disk")
        }

      val optionalCase: Write.Result = safeCall(file.convinientWrite)
      // val optionalCase: Write.Result = safeCall(file.write)

      optionalCase match {
        case Write.Error(message) => showRed(s"Error: $message")
        case Success(size)        => showGreen(s"Happy Days: ${size.toString()}")
        case Warning(message)     => showYellow(s"warning: $message")
      }
    }

    println("End")
  }

}
