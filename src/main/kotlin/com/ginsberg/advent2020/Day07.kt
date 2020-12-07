/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 7 - Handy Haversacks
 * Problem Description: http://adventofcode.com/2020/day/7
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day7/
 */
package com.ginsberg.advent2020

class Day07(input: List<String>) {

    private val relationships: Set<BagRule> = parseInput(input)

    fun solvePart1(): Int =
        findParents().size - 1

    fun solvePart2(): Int =
        baggageCost() - 1

    private fun findParents(bag: String = "shiny gold"): Set<String> =
        relationships
            .filter { it.child == bag }
            .flatMap { findParents(it.parent) }.toSet() + bag

    private fun baggageCost(bag: String = "shiny gold"): Int =
        relationships
            .filter { it.parent == bag }
            .sumBy { it.cost * baggageCost(it.child) } + 1

    private fun parseInput(input: List<String>): Set<BagRule> =
        input.filterNot { it.contains("no other") }.flatMap { row ->
            val parts = row.replace(unusedText, "").split(whitespace)
            val parent = parts.take(2).joinToString(" ")
            parts.drop(2).windowed(3, 3, false).map { child ->
                BagRule(
                    parent,
                    child.first().toInt(),
                    child.drop(1).joinToString(" ")
                )
            }
        }.toSet()

    private data class BagRule(val parent: String, val cost: Int, val child: String)

    companion object {
        private val unusedText = """bags|bag|contain|,|\.""".toRegex()
        private val whitespace = """\s+""".toRegex()
    }
}


