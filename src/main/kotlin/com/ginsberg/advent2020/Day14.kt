/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 14 - Docking Data
 * Problem Description: http://adventofcode.com/2020/day/14
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day14/
 */
package com.ginsberg.advent2020

class Day14(private val input: List<String>) {

    private val memory: MutableMap<Long, Long> = mutableMapOf()

    fun solvePart1(): Long {
        var mask = DEFAULT_MASK
        input.forEach { instruction ->
            if (instruction.startsWith("mask")) {
                mask = instruction.substringAfter("= ")
            } else {
                val address = instruction.substringAfter("[").substringBefore("]").toLong()
                val value = instruction.substringAfter("= ")
                memory[address] = value maskedWith mask
            }
        }

        return memory.values.sum()
    }

    fun solvePart2(): Long {
        var mask = DEFAULT_MASK
        input.forEach { instruction ->
            if (instruction.startsWith("mask")) {
                mask = instruction.substringAfter("= ")
            } else {
                val unmaskedAddress = instruction.substringAfter("[").substringBefore("]")
                val value = instruction.substringAfter("= ").toLong()
                unmaskedAddress.generateAddressMasks(mask).forEach { address ->
                    memory[address] = value
                }

            }
        }

        return memory.values.sum()
    }

    private infix fun String.maskedWith(mask: String): Long =
        this.toBinary().zip(mask).map { (valueChar, maskChar) ->
            maskChar.takeUnless { it == 'X' } ?: valueChar
        }.joinToString("").toLong(2)

    private fun String.toBinary(): String =
        this.toLong().toString(2).padStart(36, '0')

    private fun String.generateAddressMasks(mask: String): List<Long> {
        val addresses = mutableListOf(this.toBinary().toCharArray())
        mask.forEachIndexed { idx, bit ->
            when (bit) {
                '1' -> addresses.forEach { it[idx] = '1' }
                'X' -> {
                    addresses.forEach { it[idx] = '1' }
                    addresses.addAll(
                        addresses.map {
                            it.copyOf().apply {
                                this[idx] = '0'
                            }
                        }
                    )
                }
            }
        }
        return addresses.map { it.joinToString("").toLong(2) }
    }

    companion object {
        const val DEFAULT_MASK = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
    }
}

