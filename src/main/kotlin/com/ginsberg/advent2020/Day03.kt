/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 3 - Toboggan Trajectory
 * Problem Description: http://adventofcode.com/2020/day/3
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day3/
 */
package com.ginsberg.advent2020

class Day03(private val forest: List<String>) {

    private val width: Int = forest.first().length
    private val height: Int = forest.size

    fun solvePart1(): Int =
        treesOnSlope(3 to 1)

    fun solvePart2(): Long =
        listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
            .map { treesOnSlope(it).toLong() }
            .reduce { a, b -> a * b }

    private fun treesOnSlope(slope: Pair<Int,Int>) =
        path(slope).count { it in forest }

    private fun path(slope: Pair<Int,Int>): Sequence<Pair<Int, Int>> = generateSequence(Pair(0,0)) { prev ->
        (prev + slope).takeIf { next -> next.second < height }
    }

    private operator fun Pair<Int,Int>.plus(that: Pair<Int,Int>): Pair<Int,Int> =
        Pair(this.first+that.first, this.second+that.second)

    private operator fun List<String>.contains(location: Pair<Int, Int>): Boolean =
        this[location.second][location.first % width] == '#'
}