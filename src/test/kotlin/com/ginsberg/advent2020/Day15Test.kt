/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 15")
class Day15Test {

    // Arrange
    private val input = "0,3,6"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day15(input).solve(2020)

            // Assert
            assertThat(answer).isEqualTo(436)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day15(resourceAsString("day15.txt")).solve(2020)

            // Assert
            assertThat(answer).isEqualTo(1_373)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day15(resourceAsString("day15.txt")).solve(30_000_000)

            // Assert
            assertThat(answer).isEqualTo(112_458)
        }
    }
}