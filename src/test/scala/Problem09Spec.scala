import org.scalatest.FlatSpec

import scala.collection.mutable.Buffer

class Problem09Spec extends FlatSpec {

  val problem09 = new Problem09

  "first sample program" should "be a quine" in {
    // This test is incomplete as it only captures the final output
    val program = Array(109L, 1L, 204L, -1L, 1001L, 100L, 1L, 100L, 1008L, 100L, 16L, 101L, 1006L, 101L, 0L, 99L).toBuffer.padTo(1010, 0L)
    val machine = new problem09.Machine(program, 1)
    assert(99L == machine.run.signal)
  }

  "second sample program" should "produce a 16-digit number" in {
    val machine = new problem09.Machine(Array(1102L, 34915192L, 34915192L, 7L, 4L, 7L, 99L, 0L).toBuffer, 1)
    assert(1219070632396864L == machine.run.signal)
  }

  "third sample program" should "produce a 16-digit number" in {
    val machine = new problem09.Machine(Array(104L, 1125899906842624L, 99L).toBuffer, 1)
    assert(1125899906842624L == machine.run.signal)
  }
}
