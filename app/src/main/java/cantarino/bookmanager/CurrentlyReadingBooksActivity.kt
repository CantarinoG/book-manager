package cantarino.bookmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CurrentlyReadingBooksActivity : AppCompatActivity() {

    private lateinit var rvCurrently: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currently_reading_books)
        rvCurrently = findViewById(R.id.rvCurrently)
        var adapter = BookRecyclerViewAdapter(this)
        rvCurrently.adapter = adapter
        rvCurrently.layoutManager = LinearLayoutManager(this)
        adapter.setBooks(Utils.getInstance().currentlyReadingBooks)
    }

    override fun onBackPressed() {
        intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}