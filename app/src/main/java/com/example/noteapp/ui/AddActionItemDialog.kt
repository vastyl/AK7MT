package com.example.noteapp.ui

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.noteapp.data.db.ActionItem
import com.example.noteapp.databinding.DialogAddActionItemBinding




class AddActionItemDialog(context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var binding: DialogAddActionItemBinding

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        //setContentView(R.layout.dialog_add_action_item)
        binding = DialogAddActionItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            if(name.isNullOrEmpty()) {
                Toast.makeText(context, "Vložte prosím text", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ActionItem(name, 0,false)
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        binding.tvCancel.setOnClickListener {
            cancel()
        }
    }
}