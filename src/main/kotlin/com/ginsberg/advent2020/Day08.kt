/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 8 - Handheld Halting
 * Problem Description: http://adventofcode.com/2020/day/8
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day8/
 */
package com.ginsberg.advent2020

class Day08(input: List<String>) {

    private val instructions: List<Instruction> = input.map { Instruction.of(it) }

    fun solvePart1(): Int =
        Computer(instructions).run {
            runUntilTerminate()
            accumulator
        }

    fun solvePart2(): Int =
        instructions
            .indices
            .asSequence()
            .mapNotNull { index -> instructions.flipIndexOrNull(index) }
            .mapNotNull { inst ->
                Computer(inst).run {
                    if (runUntilTerminate() == Computer.ExecutionState.HALTED) accumulator
                    else null
                }
            }.first()


    private fun List<Instruction>.flipIndexOrNull(index: Int): List<Instruction>? =
        this[index].flipOrNull()?.let { flipped ->
            this.toMutableList().apply { this[index] = flipped }
        }

    data class Instruction(val name: String, val argument: Int) {
        fun flipOrNull(): Instruction? =
            when (name) {
                "jmp" -> Instruction("nop", argument)
                "nop" -> Instruction("jmp", argument)
                else -> null
            }

        companion object {
            fun of(input: String): Instruction =
                input.split(" ").run {
                    Instruction(this.first(), this.last().toInt())
                }
        }
    }

    data class Computer(val instructions: List<Instruction>) {
        enum class ExecutionState {
            HALTED,
            INFINITE_LOOP,
            RUNNING
        }

        private val executed = mutableSetOf<Int>()
        private var instructionPointer: Int = 0
        var accumulator: Int = 0

        fun runUntilTerminate(): ExecutionState =
            generateSequence { executeStep() }.first { it != ExecutionState.RUNNING }

        private fun executeStep(): ExecutionState {
            return when (instructionPointer) {
                in executed -> ExecutionState.INFINITE_LOOP
                !in instructions.indices -> ExecutionState.HALTED
                else -> {
                    val current = instructions[instructionPointer]
                    executed += instructionPointer

                    when (current.name) {
                        "acc" -> {
                            accumulator += current.argument
                            instructionPointer += 1
                        }
                        "jmp" -> instructionPointer += current.argument
                        "nop" -> instructionPointer += 1
                    }
                    ExecutionState.RUNNING
                }
            }
        }
    }
}


