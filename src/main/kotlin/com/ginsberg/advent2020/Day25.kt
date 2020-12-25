/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 25 - Combo Breaker
 * Problem Description: http://adventofcode.com/2020/day/25
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day25/
 */
package com.ginsberg.advent2020

class Day25(input: List<String>) {

    private val cardPk = input.first().toLong()
    private val doorPk = input.last().toLong()

    fun solvePart1(): Long =
        transform(findLoopSize(cardPk), doorPk)

    private fun transform(loopSize: Int, subject: Long): Long =
        generateSequence(1L) { it.mathPart(subject) }.drop(loopSize).first()

    private fun findLoopSize(target: Long): Int =
        generateSequence(1L) { it.mathPart() }.indexOf(target)

    private fun Long.mathPart(subject: Long = 7): Long =
        this * subject % 20201227
}

