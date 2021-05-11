package `in`.creativelizard.epoxyrecycler

import android.view.View
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

}

fun ViewModel.launchMain(work: suspend () -> Unit) = CoroutineScope(Dispatchers.IO).launch { work() }.also { addToDispose(it) }

private val disposableJob = mutableListOf<Job>()
fun addToDispose(job: Job) {
    disposableJob.add(job)
}