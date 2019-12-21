import org.scalatest.FlatSpec

class Problem09Spec extends FlatSpec {

  val problem09 = new Problem09

  "first sample program" should "be a quine" in {
    val program = Array(109L, 1L, 204L, -1L, 1001L, 100L, 1L, 100L, 1008L, 100L, 16L, 101L, 1006L, 101L, 0L, 99L).toBuffer.padTo(1010, 0L)
    val computer = new problem09.Computer(program)
    assert(program == computer.execute(1).memory)
  }

  "second sample program" should "produce a 16-digit number" in {
    val computer = new problem09.Computer(Array(1102L, 34915192L, 34915192L, 7L, 4L, 7L, 99L, 0L).toBuffer)
    assert(1219070632396864L == computer.execute(1).output)
  }

  "third sample program" should "produce a 16-digit number" in {
    val computer = new problem09.Computer(Array(104L, 1125899906842624L, 99L).toBuffer)
    assert(1125899906842624L == computer.execute(1).output)
  }
}
