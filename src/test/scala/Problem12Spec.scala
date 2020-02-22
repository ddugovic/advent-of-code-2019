import org.scalatest.FlatSpec

class Problem12Spec extends FlatSpec {

  val problem12 = new Problem12

  "first example moons" should "cycle in 2772 steps" in {
    val moon1 = problem12.newMoon("<x=-1, y=0, z=2>")
    val moon2 = problem12.newMoon("<x=2, y=-10, z=-7>")
    val moon3 = problem12.newMoon("<x=4, y=-8, z=8>")
    val moon4 = problem12.newMoon("<x=3, y=5, z=-1>")
    var moons = Seq(moon1, moon2, moon3, moon4)

    assert(moons(0).position == new problem12.Position(-1, 0, 2))
    assert(moons(0).velocity == new problem12.Velocity(0, 0, 0))
    assert(moons(1).position == new problem12.Position(2, -10, -7))
    assert(moons(1).velocity == new problem12.Velocity(0, 0, 0))
    assert(moons(2).position == new problem12.Position(4, -8, 8))
    assert(moons(2).velocity == new problem12.Velocity(0, 0, 0))
    assert(moons(3).position == new problem12.Position(3, 5, -1))
    assert(moons(3).velocity == new problem12.Velocity(0, 0, 0))

    moons = problem12.step(moons)
    assert(moons(0).position == new problem12.Position(2, -1, 1))
    assert(moons(0).velocity == new problem12.Velocity(3, -1, -1))
    assert(moons(1).position == new problem12.Position(3, -7, -4))
    assert(moons(1).velocity == new problem12.Velocity(1, 3, 3))
    assert(moons(2).position == new problem12.Position(1, -7, 5))
    assert(moons(2).velocity == new problem12.Velocity(-3, 1, -3))
    assert(moons(3).position == new problem12.Position(2, 2, 0))
    assert(moons(3).velocity == new problem12.Velocity(-1, -3, 1))

    moons = problem12.step(moons)
    assert(moons(0).position == new problem12.Position(5, -3, -1))
    assert(moons(0).velocity == new problem12.Velocity(3, -2, -2))
    assert(moons(1).position == new problem12.Position(1, -2, 2))
    assert(moons(1).velocity == new problem12.Velocity(-2, 5, 6))
    assert(moons(2).position == new problem12.Position(1, -4, -1))
    assert(moons(2).velocity == new problem12.Velocity(0, 3, -6))
    assert(moons(3).position == new problem12.Position(1, -4, 2))
    assert(moons(3).velocity == new problem12.Velocity(-1, -6, 2))

    moons = problem12.step(moons)
    assert(moons(0).position == new problem12.Position(5, -6, -1))
    assert(moons(0).velocity == new problem12.Velocity(0, -3, 0))
    assert(moons(1).position == new problem12.Position(0, 0, 6))
    assert(moons(1).velocity == new problem12.Velocity(-1, 2, 4))
    assert(moons(2).position == new problem12.Position(2, 1, -5))
    assert(moons(2).velocity == new problem12.Velocity(1, 5, -4))
    assert(moons(3).position == new problem12.Position(1, -8, 2))
    assert(moons(3).velocity == new problem12.Velocity(0, -4, 0))

    moons = problem12.step(moons)
    assert(moons(0).position == new problem12.Position(2, -8, 0))
    assert(moons(0).velocity == new problem12.Velocity(-3, -2, 1))
    assert(moons(1).position == new problem12.Position(2, 1, 7))
    assert(moons(1).velocity == new problem12.Velocity(2, 1, 1))
    assert(moons(2).position == new problem12.Position(2, 3, -6))
    assert(moons(2).velocity == new problem12.Velocity(0, 2, -1))
    assert(moons(3).position == new problem12.Position(2, -9, 1))
    assert(moons(3).velocity == new problem12.Velocity(1, -1, -1))

    moons = problem12.step(moons)
    assert(moons(0).position == new problem12.Position(-1, -9, 2))
    assert(moons(0).velocity == new problem12.Velocity(-3, -1, 2))
    assert(moons(1).position == new problem12.Position(4, 1, 5))
    assert(moons(1).velocity == new problem12.Velocity(2, 0, -2))
    assert(moons(2).position == new problem12.Position(2, 2, -4))
    assert(moons(2).velocity == new problem12.Velocity(0, -1, 2))
    assert(moons(3).position == new problem12.Position(3, -7, -1))
    assert(moons(3).velocity == new problem12.Velocity(1, 2, -2))

    moons = problem12.step(moons)
    assert(moons(0).position == new problem12.Position(-1, -7, 3))
    assert(moons(0).velocity == new problem12.Velocity(0, 2, 1))
    assert(moons(1).position == new problem12.Position(3, 0, 0))
    assert(moons(1).velocity == new problem12.Velocity(-1, -1, -5))
    assert(moons(2).position == new problem12.Position(3, -2, 1))
    assert(moons(2).velocity == new problem12.Velocity(1, -4, 5))
    assert(moons(3).position == new problem12.Position(3, -4, -2))
    assert(moons(3).velocity == new problem12.Velocity(0, 3, -1))

    moons = problem12.step(moons)
    assert(moons(0).position == new problem12.Position(2, -2, 1))
    assert(moons(0).velocity == new problem12.Velocity(3, 5, -2))
    assert(moons(1).position == new problem12.Position(1, -4, -4))
    assert(moons(1).velocity == new problem12.Velocity(-2, -4, -4))
    assert(moons(2).position == new problem12.Position(3, -7, 5))
    assert(moons(2).velocity == new problem12.Velocity(0, -5, 4))
    assert(moons(3).position == new problem12.Position(2, 0, 0))
    assert(moons(3).velocity == new problem12.Velocity(-1, 4, 2))

    moons = problem12.step(moons)
    assert(moons(0).position == new problem12.Position(5, 2, -2))
    assert(moons(0).velocity == new problem12.Velocity(3, 4, -3))
    assert(moons(1).position == new problem12.Position(2, -7, -5))
    assert(moons(1).velocity == new problem12.Velocity(1, -3, -1))
    assert(moons(2).position == new problem12.Position(0, -9, 6))
    assert(moons(2).velocity == new problem12.Velocity(-3, -2, 1))
    assert(moons(3).position == new problem12.Position(1, 1, 3))
    assert(moons(3).velocity == new problem12.Velocity(-1, 1, 3))

    moons = problem12.step(moons)
    assert(moons(0).position == new problem12.Position(5, 3, -4))
    assert(moons(0).velocity == new problem12.Velocity(0, 1, -2))
    assert(moons(1).position == new problem12.Position(2, -9, -3))
    assert(moons(1).velocity == new problem12.Velocity(0, -2, 2))
    assert(moons(2).position == new problem12.Position(0, -8, 4))
    assert(moons(2).velocity == new problem12.Velocity(0, 1, -2))
    assert(moons(3).position == new problem12.Position(1, 1, 5))
    assert(moons(3).velocity == new problem12.Velocity(0, 0, 2))

    moons = problem12.step(moons)
    assert(moons(0).position == new problem12.Position(2, 1, -3))
    assert(moons(0).velocity == new problem12.Velocity(-3, -2, 1))
    assert(moons(0).energy == 36)
    assert(moons(1).position == new problem12.Position(1, -8, 0))
    assert(moons(1).velocity == new problem12.Velocity(-1, 1, 3))
    assert(moons(1).energy == 45)
    assert(moons(2).position == new problem12.Position(3, -6, 1))
    assert(moons(2).velocity == new problem12.Velocity(3, 2, -3))
    assert(moons(2).energy == 80)
    assert(moons(3).position == new problem12.Position(2, 0, 4))
    assert(moons(3).velocity == new problem12.Velocity(1, -1, -1))
    assert(moons(3).energy == 18)

    1 to 2762 foreach {_ =>
      moons = problem12.step(moons)
    }
    assert(moons == Seq(moon1, moon2, moon3, moon4))
  }

