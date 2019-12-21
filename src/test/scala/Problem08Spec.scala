import org.scalatest.FlatSpec

class Problem08Spec extends FlatSpec {

  val problem08 = new Problem08

  "sample image" should "have product 1" in {
    val image = problem08.Image("123456789012", 3, 2)
    assert(image.product == 1)
  }

  "sample image" should "have a 2D projection" in {
    val image = problem08.Image("0222112222120000", 2, 2)
    assert(image.project == "01\n10")
  }
}
