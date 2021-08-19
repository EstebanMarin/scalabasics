package com.estebanmarin.scalaplaygound

object TwoDimensionalDigit {
  val Zero: TwoDimensionalString =
    TwoDimensionalString(
      toples = " _ ",
      middle = "| |",
      bottom = "|_|",
    )

  val One: TwoDimensionalString =
    TwoDimensionalString(
      toples = "   ",
      middle = "  |",
      bottom = "  |",
    )

  val Two: TwoDimensionalString =
    TwoDimensionalString(
      toples = " _ ",
      middle = " _|",
      bottom = "|_ ",
    )

  val Three: TwoDimensionalString =
    TwoDimensionalString(
      toples = " _ ",
      middle = " _|",
      bottom = " _|",
    )

  val Four: TwoDimensionalString =
    TwoDimensionalString(
      toples = "   ",
      middle = "|_|",
      bottom = "  |",
    )

  val Five: TwoDimensionalString =
    TwoDimensionalString(
      toples = " _ ",
      middle = "|_ ",
      bottom = " _|",
    )

  val Six: TwoDimensionalString =
    TwoDimensionalString(
      toples = " _ ",
      middle = "|_ ",
      bottom = "|_|",
    )

  val Seven: TwoDimensionalString =
    TwoDimensionalString(
      toples = " _ ",
      middle = "  |",
      bottom = "  |",
    )

  val Eight: TwoDimensionalString =
    TwoDimensionalString(
      toples = " _ ",
      middle = "|_|",
      bottom = "|_|",
    )

  val Nine: TwoDimensionalString =
    TwoDimensionalString(
      toples = " _ ",
      middle = "|_|",
      bottom = " _|",
    )

  def apply(digit: Int): TwoDimensionalString =
    digit match {
      case 0 => Zero
      case 1 => One
      case 2 => Two
      case 3 => Three
      case 4 => Four
      case 5 => Five
      case 6 => Six
      case 7 => Seven
      case 8 => Eight
      case 9 => Nine
      case _ => TwoDimensionalString.QuestionMarks
    }

}
