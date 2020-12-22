/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertTimeout
import java.time.Duration

@DisplayName("Day 22")
class Day22Test {

    // Arrange
    private val input =
        """
        Player 1:
        9
        2
        6
        3
        1

        Player 2:
        5
        8
        4
        7
        10
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day22(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(306)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day22(resourceAsList("day22.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(33_421)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day22(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(291)
        }

        @Test
        fun `Infinite loop guard works`() {
            // Arrange
            val input =
                """
                Player 1:
                43
                19
                
                Player 2:
                2
                29
                14
                """.trimIndent().lines()

            // Act/Assert
            assertTimeout(Duration.ofSeconds(2)) {
                Day22(input).solvePart2()
            }
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day22(resourceAsList("day22.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(33_651)
        }
    }
}