import org.scalatest.FlatSpec

import scala.io.Source

class Problem06Spec extends FlatSpec {

  "sample map" should "have 11 edges" in {
    val problem06 = new Problem06
    assert(problem06.edges(Source.fromResource("06.txt").getLines.toArray).length == 11)
  }

  "sample map" should "have C orbiting B" in {
    val problem06 = new Problem06
    assert(problem06.graph(Source.fromResource("06.txt").getLines.toArray)("C").center == "B")
  }

  "sample map" should "have 42 paths" in {
    val problem06 = new Problem06
    assert(problem06.count(Source.fromResource("06.txt").getLines.toArray) == 42)
  }

  "sample map" should "have distance 4 from K to I" in {
    val problem06 = new Problem06
    assert(problem06.distance(problem06.graph(Source.fromResource("06.txt").getLines.toArray), "K", "I") == 4)
  }
}
