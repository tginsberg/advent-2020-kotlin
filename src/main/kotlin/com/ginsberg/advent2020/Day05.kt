/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 5 - Binary Boarding
 * Problem Description: http://adventofcode.com/2020/day/5
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day5/
 */
package com.ginsberg.advent2020

class Day05(private val input: List<String>) {

    fun solvePart1(): Int =
        input.map { seatId(it) }.maxOrNull() ?: throw IllegalStateException("No answer")

    fun solvePart2(): Int =
        input.map { seatId(it) }.sorted().zipWithNext().first { it.second - it.first != 1 }.first + 1

    private fun seatId(pattern: String): Int =
        pattern.map { if (it in setOf('B', 'R')) '1' else '0' }.joinToString("").toInt(2)
}


