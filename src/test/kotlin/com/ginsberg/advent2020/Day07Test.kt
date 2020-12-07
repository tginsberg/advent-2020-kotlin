/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 7")
class Day07Test {

    // Arrange
    private val input = listOf(
        "light red bags contain 1 bright white bag, 2 muted yellow bags.",
        "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
        "bright white bags contain 1 shiny gold bag.",
        "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
        "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
        "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
        "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
        "faded blue bags contain no other bags.",
        "dotted black bags contain no other bags."
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day07(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(4)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day07(resourceAsList("day07.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(101)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example 1`() {
            // Act
            val answer = Day07(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(32)
        }

        @Test
        fun `Matches example 2`() {
            // Arrange
            val input = listOf(
                "shiny gold bags contain 2 dark red bags.",
                "dark red bags contain 2 dark orange bags.",
                "dark orange bags contain 2 dark yellow bags.",
                "dark yellow bags contain 2 dark green bags.",
                "dark green bags contain 2 dark blue bags.",
                "dark blue bags contain 2 dark violet bags.",
                "dark violet bags contain no other bags."
            )

            // Act
            val answer = Day07(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(126)
        }


        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day07(resourceAsList("day07.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(108_636)
        }
    }
}