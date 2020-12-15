/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 15 - Rambunctious Recitation
 * Problem Description: http://adventofcode.com/2020/day/15
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day15/
 */
package com.ginsberg.advent2020

class Day15(input: String) {

    private val startingNumbers = input.split(",").map { it.toInt() }

    fun solve(turns: Int): Int =
        memoryGame().drop(turns-1).first()

    private fun memoryGame(): Sequence<Int> = sequence {
        yieldAll(startingNumbers)
        val memory = startingNumbers.mapIndexed { index, i -> i to index }.toMap().toMutableMap()
        var turns = startingNumbers.size
        var sayNext = 0
        while(true) {
            yield(sayNext)
            val lastTimeSpoken = memory[sayNext] ?: turns
            memory[sayNext] = turns
            sayNext = turns - lastTimeSpoken
            turns++
        }
    }
}