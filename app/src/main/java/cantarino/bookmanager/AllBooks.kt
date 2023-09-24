package cantarino.bookmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AllBooks : AppCompatActivity() {

    private lateinit var rvAll: RecyclerView
    private lateinit var rvAdapter: BookRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_books)

        rvAll = findViewById(R.id.rvAll)
        rvAdapter = BookRecyclerViewAdapter(this)

        rvAll.adapter = rvAdapter
        rvAll.layoutManager = LinearLayoutManager(this)

        rvAdapter.setBooks(Utils.getInstance().allBooks)
    }
}