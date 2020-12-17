/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 17 - Conway Cubes
 * Problem Description: http://adventofcode.com/2020/day/17
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day17/
 */
package com.ginsberg.advent2020

class Day17(private val input: List<String>) {

    fun solvePart1() =
        solve { x, y ->
            Point3D(x, y, 0)
        }

    fun solvePart2(): Int =
        solve { x, y ->
            Point4D(x, y, 0, 0)
        }

    private fun solve(rounds: Int = 6, pointFunction: (Int, Int) -> Point): Int {
        var conwayGrid = parseInput(input, pointFunction)
        repeat(rounds) {
            conwayGrid = conwayGrid.nextCycle()
        }
        return conwayGrid.count { it.value }
    }

    private fun Map<Point, Boolean>.nextCycle(): Map<Point, Boolean> {
        val nextMap = this.toMutableMap()
        keys.forEach { point ->
            point.neighbors.forEach { neighbor ->
                nextMap.putIfAbsent(neighbor, false)
            }
        }
        nextMap.entries.forEach { (point, active) ->
            val activeNeighbors = point.neighbors.count { this.getOrDefault(it, false) }
            nextMap[point] = when {
                active && activeNeighbors in setOf(2, 3) -> true
                !active && activeNeighbors == 3 -> true
                else -> false
            }
        }
        return nextMap
    }

    private fun parseInput(input: List<String>, pointFunction: (Int, Int) -> Point): Map<Point, Boolean> =
        input.flatMapIndexed { x, row ->
            row.mapIndexed { y, point ->
                pointFunction(x, y) to (point == '#')
            }
        }.toMap()

}

