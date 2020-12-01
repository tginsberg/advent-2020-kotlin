/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 1 - Report Repair
 * Problem Description: http://adventofcode.com/2020/day/1
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day1/
 */
package com.ginsberg.advent2020

class Day01(private val input: List<Int>) {

    fun solvePart1(): Int =
        input.asSequence().mapNotNull { a  ->
            input.asSequence().mapNotNull { b ->
                if(a+b == 2020) a*b else null
            }.firstOrNull()
        }.first()

    fun solvePart2(): Int =
            input.asSequence().mapNotNull { a  ->
                input.asSequence().mapNotNull { b ->
                    input.asSequence().mapNotNull { c ->
                        if(a+b+c == 2020) a*b*c else null
                    }.firstOrNull()
                }.firstOrNull()
            }.first()

}