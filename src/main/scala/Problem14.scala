import scala.util.matching.Regex.Match

case class Problem14() {
  private val parser = "(\\d+) (\\w+)".r
  case class Chemical(val element: String, val amount: Int)
  object Chemical {
    def apply(input: String): Chemical = {
      val m: Match = parser.findPrefixMatchOf(input).get
      Chemical(m.group(2), m.group(1).toInt)
    }
  }
  case class ReactionMap(val reactions: Map[Set[Chemical], Chemical])
  object ReactionMap {
    def apply(inputs: Seq[String]): ReactionMap = ReactionMap(inputs.map(input => (input.split(" => ")(0).split(", ").map(Chemical(_)).toSet, Chemical(input.split(" => ")(1)))).toMap)
  }
  def react(reagents: Set[Chemical]) {
  }

  def run(inputs: Seq[String]): String = {
    val results: ReactionMap = ReactionMap(inputs)
    ""
    //Seq(results).mkString(" ")
  }
}
