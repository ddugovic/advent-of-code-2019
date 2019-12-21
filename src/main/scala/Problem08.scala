case class Problem08() {
  case class Image(input: String, rows: Int, cols: Int) {
    val layers = input.grouped(rows * cols).toSeq
    val count = layers.map(_.groupBy(identity).mapValues(_.size))
    val minLayer = count.minBy(_.getOrElse('0', 0))
    val product = minLayer('1') * minLayer('2')
    val project = layers.reduce((a, b) => a.zipWithIndex.map(t => if (t._1 == '2') b(t._2) else t._1).mkString("")).grouped(cols).mkString("\n")
  }
  def run(input: String): String = {
    val results = Image(input, 6, 25)
    Seq(results.product, results.project.replace("0", " ").replace("1", "#")).mkString("\n")
  }
}
