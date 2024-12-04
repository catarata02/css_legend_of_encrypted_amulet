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

    protected fun increaseQuality(increaseBy: Int) {
        if (this.quality < 51 - increaseBy) {
            this.quality += increaseBy
        } else {
            this.quality = 50
        }

    }

    protected fun decreaseQuality(decreaseBy: Int) {
        if (this.quality >= decreaseBy) {
            this.quality -= decreaseBy
        } else {
            this.quality = 0
        }
    }
}

class AgedBrie(
    val extSellIn: Int,
    val extQuality: Int,
) : BaseItem(name = AGED_BRIE_NAME, sellIn = extSellIn, quality = extQuality) {

    override fun updateQuality() {
        increaseQuality(1)
        if (this.sellIn < 0)
            increaseQuality(1)
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
                in 6..10 -> increaseQuality(2)
                in 0..5 -> increaseQuality(3)
                else -> increaseQuality(1)
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
        decreaseQuality(1)
        if (this.sellIn < 0) {
            decreaseQuality(1)
        }
        decreaseSellIn()
    }
}
