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
}

class AgedBrie(
    val extSellIn: Int,
    val extQuality: Int,
) : BaseItem(name = AGED_BRIE_NAME, sellIn = extSellIn, quality = extQuality) {

    override fun updateQuality() {

    }

}

class BackestagePass(
    val extSellIn: Int,
    val extQuality: Int,
) : BaseItem(name = BACKSTAGE_PASSES, sellIn = extSellIn, quality = extQuality) {
    override fun updateQuality() {

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
        this.sellIn -= 1
        if (this.quality > 0) {
            this.quality -= 1
            if (this.sellIn < 0) {
                this.quality -= 1
            }
        }
    }
}
