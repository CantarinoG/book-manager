package cantarino.bookmanager

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
}