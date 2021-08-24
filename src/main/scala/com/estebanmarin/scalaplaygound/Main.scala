package com.estebanmarin
package scalaplaygound

object main {
  def main(args: Array[String]): Unit = {
    println("-" * 50)
    code(args)
    println("-" * 50)
  }

  def code(args: Array[String]): Unit = {

    val bulb = new LightBulb
    val tv = new TV

    val energyMeter1 = new EnergyMeter(bulb)
    val energyMeter2 = new EnergyMeter(tv)

    energyMeter1.startMeasuring()
    Thread.sleep(1000)
    energyMeter1.stopMeasuring()
    println(energyMeter1.wattsConsumedInTotal)

    energyMeter1.startMeasuring()
    Thread.sleep(1000)
    energyMeter1.stopMeasuring()
    println(energyMeter1.wattsConsumedInTotal)
    println("---")

    energyMeter2.startMeasuring()
    Thread.sleep(1000)
    energyMeter2.stopMeasuring()
    println(energyMeter2.wattsConsumedInTotal)

    energyMeter2.startMeasuring()
    Thread.sleep(1000)
    energyMeter2.stopMeasuring()
    println(energyMeter2.wattsConsumedInTotal)
    println("---")
  }

}
