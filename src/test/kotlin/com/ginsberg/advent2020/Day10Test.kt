/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsListOfInt
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 10")
class Day10Test {

    // Arrange
    private val input = listOf(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4)

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day10(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(35)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day10(resourceAsListOfInt("day10.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(2_812)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day10(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(8)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day10(resourceAsListOfInt("day10.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(386_869_246_296_064L)
        }
    }
}