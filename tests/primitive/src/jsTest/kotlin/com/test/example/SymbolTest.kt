package com.test.example

import js.core.Symbol
import kotlin.test.Test
import kotlin.test.assertIs
import kotlin.test.assertIsNot

class SymbolTest {
    @Test
    fun isForWellKnownSymbol() {
        val s: Any = Symbol.hasInstance

        assertIs<Symbol>(s)
    }

    @Test
    fun isForCustomSymbol() {
        val s: Any = Symbol("custom.symbol")

        assertIs<Symbol>(s)
    }

    @Test
    fun isForObject() {
        val a = Any()

        assertIsNot<Symbol>(a)
    }

    @Test
    fun isForString() {
        val a: Any = "symbol"

        assertIsNot<Symbol>(a)
    }
}
