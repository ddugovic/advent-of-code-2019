case class Problem05() {
  class Computer(memory: Array[Int], var output: Int) {
    def read(mode: Int, address: Int) = if (mode % 10 == 1) memory(address) else memory(memory(address))
    def write(address: Int, value: Int) = {memory(memory(address)) = value}
    def step(address: Int, input: Int) = {
      val mode = memory(address) / 100
      memory(address) % 100 match {
        case 1 => {
          write(address+3, read(mode, address+1) + read(mode/10, address+2))
          address + 4
        }
        case 2 => {
          write(address+3, read(mode, address+1) * read(mode/10, address+2))
          address + 4
        }
        case 3 => {
          write(address+1, input)
          address + 2
        }
        case 4 => {
          output = read(mode, address+1)
          address + 2
        }
        case 5 => {
          if (read(mode, address+1) != 0) read(mode/10, address+2) else address + 3
        }
        case 6 => {
          if (read(mode, address+1) == 0) read(mode/10, address+2) else address + 3
        }
        case 7 => {
          write(address+3, if (read(mode, address+1) < read(mode/10, address+2)) 1 else 0)
          address + 4
        }
        case 8 => {
          write(address+3, if (read(mode, address+1) == read(mode/10, address+2)) 1 else 0)
          address + 4
        }
        case 99 => address
      }
    }
    def execute(input: Int) = {
      var address = 0
      var address2 = step(address, input)
      while (address2 != address) {
        address = address2
        address2 = step(address, input)
      }
      output
    }
  }
  def run(inputs: String): String = {
    val disk = inputs.split(",").map(_.toInt)
    List(new Computer(disk.clone, 0).execute(1), new Computer(disk, 0).execute(5)).mkString(" ")
  }
}
