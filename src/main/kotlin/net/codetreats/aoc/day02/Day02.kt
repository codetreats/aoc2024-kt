package net.codetreats.aoc.day02

import net.codetreats.aoc.Day
import net.codetreats.aoc.util.Logger
import kotlin.math.sign

class Day02 : Day<List<List<Int>>>(2) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): List<List<Int>> =
        input.map { line -> line.split("\\s+".toRegex()).map { it.toInt() } }

    override fun run1(data: List<List<Int>>): String = data.count { report -> report.isSafe() }.toString()

    override fun run2(data: List<List<Int>>): String = data.count { report -> report.generateSubsets().any { it.isSafe() } }.toString()

    private fun List<Int>.isSafe(): Boolean {
        val sign = sign(get(0).toDouble() - get(1).toDouble()).toInt()
        for (i in 1 until size) {
            val diff = (get(i - 1) - get(i)) * sign
            if (diff !in 1..3) {
                return false
            }
        }
        return true
    }

    private fun List<Int>.generateSubsets(): List<List<Int>> = indices.map { index ->
        filterIndexed { i, _ -> i != index }
    }
}