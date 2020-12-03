/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 3")
class Day03Test {

    // Arrange
    private val input = listOf(
        "..##.......",
        "#...#...#..",
        ".#....#..#.",
        "..#.#...#.#",
        ".#...##..#.",
        "..#.##.....",
        ".#.#.#....#",
        ".#........#",
        "#.##...#...",
        "#...##....#",
        ".#..#...#.#"
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day03(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(7)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day03(resourceAsList("day03.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(167)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // When
            val answer = Day03(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(336L)
        }

        @Test
        fun `Actual answer`() {
            // When
            val answer = Day03(resourceAsList("day03.txt")).solvePart2()

            // Then
            assertThat(answer).isEqualTo(736_527_114L)
        }
    }
}