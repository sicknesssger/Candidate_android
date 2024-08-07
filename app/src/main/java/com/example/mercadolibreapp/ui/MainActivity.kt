package com.example.mercadolibreapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mercadolibreapp.databinding.ActivityMainBinding
import com.example.mercadolibreapp.viewmodel.ProductViewModel
import com.example.mercadolibreapp.viewmodel.ProductViewModelFactory
import com.example.mercadolibreapp.network.RetrofitInstance
import com.example.mercadolibreapp.repository.ProductRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = ProductRepository(RetrofitInstance.apiService)
        val viewModelFactory = ProductViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ProductViewModel::class.java)

        val adapter = ProductAdapter { product ->
            Log.d("MainActivity", "Product clicked: ${product}")
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.searchButton.setOnClickListener {
            val query = binding.searchField.text.toString()
            if (query.isNotEmpty()) {
                viewModel.searchProducts(query)
            }
        }

        viewModel.products.observe(this) { products ->
            Log.d("MainActivity", "Products updated with ${products.size} items")
            adapter.submitList(products)
        }

        viewModel.error.observe(this) { error ->
            Log.e("MainActivity", "Error loading products: $error")
        }
    }
}
