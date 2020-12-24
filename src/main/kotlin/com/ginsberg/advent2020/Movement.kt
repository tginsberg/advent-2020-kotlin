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

interface Point {
    val neighbors: List<Point>
}

data class Point3D(val x: Int, val y: Int, val z: Int) : Point {
    override val neighbors: List<Point3D> by lazy {
        (x - 1..x + 1).flatMap { dx ->
            (y - 1..y + 1).flatMap { dy ->
                (z - 1..z + 1).mapNotNull { dz ->
                    Point3D(dx, dy, dz).takeUnless { it == this }
                }
            }
        }
    }

    val hexNeighbors: List<Point3D> by lazy {
        HEX_OFFSETS.map { this + it.value }
    }

    operator fun plus(other: Point3D): Point3D =
        Point3D(x + other.x, y + other.y, z + other.z)

    fun hexNeighbor(dir: String): Point3D =
        if (dir in HEX_OFFSETS) HEX_OFFSETS.getValue(dir) + this
        else throw IllegalArgumentException("No dir: $dir")

    companion object {
        val ORIGIN = Point3D(0, 0, 0)
        val HEX_OFFSETS = mapOf(
            "e" to Point3D(1, -1, 0),
            "w" to Point3D(-1, 1, 0),
            "ne" to Point3D(1, 0, -1),
            "nw" to Point3D(0, 1, -1),
            "se" to Point3D(0, -1, 1),
            "sw" to Point3D(-1, 0, 1),
        )
    }
}

data class Point4D(val x: Int, val y: Int, val z: Int, val w: Int) : Point {
    override val neighbors: List<Point4D> by lazy {
        (x - 1..x + 1).flatMap { dx ->
            (y - 1..y + 1).flatMap { dy ->
                (z - 1..z + 1).flatMap { dz ->
                    (w - 1..w + 1).mapNotNull { dw ->
                        Point4D(dx, dy, dz, dw).takeUnless { it == this }
                    }
                }
            }
        }
    }
}

