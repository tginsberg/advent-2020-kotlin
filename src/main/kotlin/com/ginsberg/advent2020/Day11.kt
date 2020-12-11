/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 11 - Seating System
 * Problem Description: http://adventofcode.com/2020/day/11
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day11/
 */
package com.ginsberg.advent2020

typealias Seats = Array<CharArray>
typealias Seat = Pair<Int, Int>

class Day11(input: List<String>) {

    private val seats: Seats = input.map { it.toCharArray() }.toTypedArray()

    fun solvePart1(): Int =
        findStableMap(4, this::countImmediateNeighbors)

    fun solvePart2(): Int =
        findStableMap(5, this::countFarNeighbors)

    private fun findStableMap(tolerance: Int, countFunction: (Seats, Seat) -> Int): Int =
        generateSequence(seats) { it.next(tolerance, countFunction) }
            .zipWithNext()
            .first { it.first.contentDeepEquals(it.second) }
            .first
            .occupied()

    private fun Seats.next(tolerance: Int, countFunction: (Seats, Seat) -> Int): Seats =
        this.mapIndexed { x, row ->
            row.mapIndexed { y, spot ->
                val occupied = countFunction(this, Seat(x, y))
                when {
                    spot == 'L' && occupied == 0 -> '#'
                    spot == '#' && occupied >= tolerance -> 'L'
                    else -> spot
                }
            }.toCharArray()
        }.toTypedArray()

    private fun countImmediateNeighbors(seats: Seats, seat: Seat): Int =
        neighbors
            .map { it + seat }
            .filter { it in seats }
            .count { seats[it.first][it.second] == '#' }

    private fun countFarNeighbors(seats: Seats, seat: Seat): Int =
        neighbors
            .mapNotNull { findSeatOnVector(seats, seat, it) }
            .count { it == '#' }

    private fun findSeatOnVector(seats: Seats, seat: Seat, vector: Seat): Char? =
        generateSequence(seat + vector) { it + vector }
            .map { if (it in seats) seats[it.first][it.second] else null }
            .first { it == null || it != '.' }

    private fun Seats.occupied(): Int =
        this.sumBy { it.count { row -> row == '#' } }

    private operator fun Seats.contains(seat: Seat): Boolean =
        seat.first in this.indices && seat.second in this.first().indices

    private operator fun Seat.plus(that: Seat): Seat =
        Seat(this.first + that.first, this.second + that.second)

    companion object {
        // @formatter:off
        private val neighbors = sequenceOf(
            -1 to -1, -1 to 0, -1 to 1,
             0 to -1,           0 to 1,
             1 to -1,  1 to 0,  1 to 1
        )
        // @formatter:on
    }
}
