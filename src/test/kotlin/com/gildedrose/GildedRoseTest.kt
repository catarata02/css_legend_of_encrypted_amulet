package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class GildedRoseTest {
    
    @Nested
    @DisplayName("GIVEN Normal Item")
    inner class NormalItems{
        @Test
        fun `with positive sellIn and quality is positive WHEN updateQuality THEN sellIn and quality are decreased by 1`() {
            val expectedAfterUpdate = createNormalItem(9, 49)
            val items = listOf(createNormalItem(10, 50))
            val app = GildedRose(items)

            app.updateQuality()

            assertEquals(expectedAfterUpdate, app.items[0])
        }

        @Test
        fun `with negative sellIn and quality is positive WHEN updateQuality THEN sellIn is decreased by 1 and quality is decreased by 2`() {
            val expectedAfterUpdate = createNormalItem(-2, 48)
            val items = listOf(createNormalItem(-1, 50))
            val app = GildedRose(items)

            app.updateQuality()

            assertEquals(expectedAfterUpdate, app.items[0])
        }

        @Test
        fun `with negative sellIn and quality is 0 WHEN updateQuality THEN sellIn is decreased by 1 and quality stays 0`() {
            val expectedAfterUpdate = createNormalItem(-2, 0)
            val items = listOf(createNormalItem(-1, 0))
            val app = GildedRose(items)

            app.updateQuality()

            assertEquals(expectedAfterUpdate, app.items[0])
        }
    }

    @Nested
    @DisplayName("GIVEN Aged Brie")
    inner class AgedBrie{
        @Test
        fun `with positive sellIn and quality less than 50 WHEN updateQuality THEN sellIn is decreased and quality is increased by 1`() {
            val expectedAfterUpdate = createAgedBrie(9, 41)
            val items = listOf(createAgedBrie(10, 40))
            val app = GildedRose(items)

            app.updateQuality()

            assertEquals(expectedAfterUpdate, app.items[0])
        }

        @Test
        fun `with positive sellIn and quality 50 WHEN updateQuality THEN sellIn is decreased and quality stays the same`() {
            val expectedAfterUpdate = createAgedBrie(9, 50)
            val items = listOf(createAgedBrie(10, 50))
            val app = GildedRose(items)

            app.updateQuality()

            assertEquals(expectedAfterUpdate, app.items[0])
        }

        @Test
        fun `with negative sellIn and quality less than 50 WHEN updateQuality THEN sellIn is decreased and quality is increased by 2`() {
            val expectedAfterUpdate = createAgedBrie(-2, 42)
            val items = listOf(createAgedBrie(-1, 40))
            val app = GildedRose(items)

            app.updateQuality()

            assertEquals(expectedAfterUpdate, app.items[0])
        }

    }
    
    @Nested
    @DisplayName("GIVEN Backstage passes to a TAFKAL80ETC concert ")
    inner class BackstagePasses{
        @Test
        fun `with sellIn above 11 and quality less than 50 WHEN updateQuality THEN sellIn is decreased and quality is increased by 1`() {
            val expectedAfterUpdate = createBackstageItem(sellIn = 15, quality = 42)
            val items = listOf(createBackstageItem( 16, 41))
            val app = GildedRose(items)

            app.updateQuality()

            assertEquals(expectedAfterUpdate, app.items[0])
        }

        @Test
        fun `with sellIn above 6 but under 11 and quality less than 50 WHEN updateQuality THEN sellIn is decreased and quality is increased by 2`() {
            val expectedAfterUpdate = createBackstageItem(9, 43)
            val items = listOf(createBackstageItem(10, 41))
            val app = GildedRose(items)

            app.updateQuality()

            assertEquals(expectedAfterUpdate, app.items[0])
        }

        @Test
        fun `with sellIn below 6 and quality less than 50 WHEN updateQuality THEN sellIn is decreased and quality is increased by 3`() {
            val expectedAfterUpdate = createBackstageItem(sellIn = 4, quality = 44)
            val items = listOf(createBackstageItem(5, 41))
            val app = GildedRose(items)

            app.updateQuality()

            assertEquals(expectedAfterUpdate, app.items[0])
        }

        @Test
        fun `with sellIn below 0 and quality less than 50 WHEN updateQuality THEN sellIn is decreased and quality is 0`() {
            val expectedAfterUpdate = createBackstageItem(sellIn = -2, quality = 0)
            val items = listOf(createBackstageItem(-1, 41))
            val app = GildedRose(items)

            app.updateQuality()

            assertEquals(expectedAfterUpdate, app.items[0])
        }

    }

    @Nested
    @DisplayName("GIVEN Sulfuras, Hand of Ragnaros ")
    inner class Sulfuras{

        @Test
        fun `with sellIn above 0 and quality less than 50 WHEN updateQuality THEN sellIn and quality stay the same`() {
            val expectedAfterUpdate = createSulfurasItem(sellIn = 16, quality = 41)
            val items = listOf(createSulfurasItem( 16, 41))
            val app = GildedRose(items)

            app.updateQuality()

            assertEquals(expectedAfterUpdate, app.items[0])
        }

        @Test
        fun `with sellIn below 0 and quality less than 50 WHEN updateQuality THEN sellIn and quality stay the same`() {
            val expectedAfterUpdate = createSulfurasItem(sellIn = -10, quality = 41)
            val items = listOf(createSulfurasItem( -10, 41))
            val app = GildedRose(items)

            app.updateQuality()

            assertEquals(expectedAfterUpdate, app.items[0])
        }

        @Test
        fun `with too high quality WHEN updateQuality THEN quality is still 100`() {
            val expectedAfterUpdate = createSulfurasItem(sellIn = -10, quality = 100)
            val items = listOf(createSulfurasItem( -10, 100))
            val app = GildedRose(items)

            app.updateQuality()

            assertEquals(expectedAfterUpdate, app.items[0])
        }
        
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

    private fun createSulfurasItem(
        sellIn: Int,
        quality: Int,
    ) = Item(name = "Sulfuras, Hand of Ragnaros", sellIn = sellIn, quality = quality)
}


