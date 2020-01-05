package uz.mahmudxon.ru_uzdictionary.ui.main.view

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_main.*
import uz.mahmudxon.ru_uzdictionary.R
import uz.mahmudxon.ru_uzdictionary.model.Word
import uz.mahmudxon.ru_uzdictionary.repository.Repository
import uz.mahmudxon.ru_uzdictionary.ui.base.BaseFragment
import uz.mahmudxon.ru_uzdictionary.ui.main.presenter.MainPresenter
import uz.mahmudxon.ru_uzdictionary.ui.navigation.NavigationFragment
import uz.mahmudxon.ru_uzdictionary.ui.preview.PreviewFragment
import uz.mahmudxon.ru_uzdictionary.util.hideKeyboard
import uz.mahmudxon.ru_uzdictionary.util.log
import java.util.*

class MainFragment : BaseFragment(R.layout.fragment_main), MainView {
    private lateinit var presenter: MainPresenter
    lateinit var adapter: MainListAdapter

    override fun onCreatedView(senderData: Any?) {
        presenter = MainPresenter(this, Repository.getInstens(requireContext()))

        adapter = MainListAdapter()
        mainList?.adapter = adapter
        mainList?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                hideKeyboard()
            }
        })
        adapter.itemClickListener = {
            addFragment(PreviewFragment(), it, true)
        }
        presenter.getRuWords()
        mainMenu?.setOnClickListener {
            addFragment(NavigationFragment()/*, true*/)
        }
    }

    override fun errorRead(s: String) {
        log(s)
    }

    override fun loadDataToAdapter(data: List<Word>) {
        val al = ArrayList<Word>()
        for (word in data) {
            //if(word.word!!.startsWith("${main_search.text}", true))
            al.add(word)
        }
        adapter.swapdata(al)
    }
// Menimcha kerakmas
//    @SuppressLint("ResourceType")
//    fun openNaviagtion(fragment: Fragment) {
//
//        fragmentManager?.beginTransaction()
//            ?.setCustomAnimations(
//                R.anim.enter_from_left,
//                R.anim.exit_to_left,
//                R.anim.pop_enter,
//                R.anim.exit_to_left
//            )
//
//            ?.add(R.id.content, fragment)
//            ?.addToBackStack(fragment.hashCode().toString())
//            ?.commit()
//    }
}