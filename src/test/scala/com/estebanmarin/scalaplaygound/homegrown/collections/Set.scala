import com.estebanmarin.scalaplaygound.homegrown.collections._
import org.scalatest.funsuite._
import org.scalatest.matchers.should._

class SetSuite extends AnyFunSuite with Matchers {
  test("apply on empty set should yield 0") {
    Set.empty(randomCharacter) shouldBe false
  }
  private def randomCharacter: String =
    scala.util.Random.alphanumeric.take(5).mkString
}
