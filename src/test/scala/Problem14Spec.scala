import org.scalatest.FlatSpec

class Problem14Spec extends FlatSpec {

  val problem14 = new Problem14

  "reactions" should "create products" in {
    val reactions = problem14.Factory(Seq("10 ORE => 10 A", "1 ORE => 1 B", "7 A, 1 B => 1 C", "7 A, 1 C => 1 D", "7 A, 1 D => 1 E", "7 A, 1 E => 1 FUEL"))
    assert(6 == reactions.reactions.size)
    assert(reactions.mix(problem14.Mixture("10 ORE")).get contains problem14.Mixture("10 A"))
    assert(reactions.mix(problem14.Mixture("1 ORE")).get contains problem14.Mixture("1 B"))
    assert(reactions.mix(problem14.Mixture("7 A, 1 B")).get contains problem14.Mixture("1 C"))
    assert(reactions.mix(problem14.Mixture("7 A, 1 C")).get contains problem14.Mixture("1 D"))
    assert(reactions.mix(problem14.Mixture("7 A, 1 D")).get contains problem14.Mixture("1 E"))
    assert(reactions.mix(problem14.Mixture("7 A, 1 E")).get contains problem14.Mixture("1 FUEL"))
  }

  "more reactions" should "create more products" in {
    val reactions = problem14.Factory(Seq("9 ORE => 2 A", "8 ORE => 3 B", "7 ORE => 5 C", "3 A, 4 B => 1 AB", "5 B, 7 C => 1 BC", "4 C, 1 A => 1 CA", "2 AB, 3 BC, 4 CA => 1 FUEL"))
    assert(7 == reactions.reactions.size)
    assert(reactions.mix(problem14.Mixture("9 ORE")).get contains problem14.Mixture("2 A"))
    assert(reactions.mix(problem14.Mixture("8 ORE")).get contains problem14.Mixture("3 B"))
    assert(reactions.mix(problem14.Mixture("7 ORE")).get contains problem14.Mixture("5 C"))
    assert(reactions.mix(problem14.Mixture("3 A, 4 B")).get contains problem14.Mixture("1 AB"))
    assert(reactions.mix(problem14.Mixture("5 B, 7 C")).get contains problem14.Mixture("1 BC"))
    assert(reactions.mix(problem14.Mixture("4 C, 1 A")).get contains problem14.Mixture("1 CA"))
    assert(reactions.mix(problem14.Mixture("2 AB, 3 BC, 4 CA")).get contains problem14.Mixture("1 FUEL"))
    assert(reactions.mix(problem14.Mixture("45 ORE")).get contains problem14.Mixture("10 A"))
    assert(reactions.mix(problem14.Mixture("64 ORE")).get contains problem14.Mixture("24 B"))
    assert(reactions.mix(problem14.Mixture("56 ORE")).get contains problem14.Mixture("40 C"))
    assert(reactions.mix(problem14.Mixture("6 A, 8 B")).get contains problem14.Mixture("2 AB"))
    assert(reactions.mix(problem14.Mixture("15 B, 21 C")).get contains problem14.Mixture("3 BC"))
    assert(reactions.mix(problem14.Mixture("16 C, 4 A")).get contains problem14.Mixture("4 CA"))
    assert(reactions.mix(problem14.Mixture("2 AB, 3 BC, 4 CA")).get contains problem14.Mixture("1 FUEL"))
  }

