import scala.collection.mutable.Buffer

trait IOChannel {
  def input(): Long
  def output(signal: Long)
}
class Computer(val channel: IOChannel, val memory: Buffer[Long]) {
  var base = 0
  var pc = 0
  def op = memory(pc) % 100
  def relativeAddress(mode: Int, address: Long) = if (mode % 10 == 2) base + address else address
  def read(mode: Int, address: Int) = if (mode % 10 == 1) memory(address) else memory(relativeAddress(mode, memory(address)).toInt)
  def write(mode: Int, address: Int, value: Long) = {memory(relativeAddress(mode, memory(address)).toInt) = value}
  def step() = {
    val mode = memory(pc).toInt / 100
    op match {
      case 1 => {
        write(mode/100, pc+3, read(mode, pc+1) + read(mode/10, pc+2))
        pc += 4
      }
      case 2 => {
        write(mode/100, pc+3, read(mode, pc+1) * read(mode/10, pc+2))
        pc += 4
      }
      case 3 => {
        write(mode, pc+1, channel.input)
        pc += 2
      }
      case 4 => {
        channel.output(read(mode, pc+1))
        pc += 2
      }
      case 5 => {
        pc = if (read(mode, pc+1) != 0) read(mode/10, pc+2).toInt else pc + 3
      }
      case 6 => {
        pc = if (read(mode, pc+1) == 0) read(mode/10, pc+2).toInt else pc + 3
      }
      case 7 => {
        write(mode/100, pc+3, if (read(mode, pc+1) < read(mode/10, pc+2)) 1 else 0)
        pc += 4
      }
      case 8 => {
        write(mode/100, pc+3, if (read(mode, pc+1) == read(mode/10, pc+2)) 1 else 0)
        pc += 4
      }
      case 9 => {
        base += read(mode, pc+1).toInt
        pc += 2
      }
      case 99 => pc 
    }
  }
  def run() = {
    var address = pc
    while (step() != address) {
      address = pc
    }
    this
  }
}
