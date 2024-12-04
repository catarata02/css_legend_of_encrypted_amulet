package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {
    
    @Test
    fun `GIVEN normal item with positive sellIn and quality WHEN updateQuality THEN sellIn and quality are decreased by 1`() {
        val expectedAfterUpdate = createNormalItem(9, 49)
        val items = listOf(createNormalItem(10, 50))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(expectedAfterUpdate, app.items[0])
    }

    @Test
    fun `GIVEN aged brie with positive sellIn and quality less than 50 WHEN updateQuality THEN sellIn is decreased and quality is increased by 1`() {
        val expectedAfterUpdate = createAgedBrie(9, 41)
        val items = listOf(createAgedBrie(10, 40))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(expectedAfterUpdate, app.items[0])
    }

    @Test
    fun `GIVEN aged brie with positive sellIn and quality 50 WHEN updateQuality THEN sellIn is decreased and quality stays the same`() {
        val expectedAfterUpdate = createAgedBrie(9, 50)
        val items = listOf(createAgedBrie(10, 50))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(expectedAfterUpdate, app.items[0])
    }

    @Test
    fun `GIVEN aged brie with negative sellIn and quality less than 50 WHEN updateQuality THEN sellIn is decreased and quality is increased by 2`() {
        val expectedAfterUpdate = createAgedBrie(-2, 42)
        val items = listOf(createAgedBrie(-1, 40))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(expectedAfterUpdate, app.items[0])
    }

    @Test
    fun `GIVEN Backstage passes to a TAFKAL80ETC concert with sellIn above 11 and quality less than 50 WHEN updateQuality THEN sellIn is decreased and quality is increased by 1`() {
        val expectedAfterUpdate = createBackstageItem(sellIn = 15, quality = 42)
        val items = listOf(createBackstageItem( 16, 41))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(expectedAfterUpdate, app.items[0])
    }

    @Test
    fun `GIVEN Backstage passes to a TAFKAL80ETC concert with sellIn above 6 but under 11 and quality less than 50 WHEN updateQuality THEN sellIn is decreased and quality is increased by 2`() {
        val expectedAfterUpdate = createBackstageItem(9, 43)
        val items = listOf(createBackstageItem(10, 41))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(expectedAfterUpdate, app.items[0])
    }

    @Test
    fun `GIVEN Backstage passes to a TAFKAL80ETC concert with sellIn below 6 and quality less than 50 WHEN updateQuality THEN sellIn is decreased and quality is increased by 3`() {
        val expectedAfterUpdate = createBackstageItem(sellIn = 4, quality = 44)
        val items = listOf(createBackstageItem(5, 41))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(expectedAfterUpdate, app.items[0])
    }

    @Test
    fun `GIVEN Backstage passes to a TAFKAL80ETC concert with sellIn below 0 and quality less than 50 WHEN updateQuality THEN sellIn is decreased and quality is 0`() {
        val expectedAfterUpdate = createBackstageItem(sellIn = -2, quality = 0)
        val items = listOf(createBackstageItem(-1, 41))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(expectedAfterUpdate, app.items[0])
    }

    private fun createNormalItem(
        sellIn: Int,
        quality: Int,
    ) = Item("foo", sellIn, quality)

    private fun createAgedBrie(
        sellIn: Int,
        quality: Int,
    ) = Item("Aged Brie", sellIn, quality)

    private fun createBackstageItem(
        sellIn: Int,
        quality: Int,
    ) = Item(name = "Backstage passes to a TAFKAL80ETC concert", sellIn = sellIn, quality = quality)
}