  "third example reactions" should "create third example products" in {
    val reactions = problem14.Factory(Seq("157 ORE => 5 NZVS", "165 ORE => 6 DCFZ", "44 XJWVT, 5 KHKGT, 1 QDVJ, 29 NZVS, 9 GPVTF, 48 HKGWZ => 1 FUEL", "12 HKGWZ, 1 GPVTF, 8 PSHF => 9 QDVJ", "179 ORE => 7 PSHF", "177 ORE => 5 HKGWZ", "7 DCFZ, 7 PSHF => 2 XJWVT", "165 ORE => 2 GPVTF", "3 DCFZ, 7 NZVS, 5 HKGWZ, 10 PSHF => 8 KHKGT"))
    assert(8 == reactions.reactions.size)
    assert(reactions.mix(problem14.Mixture("157 ORE")).get contains problem14.Mixture("5 NZVS"))
    assert(reactions.mix(problem14.Mixture("165 ORE")).get contains problem14.Mixture("6 DCFZ"))
    assert(reactions.mix(problem14.Mixture("44 XJWVT, 5 KHKGT, 1 QDVJ, 29 NZVS, 9 GPVTF, 48 HKGWZ")).get contains problem14.Mixture("1 FUEL"))
    assert(reactions.mix(problem14.Mixture("12 HKGWZ, 1 GPVTF, 8 PSHF")).get contains problem14.Mixture("9 QDVJ"))
    assert(reactions.mix(problem14.Mixture("179 ORE")).get contains problem14.Mixture("7 PSHF"))
    assert(reactions.mix(problem14.Mixture("177 ORE")).get contains problem14.Mixture("5 HKGWZ"))
    assert(reactions.mix(problem14.Mixture("7 DCFZ, 7 PSHF")).get contains problem14.Mixture("2 XJWVT"))
    assert(reactions.mix(problem14.Mixture("165 ORE")).get contains problem14.Mixture("2 GPVTF"))
    assert(reactions.mix(problem14.Mixture("3 DCFZ, 7 NZVS, 5 HKGWZ, 10 PSHF")).get contains problem14.Mixture("8 KHKGT"))
    assert(reactions.mix(problem14.Mixture("13312 ORE")).get contains problem14.Mixture("1 FUEL"))
  }

  "fourth example reactions" should "create fourth example products" in {
    val reactions = problem14.Factory(Seq("2 VPVL, 7 FWMGM, 2 CXFTF, 11 MNCFX => 1 STKFG", "17 NVRVD, 3 JNWZP => 8 VPVL", "53 STKFG, 6 MNCFX, 46 VJHF, 81 HVMC, 68 CXFTF, 25 GNMV => 1 FUEL", "22 VJHF, 37 MNCFX => 5 FWMGM", "139 ORE => 4 NVRVD", "144 ORE => 7 JNWZP", "5 MNCFX, 7 RFSQX, 2 FWMGM, 2 VPVL, 19 CXFTF => 3 HVMC", "5 VJHF, 7 MNCFX, 9 VPVL, 37 CXFTF => 6 GNMV", "145 ORE => 6 MNCFX", "1 NVRVD => 8 CXFTF", "1 VJHF, 6 MNCFX => 4 RFSQX", "176 ORE => 6 VJHF"))
    assert(12 == reactions.reactions.size)
    assert(reactions.mix(problem14.Mixture("2 VPVL, 7 FWMGM, 2 CXFTF, 11 MNCFX")).get contains problem14.Mixture("1 STKFG"))
    assert(reactions.mix(problem14.Mixture("17 NVRVD, 3 JNWZP")).get contains problem14.Mixture("8 VPVL"))
    assert(reactions.mix(problem14.Mixture("53 STKFG, 6 MNCFX, 46 VJHF, 81 HVMC, 68 CXFTF, 25 GNMV")).get contains problem14.Mixture("1 FUEL"))
    assert(reactions.mix(problem14.Mixture("22 VJHF, 37 MNCFX")).get contains problem14.Mixture("5 FWMGM"))
    assert(reactions.mix(problem14.Mixture("139 ORE")).get contains problem14.Mixture("4 NVRVD"))
    assert(reactions.mix(problem14.Mixture("144 ORE")).get contains problem14.Mixture("7 JNWZP"))
    assert(reactions.mix(problem14.Mixture("5 MNCFX, 7 RFSQX, 2 FWMGM, 2 VPVL, 19 CXFTF")).get contains problem14.Mixture("3 HVMC"))
    assert(reactions.mix(problem14.Mixture("5 VJHF, 7 MNCFX, 9 VPVL, 37 CXFTF")).get contains problem14.Mixture("6 GNMV"))
    assert(reactions.mix(problem14.Mixture("145 ORE")).get contains problem14.Mixture("6 MNCFX"))
    assert(reactions.mix(problem14.Mixture("1 NVRVD")).get contains problem14.Mixture("8 CXFTF"))
    assert(reactions.mix(problem14.Mixture("1 VJHF, 6 MNCFX")).get contains problem14.Mixture("4 RFSQX"))
    assert(reactions.mix(problem14.Mixture("176 ORE")).get contains problem14.Mixture("6 VJHF"))
    assert(reactions.mix(problem14.Mixture("180697 ORE")).get contains problem14.Mixture("1 FUEL"))
  }

