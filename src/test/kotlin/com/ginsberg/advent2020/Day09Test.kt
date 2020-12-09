/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsListOfLong
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 9")
class Day09Test {

    // Arrange
    private val input = listOf(
        35, 20, 15, 25, 47, 40, 62, 55, 65, 95, 102,
        117, 150, 182, 127, 219, 299, 277, 309, 576
    ).map { it.toLong() }

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day09(input).solvePart1(5)

            // Assert
            assertThat(answer).isEqualTo(127)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day09(resourceAsListOfLong("day09.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(1_721_308_972)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day09(input).solvePart2(5)

            // Assert
            assertThat(answer).isEqualTo(62)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day09(resourceAsListOfLong("day09.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(209_694_133)
        }
    }
}