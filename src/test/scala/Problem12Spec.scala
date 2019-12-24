import org.scalatest.FlatSpec

class Problem12Spec extends FlatSpec {

  val problem12 = new Problem12

  "moons" should "have energy" in {
    val moon1 = new problem12.Moon("<x=-1, y=0, z=2>")
    val moon2 = new problem12.Moon("<x=2, y=-10, z=-7>")
    val moon3 = new problem12.Moon("<x=4, y=-8, z=8>")
    val moon4 = new problem12.Moon("<x=3, y=5, z=-1>")

    assert(moon1.position == new problem12.Position(-1, 0, 2))
    assert(moon1.velocity == new problem12.Velocity(0, 0, 0))
    assert(moon2.position == new problem12.Position(2, -10, -7))
    assert(moon2.velocity == new problem12.Velocity(0, 0, 0))
    assert(moon3.position == new problem12.Position(4, -8, 8))
    assert(moon3.velocity == new problem12.Velocity(0, 0, 0))
    assert(moon4.position == new problem12.Position(3, 5, -1))
    assert(moon4.velocity == new problem12.Velocity(0, 0, 0))

    problem12.step(Seq(moon1, moon2, moon3, moon4))
    assert(moon1.position == new problem12.Position(2, -1, 1))
    assert(moon1.velocity == new problem12.Velocity(3, -1, -1))
    assert(moon2.position == new problem12.Position(3, -7, -4))
    assert(moon2.velocity == new problem12.Velocity(1, 3, 3))
    assert(moon3.position == new problem12.Position(1, -7, 5))
    assert(moon3.velocity == new problem12.Velocity(-3, 1, -3))
    assert(moon4.position == new problem12.Position(2, 2, 0))
    assert(moon4.velocity == new problem12.Velocity(-1, -3, 1))

    problem12.step(Seq(moon1, moon2, moon3, moon4))
    assert(moon1.position == new problem12.Position(5, -3, -1))
    assert(moon1.velocity == new problem12.Velocity(3, -2, -2))
    assert(moon2.position == new problem12.Position(1, -2, 2))
    assert(moon2.velocity == new problem12.Velocity(-2, 5, 6))
    assert(moon3.position == new problem12.Position(1, -4, -1))
    assert(moon3.velocity == new problem12.Velocity(0, 3, -6))
    assert(moon4.position == new problem12.Position(1, -4, 2))
    assert(moon4.velocity == new problem12.Velocity(-1, -6, 2))

    problem12.step(Seq(moon1, moon2, moon3, moon4))
    assert(moon1.position == new problem12.Position(5, -6, -1))
    assert(moon1.velocity == new problem12.Velocity(0, -3, 0))
    assert(moon2.position == new problem12.Position(0, 0, 6))
    assert(moon2.velocity == new problem12.Velocity(-1, 2, 4))
    assert(moon3.position == new problem12.Position(2, 1, -5))
    assert(moon3.velocity == new problem12.Velocity(1, 5, -4))
    assert(moon4.position == new problem12.Position(1, -8, 2))
    assert(moon4.velocity == new problem12.Velocity(0, -4, 0))

    problem12.step(Seq(moon1, moon2, moon3, moon4))
    assert(moon1.position == new problem12.Position(2, -8, 0))
    assert(moon1.velocity == new problem12.Velocity(-3, -2, 1))
    assert(moon2.position == new problem12.Position(2, 1, 7))
    assert(moon2.velocity == new problem12.Velocity(2, 1, 1))
    assert(moon3.position == new problem12.Position(2, 3, -6))
    assert(moon3.velocity == new problem12.Velocity(0, 2, -1))
    assert(moon4.position == new problem12.Position(2, -9, 1))
    assert(moon4.velocity == new problem12.Velocity(1, -1, -1))

    problem12.step(Seq(moon1, moon2, moon3, moon4))
    assert(moon1.position == new problem12.Position(-1, -9, 2))
    assert(moon1.velocity == new problem12.Velocity(-3, -1, 2))
    assert(moon2.position == new problem12.Position(4, 1, 5))
    assert(moon2.velocity == new problem12.Velocity(2, 0, -2))
    assert(moon3.position == new problem12.Position(2, 2, -4))
    assert(moon3.velocity == new problem12.Velocity(0, -1, 2))
    assert(moon4.position == new problem12.Position(3, -7, -1))
    assert(moon4.velocity == new problem12.Velocity(1, 2, -2))

    problem12.step(Seq(moon1, moon2, moon3, moon4))
    assert(moon1.position == new problem12.Position(-1, -7, 3))
    assert(moon1.velocity == new problem12.Velocity(0, 2, 1))
    assert(moon2.position == new problem12.Position(3, 0, 0))
    assert(moon2.velocity == new problem12.Velocity(-1, -1, -5))
    assert(moon3.position == new problem12.Position(3, -2, 1))
    assert(moon3.velocity == new problem12.Velocity(1, -4, 5))
    assert(moon4.position == new problem12.Position(3, -4, -2))
    assert(moon4.velocity == new problem12.Velocity(0, 3, -1))

    problem12.step(Seq(moon1, moon2, moon3, moon4))
    assert(moon1.position == new problem12.Position(2, -2, 1))
    assert(moon1.velocity == new problem12.Velocity(3, 5, -2))
    assert(moon2.position == new problem12.Position(1, -4, -4))
    assert(moon2.velocity == new problem12.Velocity(-2, -4, -4))
    assert(moon3.position == new problem12.Position(3, -7, 5))
    assert(moon3.velocity == new problem12.Velocity(0, -5, 4))
    assert(moon4.position == new problem12.Position(2, 0, 0))
    assert(moon4.velocity == new problem12.Velocity(-1, 4, 2))

    problem12.step(Seq(moon1, moon2, moon3, moon4))
    assert(moon1.position == new problem12.Position(5, 2, -2))
    assert(moon1.velocity == new problem12.Velocity(3, 4, -3))
    assert(moon2.position == new problem12.Position(2, -7, -5))
    assert(moon2.velocity == new problem12.Velocity(1, -3, -1))
    assert(moon3.position == new problem12.Position(0, -9, 6))
    assert(moon3.velocity == new problem12.Velocity(-3, -2, 1))
    assert(moon4.position == new problem12.Position(1, 1, 3))
    assert(moon4.velocity == new problem12.Velocity(-1, 1, 3))

    problem12.step(Seq(moon1, moon2, moon3, moon4))
    assert(moon1.position == new problem12.Position(5, 3, -4))
    assert(moon1.velocity == new problem12.Velocity(0, 1, -2))
    assert(moon2.position == new problem12.Position(2, -9, -3))
    assert(moon2.velocity == new problem12.Velocity(0, -2, 2))
    assert(moon3.position == new problem12.Position(0, -8, 4))
    assert(moon3.velocity == new problem12.Velocity(0, 1, -2))
    assert(moon4.position == new problem12.Position(1, 1, 5))
    assert(moon4.velocity == new problem12.Velocity(0, 0, 2))

    problem12.step(Seq(moon1, moon2, moon3, moon4))
    assert(moon1.position == new problem12.Position(2, 1, -3))
    assert(moon1.velocity == new problem12.Velocity(-3, -2, 1))
    assert(moon1.energy == 36)
    assert(moon2.position == new problem12.Position(1, -8, 0))
    assert(moon2.velocity == new problem12.Velocity(-1, 1, 3))
    assert(moon2.energy == 45)
    assert(moon3.position == new problem12.Position(3, -6, 1))
    assert(moon3.velocity == new problem12.Velocity(3, 2, -3))
    assert(moon3.energy == 80)
    assert(moon4.position == new problem12.Position(2, 0, 4))
    assert(moon4.velocity == new problem12.Velocity(1, -1, -1))
    assert(moon4.energy == 18)
  }
"""
Here's a second example:

<x=-8, y=-10, z=0>
<x=5, y=5, z=10>
<x=2, y=-7, z=3>
<x=9, y=-8, z=-3>
Every ten steps of simulation for 100 steps produces:

After 0 steps:
pos=<x= -8, y=-10, z=  0>, vel=<x=  0, y=  0, z=  0>
pos=<x=  5, y=  5, z= 10>, vel=<x=  0, y=  0, z=  0>
pos=<x=  2, y= -7, z=  3>, vel=<x=  0, y=  0, z=  0>
pos=<x=  9, y= -8, z= -3>, vel=<x=  0, y=  0, z=  0>

After 10 steps:
pos=<x= -9, y=-10, z=  1>, vel=<x= -2, y= -2, z= -1>
pos=<x=  4, y= 10, z=  9>, vel=<x= -3, y=  7, z= -2>
pos=<x=  8, y=-10, z= -3>, vel=<x=  5, y= -1, z= -2>
pos=<x=  5, y=-10, z=  3>, vel=<x=  0, y= -4, z=  5>

After 20 steps:
pos=<x=-10, y=  3, z= -4>, vel=<x= -5, y=  2, z=  0>
pos=<x=  5, y=-25, z=  6>, vel=<x=  1, y=  1, z= -4>
pos=<x= 13, y=  1, z=  1>, vel=<x=  5, y= -2, z=  2>
pos=<x=  0, y=  1, z=  7>, vel=<x= -1, y= -1, z=  2>

After 30 steps:
pos=<x= 15, y= -6, z= -9>, vel=<x= -5, y=  4, z=  0>
pos=<x= -4, y=-11, z=  3>, vel=<x= -3, y=-10, z=  0>
pos=<x=  0, y= -1, z= 11>, vel=<x=  7, y=  4, z=  3>
pos=<x= -3, y= -2, z=  5>, vel=<x=  1, y=  2, z= -3>

After 40 steps:
pos=<x= 14, y=-12, z= -4>, vel=<x= 11, y=  3, z=  0>
pos=<x= -1, y= 18, z=  8>, vel=<x= -5, y=  2, z=  3>
pos=<x= -5, y=-14, z=  8>, vel=<x=  1, y= -2, z=  0>
pos=<x=  0, y=-12, z= -2>, vel=<x= -7, y= -3, z= -3>

After 50 steps:
pos=<x=-23, y=  4, z=  1>, vel=<x= -7, y= -1, z=  2>
pos=<x= 20, y=-31, z= 13>, vel=<x=  5, y=  3, z=  4>
pos=<x= -4, y=  6, z=  1>, vel=<x= -1, y=  1, z= -3>
pos=<x= 15, y=  1, z= -5>, vel=<x=  3, y= -3, z= -3>

After 60 steps:
pos=<x= 36, y=-10, z=  6>, vel=<x=  5, y=  0, z=  3>
pos=<x=-18, y= 10, z=  9>, vel=<x= -3, y= -7, z=  5>
pos=<x=  8, y=-12, z= -3>, vel=<x= -2, y=  1, z= -7>
pos=<x=-18, y= -8, z= -2>, vel=<x=  0, y=  6, z= -1>

After 70 steps:
pos=<x=-33, y= -6, z=  5>, vel=<x= -5, y= -4, z=  7>
pos=<x= 13, y= -9, z=  2>, vel=<x= -2, y= 11, z=  3>
pos=<x= 11, y= -8, z=  2>, vel=<x=  8, y= -6, z= -7>
pos=<x= 17, y=  3, z=  1>, vel=<x= -1, y= -1, z= -3>

After 80 steps:
pos=<x= 30, y= -8, z=  3>, vel=<x=  3, y=  3, z=  0>
pos=<x= -2, y= -4, z=  0>, vel=<x=  4, y=-13, z=  2>
pos=<x=-18, y= -7, z= 15>, vel=<x= -8, y=  2, z= -2>
pos=<x= -2, y= -1, z= -8>, vel=<x=  1, y=  8, z=  0>

After 90 steps:
pos=<x=-25, y= -1, z=  4>, vel=<x=  1, y= -3, z=  4>
pos=<x=  2, y= -9, z=  0>, vel=<x= -3, y= 13, z= -1>
pos=<x= 32, y= -8, z= 14>, vel=<x=  5, y= -4, z=  6>
pos=<x= -1, y= -2, z= -8>, vel=<x= -3, y= -6, z= -9>

After 100 steps:
pos=<x=  8, y=-12, z= -9>, vel=<x= -7, y=  3, z=  0>
pos=<x= 13, y= 16, z= -3>, vel=<x=  3, y=-11, z= -5>
pos=<x=-29, y=-11, z= -1>, vel=<x= -3, y=  7, z=  4>
pos=<x= 16, y=-13, z= 23>, vel=<x=  7, y=  1, z=  1>

Energy after 100 steps:
pot:  8 + 12 +  9 = 29;   kin: 7 +  3 + 0 = 10;   total: 29 * 10 = 290
pot: 13 + 16 +  3 = 32;   kin: 3 + 11 + 5 = 19;   total: 32 * 19 = 608
pot: 29 + 11 +  1 = 41;   kin: 3 +  7 + 4 = 14;   total: 41 * 14 = 574
pot: 16 + 13 + 23 = 52;   kin: 7 +  1 + 1 =  9;   total: 52 *  9 = 468
Sum of total energy: 290 + 608 + 574 + 468 = 1940
"""
}
