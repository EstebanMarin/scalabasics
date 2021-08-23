package com.estebanmarin
package scalaplaygound

object main {
  def main(args: Array[String]): Unit = {
    println("-" * 50)
    code(args)
    println("-" * 50)
  }

  def code(args: Array[String]): Unit = {
    class EnergyMeter(
        wattsPerSecond: Int,
        turnDeviceOn: () => Unit,
        turnDeviceOff: () => Unit,
      ) {

      private[this] var turnedOnAtMillis: Long = 0
      private[this] var _wattsConsumedInTotal: Double = 0
      //getter
      def wattsConsumedInTotal: Double = _wattsConsumedInTotal
      //setter or muttator
      private[this] def wattsConsumedInTotal_=(newValue: Double): Unit =
        _wattsConsumedInTotal = newValue

      def startMeasuring(): Unit = {
        turnDeviceOn()
        turnedOnAtMillis = System.currentTimeMillis()
      }

      def stopMeasuring(): Unit = {

        turnDeviceOff()

        val durationInMillis = System.currentTimeMillis() - turnedOnAtMillis
        val durationInSeconds = durationInMillis.toDouble / 1000

        wattsConsumedInTotal += wattsPerSecond * durationInSeconds
        // _wattsConsumedInTotal = _wattsConsumedInTotal + (wattsPerSecond * durationInSeconds)
        // wattsConsumedInTotal_=(wattsConsumedInTotal + (wattsPerSecond * durationInSeconds))

      }

    }

    val wattsPerSecondOfTV: Int = 500

    def turnTvOn(): Unit = println("tv on")
    def turnTvOff(): Unit = println("tv off")
    val energyMeter = new EnergyMeter(
      wattsPerSecond = wattsPerSecondOfTV,
      turnDeviceOn = () => turnTvOn(),
      turnDeviceOff = () => turnTvOff(),
    )

    energyMeter.startMeasuring()
    Thread.sleep(1000)
    energyMeter.stopMeasuring()
    println(energyMeter.wattsConsumedInTotal)

    energyMeter.startMeasuring()
    Thread.sleep(1000)
    energyMeter.stopMeasuring()
    println(energyMeter.wattsConsumedInTotal)

  }
}
