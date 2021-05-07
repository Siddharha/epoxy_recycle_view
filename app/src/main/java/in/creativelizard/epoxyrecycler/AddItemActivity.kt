package `in`.creativelizard.epoxyrecycler

import `in`.creativelizard.epoxyrecycler.databinding.ActivityAddItemBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider

class AddItemActivity : AppCompatActivity() {
    private val addItemViewModel: AddItemViewModel by lazy { ViewModelProvider(this).get(AddItemViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityAddItemBinding>(this,R.layout.activity_add_item)
        binding.itemModelView = addItemViewModel
        initialize()
        onActionPerform()
    }

    private fun onActionPerform() {
        addItemViewModel.getHeader().observe(this,{
            Log.e("response",it)
        })
    }


    private fun initialize(){


    }
}