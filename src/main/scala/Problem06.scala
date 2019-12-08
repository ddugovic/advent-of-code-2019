case class Problem06() {
  case class Edge(input: String) {
    val center = input.split("\\)")(0)
    val moon = input.split("\\)")(1)
  }
  def edges(input: Array[String]): Array[Edge] = input.map(edge => Edge(edge))
  def graph(input: Array[String]): Map[String, Edge] = edges(input).map(edge => (edge.moon, edge)).toMap
  def path(g: Map[String, Edge], edge: Edge): List[Edge] = if (edge.center == "COM") List(edge) else edge :: path(g, g(edge.center))
  def count(input: Array[String]): Int = {
    val g = graph(input)
    edges(input).map(path(g, _).size).sum
  }
  def distance(g: Map[String, Edge], center1: String, center2: String): Int = {
    val path1 = path(g, g(center1))
    val path2 = path(g, g(center2))
    path1.diff(path2).union(path2.diff(path1)).size
  }
  def run(input: Array[String]): String = {
    val g = graph(input)
    Array(count(input), distance(g, g("SAN").center, g("YOU").center)).mkString(" ")
  }
}
