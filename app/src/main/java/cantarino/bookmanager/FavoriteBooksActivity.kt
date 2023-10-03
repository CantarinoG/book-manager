package cantarino.bookmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoriteBooksActivity : AppCompatActivity() {

    private lateinit var rvFavorites: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_books)
        rvFavorites = findViewById(R.id.rvFavorites)
        var adapter = BookRecyclerViewAdapter(this)
        rvFavorites.adapter = adapter
        rvFavorites.layoutManager = LinearLayoutManager(this)
        adapter.setBooks(Utils.getInstance().favoriteBooks)
    }

    override fun onBackPressed() {
        intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

}