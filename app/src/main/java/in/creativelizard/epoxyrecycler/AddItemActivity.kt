package `in`.creativelizard.epoxyrecycler

import `in`.creativelizard.epoxyrecycler.databinding.ActivityAddItemBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider

class AddItemActivity : AppCompatActivity(){
    private val addItemViewModel: AddItemViewModel by lazy { ViewModelProvider(this).get(AddItemViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityAddItemBinding>(this,R.layout.activity_add_item)
        binding.itemModelView = addItemViewModel

        onActionPerform()
    }

    private fun onActionPerform() {
       addItemViewModel.onHeaderObsValue().observe(this,{
           Toast.makeText(this,it,Toast.LENGTH_LONG).show()
       })

        addItemViewModel.onListNavListener().observe(this,{
            if (it["hasNext"] as Boolean){
                val intent = Intent(this,MainActivity::class.java)
                intent.putExtra("value",it["value"] as String)
                startActivity(intent)
            }
        })
    }




}