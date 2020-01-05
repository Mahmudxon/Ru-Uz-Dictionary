package uz.mahmudxon.ru_uzdictionary.ui.navigation

import kotlinx.android.synthetic.main.fragment_naviagtion.*
import uz.mahmudxon.ru_uzdictionary.R
import uz.mahmudxon.ru_uzdictionary.ui.base.BaseFragment
import uz.mahmudxon.ru_uzdictionary.util.hideKeyboard

class NavigationFragment :
    BaseFragment(R.layout.fragment_naviagtion/*, true, SlidrPosition.RIGHT*/) {


    override fun onCreatedView(senderData: Any?) {
        hideKeyboard()
        oldview.setOnTouchListener { _, _ ->
            finish()
            return@setOnTouchListener true
        }

//        naviagtion_content?.setOnTouchListener { _, _ ->
//            // hech narsa ;-)
//            return@setOnTouchListener true
//        }
    }

}