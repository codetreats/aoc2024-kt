package net.codetreats.aoc.day01

import net.codetreats.aoc.Day
import net.codetreats.aoc.util.Logger
import java.util.stream.IntStream
import kotlin.math.abs

class Day01 : Day<List<Pair<Int, Int>>>(1) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): List<Pair<Int, Int>> =
        input.map { it.split("\\s+".toRegex()) }.map { Pair(it[0].toInt(), it[1].toInt()) }

    override fun run1(data: List<Pair<Int, Int>>): String = run(data) { index, list1, list2 ->
        abs(list1[index] - list2[index])
    }


    override fun run2(data: List<Pair<Int, Int>>): String = run(data) { index, list1, list2 ->
        list1[index] * list2.count { it == list1[index] }
    }

    private fun run(data: List<Pair<Int, Int>>, loopAction: (index: Int, list1: List<Int>, list2: List<Int>) -> Int) : String {
        val list1 = data.map { it.first }.sorted()
        val list2 = data.map { it.second }.sorted()
        return data.indices.sumOf { i -> loopAction.invoke(i, list1, list2) }.toString()
    }
}