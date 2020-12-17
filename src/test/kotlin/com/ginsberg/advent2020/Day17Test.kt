/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 17")
class Day17Test {

    // Arrange
    private val input =
        """
            .#.
            ..#
            ###
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day17(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(112)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day17(resourceAsList("day17.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(380)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day17(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(848)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day17(resourceAsList("day17.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(2_332)
        }
    }
}