package com.estebanmarin.scalaplaygound.homegrown.collections

trait Set extends (String => Boolean) {
  def add(input: String): Set
  // final def remove(input: String): Set = element => input != element && this(input)
  // final def union(that: Set): Set = element => this(element) || that(element)
  // final def intersection(that: Set): Set = element => this(element) && that(element)
  // final def difference(that: Set): Set = element => this(element) && !that(element)
  // final def isSubsetOf(that: Set): Boolean = ???
}

object Set {
  final private case class NonEmpty(element: String, otherElements: Set) extends Set {
    final override def apply(input: String): Boolean =
      input == element || otherElements(input)

    def add(input: String): Set = NonEmpty(input, otherElements.add(input))
  }
  final private case object Empty extends Set {
    def apply(v1: String): Boolean = false

    def add(input: String): Set = NonEmpty(input, Empty)
  }

  lazy val empty: Set = Empty

}
