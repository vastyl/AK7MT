package com.example.noteapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.data.db.ActionItem
import com.example.noteapp.databinding.ActionItemBinding

class ActionItemAdapter(
    var items: List<ActionItem>,
    private val viewModel: ActionItemViewModel
): RecyclerView.Adapter<ActionItemAdapter.ActionItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionItemViewHolder {
        val binding = ActionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActionItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ActionItemViewHolder, position: Int) {
           holder.bind(items[position])

    }

    inner class ActionItemViewHolder(private val binding: ActionItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(actionItem: ActionItem) {
            binding.tvName.text = actionItem.name
            binding.statusCheckBox.isChecked = actionItem.status
            binding.ivDelete.setOnClickListener {
                viewModel.delete(actionItem)
            }

            binding.statusCheckBox.setOnCheckedChangeListener { _, isChecked ->
                actionItem.status = isChecked
                viewModel.upsert(actionItem)

            }
        }
    }
}