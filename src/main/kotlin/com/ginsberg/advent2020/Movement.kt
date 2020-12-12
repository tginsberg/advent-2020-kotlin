/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import kotlin.math.absoluteValue

sealed class Direction {
    abstract val turnLeft: Direction
    abstract val turnRight: Direction
    abstract val offset: Point2D

    operator fun invoke(dir: String): Direction =
        when (dir) {
            "N" -> North
            "S" -> South
            "E" -> East
            "W" -> West
            else -> throw IllegalArgumentException("No such direction $dir")
        }

    object North : Direction() {
        override val turnLeft = West
        override val turnRight = East
        override val offset = Point2D(-1, 0)
    }

    object South : Direction() {
        override val turnLeft = East
        override val turnRight = West
        override val offset = Point2D(1, 0)
    }

    object West : Direction() {
        override val turnLeft = South
        override val turnRight = North
        override val offset = Point2D(0, -1)
    }

    object East : Direction() {
        override val turnLeft = North
        override val turnRight = South
        override val offset = Point2D(0, 1)
    }
}


data class Point2D(val x: Int, val y: Int) {
    operator fun plus(other: Point2D): Point2D =
        Point2D(x + other.x, y + other.y)

    operator fun times(by: Int): Point2D =
        Point2D(x * by, y * by)

    infix fun distanceTo(other: Point2D): Int =
        (x - other.x).absoluteValue + (y - other.y).absoluteValue

    fun rotateLeft(): Point2D =
        Point2D(x = y * -1, y = x)

    fun rotateRight(): Point2D =
        Point2D(x = y, y = x * -1)

    companion object {
        val ORIGIN = Point2D(0, 0)
    }
}