/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

package com.ginsberg.advent2020

import java.io.File
import java.net.URI

internal object Resources {
    fun resourceAsString(fileName: String, delimiter: String = ""): String =
            resourceAsList(fileName).reduce { a, b -> "$a$delimiter$b" }

    fun resourceAsList(fileName: String): List<String> =
            File(fileName.toURI()).readLines()

    fun resourceAsListOfInt(fileName: String): List<Int> =
            resourceAsList(fileName).map { it.toInt() }

    private fun String.toURI(): URI =
            Resources.javaClass.classLoader.getResource(this)?.toURI() ?: throw IllegalArgumentException("Cannot find Resource: $this")
}

