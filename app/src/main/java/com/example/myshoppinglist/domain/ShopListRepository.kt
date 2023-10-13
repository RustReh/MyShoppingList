package com.example.myshoppinglist.domain

interface ShopListRepository {
    fun getShopList() : List<ShopItem>

    fun addShopItem(shopItem : ShopItem)
    fun getShopItem(shopItemId: Int) : ShopItem
    fun removeShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem : ShopItem)
}