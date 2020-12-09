/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

@file:Suppress("RedundantInnerClassModifier", "RedundantInnerClassModifier")

package com.ginsberg.advent2020

import com.ginsberg.advent2020.Resources.resourceAsList
import com.ginsberg.advent2020.Resources.resourceAsListOfInt
import com.ginsberg.advent2020.Resources.resourceAsListOfLong
import com.ginsberg.advent2020.Resources.resourceAsString
import com.ginsberg.advent2020.Resources.resourceAsText
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ResourcesTest {

    @Nested
    inner class ResourceAsStringTests {
        @Test
        fun `concatenates lines without delimiter`() {
            assertThat(resourceAsString("read_file_test_1.txt"))
                .isEqualTo("123")
        }

        @Test
        fun `concatenates lines with delimiter`() {
            assertThat(resourceAsString(fileName = "read_file_test_1.txt", delimiter = ":::"))
                .isEqualTo("1:::2:::3")
        }

        @Test
        fun `throws exception when file does not exist`() {
            assertThatThrownBy {
                resourceAsString("this_does_not_exist.txt", delimiter = "???")
            }.isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    @Nested
    inner class ResourceAsTextTests {
        @Test
        fun `reads file as-is into one String`() {
            assertThat(resourceAsText("read_file_test_1.txt"))
                .isEqualTo("""
                    1
                    2
                    3
                """.trimIndent())
        }
    }

    @Nested
    inner class ResourceAsListTests {
        @Test
        fun `reads lines`() {
            assertThat(resourceAsList("read_file_test_1.txt"))
                .hasSize(3)
                .containsExactly("1", "2", "3")
        }

        @Test
        fun `reads lines as Ints`() {
            assertThat(resourceAsListOfInt("read_file_test_1.txt"))
                    .hasSize(3)
                    .containsExactly(1, 2, 3)
        }

        @Test
        fun `reads lines as Longs`() {
            assertThat(resourceAsListOfLong("read_file_test_1.txt"))
                .hasSize(3)
                .containsExactly(1L, 2L, 3L)
        }

        @Test
        fun `throws exception when file does not exist`() {
            assertThatThrownBy {
                resourceAsList("this_does_not_exist.txt")
            }.isInstanceOf(IllegalArgumentException::class.java)
        }
    }

}