case class Problem06() {
  case class Edge(input: String) {
    val center = input.split("\\)")(0)
    val moon = input.split("\\)")(1)
  }
  def edges(input: Seq[String]): Seq[Edge] = input.map(Edge(_))
  def graph(input: Seq[Edge]): Map[String, Edge] = input.map(edge => (edge.moon, edge)).toMap
  def path(g: Map[String, Edge], edge: Edge): List[Edge] = if (edge.center == "COM") List(edge) else edge :: path(g, g(edge.center))
  def count(input: Seq[String]): Int = {
    val e = input.map(Edge(_))
    val g = graph(e)
    e.map(path(g, _).size).sum
  }
  def distance(g: Map[String, Edge], center1: String, center2: String): Int = {
    val path1 = path(g, g(center1))
    val path2 = path(g, g(center2))
    path1.diff(path2).union(path2.diff(path1)).size
  }
  def run(input: Seq[String]): String = {
    val g = graph(input.map(Edge(_)))
    Seq(count(input), distance(g, g("SAN").center, g("YOU").center)).mkString(" ")
  }
}
