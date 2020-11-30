
import org.scalatest.flatspec.AnyFlatSpec

class Problem05Spec extends AnyFlatSpec {

  val problem05 = new Problem05

  "first sample program" should "multiply values using immediate mode" in {
    val computer = new problem05.Computer(Array(1002, 4, 3, 4, 33))
    assert(Seq(1002, 4, 3, 4, 99) == computer.execute(1).memory.toSeq)
  }

  "second sample program" should "multiply values using immediate mode" in {
    val computer = new problem05.Computer(Array(1101, 100, -1, 4, 0))
    assert(Seq(1101, 100, -1, 4, 99) == computer.execute(1).memory.toSeq)
  }

  "third sample program" should "compare values using position mode" in {
    val computer = new problem05.Computer(Array(3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8))
    assert(Seq(3, 9, 8, 9, 10, 9, 4, 9, 99, 0, 8) == computer.execute(1).memory.toSeq)
    assert(Seq(3, 9, 8, 9, 10, 9, 4, 9, 99, 1, 8) == computer.execute(8).memory.toSeq)
  }

  "fourth sample program" should "compare values using position mode" in {
    val computer = new problem05.Computer(Array(3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8))
    assert(Seq(3, 9, 7, 9, 10, 9, 4, 9, 99, 1, 8) == computer.execute(1).memory.toSeq)
    assert(Seq(3, 9, 7, 9, 10, 9, 4, 9, 99, 0, 8) == computer.execute(8).memory.toSeq)
  }

  "fifth sample program" should "compare values using immediate mode" in {
    val computer = new problem05.Computer(Array(3, 3, 1108, -1, 8, 3, 4, 3, 99))
    assert(Seq(3, 3, 1108, 0, 8, 3, 4, 3, 99) == computer.execute(1).memory.toSeq)
  }

  "sixth sample program" should "compare values using immediate mode" in {
    val computer = new problem05.Computer(Array(3, 9, 1107, 9, 10, 9, 4, 9, 99, -1, 8))
    assert(Seq(3, 9, 1107, 9, 10, 9, 4, 9, 99, 1, 8) == computer.execute(1).memory.toSeq)
  }
}
