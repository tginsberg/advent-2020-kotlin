/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020


fun Iterable<Long>.product(): Long =
    this.reduce { a, b -> a * b }

fun <T> Iterable<T>.sumToLongBy(fn: (T) -> Long): Long =
    this.fold(0L) { carry, next -> carry + fn(next) }

fun Char.asLong(): Long =
    this.toString().toLong()
