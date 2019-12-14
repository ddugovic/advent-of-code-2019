case class Problem02() {
  case class Computer(memory: Array[Int]) {
    def read(address: Int) = memory(memory(address))
    def write(address: Int, value: Int) = {memory(memory(address)) = value}
    def step(address: Int) = memory(address) match {
      case 1 => {
        write(address+3, read(address+1) + read(address+2))
        address + 4
      }
      case 2 => {
        write(address+3, read(address+1) * read(address+2))
        address + 4
      }
      case 99 => address
    }
    def load(noun: Int, verb: Int) = {
      memory(1) = noun
      memory(2) = verb
      this
    }
    def execute() = {
      var address = 0
      var address2 = step(address)
      while (address2 != address) {
        address = address2
        address2 = step(address)
      }
      memory
    }
  }
  def run(inputs: String): String = {
    val disk = inputs.split(",").map(_.toInt)
    val results = Array.tabulate(100, 100) { Computer(disk.clone).load(_, _).execute()(0) }
    List(results(12)(2), results.flatten.indexOf(19690720)).mkString(" ")
  }
}
