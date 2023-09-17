package cantarino.bookmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class BookActivity : AppCompatActivity() {

    private lateinit var imgBookCover: ImageView
    private lateinit var btnCurrently: Button
    private lateinit var btnWishlist: Button
    private lateinit var btnAlreadyRead: Button
    private lateinit var btnAddFavorites: Button
    private lateinit var txtNameBook: TextView
    private lateinit var txtAuthorBook: TextView
    private lateinit var txtPagesBook: TextView
    private lateinit var txtDescriptionBook: TextView
    private lateinit var txtNameCurrent: TextView
    private lateinit var txtAuthorCurrent: TextView
    private lateinit var txtPagesCurrent: TextView
    private lateinit var txtDescriptionCurrent: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        initViews()

        setData(Book(1, "Book1", "Author1", 100,
            "https://marketplace.canva.com/EAFersXpW3g/1/0/1003w/canva-blue-and-white-modern-business-book-cover-cfxNJXYre8I.jpg",
            "It's a nice book!", "It's a really, really, really, really, really, really, really, really nice book."))



    }

    private fun initViews() {
        imgBookCover = findViewById(R.id.imgBookCover)
        btnCurrently = findViewById(R.id.btnCurrently)
        btnWishlist = findViewById(R.id.btnWishlist)
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead)
        btnAddFavorites = findViewById(R.id.btnAddFavorites)
        txtNameBook = findViewById(R.id.txtNameBook)
        txtAuthorBook = findViewById(R.id.txtAuthorBook)
        txtPagesBook = findViewById(R.id.txtPagesBook)
        txtDescriptionBook = findViewById(R.id.txtDescriptionBook)
        txtNameCurrent = findViewById(R.id.txtNameCurrent)
        txtAuthorCurrent = findViewById(R.id.txtAuthorCurrent)
        txtPagesCurrent = findViewById(R.id.txtPagesCurrent)
        txtDescriptionCurrent = findViewById(R.id.txtDescriptionCurrent)
    }

    private fun setData(book: Book) {
        txtNameCurrent.text = book.name
        txtAuthorCurrent.text = book.author
        txtPagesCurrent.text = book.pages.toString()
        txtDescriptionCurrent.text = book.longDesc
        Glide.with(this).asBitmap().load(book.imageURL).into(imgBookCover)

    }

}