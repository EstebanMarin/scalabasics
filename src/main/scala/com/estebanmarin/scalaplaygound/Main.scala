package com.estebanmarin
package scalaplaygound

object main {
  def main(args: Array[String]): Unit = {
    println("-" * 50)
    code(args)
    println("-" * 50)
  }

  def code(args: Array[String]): Unit = {

    trait Device {
      def wattsPerSecond: Int
      def turnDeviceOn(): Unit
      def turnDeviceOff(): Unit
    }

    class EnergyMeter(device: Device) {

      private[this] var turnedOnAtMillis: Long = 0
      private[this] var _wattsConsumedInTotal: Double = 0
      //getter
      def wattsConsumedInTotal: Double = _wattsConsumedInTotal
      //setter or muttator
      private[this] def wattsConsumedInTotal_=(newValue: Double): Unit =
        _wattsConsumedInTotal = newValue

      def startMeasuring(): Unit = {
        device.turnDeviceOn()
        turnedOnAtMillis = System.currentTimeMillis()
      }

      def stopMeasuring(): Unit = {

        device.turnDeviceOff()

        val durationInMillis = System.currentTimeMillis() - turnedOnAtMillis
        val durationInSeconds = durationInMillis.toDouble / 1000

        wattsConsumedInTotal += wattsPerSecond * durationInSeconds
        // _wattsConsumedInTotal = _wattsConsumedInTotal + (wattsPerSecond * durationInSeconds)
        // wattsConsumedInTotal_=(wattsConsumedInTotal + (wattsPerSecond * durationInSeconds))

      }

    }

    object EnergyMeter {

      def apply(device: Any): EnergyMeter =
        device match {
          case lightBulb: LightBulb =>
            new EnergyMeter(
              wattsPerSecond = lightBulb.wattsPerSecond,
              turnDeviceOn = () => lightBulb.turnOn(),
              turnDeviceOff = () => lightBulb.turnOff(),
            )
          case tv: TV =>
            new EnergyMeter(
              wattsPerSecond = tv.wattsPerSecond,
              turnDeviceOn = () => tv.turnOn(),
              turnDeviceOff = () => tv.turnOff(),
            )
          case _ =>
            sys.error("No such device")

        }

    }

    class TV {

      val wattsPerSecond: Int = 500

      def turnOn(): Unit = println("tv on")
      def turnOff(): Unit = println("tv off")
    }

    class LightBulb {

      val wattsPerSecond: Int = 50

      def turnOn(): Unit = println("bulb on")
      def turnOff(): Unit = println("bulb off")
    }

    class Whatever
    val whatever: Whatever = new Whatever

    val lighBulb: LightBulb = new LightBulb
    val tv: TV = new TV

    // val energyMeter = new EnergyMeter(
    //   wattsPerSecond = lighBulb.wattsPerSecond,
    //   turnDeviceOn = () => lighBulb.turnOn(),
    //   turnDeviceOff = () => lighBulb.turnOff(),
    // )

    val energyMeter = EnergyMeter(tv)

    energyMeter.startMeasuring()
    Thread.sleep(1000)
    energyMeter.stopMeasuring()
    println(energyMeter.wattsConsumedInTotal)

    energyMeter.startMeasuring()
    Thread.sleep(1000)
    energyMeter.stopMeasuring()
    println(energyMeter.wattsConsumedInTotal)

    val energyMeter2 = EnergyMeter(lighBulb)

    energyMeter2.startMeasuring()
    Thread.sleep(1000)
    energyMeter2.stopMeasuring()
    println(energyMeter2.wattsConsumedInTotal)

    energyMeter2.startMeasuring()
    Thread.sleep(1000)
    energyMeter2.stopMeasuring()
    println(energyMeter2.wattsConsumedInTotal)
  }
}
