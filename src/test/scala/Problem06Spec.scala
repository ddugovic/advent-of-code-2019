

import scala.io.Source
import org.scalatest.flatspec.AnyFlatSpec

class Problem06Spec extends AnyFlatSpec {

  val problem06 = new Problem06

  "sample map" should "have 11 edges" in {
    assert(problem06.edges(Source.fromResource("06.txt").getLines.toSeq).length == 11)
  }

  "sample map" should "have C orbiting B" in {
    assert(problem06.graph(Source.fromResource("06.txt").getLines.toSeq.map(problem06.Edge(_)))("C").center == "B")
  }

  "sample map" should "have 42 paths" in {
    assert(problem06.count(Source.fromResource("06.txt").getLines.toSeq) == 42)
  }

  "sample map" should "have distance 4 from K to I" in {
    assert(problem06.distance(problem06.graph(Source.fromResource("06.txt").getLines.toSeq.map(problem06.Edge(_))), "K", "I") == 4)
  }
}
