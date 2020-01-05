package uz.mahmudxon.ru_uzdictionary.ui.main.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import uz.mahmudxon.ru_uzdictionary.model.Word
import uz.mahmudxon.ru_uzdictionary.repository.Repository
import uz.mahmudxon.ru_uzdictionary.ui.main.view.MainView

class MainPresenter(private val view: MainView, private val repository: Repository) {

    private lateinit var compositeDisposable: CompositeDisposable

    fun getUzWords() {
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            repository.getUzWORDS()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.loadData(it)
                }, {
                    view.errorRead("${it.message}")
                })
        )
    }

    fun getUzFav() {
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            repository.getUzFavWORDS()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.loadData(it)
                }, {
                    view.errorRead("${it.message}")
                })
        )
    }

    fun updateUzWord(word: Word) {
        repository.updateUzWord(word)
    }

    fun getRuWords() {
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            repository.getRuWORDS()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.loadData(it)
                }, {
                    view.errorRead("${it.message}")
                })
        )
    }

    fun getRuFav() {
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            repository.getRuFavWORDS()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.loadData(it)
                }, {
                    view.errorRead("${it.message}")
                })
        )
    }

    fun updateRuWord(word: Word) {
        repository.updateRuWord(word)
    }
}