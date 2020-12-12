/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 12 - Rain Risk
 * Problem Description: http://adventofcode.com/2020/day/12
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day12/
 */
package com.ginsberg.advent2020

class Day12(private val input: List<String>) {

    fun solvePart1(): Int =
        input.fold(Ship(Point2D.ORIGIN, Direction.East)) { ship, instruction ->
            val command = instruction.first()
            val amount = instruction.substring(1).toInt()
            when (command) {
                'N' -> ship.move(Direction.North, amount)
                'S' -> ship.move(Direction.South, amount)
                'E' -> ship.move(Direction.East, amount)
                'W' -> ship.move(Direction.West, amount)
                'F' -> ship.forward(amount)
                'L' -> ship.turnLeft(amount / 90)
                'R' -> ship.turnRight(amount / 90)
                else -> throw IllegalArgumentException("Unknown instruction: $instruction")
            }
        }.at distanceTo Point2D.ORIGIN

    fun solvePart2(): Int {
        var waypoint = Waypoint()
        var ship = Ship()
        input.forEach { instruction ->
            val command = instruction.first()
            val amount = instruction.substring(1).toInt()
            when (command) {
                'N' -> waypoint = waypoint.move(Direction.North, amount)
                'S' -> waypoint = waypoint.move(Direction.South, amount)
                'E' -> waypoint = waypoint.move(Direction.East, amount)
                'W' -> waypoint = waypoint.move(Direction.West, amount)
                'F' -> ship = ship.copy(at = ship.at + (waypoint.at * amount))
                'L' -> waypoint = waypoint.turnLeft(amount / 90)
                'R' -> waypoint = waypoint.turnRight(amount / 90)
                else -> throw IllegalArgumentException("Unknown instruction: $instruction")
            }
        }
        return Point2D.ORIGIN distanceTo ship.at
    }


    data class Waypoint(val at: Point2D = Point2D(-1, 10)) {
        fun move(dir: Direction, amount: Int): Waypoint =
            Waypoint(at + (dir.offset * amount))

        fun turnLeft(amount: Int): Waypoint =
            (0 until amount).fold(this) { carry, _ ->
                Waypoint(carry.at.rotateLeft())
            }

        fun turnRight(amount: Int): Waypoint =
            (0 until amount).fold(this) { carry, _ ->
                Waypoint(carry.at.rotateRight())
            }
    }

    data class Ship(val at: Point2D = Point2D.ORIGIN, val facing: Direction = Direction.East) {

        fun forward(amount: Int): Ship =
            copy(at = at + (facing.offset * amount))

        fun move(dir: Direction, amount: Int): Ship =
            copy(at = at + (dir.offset * amount))

        fun turnLeft(times: Int): Ship =
            (0 until times).fold(this) { carry, _ ->
                carry.copy(facing = carry.facing.turnLeft)
            }

        fun turnRight(times: Int): Ship =
            (0 until times).fold(this) { carry, _ ->
                carry.copy(facing = carry.facing.turnRight)
            }
    }
}