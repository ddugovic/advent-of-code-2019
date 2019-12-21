case class Problem04() {
  private val decrease = "9[0-8]|8[0-7]|7[0-6]|6[0-5]|5[0-4]|4[0-3]|3[0-2]|2[0-1]|10".r
  private val repetition = "(\\d)\\1".r
  private val repetition2 = "(\\d)\\1+".r
  case class Word(val digits: String) {
    val decreasing = decrease.findFirstIn(digits).isDefined
    lazy val repeating = repetition.findFirstIn(digits).isDefined
    lazy val repeating2 = repetition2.findAllIn(digits).exists(_.length == 2)
  }
  def run(input: String): String = {
    val bounds = input.split("-").map(_.toInt)
    val words = (bounds(0) to bounds(1)).map(digits => Word(digits.toString)).filterNot(_.decreasing)
    Seq(words.count(_.repeating), words.count(_.repeating2)).mkString(" ")
  }
}
