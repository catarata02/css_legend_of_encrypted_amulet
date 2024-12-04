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

}


