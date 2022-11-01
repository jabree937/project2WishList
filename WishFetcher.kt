package com.example.whishlist

class WishFetcher {
    companion object {

        private val nameList = mutableListOf<String>()
        private val urlList = mutableListOf<String>()
        private val priceList = mutableListOf<String>()

        fun addWishes(name: String, url: String, price: String) {
            nameList.add(name)
            urlList.add(url)
            priceList.add(price)
        }

        fun getWishes(): MutableList<Wish>
        {
            val wishes : MutableList<Wish> = ArrayList()
            for (i in nameList.indices) {
                val wish = Wish(nameList[i], urlList[i], priceList[i])
                wishes.add(wish)
            }
            return wishes
        }



    }
}