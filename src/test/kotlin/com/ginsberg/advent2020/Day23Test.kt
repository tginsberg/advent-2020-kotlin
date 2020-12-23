/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 23")
class Day23Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example - 10 moves`() {
            // Act
            val answer = Day23("389125467").solvePart1(10)

            // Assert
            assertThat(answer).isEqualTo("92658374")
        }

        @Test
        fun `Matches example - 100 moves`() {
            // Act
            val answer = Day23("389125467").solvePart1(100)

            // Assert
            assertThat(answer).isEqualTo("67384529")
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day23("219748365").solvePart1(100)

            // Assert
            assertThat(answer).isEqualTo("35827964")
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day23("389125467").solvePart2(10_000_000)

            // Assert
            assertThat(answer).isEqualTo(149245887792)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day23("219748365").solvePart2(10_000_000)

            // Assert
            assertThat(answer).isEqualTo(540_3610_688L)
        }
    }
}