package com.test.example

import kotlin.test.Test

class TopPropertyFromOtherModuleTest {
    @Test
    fun test() {
        assertEquals("arrow", Arrow)
    }

    @Test
    fun testReassign() {
        assertEquals("arrow", MyArrow)
    }
}
