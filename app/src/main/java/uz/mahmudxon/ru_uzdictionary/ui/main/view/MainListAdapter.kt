package uz.mahmudxon.ru_uzdictionary.ui.main.view

import android.view.View
import kotlinx.android.synthetic.main.item_word.view.*
import uz.mahmudxon.ru_uzdictionary.R
import uz.mahmudxon.ru_uzdictionary.model.Word
import uz.mahmudxon.ru_uzdictionary.ui.base.BaseAdapterRecyclerview
import uz.mahmudxon.ru_uzdictionary.util.blockClickable

class MainListAdapter : BaseAdapterRecyclerview<Word>(R.layout.item_word, ArrayList()) {

    var itemClickListener: ((Word) -> Unit)? = null

    override fun bindData(itemView: View, itemdata: Word) {
        itemView.apply {
            item_text?.text = itemdata.word

            setOnClickListener {
                itemClickListener?.invoke(itemdata)
                it.blockClickable()
            }
        }
    }
}