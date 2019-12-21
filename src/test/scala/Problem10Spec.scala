import org.scalatest.FlatSpec

import scala.io.Source

class Problem10Spec extends FlatSpec {

  val problem10 = new Problem10

  "first sample map" should "detect 8 asteroids" in {
    val graph = problem10.Graph(""".#..#
.....
#####
....#
...##""")
    assert(graph.ranks.max == 8)
  }

  "second sample map" should "detect 33 asteroids" in {
    val graph = problem10.Graph("""......#.#.
#..#.#....
..#######.
.#.#.###..
.#..#.....
..#....#.#
#..#....#.
.##.#..###
##...#..#.
.#....####""")
    assert(graph.ranks.max == 33)
  }

  "third sample map" should "detect 35 asteroids" in {
    val graph = problem10.Graph("""#.#...#.#.
.###....#.
.#....#...
##.#.#.#.#
....#.#.#.
.##..###.#
..#...##..
..##....##
......#...
.####.###.""")
    assert(graph.ranks.max == 35)
  }

  "fourth sample map" should "detect 41 asteroids" in {
    val graph = problem10.Graph(""".#..#..###
####.###.#
....###.#.
..###.##.#
##.##.#.#.
....###..#
..#.#..#.#
#..#.#.###
.##...##.#
.....#.#..""")
    assert(graph.ranks.max == 41)
  }

  "fifth sample map" should "vaporize 210 asteroids" in {
    val graph = problem10.Graph(Source.fromResource("10.txt").mkString.trim)
    assert(graph.ranks.max == 210)
    assert(graph.targets(0).id == 1112)
    assert(graph.targets(1).id == 1201)
    assert(graph.targets(2).id == 1202)
    assert(graph.targets(9).id == 1208)
    assert(graph.targets(19).id == 1600)
    assert(graph.targets(49).id == 1609)
    assert(graph.targets(99).id == 1016)
    assert(graph.targets(198).id == 906)
    assert(graph.targets(199).id == 802)
    assert(graph.targets(200).id == 1009)
  }

  "sixth sample map" should "vaporize asteroids" in {
    val graph = problem10.Graph(""".#....#####...#..
##...##.#####..##
##...#...#.#####.
..#.....#...###..
..#.#.....#....##""")
    assert(graph.targets(8).id == 1501)
    assert(graph.targets(17).id == 404)
    assert(graph.targets(26).id == 501)
  }
}
