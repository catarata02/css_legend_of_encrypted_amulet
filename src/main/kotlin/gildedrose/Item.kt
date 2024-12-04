package com.gildedrose

open class Item(
    var name: String,
    var sellIn: Int,
    var quality: Int,
) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

const val AGED_BRIE_NAME = "Aged Brie"
const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
const val SULFURAS_NAME = "Sulfuras, Hand of Ragnaros"

abstract class BaseItem(
    var name: String,
    var sellIn: Int,
    var quality: Int,
) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }

    abstract fun updateQuality()
    protected fun decreaseSellIn() {
        this.sellIn -= 1
    }

    protected fun increaseQuality() {
        if (this.quality < 50)
            this.quality += 1
    }

    protected fun decreaseQuality() {
        if (this.quality > 0)
            this.quality -= 1
    }
}

class AgedBrie(
    val extSellIn: Int,
    val extQuality: Int,
) : BaseItem(name = AGED_BRIE_NAME, sellIn = extSellIn, quality = extQuality) {

    override fun updateQuality() {
        increaseQuality()
        if (this.sellIn < 0)
            increaseQuality()
        decreaseSellIn()
    }

}

class BackestagePass(
    val extSellIn: Int,
    val extQuality: Int,
) : BaseItem(name = BACKSTAGE_PASSES, sellIn = extSellIn, quality = extQuality) {
    override fun updateQuality() {
        if (this.sellIn < 0) {
            this.quality = 0
        } else {
            when (this.sellIn) {
                in 6..10 -> {
                    increaseQuality()
                    increaseQuality()
                }
                in 0 .. 5 -> {
                    increaseQuality()
                    increaseQuality()
                    increaseQuality()
                }
                else -> increaseQuality()
            }
        }
        decreaseSellIn()
    }
}

class Sulfuras(
    val extSellIn: Int,
    val extQuality: Int,
) : BaseItem(name = SULFURAS_NAME, sellIn = extSellIn, quality = extQuality) {
    override fun updateQuality() {

    }
}

class NormalItem(
    val extSellIn: Int,
    val extQuality: Int,
    val extName: String,
) : BaseItem(name = extName, sellIn = extSellIn, quality = extQuality) {
    override fun updateQuality() {
        decreaseQuality()
        if (this.sellIn < 0) {
            decreaseQuality()
        }
        decreaseSellIn()
    }
}
