package com.github.cosminci.ec._2024

import com.github.cosminci.ec.utils

object Day1 {

  def main(args: Array[String]): Unit = {
    println(s"Part 1: ${countPotionsNeeded1(utils.loadInputAsStrings("2024/day1/part1.txt").head)}")
    println(s"Part 2: ${countPotionsNeeded2(utils.loadInputAsStrings("2024/day1/part2.txt").head)}")
    println(s"Part 3: ${countPotionsNeeded3(utils.loadInputAsStrings("2024/day1/part3.txt").head)}")
  }

  def countPotionsNeeded1(creatures: String): Int =
    creatures.map(potionsNeeded).sum

  def countPotionsNeeded2(creatures: String): Int =
    creatures.grouped(2).map { pair =>
      if (pair.contains('x')) pair.map(potionsNeeded).sum
      else pair.map(potionsNeeded).sum + 2
    }.sum

  def countPotionsNeeded3(creatures: String): Int =
    creatures.grouped(3).map { triple =>
      if (triple.count(_ == 'x') == 0) triple.map(potionsNeeded).sum + 6
      else if (triple.count(_ == 'x') == 1) triple.map(potionsNeeded).sum + 2
      else triple.map(potionsNeeded).sum
    }.sum

  private def potionsNeeded(creature: Char) = creature match {
    case 'A' => 0
    case 'B' => 1
    case 'C' => 3
    case 'D' => 5
    case 'x' => 0
  }

}