  "second example moons" should "have energy" in {
    var moon1 = problem12.newMoon("<x=-8, y=-10, z=0>")
    var moon2 = problem12.newMoon("<x=5, y=5, z=10>")
    var moon3 = problem12.newMoon("<x=2, y=-7, z=3>")
    var moon4 = problem12.newMoon("<x=9, y=-8, z=-3>")
    var moons = Seq(moon1, moon2, moon3, moon4)

    assert(moons(0).position == new problem12.Position(-8, -10, 0))
    assert(moons(0).velocity == new problem12.Velocity(0, 0, 0))
    assert(moons(1).position == new problem12.Position(5, 5, 10))
    assert(moons(1).velocity == new problem12.Velocity(0, 0, 0))
    assert(moons(2).position == new problem12.Position(2, -7, 3))
    assert(moons(2).velocity == new problem12.Velocity(0, 0, 0))
    assert(moons(3).position == new problem12.Position(9, -8, -3))
    assert(moons(3).velocity == new problem12.Velocity(0, 0, 0))

    1 to 10 foreach {_ =>
      moons = problem12.step(moons)
    }
    assert(moons(0).position == new problem12.Position(-9, -10, 1))
    assert(moons(0).velocity == new problem12.Velocity(-2, -2, -1))
    assert(moons(1).position == new problem12.Position(4, 10, 9))
    assert(moons(1).velocity == new problem12.Velocity(-3, 7, -2))
    assert(moons(2).position == new problem12.Position(8, -10, -3))
    assert(moons(2).velocity == new problem12.Velocity(5, -1, -2))
    assert(moons(3).position == new problem12.Position(5, -10, 3))

    1 to 10 foreach {_ =>
      moons = problem12.step(moons)
    }
    assert(moons(0).position == new problem12.Position(-10, 3, -4))
    assert(moons(0).velocity == new problem12.Velocity(-5, 2, 0))
    assert(moons(1).position == new problem12.Position(5, -25, 6))
    assert(moons(1).velocity == new problem12.Velocity(1, 1, -4))
    assert(moons(2).position == new problem12.Position(13, 1, 1))
    assert(moons(2).velocity == new problem12.Velocity(5, -2, 2))
    assert(moons(3).position == new problem12.Position(0, 1, 7))

    1 to 10 foreach {_ =>
      moons = problem12.step(moons)
    }
    assert(moons(0).position == new problem12.Position(15, -6, -9))
    assert(moons(0).velocity == new problem12.Velocity(-5, 4, 0))
    assert(moons(1).position == new problem12.Position(-4, -11, 3))
    assert(moons(1).velocity == new problem12.Velocity(-3, -10, 0))
    assert(moons(2).position == new problem12.Position(0, -1, 11))
    assert(moons(2).velocity == new problem12.Velocity(7, 4, 3))
    assert(moons(3).position == new problem12.Position(-3, -2, 5))
    assert(moons(3).velocity == new problem12.Velocity(1, 2, -3))

    1 to 10 foreach {_ =>
      moons = problem12.step(moons)
    }
    assert(moons(0).position == new problem12.Position(14, -12, -4))
    assert(moons(0).velocity == new problem12.Velocity(11, 3, 0))
    assert(moons(1).position == new problem12.Position(-1, 18, 8))
    assert(moons(1).velocity == new problem12.Velocity(-5, 2, 3))
    assert(moons(2).position == new problem12.Position(-5, -14, 8))
    assert(moons(2).velocity == new problem12.Velocity(1, -2, 0))
    assert(moons(3).position == new problem12.Position(0, -12, -2))
    assert(moons(3).velocity == new problem12.Velocity(-7, -3, -3))

    1 to 10 foreach {_ =>
      moons = problem12.step(moons)
    }
    assert(moons(0).position == new problem12.Position(-23, 4, 1))
    assert(moons(0).velocity == new problem12.Velocity(-7, -1, 2))
    assert(moons(1).position == new problem12.Position(20, -31, 13))
    assert(moons(1).velocity == new problem12.Velocity(5, 3, 4))
    assert(moons(2).position == new problem12.Position(-4, 6, 1))
    assert(moons(2).velocity == new problem12.Velocity(-1, 1, -3))
    assert(moons(3).position == new problem12.Position(15, 1, -5))
    assert(moons(3).velocity == new problem12.Velocity(3, -3, -3))

    1 to 10 foreach {_ =>
      moons = problem12.step(moons)
    }
    assert(moons(0).position == new problem12.Position(36, -10, 6))
    assert(moons(0).velocity == new problem12.Velocity(5, 0, 3))
    assert(moons(1).position == new problem12.Position(-18, 10, 9))
    assert(moons(1).velocity == new problem12.Velocity(-3, -7, 5))
    assert(moons(2).position == new problem12.Position(8, -12, -3))
    assert(moons(2).velocity == new problem12.Velocity(-2, 1, -7))
    assert(moons(3).position == new problem12.Position(-18, -8, -2))
    assert(moons(3).velocity == new problem12.Velocity(0, 6, -1))

    1 to 10 foreach {_ =>
      moons = problem12.step(moons)
    }
    assert(moons(0).position == new problem12.Position(-33, -6, 5))
    assert(moons(0).velocity == new problem12.Velocity(-5, -4, 7))
    assert(moons(1).position == new problem12.Position(13, -9, 2))
    assert(moons(1).velocity == new problem12.Velocity(-2, 11, 3))
    assert(moons(2).position == new problem12.Position(11, -8, 2))
    assert(moons(2).velocity == new problem12.Velocity(8, -6, -7))
    assert(moons(3).position == new problem12.Position(17, 3, 1))
    assert(moons(3).velocity == new problem12.Velocity(-1, -1, -3))

    1 to 10 foreach {_ =>
      moons = problem12.step(moons)
    }
    assert(moons(0).position == new problem12.Position(30, -8, 3))
    assert(moons(0).velocity == new problem12.Velocity(3, 3, 0))
    assert(moons(1).position == new problem12.Position(-2, -4, 0))
    assert(moons(1).velocity == new problem12.Velocity(4, -13, 2))
    assert(moons(2).position == new problem12.Position(-18, -7, 15))
    assert(moons(2).velocity == new problem12.Velocity(-8, 2, -2))
    assert(moons(3).position == new problem12.Position(-2, -1, -8))
    assert(moons(3).velocity == new problem12.Velocity(1, 8, 0))

    1 to 10 foreach {_ =>
      moons = problem12.step(moons)
    }
    assert(moons(0).position == new problem12.Position(-25, -1, 4))
    assert(moons(0).velocity == new problem12.Velocity(1, -3, 4))
    assert(moons(1).position == new problem12.Position(2, -9, 0))
    assert(moons(1).velocity == new problem12.Velocity(-3, 13, -1))
    assert(moons(2).position == new problem12.Position(32, -8, 14))
    assert(moons(2).velocity == new problem12.Velocity(5, -4, 6))
    assert(moons(3).position == new problem12.Position(-1, -2, -8))
    assert(moons(3).velocity == new problem12.Velocity(-3, -6, -9))

    1 to 10 foreach {_ =>
      moons = problem12.step(moons)
    }
    assert(moons(0).position == new problem12.Position(8, -12, -9))
    assert(moons(0).velocity == new problem12.Velocity(-7, 3, 0))
    assert(moons(0).energy == 290)
    assert(moons(1).position == new problem12.Position(13, 16, -3))
    assert(moons(1).velocity == new problem12.Velocity(3, -11, -5))
    assert(moons(1).energy == 608)
    assert(moons(2).position == new problem12.Position(-29, -11, -1))
    assert(moons(2).velocity == new problem12.Velocity(-3, 7, 4))
    assert(moons(2).energy == 574)
    assert(moons(3).position == new problem12.Position(16, -13, 23))
    assert(moons(3).velocity == new problem12.Velocity(7, 1, 1))
    assert(moons(3).energy == 468)

/*
    1 to 8 foreach {_ =>
      1 to 585846853 foreach {_ =>
        moons = problem12.step(moons)
      }
    }
    assert(moons(0).position == new problem12.Position(-8, -10, 0))
    assert(moons(0).velocity == new problem12.Velocity(0, 0, 0))
    assert(moons(1).position == new problem12.Position(5, 5, 10))
    assert(moons(1).velocity == new problem12.Velocity(0, 0, 0))
    assert(moons(2).position == new problem12.Position(2, -7, 3))
    assert(moons(2).velocity == new problem12.Velocity(0, 0, 0))
    assert(moons(3).position == new problem12.Position(9, -8, -3))
    assert(moons(3).velocity == new problem12.Velocity(0, 0, 0))
*/
  } 
}
