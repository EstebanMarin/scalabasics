package com.estebanmarin.scalaplaygound.homegrown.collections

trait Set extends (String => Boolean) {
  final def add(input: String): Set = element => input == element || this(element)
  final def remove(input: String): Set = element => input != element
  final def union(that: Set): Set = element => this(element) || that(element)
  final def intersection(that: Set): Set = element => this(element) && that(element)
}

object Set {
  lazy val empty: Set = input => false

}
