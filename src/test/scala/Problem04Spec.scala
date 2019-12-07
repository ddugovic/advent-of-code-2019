import org.scalatest.FlatSpec

class Problem04Spec extends FlatSpec {

  "112233" should "meet criteria" in {
    val problem04 = new Problem04
    assert(problem04.decreasing("112233") == false)
    assert(problem04.repeating("112233") == true)
    assert(problem04.repeating2("112233") == true)
  }

  "223450" should "fail criteria" in {
    val problem04 = new Problem04
    assert(problem04.decreasing("223450") == true)
    assert(problem04.repeating("223450") == true)
  }

  "123789" should "fail criteria" in {
    val problem04 = new Problem04
    assert(problem04.decreasing("1234789") == false)
    assert(problem04.repeating("123789") == false)
  }

  "123444" should "fail criteria" in {
    val problem04 = new Problem04
    assert(problem04.decreasing("123444") == false)
    assert(problem04.repeating2("123444") == false)
  }

  "111122" should "meet criteria" in {
    val problem04 = new Problem04
    val repetition2 = "(\\d)\\1+".r
    assert(problem04.decreasing("111122") == false)
    assert(problem04.repeating2("111122") == true)
  }
}
