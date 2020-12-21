/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 21")
class Day21Test {

    // Arrange
    private val input =
        """
        mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
        trh fvjkl sbzzf mxmxvkd (contains dairy)
        sqjhc fvjkl (contains soy)
        sqjhc mxmxvkd sbzzf (contains fish)
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day21(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(5)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day21(resourceAsList("day21.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(1_913)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day21(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo("mxmxvkd,sqjhc,fvjkl")
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day21(resourceAsList("day21.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo("gpgrb,tjlz,gtjmd,spbxz,pfdkkzp,xcfpc,txzv,znqbr")
        }
    }
}