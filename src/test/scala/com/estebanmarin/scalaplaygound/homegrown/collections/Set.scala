import com.estebanmarin.scalaplaygound.homegrown.collections._
import org.scalatest.funsuite._
import org.scalatest.matchers.should._

class SetSuite extends AnyFunSuite with Matchers {
  test("apply on empty set should yield 0") {
    Set.empty(randomString) shouldBe false
  }
  test("add on an empty set should yield a new Set with one element") {
    val first = randomString
    val second = randomString
    first should not be second
    val set = Set.empty.add(first)
    set(first) shouldBe true
    set(second)
  }
  test("add on an non empty set should yield a new Set with two element") {
    val first = randomString
    val second = randomString
    first should not be second
    val set = Set.empty.add(first).add(second)
    set(first) shouldBe true
    set(second) shouldBe true
  }
  test("remove on a non empty Set should yield a new Set without the element") {
    val element = randomString
    val setWithElement = Set.empty.add(element)
    setWithElement(element) shouldBe true
    val setWithoutTheElement = setWithElement.remove(element)
    setWithoutTheElement(element) shouldBe false
  }
  test("remove only the element in question") {
    val first = randomString
    val second = randomString
    val setWithElement = Set.empty.add(first).add(second)
    setWithElement(first) shouldBe true
    setWithElement(second) shouldBe true
    val setWithoutTheElement = setWithElement.remove(second)

    setWithoutTheElement(first) shouldBe true
    setWithoutTheElement(second) shouldBe false
  }
  test("remove only the element in question 2") {
    val first = randomString
    val second = randomString
    val setWithElement = Set.empty.add(first).add(second)
    setWithElement(first) shouldBe true
    setWithElement(second) shouldBe true
    val setWithoutTheElement = setWithElement.remove(first)

    setWithoutTheElement(first) shouldBe false
    setWithoutTheElement(second) shouldBe true
  }
  test("union on an empty set should yield an empty set") {
    Set.empty.union(Set.empty)(randomString) shouldBe false
  }
  test(
    "union on a non empty Set with an empty set should yield the original Set untouched"
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
  test("union on non empty set should yield their union") {
    val a = randomString
    val b = randomString
    val c = randomString
    val d = randomString

    val left = Set.empty.add(a).add(b)
    val right = Set.empty.add(c).add(d)

    val leftUnion = left.union(right)
    leftUnion(a) shouldBe true
    leftUnion(b) shouldBe true
    leftUnion(c) shouldBe true
    leftUnion(d) shouldBe true

    val rightUnion = left.union(right)
    rightUnion(a) shouldBe true
    rightUnion(b) shouldBe true
    rightUnion(c) shouldBe true
    rightUnion(d) shouldBe true
  }
  test("intersection on empty Set should yield and empty Set") {
    Set.empty.intersection(Set.empty)(randomString) shouldBe false
  }
  test("intersection on non empty set should yield their intersection") {
    val a = randomString
    val b = randomString
    val c = randomString
    val d = randomString

    val left = Set.empty.add(a).add(b).add(c)
    val right = Set.empty.add(c).add(d)

    val leftIntersection = left.intersection(right)
    leftIntersection(a) shouldBe false
    leftIntersection(b) shouldBe false
    leftIntersection(c) shouldBe true
    leftIntersection(d) shouldBe false

  }
  test("difference on a non empty set with a empty set should yield an empty set") {
    val first = randomString
    val second = randomString

    val emptySet = Set.empty
    val nonEmptySet = Set.empty.add(first).add(second)

    emptySet.difference(nonEmptySet)(first) shouldBe false
    emptySet.difference(nonEmptySet)(second) shouldBe false

    nonEmptySet.difference(that = emptySet)(first) shouldBe true
    nonEmptySet.difference(that = emptySet)(second) shouldBe true
  }
  test("difference on non two empty Sets should yield their difference") {
    val a = randomString
    val b = randomString
    val c = randomString
    val d = randomString

    val left = Set.empty.add(a).add(b).add(c)
    val right = Set.empty.add(b).add(c).add(d)

    val leftDifference = left.difference(right)
    leftDifference(a) shouldBe true
    leftDifference(b) shouldBe false
    leftDifference(c) shouldBe false
    leftDifference(d) shouldBe false

    val rightDifference = right.difference(left)
    rightDifference(a) shouldBe false
    rightDifference(b) shouldBe false
    rightDifference(c) shouldBe false
    rightDifference(d) shouldBe true
  }
  ignore("is Subsetof on an empty Set should yield true") {
    Set.empty.isSubsetOf(Set.empty) shouldBe true
    Set.empty.isSubsetOf(Set.empty.add(randomString)) shouldBe true
  }
  private def randomString: String =
    scala.util.Random.alphanumeric.take(5).mkString
}
