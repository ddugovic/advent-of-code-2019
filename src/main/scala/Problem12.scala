import scala.util.matching.Regex.Match

case class Problem12() {
  private val parser = "<x=(-?\\d+), y=(-?\\d+), z=(-?\\d+)>".r
  case class Position(val x: Int, val y: Int, val z: Int) {
    def sum = x.abs + y.abs + z.abs
    def add(velocity: Velocity) = Position(x + velocity.dx, y + velocity.dy, z + velocity.dz)
    def subtract(position: Position) = Position(x - position.x, y - position.y, z - position.z)
    def signum: Tuple3[Int, Int, Int] = (x.signum, y.signum, z.signum)
  }
  case class Velocity(val dx: Int, val dy: Int, val dz: Int) {
    def sum = dx.abs + dy.abs + dz.abs
    def add(ddp: Tuple3[Int, Int, Int]) = Velocity(dx + ddp._1, dy + ddp._2, dz + ddp._3)
  }
  case class Moon(val position: Position, val velocity: Velocity) {
    def energy = position.sum * velocity.sum
    def accelerate(moons: Seq[Moon]): Velocity = moons.foldLeft(velocity)((velocity, moon) =>
        velocity.add(moon.position.subtract(position).signum)
    )
  }
  def newPosition(input: String): Position = {
    val m: Match = parser.findPrefixMatchOf(input).get
    Position(m.group(1).toInt, m.group(2).toInt, m.group(3).toInt)
  }
  def newMoon(input: String): Moon = Moon(newPosition(input), Velocity(0, 0, 0))
  def step(moons: Seq[Moon]) = {
    var newMoons = moons
    val map = newMoons.zip(newMoons.map(_.accelerate(newMoons)))
    map.map((tuple) => Moon(tuple._1.position.add(tuple._2), tuple._2))
  }
  def run(inputs: Seq[String]): String = {
    var moons = inputs.map(input => newMoon(input))
    1 to 1000 foreach {_ =>
      moons = step(moons)
    }
    val energy = moons.map(_.energy).sum
    Seq(energy, 1000).mkString(" ")
  }
}
