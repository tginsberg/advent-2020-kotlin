/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 13")
class Day13Test {

    // Arrange
    private val input = listOf(
        "939",
        "7,13,x,x,59,x,31,19"
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day13(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(295)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day13(resourceAsList("day13.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(2_045)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day13(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1_068_781L)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day13(resourceAsList("day13.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(402_251_700_208_309L)
        }
    }
}