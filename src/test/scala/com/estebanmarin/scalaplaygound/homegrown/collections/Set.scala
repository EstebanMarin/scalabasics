import com.estebanmarin.scalaplaygound.homegrown.collections._
import org.scalatest.funsuite._
import org.scalatest.matchers.should._

class SetSuite extends AnyFunSuite with Matchers {
  test("1 - apply on empty set should yield 0") {
    Set.empty.size shouldBe 0
  }
  test("2- add on an empty set should yield a new Set with one element") {
    val first = randomString
    val second = randomString
    first should not be second
    val set = Set.empty.add(first)
    set(first) shouldBe true
    set(second)
  }
  test("3- add on an non empty set should yield a new Set with two element") {
    val first = randomString
    val second = randomString
    first should not be second
    val set = Set.empty.add(first).add(second)
    set(first) shouldBe true
    set(second) shouldBe true
  }
  test("4- remove on an empty set should yield an empty set") {
    val element = randomString
    val stillEmpty = Set.empty.remove(element)
    stillEmpty(element) shouldBe false
  }
  test("5- remove on a non empty Set should yield a new Set without the element") {
    val element = randomString
    val setWithElement = Set.empty.add(element)
    setWithElement(element) shouldBe true
    val setWithoutTheElement = setWithElement.remove(element)
    setWithoutTheElement(element) shouldBe false
  }
  test("6 - remove only the element in question") {
    val first = randomString
    val second = randomString
    val setWithElement = Set.empty.add(first).add(second)
    setWithElement(first) shouldBe true
    setWithElement(second) shouldBe true
    val setWithoutTheElement = setWithElement.remove(second)

    setWithoutTheElement(first) shouldBe true
    setWithoutTheElement(second) shouldBe false
  }
  test("7 - remove only the element in question 2") {
    val first = randomString
    val second = randomString
    val setWithElement = Set.empty.add(first).add(second)
    setWithElement(first) shouldBe true
    setWithElement(second) shouldBe true
    val setWithoutTheElement = setWithElement.remove(first)

    setWithoutTheElement(first) shouldBe false
    setWithoutTheElement(second) shouldBe true
  }
  test("8 - add/remove should ensure that all elements are distinct") {
    val element = randomString
    val set = Set.empty.add(element).add(element).remove(element)
    set(element) shouldBe false
  }
  test("9 - union on an empty set should yield an empty set") {
    Set.empty.union(Set.empty)(randomString) shouldBe false
  }
  test(
    "9 - union on a non empty Set with an empty set should yield the original Set untouched"
  ) {
    val first = randomString
    val second = randomString

    first should not be second

    val emptySet = Set.empty
    val nonEmptySet = Set.empty.add(first).add(second)

    emptySet.union(nonEmptySet)(first) shouldBe true
    emptySet.union(nonEmptySet)(second) shouldBe true

    nonEmptySet.union(emptySet)(first) shouldBe true
    nonEmptySet.union(emptySet)(second) shouldBe true
  }
  test("9 - union on non empty set should yield their union") {
    val a = randomString
    val b = randomString
    val c = randomString
    val d = randomString

    val left = Set.empty.add(a).add(b)
    val right = Set.empty.add(c).add(d)

    left.union(right) shouldBe (Set.empty.add(a).add(b).add(c).add(d))
    right.union(left) shouldBe (Set.empty.add(a).add(b).add(c).add(d))
  }
  test("10 - intersection on empty Set should yield and empty Set") {
    Set.empty.intersection(Set.empty)(randomString) shouldBe false
  }
  test("11 - intersection on non empty set should yield their intersection") {
    val a = randomString
    val b = randomString
    val c = randomString
    val d = randomString

    val left = Set.empty.add(a).add(b).add(c)
    val right = Set.empty.add(c).add(d)

    left.intersection(right) shouldBe (Set.empty.add(c))
    right.intersection(left) shouldBe (Set.empty.add(c))
  }
  test("12 - difference on a non empty set with a empty set should yield an empty set") {
    val first = randomString
    val second = randomString

    val emptySet = Set.empty
    val nonEmptySet = Set.empty.add(first).add(second)

    emptySet.difference(nonEmptySet)(first) shouldBe false
    emptySet.difference(nonEmptySet)(second) shouldBe false

    nonEmptySet.difference(that = emptySet)(first) shouldBe true
    nonEmptySet.difference(that = emptySet)(second) shouldBe true
  }
  test("13 difference on non two empty Sets should yield their difference") {
    val a = randomString
    val b = randomString
    val c = randomString
    val d = randomString

    val left = Set.empty.add(a).add(b).add(c)
    val right = Set.empty.add(b).add(c).add(d)

    left.difference(right) shouldBe (Set.empty.add(a))
    right.difference(left) shouldBe (Set.empty.add(d))
  }
  test("13 - is Subsetof on an empty Set should yield true") {
    Set.empty.isSubsetOf(Set.empty) shouldBe true
    Set.empty.isSubsetOf(Set.empty.add(randomString)) shouldBe true
  }
  test("14 - isSubsetOf on itself should yield true") {
    val set = Set.empty.add(randomString)
    set.isSubsetOf(set) shouldBe true
  }
  test("15 - isSubsetOf on a non empty Set should yield false") {
    val a = randomString
    val b = randomString
    val c = randomString
    val left = Set.empty.add(a).add(b)
    val right = left.add(c)
    left.isSubsetOf(right) shouldBe true
    right.isSubsetOf(left) shouldBe false
  }
  test("16 - isSuperset on itself should yield true") {
    val set = Set.empty.add(randomString)
    set.isSupersetOf(set) shouldBe true
  }
  test("17 - isSuperset on a non empty Set should yield false") {
    val a = randomString
    val b = randomString
    val c = randomString
    val left = Set.empty.add(a).add(b)
    val right = left.add(c)
    left.isSupersetOf(right) shouldBe false
    left.isSupersetOf(left) shouldBe true
  }
  test("18 - hashCode on an empty set should not be random") {
    Set.empty.hashCode shouldBe Set.empty.hashCode
    val element = randomString
    Set.empty.add(element).hashCode shouldBe Set.empty.add(element).hashCode
  }
  test("19 - hashCode on an empty Set should not be 0") {
    Set.empty.hashCode should not be 0
  }
  test(
    "20 - on a non empty Set should be the sum of all the hashCodes and the hashCode of the empty set"
  ) {
    val first = randomString
    val second = randomString
    val expected = Set.empty.hashCode + first.hashCode + second.hashCode

    Set.empty.add(first).add(second).hashCode shouldBe expected
  }
  test("size on an empty Set should be 0") {
    Set.empty.size shouldBe 0
  }
  test("size on a non empty Set should be 1") {
    Set.empty.add(randomString).size shouldBe 1
  }
  test("size on a non empty Set with 2 distinct elements added should be 2") {
    val first = randomString
    val second = randomString
    first should not be second
    Set.empty.add(first).add(second).size shouldBe 2
  }
  test("size on a non empty Set with 2 equal elements added should be 1") {
    val element = randomString
    Set.empty.add(element).add(element).size shouldBe 1
  }
  test("isEmpty on an empty Set should yield true") {
    Set.empty.isEmpty shouldBe true
    Set.empty.nonEmpty shouldBe false
  }
  test("isEmpty on a non empty Set should yield false") {
    Set.empty.add(randomString).isEmpty shouldBe false
    Set.empty.add(randomString).nonEmpty shouldBe true
  }
  test("isSingleton on an empty Set should yield false") {
    Set.empty.isSingleton shouldBe false
  }
  test("isSingleton on a Set with more than one element should yield false") {
    val first = randomString
    val second = randomString
    first should not be second
    Set.empty.add(first).add(second).isSingleton shouldBe false
  }
  test("isSingleton on a Set with a single element should yield true") {
    Set.empty.add(randomString).isSingleton shouldBe true
  }
  test("sample should yield a random element from the Set") {
    Set.empty.sample shouldBe None
    val a = randomString
    Set.empty.add(a).sample shouldBe Some(a)
    val b = randomString
    Set.empty.add(a).add(b).sample should contain oneOf (a, b)
  }
  test("foreach on an empty Set should not apply the function") {
    noException should be thrownBy Set.empty.foreach(_ => sys.error("should not be thrown"))
  }
  test("foreach on a non empty Set should apply the function") {
    var functionWasApplied = false
    Set.empty.add(randomString).foreach(_ => functionWasApplied = true)
    functionWasApplied shouldBe true
  }
  test("Should be able to calculate the size of the given set") {
    var size = 0
    val set = Set.empty
    set.foreach(_ => size += 1)
    size shouldBe 0
    size shouldBe set.size
  }
  test("foreach should be able to calculate the size of the given set 1") {
    var size = 0
    val set = Set.empty.add(randomString)
    set.foreach(_ => size += 1)
    size shouldBe 1
    size shouldBe set.size
  }
  test("foreach should be able to calculate the size of the given set 2") {
    var size = 0
    val set = Set.empty.add(randomString).add(randomString)
    set.foreach(_ => size += 1)
    size shouldBe 2
    size shouldBe set.size
  }
  test("foreach should be able to calculate the size of the given set 3") {
    var size = 0
    val element = randomString
    val set = Set.empty.add(element).add(element)
    set.foreach(_ => size += 1)
    size shouldBe 1
    size shouldBe set.size
  }
  test("Set( should not compile") {
    "Set()" shouldNot compile
  }
  test(
    "Calling the varargs apply method on the Set companion Object should yield a Set with all the arguments as elements"
  ) {
    val a = randomString
    val b = randomString
    val c = randomString
    Set(a, b, c) shouldBe Set.empty.add(a).add(b).add(c)
  }
  private def randomString: String =
    scala.util.Random.alphanumeric.take(5).mkString
}
