package com.example.noteapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.data.db.ActionItem
import com.example.noteapp.databinding.ActivityMainBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class MainActivity : AppCompatActivity() , KodeinAware {

    override val kodein by kodein()
    private val factory: ActionItemViewModelFactory by instance()

    lateinit var viewModel: ActionItemViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, factory).get(ActionItemViewModel::class.java)

        val adapter = ActionItemAdapter(listOf(), viewModel)

        binding.rvActionItems.layoutManager = LinearLayoutManager(this)
        binding.rvActionItems.adapter = adapter

        viewModel.getAllActionItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        binding.fab.setOnClickListener {
            AddActionItemDialog(
                this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: ActionItem) {
                        viewModel.upsert(item)
                    }
                }).show()
        }
        binding.fabApi.setOnClickListener {
            val intent = Intent(this, ApiActivity::class.java)
            // start your next activity
            startActivity(intent)
        }



    }
  }




