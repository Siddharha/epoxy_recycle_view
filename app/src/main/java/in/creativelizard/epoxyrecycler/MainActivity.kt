package `in`.creativelizard.epoxyrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var datas:DataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
    }

    private fun loadData() {
        datas = getData() //From Model data

        rlItems.withModels {
            datas.items.forEachIndexed { index, item ->
                cell {
                    id(index)
                    data(item)
                }
            }
        }
    }
}