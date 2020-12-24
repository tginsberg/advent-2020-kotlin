/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 24 - Lobby Layout
 * Problem Description: http://adventofcode.com/2020/day/24
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day24/
 */
package com.ginsberg.advent2020

class Day24(private val input: List<String>) {

    fun solvePart1(): Int =
        decorateFloor().size

    fun solvePart2(): Int =
        generateSequence(decorateFloor()) { it.nextFloor() }
            .drop(100)
            .first()
            .size

    private fun Set<Point3D>.nextFloor(): Set<Point3D> {
        val pointsToEvaluate = this + (this.flatMap { point -> point.hexNeighbors })
        return pointsToEvaluate.filter { tile ->
            val adjacentBlackTiles = tile.hexNeighbors.count { it in this }
            val black = tile in this
            when {
                black && (adjacentBlackTiles == 0 || adjacentBlackTiles > 2) -> false
                !black && adjacentBlackTiles == 2 -> true
                else -> black
            }
        }.toSet()
    }

    private fun decorateFloor(): Set<Point3D> =
        input
            .map { it.walkPath() }
            .groupBy { it }
            .filter { it.value.size % 2 == 1  }
            .keys

    private fun String.walkPath(): Point3D =
        splitPattern
            .findAll(this)
            .map { it.value }
            .fold(Point3D.ORIGIN) { last, dir ->
                last.hexNeighbor(dir)
            }

    companion object {
        private val splitPattern = "([ns]?[ew])".toRegex()
    }

}
