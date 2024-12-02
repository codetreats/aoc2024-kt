package net.codetreats.aoc.day02

import net.codetreats.aoc.util.Level
import net.codetreats.aoc.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class Day02Test {
    private lateinit var classUnderTest : Day02

    @BeforeEach
    fun setup() {
        Logger.level = Level.ERROR
        classUnderTest = Day02()
    }

    @Test
    fun testPart01() {
        assertEquals("282", classUnderTest.run1(false))
    }

    @Test
    fun testPart01_dummyData() {
        assertEquals("2", classUnderTest.run1(true))
    }

    @Test
    fun testPart02() {
        assertEquals("349", classUnderTest.run2(false))
    }

    @Test
    fun testPart02_dummyData() {
        assertEquals("4", classUnderTest.run2(true))
    }
}
