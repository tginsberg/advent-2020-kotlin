/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 18 - Operation Order
 * Problem Description: http://adventofcode.com/2020/day/18
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day18/
 */
package com.ginsberg.advent2020

class Day18(input: List<String>) {

    private val equations = input.map { it.replace(" ", "") }

    fun solvePart1(): Long =
        equations.sumToLongBy { solvePart1(it.iterator()) }

    fun solvePart2(): Long =
        equations.sumToLongBy { solvePart2(it.iterator()) }

    private fun solvePart1(equation: CharIterator): Long {
        val numbers = mutableListOf<Long>()
        var op = '+'
        while (equation.hasNext()) {
            when (val next = equation.nextChar()) {
                '(' -> numbers += solvePart1(equation)
                ')' -> break
                in setOf('+', '*') -> op = next
                else -> numbers += next.asLong()
            }
            if (numbers.size == 2) {
                val a = numbers.removeLast()
                val b = numbers.removeLast()
                numbers += if (op == '+') a + b else a * b
            }
        }
        return numbers.first()
    }

    private fun solvePart2(equation: CharIterator): Long {
        val multiplyThese = mutableListOf<Long>()
        var added = 0L
        while (equation.hasNext()) {
            val next = equation.nextChar()
            when {
                next == '(' -> added += solvePart2(equation)
                next == ')' -> break
                next == '*' -> {
                    multiplyThese += added
                    added = 0L
                }
                next.isDigit() -> added += next.asLong()
            }
        }
        return (multiplyThese + added).product()
    }

}
