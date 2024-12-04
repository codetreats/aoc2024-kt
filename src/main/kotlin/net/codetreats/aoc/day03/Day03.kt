package net.codetreats.aoc.day03

import net.codetreats.aoc.Day
import net.codetreats.aoc.util.Logger

class Day03 : Day<String>(3) {
    private val mul = "^mul\\([1-9][0-9]?[0-9]?,[1-9][0-9]?[0-9]?\\).*\$".toRegex()
    private val splitter = Regex("(?=(do\\(\\)|don't\\(\\)|mul))")

    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): String = input.joinToString("")

    override fun run1(data: String): String = splitter.split(data).sumOf { it.asMul() }.toString()

    override fun run2(data: String): String {
        var enabled = true
        var sum = 0
        splitter.split(data).forEach { part ->
            if (part.startsWith("do()")) {
                enabled = true
            }
            if (part.startsWith("don't()")) {
                enabled = false
            }
            if (enabled) {
                sum += part.asMul()
            }
        }
        return sum.toString()
    }

    private fun String.asMul() : Int {
        if (!matches(mul)) {
            return 0
        }
        val parts = substring(3).split("(",",",")")
        return parts[1].toInt() * parts[2].toInt()
    }
}