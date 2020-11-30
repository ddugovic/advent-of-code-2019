

import scala.collection.mutable.Buffer
import org.scalatest.flatspec.AnyFlatSpec

class Problem13Spec extends AnyFlatSpec {

  val problem13 = new Problem13

  "simple game" should "draw tiles" in {
    val game = new problem13.Game(Buffer(99L))
    game.step(1L, 2L, 3L)
    game.step(6L, 5L, 4L)
    assert(Map((1, 2) -> 3L, (6, 5) -> 4L) == game.map)
  }
}
