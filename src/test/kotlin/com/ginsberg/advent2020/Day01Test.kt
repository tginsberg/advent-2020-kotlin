/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsListOfInt
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day01Test {

    // Arrange
    private val input = listOf(1721, 979, 366, 299, 675, 1456)

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day01(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(514_579)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day01(resourceAsListOfInt("day01.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(181_044)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // When
            val answer = Day01(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(241_861_950)
        }

        @Test
        fun `Actual answer`() {
            // When
            val answer = Day01(resourceAsListOfInt("day01.txt")).solvePart2()

            // Then
            assertThat(answer).isEqualTo(82_660_352)
        }
    }
}