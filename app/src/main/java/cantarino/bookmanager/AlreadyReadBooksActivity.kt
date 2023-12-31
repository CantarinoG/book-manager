package cantarino.bookmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AlreadyReadBooksActivity : AppCompatActivity() {

    private lateinit var rvAlready: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_already_read_books)
        rvAlready = findViewById(R.id.rvAlready)
        var adapter = BookRecyclerViewAdapter(this)
        rvAlready.adapter = adapter
        rvAlready.layoutManager = LinearLayoutManager(this)
        adapter.setBooks(Utils.getInstance().alreadyReadBooks)
    }

    override fun onBackPressed() {
        intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}