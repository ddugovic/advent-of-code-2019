import org.scalatest.FlatSpec

class Problem01Spec extends FlatSpec {

  val problem01 = new Problem01

  "12 mass" should "require 2 fuel and no further fuel" in {
    assert(problem01.fuel(12) == 2)
    assert(problem01.fuel2(12) == 2)
  }

  "14 mass" should "require 2 fuel" in {
    assert(problem01.fuel(14) == 2)
  }

  "1969 mass" should "require 654 fuel and 966 total fuel" in {
    assert(problem01.fuel(1969) == 654)
    assert(problem01.fuel2(1969) == 966)
  }

  "100756 mass" should "require 33583 fuel and 50346 total fuel" in {
    assert(problem01.fuel(100756) == 33583)
    assert(problem01.fuel2(100756) == 50346)
  }
}