  "fifth example reactions" should "create fifth example products" in {
    val reactions = problem14.Factory(Seq("171 ORE => 8 CNZTR", "7 ZLQW, 3 BMBT, 9 XCVML, 26 XMNCP, 1 WPTQ, 2 MZWV, 1 RJRHP => 4 PLWSL", "114 ORE => 4 BHXH", "14 VRPVC => 6 BMBT", "6 BHXH, 18 KTJDG, 12 WPTQ, 7 PLWSL, 31 FHTLT, 37 ZDVW => 1 FUEL", "6 WPTQ, 2 BMBT, 8 ZLQW, 18 KTJDG, 1 XMNCP, 6 MZWV, 1 RJRHP => 6 FHTLT", "15 XDBXC, 2 LTCX, 1 VRPVC => 6 ZLQW", "13 WPTQ, 10 LTCX, 3 RJRHP, 14 XMNCP, 2 MZWV, 1 ZLQW => 1 ZDVW", "5 BMBT => 4 WPTQ", "189 ORE => 9 KTJDG", "1 MZWV, 17 XDBXC, 3 XCVML => 2 XMNCP", "12 VRPVC, 27 CNZTR => 2 XDBXC", "15 KTJDG, 12 BHXH => 5 XCVML", "3 BHXH, 2 VRPVC => 7 MZWV", "121 ORE => 7 VRPVC", "7 XCVML => 6 RJRHP", "5 BHXH, 4 VRPVC => 5 LTCX"))
    assert(17 == reactions.reactions.size)
    assert(reactions.mix(problem14.Mixture("171 ORE")).get contains problem14.Mixture("8 CNZTR"))
    assert(reactions.mix(problem14.Mixture("7 ZLQW, 3 BMBT, 9 XCVML, 26 XMNCP, 1 WPTQ, 2 MZWV, 1 RJRHP")).get contains problem14.Mixture("4 PLWSL"))
    assert(reactions.mix(problem14.Mixture("114 ORE")).get contains problem14.Mixture("4 BHXH"))
    assert(reactions.mix(problem14.Mixture("14 VRPVC")).get contains problem14.Mixture("6 BMBT"))
    assert(reactions.mix(problem14.Mixture("6 BHXH, 18 KTJDG, 12 WPTQ, 7 PLWSL, 31 FHTLT, 37 ZDVW")).get contains problem14.Mixture("1 FUEL"))
    assert(reactions.mix(problem14.Mixture("6 WPTQ, 2 BMBT, 8 ZLQW, 18 KTJDG, 1 XMNCP, 6 MZWV, 1 RJRHP")).get contains problem14.Mixture("6 FHTLT"))
    assert(reactions.mix(problem14.Mixture("15 XDBXC, 2 LTCX, 1 VRPVC")).get contains problem14.Mixture("6 ZLQW"))
    assert(reactions.mix(problem14.Mixture("13 WPTQ, 10 LTCX, 3 RJRHP, 14 XMNCP, 2 MZWV, 1 ZLQW")).get contains problem14.Mixture("1 ZDVW"))
    assert(reactions.mix(problem14.Mixture("5 BMBT")).get contains problem14.Mixture("4 WPTQ"))
    assert(reactions.mix(problem14.Mixture("189 ORE")).get contains problem14.Mixture("9 KTJDG"))
    assert(reactions.mix(problem14.Mixture("1 MZWV, 17 XDBXC, 3 XCVML")).get contains problem14.Mixture("2 XMNCP"))
    assert(reactions.mix(problem14.Mixture("12 VRPVC, 27 CNZTR")).get contains problem14.Mixture("2 XDBXC"))
    assert(reactions.mix(problem14.Mixture("15 KTJDG, 12 BHXH")).get contains problem14.Mixture("5 XCVML"))
    assert(reactions.mix(problem14.Mixture("3 BHXH, 2 VRPVC")).get contains problem14.Mixture("7 MZWV"))
    assert(reactions.mix(problem14.Mixture("121 ORE")).get contains problem14.Mixture("7 VRPVC"))
    assert(reactions.mix(problem14.Mixture("7 XCVML")).get contains problem14.Mixture("6 RJRHP"))
    assert(reactions.mix(problem14.Mixture("5 BHXH, 4 VRPVC")).get contains problem14.Mixture("5 LTCX"))

    assert(reactions.mix(problem14.Mixture("2210736 ORE")).get contains problem14.Mixture("1 FUEL"))
  }
}
