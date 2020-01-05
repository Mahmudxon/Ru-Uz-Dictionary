package uz.mahmudxon.ru_uzdictionary.ui.main.view

import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_main.*
import uz.mahmudxon.ru_uzdictionary.R
import uz.mahmudxon.ru_uzdictionary.model.Word
import uz.mahmudxon.ru_uzdictionary.repository.Repository
import uz.mahmudxon.ru_uzdictionary.ui.base.BaseFragment
import uz.mahmudxon.ru_uzdictionary.ui.main.presenter.MainPresenter
import uz.mahmudxon.ru_uzdictionary.ui.navigation.NavigationFragment
import uz.mahmudxon.ru_uzdictionary.ui.preview.PreviewFragment
import uz.mahmudxon.ru_uzdictionary.util.Prefs
import uz.mahmudxon.ru_uzdictionary.util.hideKeyboard
import uz.mahmudxon.ru_uzdictionary.util.log

class MainFragment : BaseFragment(R.layout.fragment_main), MainView {
    private lateinit var presenter: MainPresenter
    lateinit var adapter: MainListAdapter
    lateinit var data: List<Word>

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
        setupLanguage()
        mainMenu?.setOnClickListener {
            addFragment(NavigationFragment()/*, true*/)
        }

        mainSwap?.setOnClickListener {
            if (Prefs.getLanguage(requireContext()).equals(Prefs.Language.RU)) {
                Prefs.saveLang(requireContext(), Prefs.Language.UZ)
            } else {
                Prefs.saveLang(requireContext(), Prefs.Language.RU)
            }
            setupLanguage()
            mainSwap?.isClickable = false
        }

        main_search?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setDataToadapter()
            }
        })
    }

    override fun errorRead(s: String) {
        log(s)
    }

    override fun loadData(data: List<Word>) {
        this.data = data
        setDataToadapter()
    }


    fun setDataToadapter() {
        val temp = ArrayList<Word>()

        for (word in data) {

            if (main_search?.text.toString().isNotEmpty()) {
                if (word.word!!.startsWith("${main_search?.text}")) {
                    temp.add(word)
                }
            } else {
                temp.add(word)
            }
        }
        adapter.swapdata(temp)
        mainSwap?.isClickable = true
    }


// Menimcha kerakmas chunki animatsiya menga yoqmadi
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

    private fun setupLanguage() {
        val language = Prefs.getLanguage(context!!)
        mainTopText?.text = language
        if (language!! == Prefs.Language.RU) {
            presenter.getRuWords()
        } else {
            presenter.getUzWords()
        }

    }
}