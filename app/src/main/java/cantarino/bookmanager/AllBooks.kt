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

        val books = ArrayList<Book>()
        books.add(Book(1, "Book1", "Author1", 100,
            "https://marketplace.canva.com/EAFersXpW3g/1/0/1003w/canva-blue-and-white-modern-business-book-cover-cfxNJXYre8I.jpg",
        "It's a nice book!", "It's a really, really, really, really, really, really, really, really nice book."))
        books.add(Book(2, "Book2", "Author2", 200,
            "https://marketplace.canva.com/EAFersXpW3g/1/0/1003w/canva-blue-and-white-modern-business-book-cover-cfxNJXYre8I.jpg",
            "It's a nice book!", "It's a really, really, really, really, really, really, really, really nice book."))

        rvAdapter.setBooks(books)
    }
}