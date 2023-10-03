package cantarino.bookmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class BookActivity : AppCompatActivity() {

    companion object {
        const val BOOK_ID_KEY: String = "bookId"
    }

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

        var intent = intent
        if(null != intent) {
            var bookId = intent.getIntExtra(BOOK_ID_KEY, -1)
            if (bookId != -1) {
                var incomingBook = Utils.getInstance().getBookById(bookId)
                if (null != incomingBook) {
                    setData(incomingBook)
                    handleAlreadyRead(incomingBook)
                    handleWantToRead(incomingBook)
                    handleCurrentReading(incomingBook)
                    handleFavorites(incomingBook)
                }
            }
        }
    }

    private fun handleAlreadyRead(book: Book){
        var alreadyReadBooks = Utils.getInstance().alreadyReadBooks
        var existInAlreadyReadBooks = false

        alreadyReadBooks.forEach { b ->
            if (b.id == book.id) existInAlreadyReadBooks = true
        }
        if (existInAlreadyReadBooks) btnAlreadyRead.isEnabled = false
        else {
            btnAlreadyRead.setOnClickListener {
                if (Utils.getInstance().addToAlreadyRead(book)) {
                    Toast.makeText(this, "Book Added", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, AlreadyReadBooksActivity::class.java))
                } else Toast.makeText(this, "Something wrong happened, try again.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun handleWantToRead(book: Book) {
        var wantToReadBooks = Utils.getInstance().wantToReadBooks
        var existInWantToReadBooks = false

        wantToReadBooks.forEach { b ->
            if(b.id == book.id) existInWantToReadBooks = true
        }
        if(existInWantToReadBooks) btnWishlist.isEnabled = false
        else {
            btnWishlist.setOnClickListener {
                if(Utils.getInstance().addToWantToRead(book)) {
                    Toast.makeText(this, "Book Added", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, WantToReadBooksActivity::class.java))
                } else Toast.makeText(this, "Something wrong happened, try again.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun handleCurrentReading(book: Book) {
        var currentlyReadingBooks = Utils.getInstance().currentlyReadingBooks
        var existInCurrentlyReadingBooks = false

        currentlyReadingBooks.forEach { b ->
            if(b.id == book.id) existInCurrentlyReadingBooks = true
        }
        if(existInCurrentlyReadingBooks) btnCurrently.isEnabled = false
        else {
            btnCurrently.setOnClickListener {
                if(Utils.getInstance().addToCurrentlyReading(book)) {
                    Toast.makeText(this, "Book added", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, CurrentlyReadingBooksActivity::class.java))
                } else Toast.makeText(this, "Something wrong happened, try again.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun handleFavorites(book: Book) {
        var favoriteBooks = Utils.getInstance().favoriteBooks
        var existInFavoriteBooks = false

        favoriteBooks.forEach { b ->
            if(b.id == book.id) existInFavoriteBooks = true
        }
        if(existInFavoriteBooks) btnAddFavorites.isEnabled = false
        else {
            btnAddFavorites.setOnClickListener {
                if(Utils.getInstance().addToFavorites(book)) {
                    Toast.makeText(this, "Book added", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, FavoriteBooksActivity::class.java))
                } else Toast.makeText(this, "Something wrong happened, try again.", Toast.LENGTH_SHORT).show()
            }
        }
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