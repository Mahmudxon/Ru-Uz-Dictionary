package uz.mahmudxon.ru_uzdictionary.ui.preview

import com.r0adkll.slidr.model.SlidrPosition
import kotlinx.android.synthetic.main.fragment_preview.*
import uz.mahmudxon.ru_uzdictionary.R
import uz.mahmudxon.ru_uzdictionary.model.Word
import uz.mahmudxon.ru_uzdictionary.ui.base.BaseFragment
import uz.mahmudxon.ru_uzdictionary.util.hideKeyboard

class PreviewFragment : BaseFragment(R.layout.fragment_preview, canSwipe = true) {

    lateinit var word: Word
    override fun onCreatedView(senderData: Any?) {
        hideKeyboard()
        word = senderData!! as Word

        pf_word?.text = word.word
        pf_meaning?.text = word.meaning
        pf_back?.setOnClickListener {
            finish()
        }

    }
}