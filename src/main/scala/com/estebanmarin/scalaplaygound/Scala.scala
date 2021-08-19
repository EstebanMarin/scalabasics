package com.estebanmarin.scalaplaygound

import scala.concurrent.duration._
import java.util.Timer
import java.util.TimerTask

object Scala {
  def tickUntilEnterPressed(interval: FiniteDuration)(code: => Unit) = {
    val timer: Timer = new Timer

    val delayInMilli: Long = 0
    val periodInMilli: Long = interval.toMillis
    val timerTask: TimerTask = new TimerTask {
      def run(): Unit =
        code
    }

    timer.scheduleAtFixedRate(
      timerTask,
      delayInMilli,
      periodInMilli,
    )

    io.StdIn.readLine()
    timer.cancel()
  }
  def wait(delay: FiniteDuration): Unit = Thread.sleep(delay.toMillis)
  def loop(times: Int)(code: => Unit): Unit = 1 to times foreach (_ => code)
}
