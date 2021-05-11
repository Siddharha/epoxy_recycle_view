package `in`.creativelizard.epoxyrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var datas :DataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
    }

    private fun loadData() {
        datas = getData() //From Model data

        if(intent.hasExtra("value")){
            val headerItm = intent.getStringExtra("value")
            Toast.makeText(this,headerItm,Toast.LENGTH_LONG).show()

        }

        rlItems.withModels {
            datas.dataList.forEachIndexed { index, item ->

                when(item.contentType){
                    "header" -> {
                        (item.contentData as HeaderData).items.forEachIndexed { i, contentItm ->
                            hCell {
                                id(i)
                                headerData (contentItm)
                            }
                        }
                    }
                    "body" ->{
                        (item.contentData as BodyData).items.forEachIndexed { i, contentItm ->
                            cell {
                                id(i)
                               // da (contentItm)
                                bodyData(contentItm)
                            }
                        }
                    }

                    "footer" ->{
                        (item.contentData as FooterData).apply {
                            fCell {
                                val data = this@apply
                                id(0)
                                footerData(data)
                            }
                        }
                    }

                }

            }
        }
    }
}