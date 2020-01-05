package uz.mahmudxon.ru_uzdictionary.ui.navigation

import android.view.View
import kotlinx.android.synthetic.main.item_menu.view.*
import uz.mahmudxon.ru_uzdictionary.R
import uz.mahmudxon.ru_uzdictionary.model.Menu
import uz.mahmudxon.ru_uzdictionary.ui.base.BaseAdapterRecyclerview

class MenuAdapter : BaseAdapterRecyclerview<Menu>(R.layout.item_menu, ArrayList()) {
    override fun bindData(itemView: View, itemdata: Menu) {
        itemView.apply {
            menu_icon?.setImageResource(itemdata.icon)
            menu_title?.text = itemdata.title
        }
    }
}