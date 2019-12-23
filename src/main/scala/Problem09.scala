import scala.collection.mutable.Buffer

case class Problem09() {
  class Machine(val program: Buffer[Long], id: Long, var signal: Long = 0) extends IOChannel {
    val computer = new Computer(this, program)
    def input(): Long = id
    def output(signal: Long) = {
      this.signal = signal
    }
    def run() = {
      computer.run()
      this
    }
  }
  def run(inputs: String): String = {
    val program = inputs.split(",").map(_.toLong)
    Seq(new Machine(program.toBuffer.padTo(2048, 0L), 1L).run.signal,
        new Machine(program.toBuffer.padTo(2048, 0L), 2L).run.signal).mkString(" ")
  }
}
