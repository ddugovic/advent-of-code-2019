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
  // https://stackoverflow.com/a/40876649
  def lcm(seq: Seq[BigInt]): BigInt = seq.foldLeft(1: BigInt) {
    (a, b) => b * a / Stream.iterate((a, b)) {
      case (x, y) => (y, x % y)
    }.dropWhile(_._2 != 0).head._1
  }
  def run(inputs: Seq[String]): String = {
    val moons = inputs.map(input => newMoon(input))
    var newMoons = moons
    var energy = 0
    var x = 1
    var y = 1
    var z = 1
    // Because at t=0 all moons have velocity=0, at t=-1 all moons are in the same position.
    // In each dimension this repetition will occur in each period; periods have even parity.
    (2 to 1000000 by 2) foreach {i =>
      newMoons = step(newMoons)
      newMoons = step(newMoons)
      if (i == 1000) {
        energy = newMoons.map(_.energy).sum
      }
      val offsets = for ((newMoon, moon) <- (newMoons zip moons)) yield newMoon.position.subtract(moon.position)
      if (x == 1 && offsets(0).x == 0 && offsets(1).x == 0 && offsets(2).x == 0 && offsets(3).x == 0) {
        x = i
      }
      if (y == 1 && offsets(0).y == 0 && offsets(1).y == 0 && offsets(2).y == 0 && offsets(3).y == 0) {
        y = i
      }
      if (z == 1 && offsets(0).z == 0 && offsets(1).z == 0 && offsets(2).z == 0 && offsets(3).z == 0) {
        z = i
      }
    }
    Seq(energy, lcm(Seq(x, y, z))).mkString(" ")
  }
}
