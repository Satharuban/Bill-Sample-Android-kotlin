package com.example.myapplication

import android.util.Log

class Item(var item_name:String, var item_count: Int?, var item_unit_price:Int) {


        var total:Int = 0

    var item_count1: Int?
        get(){
            return item_count
        }                     // getter
        set(value) { item_count1=item_count
            Log.e("tt",item_count1.toString())}

}


