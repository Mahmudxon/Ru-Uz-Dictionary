package uz.mahmudxon.ru_uzdictionary.ui.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList


abstract class BaseAdapterRecyclerview <T>(@LayoutRes val layout : Int, var data : ArrayList<T>,val context: Context? = null)
    : RecyclerView.Adapter<BaseAdapterRecyclerview<T>.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view = view)
    }

    fun swapdata(newdata : ArrayList<T>)
    {
        data.clear()
        data.addAll(newdata)
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    abstract fun bindData(itemView: View, itemdata : T)


    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        fun bind()
        {
            bindData(itemView, data[adapterPosition])
        }
    }
}
