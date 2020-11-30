
import org.scalatest.flatspec.AnyFlatSpec

class Problem02Spec extends AnyFlatSpec {

  val problem02 = new Problem02

  "first sample program" should "add inputs and multiply inputs" in {
    val computer = new problem02.Computer(Array(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50))
    assert(Seq(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50) == computer.execute().toSeq)
  }

  "second sample program" should "add inputs" in {
    val computer = new problem02.Computer(Array(1, 0, 0, 0, 99))
    assert(Seq(2, 0, 0, 0, 99) == computer.execute().toSeq)
  }

  "third sample program" should "multiply inputs" in {
    val computer = new problem02.Computer(Array(2, 3, 0, 3, 99))
    assert(Seq(2, 3, 0, 6, 99) == computer.execute().toSeq)
  }

  "fourth sample program" should "multiply inputs" in {
    val computer = new problem02.Computer(Array(2, 4, 4, 5, 99, 0))
    assert(Seq(2, 4, 4, 5, 99, 9801) == computer.execute().toSeq)
  }

  "fifth sample program" should "multiply inputs" in {
    val computer = new problem02.Computer(Array(1, 1, 1, 4, 99, 5, 6, 0, 99))
    assert(Seq(30, 1, 1, 4, 2, 5, 6, 0, 99) == computer.execute().toSeq)
  }
}
