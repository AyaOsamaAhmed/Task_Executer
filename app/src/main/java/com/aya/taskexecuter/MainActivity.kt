package com.aya.taskexecuter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.aya.taskexecuter.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var adapter : TaskAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)


        clickable()
        adapter = TaskAdapter()

        binding.listItems.adapter = adapter
    }

    fun clickable (){

        binding.task1.setOnClickListener {
            clearBackground()
            binding.task1.setBackgroundResource(R.drawable.backgroud_black)
            binding.task1.setTextColor(Color.WHITE)
            setCurrentTime(getString(R.string.task1))
        }
        binding.task2.setOnClickListener {
            clearBackground()
            binding.task2.setBackgroundResource(R.drawable.backgroud_black)
            binding.task2.setTextColor(Color.WHITE)
            setCurrentTime(getString(R.string.task2))
        }
        binding.task3.setOnClickListener {
            clearBackground()
            binding.task3.setBackgroundResource(R.drawable.backgroud_black)
            binding.task3.setTextColor(Color.WHITE)
            setCurrentTime(getString(R.string.task3))
        }
        binding.task4.setOnClickListener {
            clearBackground()
            binding.task4.setBackgroundResource(R.drawable.backgroud_black)
            binding.task4.setTextColor(Color.WHITE)
            setCurrentTime(getString(R.string.task4))
        }
    }

    fun setCurrentTime(task : String){
        val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm")
        val currentDate = sdf.format(Date())
        val model  = TaskModel(task = task , time = currentDate)
        adapter.setNewTask(model)
        adapter.notifyDataSetChanged()
    }

    fun clearBackground(){
        binding.task1.setBackgroundColor(Color.WHITE)
        binding.task1.setTextColor(Color.BLACK)
        binding.task2.setBackgroundColor(Color.WHITE)
        binding.task2.setTextColor(Color.BLACK)
        binding.task3.setBackgroundColor(Color.WHITE)
        binding.task3.setTextColor(Color.BLACK)
        binding.task4.setBackgroundColor(Color.WHITE)
        binding.task4.setTextColor(Color.BLACK)
    }

}