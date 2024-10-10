package com.example.imagelist

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.imagelist.databinding.ActivityMainBinding
import com.example.imagelist.ui.theme.ImageListTheme

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameList = arrayOf("2024/07/28 20:26:04","2023/10/25 17:51:08","2023/08/18 19:28:06","2023/08/11 20:32:43","2023/08/11 20:29:30","2023/08/11 20:28:01","2023/08/07 20:34:59",
            "2023/08/07 20:22:24","2023/08/07 20:20:50","2023/07/30 20:20:41","2023/07/30 20:20:11","2023/07/30 20:17:54","2023/07/21 20:12:19","2023/07/19 20:32:13")


        val imageList = intArrayOf(
            R.drawable._0240728_202604,
            R.drawable._0231025_175108,
            R.drawable._0230818_192806,
            R.drawable._0230811_203243,
            R.drawable._0230811_202930,
            R.drawable._0230811_202801,
            R.drawable._0230807_203459,
            R.drawable._0230807_202224,
            R.drawable._0230807_202050,
            R.drawable._0230730_202041,
            R.drawable._0230730_202011,
            R.drawable._0230730_201754,
            R.drawable._0230721_201219,
            R.drawable._0230719_203213,
        )

        val dateList = arrayOf("2024/07/28 20:26:04","2023/10/25 17:51:08","2023/08/18 19:28:06","2023/08/11 20:32:43","2023/08/11 20:29:30","2023/08/11 20:28:01","2023/08/07 20:34:59",
            "2023/08/07 20:22:24","2023/08/07 20:20:50","2023/07/30 20:20:41","2023/07/30 20:20:11","2023/07/30 20:17:54","2023/07/21 20:12:19","2023/07/19 20:32:13")
        val creditList = arrayOf("Falka Marietta","Falka Marietta","Falka Marietta","Falka Marietta","Falka Marietta","Falka Marietta","Falka Marietta","Falka Marietta",
            "Falka Marietta","Falka Marietta","Falka Marietta","Falka Marietta","Falka Marietta","Falka Marietta",)



        for (i in imageList.indices){
            listData = ListData(nameList[i],dateList[i],creditList[i],imageList[i])
            dataArrayList.add(listData)
        }

        listAdapter = ListAdapter(this@MainActivity, dataArrayList)
        binding.listview.adapter = listAdapter
        binding.listview.isClickable = true

        binding.listview.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
                val intent = Intent(this@MainActivity, DetailedActivity::class.java)
                intent.putExtra("name", nameList[i])
                intent.putExtra("date", dateList[i])
                intent.putExtra("credit", creditList[i])
                intent.putExtra("image", imageList[i])
                startActivity(intent)
            }
    }
}
