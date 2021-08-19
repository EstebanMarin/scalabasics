package com.estebanmarin.scalaplaygound

final case class TwoDimensionalString(
    toples: String,
    middle: String,
    bottom: String,
  ) {

  require(requirement = doAllRowsHaveTheSameLength, message = "All rows must have the same lenght")

  def doAllRowsHaveTheSameLength: Boolean =
    (toples.length equals middle.length) && (middle.length equals bottom.length)

  def +(that: TwoDimensionalString): TwoDimensionalString =
    TwoDimensionalString(
      toples = this.toples + that.toples,
      middle = this.middle + that.middle,
      bottom = this.bottom + that.bottom,
    )
  def show(): Unit =
    println(render)

  def render: String =
    s"${toples}\n${middle}\n${bottom}\n"

}

object TwoDimensionalString {
  val QuestionMarks: TwoDimensionalString =
    TwoDimensionalString(
      toples = "   ",
      middle = " ? ",
      bottom = " ? ",
    )

  val Empty: TwoDimensionalString =
    TwoDimensionalString(
      toples = "",
      middle = "",
      bottom = "",
    )
}
