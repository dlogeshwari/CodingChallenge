package com.botcraft.codingchallenge.presentation.locks

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.botcraft.codingchallenge.R
import com.botcraft.codingchallenge.databinding.HolderLockAttrBinding
import com.botcraft.codingchallenge.domain.model.*

import kotlin.properties.Delegates

@SuppressLint("NotifyDataSetChanged")
class LockAttributesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Filterable {

    var mLockList: List<LockAttribute> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    fun addData(list: List<LockAttribute>) {
        mLockList = list
        mLockListFiltered = mLockList
        notifyDataSetChanged()
    }

    var mLockListFiltered: List<LockAttribute> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderLockBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.holder_lock_attr, parent, false
        )
        return LockViewHolder(holderLockBinding)
    }

    override fun getItemViewType(position: Int): Int {
        return mLockListFiltered.get(position).type
    }

    override fun getItemCount(): Int =
        if (mLockListFiltered.isEmpty()) 0 else mLockListFiltered.size

    private fun getItem(position: Int): LockAttribute = mLockListFiltered[position]

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as LockViewHolder).onBind(getItem(position))
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint?.toString() ?: ""
                if (charString.isEmpty()) mLockListFiltered = mLockList else {
                    val filteredList = ArrayList<LockAttribute>()
                    mLockList
                        .filter {

                            when (it) {
                                is LockVoltageWrapper -> (it.primary.default?.contains(constraint!!)!!)
                                is LockTypeWrapper -> (it.primary.default?.contains(constraint!!)!!)
                                is LockKickWrapper -> (it.primary.default?.contains(constraint!!)!!)
                                is LockReleaseWrapper -> (it.primary.default?.contains(constraint!!)!!)
                                //   is LockAngelWrapper -> (it.primary.default?.contains(constraint!!)!!)
                                //   is LockReleaseTimeWrapper -> (it.primary.default?.contains(constraint!!)!!)

                                else -> {
                                    false
                                }
                            }
                        }
                        .forEach { filteredList.add(it) }
                    mLockListFiltered = filteredList

                    Log.e("performFiltering: t1: ", filteredList.size.toString())

                }
                return FilterResults().apply { values = mLockListFiltered }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                mLockListFiltered = if (results?.values == null)
                    ArrayList()
                else
                    results.values as List<LockAttribute>
                notifyDataSetChanged()

                Log.e("performFiltering: t2 ", "called" + mLockListFiltered.size)

            }
        }
    }

    private inner class LockViewHolder(private val viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        fun onBind(lock: LockAttribute) {
            (viewDataBinding as HolderLockAttrBinding)
            if (lock is LockVoltageWrapper) {
                viewDataBinding.lockName.text = LOCK_VOLTAGE
                viewDataBinding.primary.text = lock.primary.default
                viewDataBinding.secondary.text = lock.secondary.default
            }
            if (lock is LockTypeWrapper) {
                viewDataBinding.lockName.text = LOCK_TYPE
                viewDataBinding.primary.text = lock.primary.default
                viewDataBinding.secondary.text = lock.secondary.default
            }
            if (lock is LockKickWrapper) {
                viewDataBinding.lockName.text = LOCK_KICK
                viewDataBinding.primary.text = lock.primary.default
                viewDataBinding.secondary.text = lock.secondary.default
            }
            if (lock is LockReleaseWrapper) {
                viewDataBinding.lockName.text = LOCK_RELEASE
                viewDataBinding.primary.text = lock.primary.default
                viewDataBinding.secondary.text = lock.secondary.default
            }
            if (lock is LockReleaseTimeWrapper) {
                viewDataBinding.lockName.text = LOCK_RELEASE_TIME
                viewDataBinding.primary.text = lock.primary.default.toString()
                viewDataBinding.secondary.text = lock.secondary.default.toString()
            }
            if (lock is LockAngelWrapper) {
                viewDataBinding.lockName.text = LOCK_ANGLE
                viewDataBinding.primary.text = lock.primary.default.toString()
                viewDataBinding.secondary.text = lock.secondary.default.toString()
            }

        }
    }

    companion object {
        const val LOCK_VOLTAGE = "Lock Voltage"
        const val LOCK_TYPE = "Lock Type"
        const val LOCK_KICK = "Lock Kick"
        const val LOCK_RELEASE = "Lock Release"
        const val LOCK_RELEASE_TIME = "Lock Release Time"
        const val LOCK_ANGLE = "Lock Angle"
    }
}