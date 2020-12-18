/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020


fun Iterable<Long>.product(): Long =
    this.reduce { a, b -> a * b }

fun Char.asLong(): Long =
    this.toString().toLong()
