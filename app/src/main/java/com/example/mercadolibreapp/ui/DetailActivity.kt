package com.example.mercadolibreapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mercadolibreapp.R
import com.example.mercadolibreapp.databinding.ActivityDetailBinding
import com.example.mercadolibreapp.model.Product

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val product: Product? = intent.getParcelableExtra("product")
        if (product != null) {
            binding.product = product
        } else {
            finish()
        }
    }
}
