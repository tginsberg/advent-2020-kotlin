/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 12")
class Day12Test {

    // Arrange
    private val input = listOf(
        "F10",
        "N3",
        "F7",
        "R90",
        "F11"
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day12(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(25)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day12(resourceAsList("day12.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(1_838)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day12(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(286)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day12(resourceAsList("day12.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(89_936)
        }
    }
}