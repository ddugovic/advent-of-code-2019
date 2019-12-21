case class Problem01() {
  def fuel(mass: Int): Int = mass / 3 - 2
  def fuel2(mass: Int): Int = if (fuel(mass) > 0) fuel(mass) + fuel2(fuel(mass)) else 0
  def run(inputs: Seq[String]): String = {
    val results = inputs.map(_.toInt)
    Seq(results.map(fuel(_)).sum, results.map(fuel2(_)).sum).mkString(" ")
  }
}
