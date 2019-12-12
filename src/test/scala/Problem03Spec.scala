import org.scalatest.FlatSpec

class Problem03Spec extends FlatSpec {

  "first sample wire" should "go right 8, up 5, left 5, down 3" in {
    val problem03 = new Problem03
    val wire = problem03.wire("R8,U5,L5,D3")
    assert(wire.contains(problem03.Point(8, 0)))
    assert(wire.contains(problem03.Point(8, 5)))
    assert(wire.contains(problem03.Point(3, 5)))
    assert(wire.contains(problem03.Point(3, 2)))
  }

  "second sample wire" should "go up 7, right 6, down 4, left 4" in {
    val problem03 = new Problem03
    val wire = problem03.wire("U7,R6,D4,L4")
    assert(wire.contains(problem03.Point(0, 7)))
    assert(wire.contains(problem03.Point(6, 7)))
    assert(wire.contains(problem03.Point(6, 3)))
    assert(wire.contains(problem03.Point(2, 3)))
  }
}
