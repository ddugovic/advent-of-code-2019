case class Problem01() {
  def fuel(mass: Int): Int = mass / 3 - 2
  def fuel2(mass: Int): Int = if (fuel(mass) > 0) fuel(mass) + fuel2(fuel(mass)) else 0
  def run(inputs: List[String]): String = {
    val results: List[List[Int]] = inputs.map(_.toInt).map (mass => List(mass, fuel(mass), fuel2(mass)))
    List(results.map(_(1)).sum, results.map(_(2)).sum).mkString(" ")
  }
}
