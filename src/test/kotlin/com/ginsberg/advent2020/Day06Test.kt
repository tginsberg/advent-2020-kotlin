/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 6")
class Day06Test {

    // Arrange
    private val input = """
        abc

        a
        b
        c

        ab
        ac

        a
        a
        a
        a

        b
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day06(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(11)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day06(resourceAsText("day06.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(6_551)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day06(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(6)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day06(resourceAsText("day06.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(3_358)
        }
    }
}