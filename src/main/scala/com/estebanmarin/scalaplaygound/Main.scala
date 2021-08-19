package com.estebanmarin
package scalaplaygound

import Constants._
import scala.concurrent.duration._

object TickUntilEnterPressed {
  def main(args: Array[String]): Unit =
    Scala.tickUntilEnterPressed(Interval) {

      Terminal.clearCanvas()
      Terminal.goUp(LineToGoUp)
      TwoDimensionalTime.showCurrent(TimePattern)
    }
}
object TickForFewSeconds {
  def main(args: Array[String]): Unit =
    Scala.loop(times = FewSeconds) {
      Terminal.clearCanvas()
      Terminal.goUp(LineToGoUp)
      TwoDimensionalTime.showCurrent(TimePattern)
      Scala.wait(Interval)
    }
}

object Constants {
  val FewSeconds: Int = 30
  val TimePattern: String = "HH:mm:ss"
  val Interval: FiniteDuration = 1.second
  val LineToGoUp: Int = Int.MaxValue
}
