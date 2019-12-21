case class Problem04() {
  private val decrease = "9[0-8]|8[0-7]|7[0-6]|6[0-5]|5[0-4]|4[0-3]|3[0-2]|2[0-1]|10".r
  private val repetition = "(\\d)\\1".r
  private val repetition2 = "(\\d)\\1+".r
  def decreasing(word: String) = decrease.findFirstIn(word).isDefined
  def repeating(word: String) = repetition.findFirstIn(word).isDefined
  def repeating2(word: String) = repetition2.findAllIn(word).exists(_.length == 2)
  def run(input: String): String = {
    val bounds = input.split("-").map(_.toInt)
    val words = (bounds(0) to bounds(1)).map(_.toString).filterNot(decreasing)
    Seq(words.count(repeating), words.count(repeating2)).mkString(" ")
  }
}
