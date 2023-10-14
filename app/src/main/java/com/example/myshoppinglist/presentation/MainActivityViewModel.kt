package com.example.myshoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshoppinglist.data.ShopListRepositoryImpl
import com.example.myshoppinglist.domain.EditShopItemUseCase
import com.example.myshoppinglist.domain.GetShopListUseCase
import com.example.myshoppinglist.domain.RemoveShopItemUseCase
import com.example.myshoppinglist.domain.ShopItem
import com.example.myshoppinglist.domain.ShopListRepository

class MainActivityViewModel : ViewModel() {
    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val removeShopItemUseCase = RemoveShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun removeShopItem(shopItem: ShopItem) {
        removeShopItemUseCase.removeShopItem(shopItem)
    }
    fun changeEnableState(shopItem : ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}