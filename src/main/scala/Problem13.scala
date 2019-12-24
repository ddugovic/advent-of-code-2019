import scala.collection.mutable.Buffer
import scala.collection.mutable.Map

case class Problem13() {
  class Cabinet(var program: Seq[Long], var coins: Long = 1L) {
    def load(): Buffer[Long] = {
      val buffer = program.toBuffer.padTo(2200, 0L)
      buffer(0) = coins
      buffer
    }
  }
  class Game(var program: Buffer[Long], var score: Long = 0L, val map: Map[(Int, Int), Long] = Map()) extends IOChannel[Long] {
    val computer: Computer = new Computer(this, program)
    var c: Int = 0
    var r: Int = 0
    var count: Int = 0
    def step(x: Long, y: Long, tile: Long) = {
      output(x)
      output(y)
      output(tile)
    }
    def input = {
      val paddle = map.collect {case ((x, _), 3L) => x}.sum
      val ball = map.collect {case ((x, _), 4L) => x}.sum
      (ball - paddle).signum
    }
    def output(signal: Long) = {
      count % 3 match {
      case 0 => c = signal.toInt
      case 1 => r = signal.toInt
      case _ => if ((c, r) == (-1, 0)) score = signal else map((c, r)) = signal
      }
      count += 1
    }
    def run() = {
      computer.run()
      this
    }
  }
  def run(inputs: String): String = {
    val program = inputs.split(",").map(_.toLong)
    val r = 0
    val c = 0
    Seq(new Game(new Cabinet(program).load).run().map.count(_._2 == 2L),
        new Game(new Cabinet(program, 2L).load).run().score).mkString(" ")
  }
}
