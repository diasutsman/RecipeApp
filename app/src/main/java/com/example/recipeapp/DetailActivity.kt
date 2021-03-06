package com.example.recipeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.recipeapp.data.Recipes
import com.example.recipeapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarDetail)
//      untuk menampilkan tombol back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataRecipes = intent.getParcelableExtra<Recipes>(RECIPES_DATA) as Recipes
        Glide.with(this).load(dataRecipes.photo).into(binding.imgDetail)

        binding.apply {
            titleDetailRecipe.title = dataRecipes.name
            tvNameRecipeDetail.text = dataRecipes.name
            tvCaloriesDetail.text = dataRecipes.calories
            tvCarboDetail.text = dataRecipes.carbo
            tvProteinDetail.text = dataRecipes.protein
            tvIngredientsDetail.text = dataRecipes.ingredients
            tvInstructionDetail.text = dataRecipes.instructions
            tvDescriptionDetail.text = dataRecipes.description
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val RECIPES_DATA = "recipes"
    }
}