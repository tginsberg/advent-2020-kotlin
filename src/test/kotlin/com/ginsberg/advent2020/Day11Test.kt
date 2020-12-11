/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 11")
class Day11Test {

    // Arrange
    private val input = listOf(
        "L.LL.LL.LL",
        "LLLLLLL.LL",
        "L.L.L..L..",
        "LLLL.LL.LL",
        "L.LL.LL.LL",
        "L.LLLLL.LL",
        "..L.L.....",
        "LLLLLLLLLL",
        "L.LLLLLL.L",
        "L.LLLLL.LL"
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day11(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(37)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day11(resourceAsList("day11.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(2_406)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day11(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(26)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day11(resourceAsList("day11.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(2_149)
        }
    }
}