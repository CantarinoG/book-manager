package cantarino.bookmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnAll: Button
    private lateinit var btnCurrent: Button
    private lateinit var btnAlready: Button
    private lateinit var btnWish: Button
    private lateinit var btnFavorites: Button
    private lateinit var btnAbout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        btnAll.setOnClickListener { startActivity(Intent(this, AllBooks::class.java)) }
        btnAlready.setOnClickListener { startActivity(Intent(this, AlreadyReadBooksActivity::class.java)) }
        btnWish.setOnClickListener { startActivity(Intent(this, WantToReadBooksActivity::class.java)) }
        btnCurrent.setOnClickListener { startActivity(Intent(this, CurrentlyReadingBooksActivity::class.java)) }

        Utils.getInstance()

    }

    private fun initViews() {
        btnAll = findViewById(R.id.btnAll)
        btnCurrent = findViewById(R.id.btnCurrent)
        btnAlready = findViewById(R.id.btnAlready)
        btnWish = findViewById(R.id.btnWish)
        btnFavorites = findViewById(R.id.btnFavorites)
        btnAbout = findViewById(R.id.btnAbout)
    }

}