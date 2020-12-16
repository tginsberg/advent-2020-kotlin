/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 16 - Ticket Translation
 * Problem Description: http://adventofcode.com/2020/day/16
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day16/
 */
package com.ginsberg.advent2020

class Day16(input: List<String>) {

    private val ticketRules: Map<String,List<IntRange>> = parseTicketRules(input)
    private val allRuleRanges: List<IntRange> = ticketRules.values.flatten()
    private val ourTicket: List<Int> = parseOurTicket(input)
    private val nearbyTickets: List<List<Int>> = parseNearbyTickets(input)
    
    fun solvePart1(): Int =
        nearbyTickets.sumBy { ticket ->
            ticket.filter { field ->
                allRuleRanges.none { rule -> field in rule }
            }.sum()
        }

    fun solvePart2(): Long {
        val validTickets = nearbyTickets.filter { it.isValidTicket() }

        val possibleFieldRules: Map<String,MutableSet<Int>> = ticketRules.keys.map { rule ->
            rule to ourTicket.indices.filter { column ->
                validTickets.columnPassesRule(column, rule)
            }.toMutableSet()
        }.toMap()

        val foundRules = reduceRules(possibleFieldRules)

        return foundRules.entries
            .filter { it.key.startsWith("departure") }
            .map { ourTicket[it.value].toLong() }
            .reduce { a, b -> a * b }
    }

    private fun reduceRules(possibleRules: Map<String,MutableSet<Int>>): Map<String,Int> {
        val foundRules = mutableMapOf<String,Int>()
        while(foundRules.size < possibleRules.size) {
            possibleRules.entries
                .filter { (_, possibleValues) -> possibleValues.size == 1 }
                .forEach { (rule, possibleValues) ->
                    val columnNumber = possibleValues.first()
                    foundRules[rule] = columnNumber
                    possibleRules.values.forEach { it.remove(columnNumber) }
                }
        }
        return foundRules
    }

    private fun List<List<Int>>.columnPassesRule(column: Int, fieldName: String): Boolean =
        this.all { ticket ->
            ticketRules.getValue(fieldName).any { rule -> ticket[column] in rule }
        }

    private fun List<Int>.isValidTicket(): Boolean =
        this.all { field ->
            allRuleRanges.any { rule ->
                field in rule
            }
        }

    private fun parseTicketRules(input: List<String>): Map<String,List<IntRange>> =
        input.takeWhile { it.isNotEmpty() }.map { line ->
            val (name, start1, end1, start2, end2) = ticketRuleRegex.matchEntire(line)!!.destructured
            name to listOf(
                start1.toInt() .. end1.toInt(),
                start2.toInt() .. end2.toInt()
            )
        }.toMap()

    private fun parseOurTicket(input: List<String>): List<Int> =
        input.dropWhile { it != "your ticket:" }.drop(1).first().split(",").map { it.toInt() }

    private fun parseNearbyTickets(input: List<String>): List<List<Int>> =
        input.dropWhile { it != "nearby tickets:" }.drop(1).map { row ->
            row.split(",").map { it.toInt() }
        }

    companion object {
        private val ticketRuleRegex = """^([a-z ]+): (\d+)-(\d+) or (\d+)-(\d+)$""".toRegex()
    }

}

