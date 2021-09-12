package enviouchegou.android.network.ui

import androidx.lifecycle.MutableLiveData
import java.util.concurrent.atomic.AtomicBoolean
import retrofit2.Call

internal class UiLiveData<T>(private val call: Call<T>,
                             private val ignoreIsSuccessInBody: Boolean) : MutableLiveData<UiState<T>>() {

    private var started = AtomicBoolean(false)

    override fun onActive() {
        super.onActive()
        if (started.compareAndSet(false, true))
            postValue(UiLoading)
        doCall()
    }

    private fun doCall() {
        if (!call.isExecuted)
            call.enqueue(UiStateCallback(this, ignoreIsSuccessInBody))
    }
}
