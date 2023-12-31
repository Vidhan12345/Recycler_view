package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding
import javax.net.ssl.SSLSessionBindingEvent

class MainActivity : AppCompatActivity() {
    lateinit var myrv : RecyclerView
    lateinit var userDetails : ArrayList<UserModel>

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var imageArray = arrayOf(
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img6,
        )
        var nameArray = arrayOf("Vidhan","Ujjwal","Mehul")
        var ageArray = arrayOf(19,17,19)
        var secArray = arrayOf("R","S","A")

        myrv = binding.rv
        myrv.layoutManager = LinearLayoutManager(this)
        userDetails = arrayListOf<UserModel>()

        for(index in imageArray.indices){
            val details = UserModel(imageArray[index],nameArray[index],ageArray[index],secArray[index])
            userDetails.add(details)
        }

        var myAdapter = MyAdapter(userDetails,this)
        binding.rv.adapter = myAdapter
        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClicking(position: Int) {
                Toast.makeText(this@MainActivity, "Item Clicked", Toast.LENGTH_LONG).show()
            }

        })

    }
}