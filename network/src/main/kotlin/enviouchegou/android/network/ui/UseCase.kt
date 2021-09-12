package enviouchegou.android.network.ui

import enviouchegou.android.network.model.GENERIC_ERROR_MSG

abstract class UseCase<in P, R> {

    operator fun invoke(parameters: P, result: UiStateLiveData<R>) {
        result.postValue(UiLoading)
        try {
            create(parameters).let { useCaseResponse ->
                result.postValue(UiSuccess(useCaseResponse))
            }
        } catch (exception: IllegalStateException) {
            result.postValue(UiError(ErrorData(exception.message ?: GENERIC_ERROR_MSG)))
        }
    }

    protected abstract fun create(parameters: P): R
}
