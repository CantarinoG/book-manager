package cantarino.bookmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WantToReadBooksActivity : AppCompatActivity() {

    private lateinit var rvWantToRead: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_want_to_read_books)

        rvWantToRead = findViewById(R.id.rvWantToRead)
        var adapter = BookRecyclerViewAdapter(this)
        rvWantToRead.adapter = adapter
        rvWantToRead.layoutManager = LinearLayoutManager(this)
        adapter.setBooks(Utils.getInstance().wantToReadBooks)
    }

    override fun onBackPressed() {
        intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

}