package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication2.ItemAdapter
import kotlinx.android.synthetic.main.activity_main.*

@ExperimentalStdlibApi
class MainActivity : AppCompatActivity() {


    val items = ArrayList<Item>()
    lateinit var rv: RecyclerView
    val adapter = ItemAdapter(items)

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.Item_Recyclerview)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        var total = findViewById<TextView>(R.id.Total)
        total.setText("")



        fun item(item: Item) {
            var iname = item.item_name
            var icount = item.item_count
            var iprice = item.item_unit_price

             item.item_unit_price=("$icount".toInt())*("$iprice".toInt())

            if (items.size > 0) {
                //items.forEach { it.item_count

                val index = items.indexOfFirst { it.item_name == item.item_name }
                if (index < 0) {
                    items.add(item)
                }else{
                    var icount = items[index].item_count
                  Log.e("t1", icount.toString())



                  //  items[index].item_count =  6;


                    item.item_count = item.item_count?.plus("$icount".toInt())
                    Log.e("tt",item.item_count.toString())
                    var subtotal = ("$icount".toInt())*("$iprice".toInt())
                    Log.e("t1", subtotal.toString())

                   items.removeAt(index)
                    items.add(index,item)

                }
            } else {
                items.add(item)

            }
            rv.adapter = adapter
            CalculateTotal()

        }




        Item1.setOnClickListener { item(Item("Item1", 1, 10)) }
        Item2.setOnClickListener { item(Item("Item2", 2, 20)) }
        Item3.setOnClickListener { item(Item("Item3", 0, 30)) }
        Item4.setOnClickListener { item(Item("Item4", 0, 40)) }
        Item5.setOnClickListener { item(Item("Item5", 0, 50)) }
//        Item2.setOnClickListener { item("Item2", 0, 20) }
//        Item3.setOnClickListener { item("Item3", 0, 20) }
//        Item4.setOnClickListener { item("Item4", 0, 20) }
//        Item5.setOnClickListener { item("Item5", 0, 20) }
//        Item6.setOnClickListener { item("Item6", 0, 20) }
//        Item7.setOnClickListener { item("Item7", 0, 20) }
//        Item8.setOnClickListener { item("Item8", 0, 20) }
//        Item9.setOnClickListener { item("Item9", 0, 20) }
//        Item10.setOnClickListener { item("Item10", 0, 20) }
//        Item11.setOnClickListener { item("Item11", 0, 20) }
//        Item12.setOnClickListener { item("Item12", 0, 20) }
//        Item13.setOnClickListener { item("Item13", 0, 20) }
//        Item14.setOnClickListener { item("Item14", 0, 20) }
//        Item15.setOnClickListener { item("Item2", 0, 20) }
        Reset.setOnClickListener {
            items.clear()
            rv.adapter = adapter
        }


    }

    private  fun CalculateTotal() {
        var total:Int=0
        for (item in items){
            var p=item.item_unit_price
            var q=item.item_count
            total += p* q!!
        }

            Log.e("total", total.toString())
        }








    }









