import org.scalatest.FlatSpec

class Problem02Spec extends FlatSpec {

  "first program" should "add inputs and multiply inputs" in {
    val problem02 = new Problem02
    val computer = problem02.Computer(Array(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50))
    assert(List(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50) == computer.execute().toList)
  }
}
