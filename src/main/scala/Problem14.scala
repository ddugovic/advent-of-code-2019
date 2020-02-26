import scala.util.matching.Regex.Match

case class Problem14() {
  private val parser = "(\\d+) (\\w+)".r
  case class Mixture(val resources: Map[String, Int]) {
    def add(mixture: Mixture): Mixture = Mixture(resources ++ mixture.resources.map{ case (k,v) => k -> (v + resources.getOrElse(k,0)) })
  }
  object Mixture {
    def apply(input: String): Mixture = input.split(", ").map {s =>
      val m: Match = parser.findPrefixMatchOf(s).get
      Mixture(Map(m.group(2) -> m.group(1).toInt))
    }.reduce(_ add _)
  }
  case class Factory(val reactions: Map[Mixture, Seq[Mixture]]) {
    def mix(chemicals: Mixture): Option[Set[Mixture]] = reactions.get(chemicals).map(_.toSet)
    def produce(chemicals: Mixture): Set[Mixture] = mix(chemicals) getOrElse Set(chemicals)
  }
  object Factory {
    def apply(inputs: Seq[String]): Factory = Factory(inputs.map(input => (Mixture(input.split(" => ")(0)), Mixture(input.split(" => ")(1)))).groupMap(_._1)(_._2))
  }

  def run(inputs: Seq[String]): String = {
    val results: Factory = Factory(inputs)
    ""
    //Seq(results).mkString(" ")
  }
}
