/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 9 - Encoding Error
 * Problem Description: http://adventofcode.com/2020/day/9
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day9/
 */
package com.ginsberg.advent2020

class Day09(private val input: List<Long>) {

    fun solvePart1(preamble: Int = 25): Long =
        input.windowed(preamble+1, 1, false).first { !it.preambleIsValid() }.last()

    fun solvePart2(preamble: Int = 25): Long {
        val target = solvePart1(preamble)
        val range = input.takeWhile { it != target }.findRangeSummingTo(target)
        return range.minOrNull()!! + range.maxOrNull()!!
    }

    private fun List<Long>.preambleIsValid(): Boolean {
        val target = this.last()
        val subjects = this.dropLast(1).toSet()
        return subjects.any { target - it in subjects }
    }

    private fun List<Long>.findRangeSummingTo(target: Long): List<Long> =
        this.indices.mapNotNull { start ->
            this.indices.drop(start+1).reversed().mapNotNull { end ->
                this.subList(start, end).takeIf { it.sum() == target }
            }.firstOrNull()
        }.first()
}


