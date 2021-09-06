package com.estebanmarin.scalaplaygound

object Helpers {
  def showRed(string: String): Unit =
    styled(string, Console.RED)

  def showGreen(string: String): Unit =
    styled(string, Console.GREEN)

  def showYellow(string: String): Unit =
    styled(string, Console.YELLOW)

  private def styled(string: String, color: String) =
    println(s"$color $string ${Console.RESET}")
}
