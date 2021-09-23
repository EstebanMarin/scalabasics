package com.estebanmarin.scalaplaygound.homegrown.collections

sealed trait Set[Element] extends (Element => Boolean) {
  import Set._
  final override def apply(input: Element): Boolean =
    fold(false)(_ || _ == input)

  @scala.annotation.tailrec
  final def fold[R](seed: R)(function: (R, Element) => R): R =
    if (isEmpty)
      seed
    else {
      val nonEmptySet: NonEmpty[Element] = this.asInstanceOf[NonEmpty[Element]]
      val element: Element = nonEmptySet.element
      val otherElements: Set[Element] = nonEmptySet.otherElements
      otherElements.fold[R](function(seed, element))(function)
    }

  final def add(input: Element): Set[Element] =
    fold(NonEmpty(input, empty)) { (acc, current) =>
      if (current == input) acc else NonEmpty(current, acc)
    }

  final def remove(input: Element): Set[Element] =
    fold(empty[Element]) { (acc, current) =>
      if (current == input) acc else NonEmpty(current, acc)
    }

  final def union(that: Set[Element]): Set[Element] =
    fold(that)(_ add _)

  final def intersection(that: Set[Element]): Set[Element] =
    fold(empty[Element]) { (acc, current) =>
      if (that(current)) acc.add(current) else acc
    }

  final def difference(that: Set[Element]): Set[Element] =
    fold(empty[Element]) { (acc, current) =>
      if (!that(current)) acc.add(current) else acc
    }

  final def isSubsetOf(that: Set[Element]): Boolean =
    fold(true)(_ && that(_))

  final def isSupersetOf(that: Set[Element]): Boolean =
    that.isSubsetOf(this)

  final override def equals(other: Any): Boolean = other match {
    case that: Set[Element] => this.isSubsetOf(that) && that.isSubsetOf(this)
    case _                  => false
  }

  final override def hashCode: Int =
    if (isEmpty)
      41
    else {
      val nonEmptySet = this.asInstanceOf[NonEmpty[Element]]
      val element = nonEmptySet.element
      val otherElements = nonEmptySet.otherElements

      element.hashCode + otherElements.hashCode
    }

  final def size: Int = {
    var result = 0

    foreach { _ =>
      result = result + 1
    }

    result
  }

  final def isEmpty: Boolean =
    this.isInstanceOf[Empty[Element]]

  final def nonEmpty: Boolean =
    !isEmpty

  final def isSingleton: Boolean =
    if (isEmpty)
      false
    else {
      val nonEmptySet = this.asInstanceOf[NonEmpty[Element]]
      val otherElements = nonEmptySet.otherElements

      otherElements.isEmpty
    }

  def sample: Option[Element] =
    if (isEmpty)
      None
    else {
      val nonEmptySet = this.asInstanceOf[NonEmpty[Element]]
      val element = nonEmptySet.element

      Some(element)
    }

  final def foreach[Result](function: Element => Result): Unit =
    if (nonEmpty) {
      val nonEmptySet = this.asInstanceOf[NonEmpty[Element]]
      val element = nonEmptySet.element
      val otherElements = nonEmptySet.otherElements

      function(element)
      otherElements.foreach(function)
    }

  final def map[Result](function: Element => Result): Set[Result] = {
    var result = empty[Result]

    foreach { current =>
      result = result.add(function(current))
    }

    result
  }

  final def flatMap[Result](function: Element => Set[Result]): Set[Result] = {
    var result = empty[Result]

    foreach { outerCurrent =>
      function(outerCurrent).foreach { innerCurrent =>
        result = result.add(innerCurrent)
      }
    }

    result
  }
}

object Set {
  def apply[Element](element: Element, otherElements: Element*): Set[Element] = {
    var result: Set[Element] = empty[Element].add(element)

    otherElements.foreach { current =>
      result = result.add(current)
    }

    result
  }

  final private case class NonEmpty[Element](element: Element, otherElements: Set[Element])
      extends Set[Element]

  private object NonEmpty {
    private[this] def unapply(any: Any): Option[(String, Any)] =
      patternMatchingNotSupported
  }

  private class Empty[Element] extends Set[Element] {
    private[this] def unapply(any: Any): Option[(String, Any)] =
      patternMatchingNotSupported
  }

  private[this] def unapply(any: Any): Option[(String, Any)] =
    patternMatchingNotSupported

  private[this] def patternMatchingNotSupported: Nothing =
    sys.error("pattern matching on Sets is expensive and therefore not supported")

  def empty[Element]: Set[Element] = new Empty[Element]
}
