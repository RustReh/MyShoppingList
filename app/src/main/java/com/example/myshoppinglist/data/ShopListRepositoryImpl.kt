package com.example.myshoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myshoppinglist.domain.ShopItem
import com.example.myshoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()
    private  var autoIncrementId = 0
    private val shopListLD = MutableLiveData<List<ShopItem>>()

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, enabled = true)
            addShopItem(item)
        }
    }
    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun addShopItem(shopItem: ShopItem) {
        if ( shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId }?: throw RuntimeException ("Not Found ID")
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    private fun updateList(){
        shopListLD.value = shopList.toList()
    }
}