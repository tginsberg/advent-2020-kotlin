/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 13 - Shuttle Search
 * Problem Description: http://adventofcode.com/2020/day/13
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day13/
 */
package com.ginsberg.advent2020

class Day13(input: List<String>) {

    private val startTime: Int = input.first().toInt()
    private val busses: List<Int> = input
        .last()
        .split(",")
        .mapNotNull { s -> if (s == "x") null else s.toInt() }

    private val indexedBusses: List<IndexedBus> = input
        .last()
        .split(",")
        .mapIndexedNotNull { index, s -> if (s == "x") null else IndexedBus(index, s.toLong()) }

    fun solvePart1(): Int =
        generateSequence(startTime) { it + 1 }
            .mapNotNull { time ->
                busses
                    .firstOrNull { bus -> time % bus == 0 }
                    ?.let { bus -> Pair(time, bus) }
            }
            .first()
            .run { (first - startTime) * second }

    fun solvePart2(): Long {
        var stepSize = indexedBusses.first().bus
        var time = 0L
        indexedBusses.drop(1).forEach { (offset, bus) ->
            while ((time + offset) % bus != 0L) {
                time += stepSize
            }
            stepSize *= bus // New Ratio!
        }
        return time
    }

    data class IndexedBus(val index: Int, val bus: Long)
}
