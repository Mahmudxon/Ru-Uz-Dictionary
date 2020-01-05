package uz.mahmudxon.ru_uzdictionary.ui.main.view

import uz.mahmudxon.ru_uzdictionary.model.Word

interface MainView {
    fun errorRead(s : String)
    fun loadData(data : List<Word>)
}