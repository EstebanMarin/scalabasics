package com.estebanmarin.scalaplaygound

final case class Person(
    name: String,
    age: Int,
    isMale: Boolean,
  ) {
  def isFemale: Boolean = !isMale
}
