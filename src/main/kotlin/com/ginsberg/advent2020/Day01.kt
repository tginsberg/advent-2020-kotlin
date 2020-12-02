/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 1 - Report Repair
 * Problem Description: http://adventofcode.com/2020/day/1
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day1/
 */
package com.ginsberg.advent2020

class Day01(data: List<Int>) {

    private val input = data.sorted()

    fun solvePart1(): Int =
        input.mapIndexedNotNull { idx, a ->
            input
                .drop(idx + 1)
                .dropWhile { a + it < 2020 }
                .take(1)
                .firstOrNull { a + it == 2020 }
                ?.let { a * it }
        }.first()

    fun solvePart2(): Int =
        input.mapIndexedNotNull { aIdx, a ->
            input
                .drop(aIdx + 1)
                .mapIndexedNotNull { bIdx, b ->
                    input
                        .drop(bIdx + 1)
                        .dropWhile { a + b + it < 2020 }
                        .take(1)
                        .firstOrNull { a + b + it == 2020 }
                        ?.let { a * b * it }
                }.firstOrNull()
        }.first()

}