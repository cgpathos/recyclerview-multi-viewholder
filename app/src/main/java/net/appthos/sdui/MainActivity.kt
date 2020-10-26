package net.appthos.sdui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import net.appthos.sdui.data.DataProvider
import net.appthos.sdui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bnd: ActivityMainBinding
    private lateinit var dataProvider: DataProvider
    private lateinit var componentAdapter: ComponentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bnd = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bnd.root)

        dataProvider = DataProvider()
        componentAdapter = ComponentAdapter()
        bnd.listItem.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = componentAdapter
        }

        componentAdapter.submitList(dataProvider.getServerData())
    }
}