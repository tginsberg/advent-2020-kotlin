/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 22 - Crab Combat
 * Problem Description: http://adventofcode.com/2020/day/22
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day22/
 */
package com.ginsberg.advent2020

import java.util.Objects

typealias Deck = MutableList<Int>

class Day22(input: List<String>) {

    private val deck1: Deck = input.drop(1).takeWhile { it.isNotBlank() }.map { it.toInt() }.toMutableList()
    private val deck2: Deck = input.dropWhile { it.isNotBlank() }.drop(2).map { it.toInt() }.toMutableList()

    fun solvePart1(): Int =
        playUntilWinner().score()

    fun solvePart2(): Int =
        playUntilWinner(true).score()

    private fun playUntilWinner(allowRecursive: Boolean = false): Deck =
        if (playGame(deck1, deck2, allowRecursive)) deck1 else deck2

    private fun playGame(deckA: Deck, deckB: Deck, allowRecursive: Boolean): Boolean {
        val history = mutableSetOf(Objects.hash(deckA, deckB))
        deckA.pairedWith(deckB).forEach { (a, b) ->
            val winner = when {
                allowRecursive && deckA.size >= a && deckB.size >= b ->
                    playGame(
                        deckA.take(a).toMutableList(),
                        deckB.take(b).toMutableList(),
                        true
                    )
                else -> a > b
            }
            if (winner) deckA.addAll(listOf(a, b)) else deckB.addAll(listOf(b, a))

            if(allowRecursive) {
                Objects.hash(deckA, deckB).also {
                    if (it in history) return true else history += it
                }
            }
        }
        return deckA.isNotEmpty()
    }

    private fun Deck.score(): Int =
        this.foldIndexed(0) { index, acc, current -> acc + (current * (size - index)) }

    private fun Deck.pairedWith(other: Deck): Sequence<Pair<Int, Int>> = sequence {
        while (this@pairedWith.isNotEmpty() && other.isNotEmpty()) {
            yield(Pair(this@pairedWith.removeFirst(), other.removeFirst()))
        }
    }
}
