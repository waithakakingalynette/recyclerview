package com.example.recyclerviewsassignment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private var Any.text: String
    get() {}
    set() {}
private val View.tvFibonacciNumber: Any
    get() {
        TODO("Not yet implemented")
    }

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fibonacciList = getFibonacciList()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = FibonacciAdapter(fibonacciList)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    fun fibonacci(n: Int): Int {
        return if (n <= 1) n else fibonacci(n - 1) + fibonacci(n - 2)
    }

    fun getFibonacciList(): List<Int> {
        val fibonacciList = mutableListOf<Int>()
        for (i in 0..99) {
            fibonacciList.add(fibonacci(i))
        }
        return fibonacciList
    }

    class FibonacciAdapter(private val fibonacciList: List<Int>) :
        RecyclerView.Adapter<FibonacciAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_fibonacci, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(fibonacciList[position])
        }

        override fun getItemCount(): Int {
            return fibonacciList.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(fibonacciNumber: Int) {
                itemView.tvFibonacciNumber.text = fibonacciNumber.toString()
            }
        }
    }
}