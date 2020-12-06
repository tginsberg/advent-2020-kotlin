/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 6 - Custom Customs
 * Problem Description: http://adventofcode.com/2020/day/6
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day6/
 */
package com.ginsberg.advent2020

class Day06(input: String) {

    private val answers: List<List<String>> = input
        .split("\n\n")
        .map { it.lines().filter { line -> line.isNotBlank() } }

    fun solvePart1(): Int =
        answers.sumBy { it.joinToString("").toSet().size }

    fun solvePart2(): Int =
        answers.sumBy { group ->
            group
                .joinToString("")
                .groupingBy { it }
                .eachCount()
                .count { it.value == group.size }
        }
}


