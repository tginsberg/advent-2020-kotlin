/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 25")
class Day25Test {

    // Arrange
    private val input =
        """
        5764801
        17807724
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day25(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(14897079L)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day25(resourceAsList("day25.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(8329514L)
        }
    }

}