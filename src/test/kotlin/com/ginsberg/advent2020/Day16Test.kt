/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 16")
class Day16Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        // Arrange
        private val input =
            """
            class: 1-3 or 5-7
            row: 6-11 or 33-44
            seat: 13-40 or 45-50

            your ticket:
            7,1,14

            nearby tickets:
            7,3,47
            40,4,50
            55,2,20
            38,6,12
        """.trimIndent().lines()

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day16(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(71)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day16(resourceAsList("day16.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(21_978)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        // Arrange
        private val input =
            """
                departure a: 0-1 or 4-19
                row: 0-5 or 8-19
                departure b: 0-13 or 16-19

                your ticket:
                11,12,13

                nearby tickets:
                3,9,18
                15,1,5
                5,14,9
            """.trimIndent().lines()

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day16(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(156)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day16(resourceAsList("day16.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1053686852011L)
        }
    }
}