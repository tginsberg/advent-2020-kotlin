/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 8")
class Day08Test {

    // Arrange
    private val input = listOf(
        "nop +0",
        "acc +1",
        "jmp +4",
        "acc +3",
        "jmp -3",
        "acc -99",
        "acc +1",
        "jmp -4",
        "acc +6"
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day08(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(5)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day08(resourceAsList("day08.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(1_134)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day08(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(8)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day08(resourceAsList("day08.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1_205)
        }
    }
}