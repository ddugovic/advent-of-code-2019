import org.scalatest.FlatSpec

class Problem04Spec extends FlatSpec {

  val problem04 = new Problem04

  "112233" should "meet criteria" in {
    assert(problem04.Word("112233").decreasing == false)
    assert(problem04.Word("112233").repeating == true)
    assert(problem04.Word("112233").repeating2 == true)
  }

  "223450" should "fail criteria" in {
    assert(problem04.Word("223450").decreasing == true)
    assert(problem04.Word("223450").repeating == true)
  }

  "123789" should "fail criteria" in {
    assert(problem04.Word("123789").decreasing == false)
    assert(problem04.Word("123789").repeating == false)
  }

  "123444" should "fail criteria" in {
    assert(problem04.Word("123444").decreasing == false)
    assert(problem04.Word("123444").repeating == true)
  }

  "111122" should "meet criteria" in {
    assert(problem04.Word("111122").decreasing == false)
    assert(problem04.Word("111122").repeating == true)
  }
}
