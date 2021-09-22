package com.estebanmarin.scalaplaygound.homegrown.collections

trait Set extends (String => Boolean) {
  def add(input: String): Set
  def remove(input: String): Set
  def union(that: Set): Set
  def intersection(that: Set): Set
  def difference(that: Set): Set
  def isSubsetOf(that: Set): Boolean
  final def isSupersetOf(that: Set): Boolean =
    that.isSubsetOf(this)
  final override def equals(other: Any): Boolean = other match {
    case that: Set => this.isSubsetOf(that) && that.isSubsetOf(this)
    case _         => false
  }
  def size: Int
}

object Set {
  final private case class NonEmpty(element: String, otherElements: Set) extends Set {
    final override def apply(input: String): Boolean =
      input == element || otherElements(input)
    final override def add(input: String): Set =
      if (input == element) this else NonEmpty(input, otherElements.add(element))
    final override def remove(input: String): Set =
      if (input == element) otherElements else NonEmpty(element, otherElements.remove(input))
    final override def union(that: Set): Set =
      otherElements.union(that.add(element))
    final override def intersection(that: Set): Set = {
      val intersectionofOthers = otherElements.intersection(that)
      if (that(element))
        intersectionofOthers.add(element)
      else
        intersectionofOthers
    }
    final override def difference(that: Set): Set = {
      val differencefOthers = otherElements.difference(that)
      if (that(element))
        differencefOthers
      else
        differencefOthers.add(element)
    }
    final override def isSubsetOf(that: Set): Boolean =
      that(element) && otherElements.isSubsetOf(that)
    final override def hashCode: Int =
      element.hashCode + otherElements.hashCode
    final override def size: Int = 1 + otherElements.size

  }
  final private case object Empty extends Set {
    final override def apply(v1: String): Boolean = false
    final override def add(input: String): Set = NonEmpty(input, Empty)
    final override def remove(input: String): Set = this
    final override def union(that: Set): Set = that
    final override def intersection(that: Set): Set = this
    final override def difference(that: Set): Set = this
    final override def isSubsetOf(that: Set): Boolean = true
    final override def size: Int = 0
  }

  lazy val empty: Set = Empty

}
