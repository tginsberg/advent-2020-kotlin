/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day05Test {


    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        // Arrange
        private val input = mapOf(
            "BFFFBBFRRR" to 567,
            "FFFBBBFRRR" to 119,
            "BBFFBBFRLL" to 820
        )

        @Test
        fun `Matches examples`() {
            input.forEach { (key, expected) ->
                // Act
                val answer = Day05(listOf(key)).solvePart1()

                // Assert
                assertThat(answer).isEqualTo(expected)
            }
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day05(resourceAsList("day05.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(861)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Actual answer`() {
            // When
            val answer = Day05(resourceAsList("day05.txt")).solvePart2()

            // Then
            assertThat(answer).isEqualTo(633)
        }
    }
}
