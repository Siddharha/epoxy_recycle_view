package `in`.creativelizard.epoxyrecycler

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import kotlinx.coroutines.*

class AddItemViewModel : BaseViewModel() {
     val headerData = MutableLiveData<String>()

    private val onAddedValue = MutableLiveData<String>()
    private val _navItm = MutableLiveData<HashMap<String,Any>>()

    fun onClickItemAdd() {
        Log.e("response","${headerData.value}")
        launchMain{
            getDataForTestCoroutineTest()
        }

        }

    fun onClickListPage() {
        val it =  HashMap<String,Any>()
        it.apply {
            put("hasNext",true)
            put("value",onAddedValue.value!!)
        }
        _navItm.value = it

    }

    val onListNavListener:()->LiveData<HashMap<String,Any>> = {_navItm}

    val onHeaderObsValue:()->LiveData<String> = {
        onAddedValue
    }

    private  suspend fun getDataForTestCoroutineTest(){
            Thread.sleep(5000)
            onAddedValue.postValue( headerData.value!!)


    }
}



