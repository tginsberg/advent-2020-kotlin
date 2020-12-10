/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 10 - Adapter Array
 * Problem Description: http://adventofcode.com/2020/day/10
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day10/
 */
package com.ginsberg.advent2020

class Day10(input: List<Int>) {

    private val adapters: List<Int> = input.plus(0).plus(input.maxOrNull()!! + 3).sorted()

    fun solvePart1(): Int =
        adapters
            .asSequence()
            .zipWithNext()
            .map { it.second - it.first }
            .groupingBy { it }
            .eachCount()
            .run {
                getOrDefault(1, 1) * getOrDefault(3, 1)
            }

    fun solvePart2(): Long {
        val pathsByAdapter: MutableMap<Int,Long> = mutableMapOf(0 to 1L)

        adapters.drop(1).forEach { adapter ->
            pathsByAdapter[adapter] = (1 .. 3).map { lookBack ->
                pathsByAdapter.getOrDefault(adapter - lookBack, 0)
            }.sum()
        }

        return pathsByAdapter.getValue(adapters.last())
    }

}


