package `in`.creativelizard.epoxyrecycler

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddItemViewModel : ViewModel() {
   // private val  loginRepo = LoginRepo.getInstance()

//    val getLogin:(String,String) -> MutableLiveData<LoginResponse> = {usr,pass->
//        loginRepo.getLoginDetails(usr,pass)}

     val headerData = MutableLiveData<String>()
    fun onClickItemAdd() {
        Log.e("response","${headerData.value}")
}

val getHeader:() -> LiveData<String> = {
    headerData
}
}