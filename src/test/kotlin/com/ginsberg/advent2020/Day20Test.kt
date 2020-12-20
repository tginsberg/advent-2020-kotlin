/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 20")
class Day20Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day20(resourceAsText("day20_test.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(20_899_048_083_289L)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day20(resourceAsText("day20.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(51_214_443_014_783L)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day20(resourceAsText("day20_test.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(273)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day20(resourceAsText("day20.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(2_065)
        }
    }
}