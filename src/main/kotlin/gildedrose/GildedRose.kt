package com.gildedrose

class GildedRose(var items: List<Item>) {

    private lateinit var typedItems: List<BaseItem>
    
    init {
        typedItems = items.map { mapToBaseItem(it) }
    }

    fun updateQuality() {
        typedItems.forEach { it.updateQuality() }
        items = typedItems.map { mapToItem(it) }
       
    }

    private fun mapToItem(baseItem: BaseItem): Item {
        return Item(name = baseItem.name, sellIn = baseItem.sellIn, quality = baseItem.quality)
    }


    private fun mapToBaseItem(item: Item) : BaseItem {
        return when (item.name) {
            AGED_BRIE_NAME -> AgedBrie(extSellIn = item.sellIn, extQuality = item.quality)
            BACKSTAGE_PASSES -> BackestagePass(extSellIn = item.sellIn, extQuality = item.quality)
            SULFURAS_NAME -> Sulfuras(extSellIn = item.sellIn, extQuality = item.quality)
            else -> NormalItem(extSellIn = item.sellIn, extQuality = item.quality, extName = "foo")
        }
    }

}

