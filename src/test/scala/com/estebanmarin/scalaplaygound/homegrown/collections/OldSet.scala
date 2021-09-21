package com.estebanmarin.scalaplaygound.homegrown.collections

trait OldSet extends (String => Boolean) {
  final def add(input: String): OldSet = element => input == element || this(element)
  final def remove(input: String): OldSet = element => input != element && this(input)
  final def union(that: OldSet): OldSet = element => this(element) || that(element)
  final def intersection(that: OldSet): OldSet = element => this(element) && that(element)
  final def difference(that: OldSet): OldSet = element => this(element) && !that(element)
  final def isSubsetOf(that: OldSet): Boolean = ???
}

object OldSet {
  lazy val empty: Set = input => false
}
