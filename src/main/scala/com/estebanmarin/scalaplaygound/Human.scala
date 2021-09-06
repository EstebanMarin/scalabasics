package com.estebanmarin.scalaplaygound

final class Human(
    val name: String,
    val age: Int,
    val isMale: Boolean,
  ) {
  private def isFemale: Boolean = !isMale
  override def toString: String =
    s"Human($name, $age, $isMale)"
}

object Human {
  def apply(
      name: String,
      age: Int,
      isMale: Boolean,
    ): Human = new Human(name = name, age = age, isMale = isMale)

  override def toString: String = s"Human"

}
