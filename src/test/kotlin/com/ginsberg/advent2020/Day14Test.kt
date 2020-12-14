/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 14")
class Day14Test {

    // Arrange
    private val input = listOf(
        "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
        "mem[8] = 11",
        "mem[7] = 101",
        "mem[8] = 0"
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day14(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(165L)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day14(resourceAsList("day14.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(15_403_588_588_538L)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        // Arrange
        private val input = listOf(
            "mask = 000000000000000000000000000000X1001X",
            "mem[42] = 100",
            "mask = 00000000000000000000000000000000X0XX",
            "mem[26] = 1"
        )

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day14(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(208)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day14(resourceAsList("day14.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(3_260_587_250_457L)
        }
    }
}