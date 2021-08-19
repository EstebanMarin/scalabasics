package com.estebanmarin.scalaplaygound

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object TwoDimensionalTime {

  val Stars: TwoDimensionalString =
    TwoDimensionalString(
      toples = "   ",
      middle = " * ",
      bottom = " * ",
    )
  def showCurrent(pattern: String): Unit =
    show(LocalDateTime.now(), pattern)

  def show(time: LocalDateTime, pattern: String): Unit =
    formatted(time, pattern).show()

  def formatted(time: LocalDateTime, pattern: String): TwoDimensionalString = {
    var result: TwoDimensionalString = TwoDimensionalString.Empty
    oneDimensional(time, pattern) foreach { timeDigit =>
      if (timeDigit == ':')
        result += Stars
      else
        result += TwoDimensionalDigit(digit = timeDigit.toString().toInt)
    }
    result
  }

  def formatted2(time: LocalDateTime, pattern: String): TwoDimensionalString =
    oneDimensional(time, pattern).foldLeft(TwoDimensionalString.Empty) { (result, timeDigit) =>
      if (timeDigit == ':')
        result + Stars
      else
        result + TwoDimensionalDigit(digit = timeDigit.toString().toInt)
    }

  def oneDimensional(time: LocalDateTime, pattern: String): String =
    time.format(DateTimeFormatter.ofPattern(pattern))

}
