package com.estebanmarin.scalaplaygound

object FarAway {
  lazy val code: (Boolean, Boolean) => String = { (first: Boolean, second: Boolean) =>
    if (first)
      "I am happy because it's sunny day"
    else if (second)
      "I am sad because its raining"
    else
      "I am not sure on how I fell"
  }

  def code2(first: Boolean = true, second: Boolean = true): String =
    if (first)
      "I am happy because it's sunny day"
    else if (second)
      "I am sad because its raining"
    else
      "I am not sure on how I fell"

}
