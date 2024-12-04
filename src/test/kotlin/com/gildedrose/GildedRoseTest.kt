package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.exp

internal class GildedRoseTest {

    @Test
    fun `GIVEN normal item with positive sellIn and quality WHEN updateQuality THEN sellIn and quality are decreased by 1`() {
        val expectedAfterUpdate = Item(name = "foo", sellIn = 9, quality = 49)
        val items = listOf(Item("foo", 10, 50))
        val app = GildedRose(items)
        
        app.updateQuality()
        
        assertEquals(expectedAfterUpdate, app.items[0])
    }

    @Test
    fun `GIVEN aged brie with positive sellIn and quality less than 50 WHEN updateQuality THEN sellIn is decreased and quality is increased by 1`() {
        val expectedAfterUpdate = Item(name = "Aged Brie", sellIn = 9, quality = 41)
        val items = listOf(Item("Aged Brie", 10, 40))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(expectedAfterUpdate, app.items[0])
    }

    @Test
    fun `GIVEN aged brie with positive sellIn and quality 50 WHEN updateQuality THEN sellIn is decreased and quality stays the same`() {
        val expectedAfterUpdate = Item(name = "Aged Brie", sellIn = 9, quality = 50)
        val items = listOf(Item("Aged Brie", 10, 50))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(expectedAfterUpdate, app.items[0])
    }

    @Test
    fun `GIVEN aged brie with negative sellIn and quality less than 50 WHEN updateQuality THEN sellIn is decreased and quality is increased by 2`() {
        val expectedAfterUpdate = Item(name = "Aged Brie", sellIn = -2, quality = 42)
        val items = listOf(Item("Aged Brie", -1, 40))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(expectedAfterUpdate, app.items[0])
    }

}


