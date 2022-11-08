package kr.ac.kumoh.S20180735

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kr.ac.kumoh.S20180735.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding

    private val songs = arrayOf(
        "the call", "rise", "warriors", "오르트 구름", "사건의 지평선")

    override fun onCreate(savedInstanceState: Bundle?) {
        view = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.list.adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, songs)

        view.list.setOnItemClickListener { _, _, i, _ ->
            val uri = Uri.parse("http://youtube.com/results?search_query=노래방+" + songs[i])
            val youtube = Intent(Intent.ACTION_VIEW, uri)
            startActivity(youtube)
        }
    }
}