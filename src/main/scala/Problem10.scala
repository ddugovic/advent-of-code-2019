import scala.math.atan2

case class Problem10() {
  case class Graph(val input: String) {
    val points = input.split('\n').zipWithIndex.map {case (i, y) => i.zipWithIndex.collect {case (c, x) if (c == '#') => Point(x, y)}}.flatten
    val edges: Seq[Edge] = points.combinations(2).collect {case (edge) if (!points.exists(_.between(edge(0), edge(1)))) => Edge(edge(0), edge(1))}.toSeq
    val ranks: Seq[Int] = points.map(point => edges.count(_.contains(point)))
    lazy val center: Point = (points zip ranks).maxBy(_._2)._1
    lazy val targets: Seq[Point] = edges.collect {
      case Edge(p1, this.center) => p1
      case Edge(this.center, p2) => p2
    }.sortBy(this.center.theta(_))
  }
  case class Edge(val p1: Point, val p2: Point) {
    def contains(p: Point) = (p1 == p || p2 == p)
  }
  case class Point(val x: Int, val y: Int) {
    val id = 100 * x + y
    def between(p1: Point, p2: Point) = (p1.x - x).signum == (x - p2.x).signum && (p1.y - y).signum == (y - p2.y).signum && (p1.x - x) * (p2.y - y) == (p2.x - x) * (p1.y - y)
    def theta(p: Point) = atan2(x - p.x - 0.01, p.y - y)
  }
  def run(input: String): String = {
    val graph = Graph(input)
    Seq(graph.ranks.max, graph.targets(199).id).mkString(" ")
  }
}
