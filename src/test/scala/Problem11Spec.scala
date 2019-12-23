import org.scalatest.FlatSpec

import scala.collection.mutable.Buffer

class Problem11Spec extends FlatSpec {

  val problem11 = new Problem11

  "simple robot" should "paint 6 tiles" in {
    val robot = new problem11.Robot(Buffer(99L))
    robot.step(1L, 0L)
    assert(0L == robot.input)
    robot.step(0L, 0L)
    assert(0L == robot.input)
    robot.step(1L, 0L)
    assert(0L == robot.input)
    robot.step(1L, 0L)
    assert(1L == robot.input)
    robot.step(0L, 1L)
    assert(0L == robot.input)
    robot.step(1L, 0L)
    assert(0L == robot.input)
    robot.step(1L, 0L)
    assert(0L == robot.input)
    assert(6 == robot.map.size)
  }
}
