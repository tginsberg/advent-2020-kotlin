/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 2 - Password Philosophy
 * Problem Description: http://adventofcode.com/2020/day/2
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day2/
 */
package com.ginsberg.advent2020

class Day02(input: List<String>) {

    private val data: List<PasswordRow> = input.map { PasswordRow.of(it) }

    fun solvePart1(): Int =
        data.count { it.validPart1 }

    fun solvePart2(): Int =
        data.count { it.validPart2 }

    data class PasswordRow(val range: IntRange, val letter: Char, val password: String) {

        val validPart1 = password.count { it == letter } in range

        val validPart2 = (password[range.first-1] == letter) xor (password[range.last-1] == letter)

        companion object {

            private val pattern = """^(\d+)-(\d+) (\w): (.+)$""".toRegex()

            fun of(input: String): PasswordRow {
                val (min, max, letter, password) = pattern.find(input)!!.destructured
                return PasswordRow(min.toInt() .. max.toInt(), letter.first(), password)
            }
        }
    }

}