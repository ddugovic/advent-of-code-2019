import scala.util.matching.Regex.Match

case class Problem12() {
  private val parser = "<x=(-?\\d+), y=(-?\\d+), z=(-?\\d+)>".r
  case class Position(val x: Int, val y: Int, val z: Int) {
    def sum = x.abs + y.abs + z.abs
    def add(velocity: Velocity) = Position(x + velocity.dx, y + velocity.dy, z + velocity.dz)
  }
  case class Velocity(val dx: Int, val dy: Int, val dz: Int) {
    def sum = dx.abs + dy.abs + dz.abs
    def add(ddx: Int, ddy: Int, ddz: Int) = Velocity(dx + ddx, dy + ddy, dz + ddz)
  }
  class Moon(val input: String) {
    val m: Match = parser.findPrefixMatchOf(input).get
    var position = Position(m.group(1).toInt, m.group(2).toInt, m.group(3).toInt)
    var velocity = Velocity(0, 0, 0)
    def energy = position.sum * velocity.sum
    def accelerate(moons: Seq[Moon]) = for (moon <- moons) {
      this.velocity = this.velocity.add((moon.position.x - position.x).signum, (moon.position.y - position.y).signum, (moon.position.z - position.z).signum)
    }
  }
  def step(moons: Seq[Moon], steps: Int = 1) {
    1 to steps foreach {_ =>
      for (moon <- moons) moon.accelerate(moons)
      for (moon <- moons) moon.position = moon.position.add(moon.velocity)
    }
  }
  def run(inputs: Seq[String]): String = {
    val moons = inputs.map(new Moon(_))
    step(moons, 1000)
    Seq(moons.map(_.energy).sum).mkString(" ")
  }
}
