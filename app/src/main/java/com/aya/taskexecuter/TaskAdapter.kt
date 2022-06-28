package com.aya.taskexecuter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aya.taskexecuter.databinding.ItemListBinding

class TaskAdapter () :
    RecyclerView.Adapter<TaskAdapter.ViewHolderTask>()  {

    private  var models = ArrayList<TaskModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTask {
        val binding: ItemListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_list, parent, false)

          return ViewHolderTask(binding)
    }

    fun setList(model: ArrayList<TaskModel>){
        models = model
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setNewTask(model:TaskModel){
        models.add(model)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolderTask, position: Int) {
        val model = models[position]
        holder.bind(model)
        holder.itemRowBinding.task.text = model.task
        holder.itemRowBinding.time.text = model.time

    }

    override fun getItemCount(): Int {
        return if (models.size > 0) models.size else 0
    }


    class ViewHolderTask(binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var itemRowBinding: ItemListBinding= binding
        fun bind(obj: TaskModel) {
            itemRowBinding.setVariable( BR.model, obj)
            itemRowBinding.executePendingBindings()
        }
    }
}