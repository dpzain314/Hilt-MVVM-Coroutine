package com.vuonghung.dpz.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vuonghung.dpz.R
import com.vuonghung.dpz.data.model.UserModel
import com.vuonghung.dpz.databinding.ItemLayoutBinding

//class ListUserAdapter(
//    private val context: Context, private val data: ArrayList<UserModel>
//) : RecyclerView.Adapter<ListUserAdapter.DataViewHolder>() {
//    private lateinit var viewBinding: ItemLayoutBinding
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
//        viewBinding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return DataViewHolder(viewBinding)
//    }
//
//    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
//        holder.bind(data[position], context)
//    }
//
//    override fun getItemCount(): Int {
//        return data.size
//    }
//
//    class DataViewHolder(viewBinding: ItemLayoutBinding) :
//        RecyclerView.ViewHolder(viewBinding.root) {
//        private val textViewUserName: TextView = viewBinding.textViewUserName
//        private val textViewUserPhone: TextView = viewBinding.textViewUserPhone
//        private val imageViewAvatar: ImageView = viewBinding.imageViewAvatar
//        fun bind(user: UserModel, context: Context) {
//            textViewUserName.text = user.name
//            textViewUserPhone.text = user.phone
//            imageViewAvatar.setImageDrawable(
//                ContextCompat.getDrawable(
//                    context,
//                    R.drawable.ic_launcher_foreground
//                )
//            )
//        }
//    }
//
//    fun addData(list: List<UserModel>) {
//        data.addAll(list)
//    }
//}

class ListUserAdapter(private val context: Context, private val data: ArrayList<UserModel>) :
    ListAdapter<UserModel, ListUserAdapter.DataViewHolder>(DiffCallBack()) {
    private lateinit var viewBinding: ItemLayoutBinding
    private var itemListListener: ItemListListener? = null

    interface ItemListListener{
        fun onItemClick(user : UserModel)
    }

    class DiffCallBack : DiffUtil.ItemCallback<UserModel>() {
        override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        viewBinding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(data[position], context)
    }

    fun addNewData(list: List<UserModel>) {
        data.clear()
        data.addAll(list)
    }

    fun setOnClickListener(onClickListener: ItemListListener){
        this.itemListListener = onClickListener
    }

    inner class DataViewHolder(viewBinding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        private val rootView = viewBinding.containerItemList
        private val textViewUserName: TextView = viewBinding.textViewUserName
        private val textViewUserPhone: TextView = viewBinding.textViewUserPhone
        private val imageViewAvatar: ImageView = viewBinding.imageViewAvatar
        fun bind(user: UserModel, context: Context) {
            textViewUserName.text = user.name
            textViewUserPhone.text = user.phone
            imageViewAvatar.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_launcher_foreground
                )
            )
            rootView.setOnClickListener {
                itemListListener?.onItemClick(user)
            }

        }
    }
}