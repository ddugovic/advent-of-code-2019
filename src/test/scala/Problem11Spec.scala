import org.scalatest.FlatSpec

import scala.collection.mutable.Buffer

class Problem11Spec extends FlatSpec {

  val problem11 = new Problem11

  "simple robot" should "paint 6 tiles" in {
    val robot = new problem11.Robot(Buffer(99L), 5, 5)
    robot.step(1L, 0L)
    robot.step(0L, 0L)
    robot.step(1L, 0L)
    robot.step(1L, 0L)
    assert(1L == robot.input)
    robot.step(0L, 1L)
    robot.step(1L, 0L)
    robot.step(1L, 0L)
    assert(Map((4, 6) -> 1L, (5, 5) -> 0L, (5, 6) -> 1L, (5, 4) -> 0L, (6, 4) -> 1L, (6, 5) -> 1L) == robot.map)
  }
}
