package com.botcraft.codingchallenge.presentation.locks

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.botcraft.codingchallenge.R
import com.botcraft.codingchallenge.databinding.ActivityLocksBinding
import com.botcraft.codingchallenge.domain.model.*
import com.botcraft.codingchallenge.utils.isNetworkAvailable
import org.koin.androidx.viewmodel.ext.android.viewModel

class LockAttributesActivity : AppCompatActivity(),  androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private lateinit var activityPostsBinding: ActivityLocksBinding
    private var mAdapter: LockAttributesAdapter? = LockAttributesAdapter()
    private val postViewModel: LockAttributesViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPostsBinding = DataBindingUtil.setContentView(this, R.layout.activity_locks)

        activityPostsBinding.recyclerView.adapter = mAdapter

        activityPostsBinding.searchLayout.findViewById<androidx.appcompat.widget.SearchView>(R.id.search_view)
            .setOnQueryTextListener(this)

        if (isNetworkAvailable()) {
            postViewModel.getPosts()
        } else {
            Toast.makeText(
                this,
                getString(R.string.no_internet_connection),
                LENGTH_SHORT
            ).show()
        }

        with(postViewModel) {

            locksData.observe(this@LockAttributesActivity, Observer {
                activityPostsBinding.progressBar.visibility = GONE
                val items = listOf(
                    LockVoltageWrapper(
                        it.lockVoltage as LockVoltage,
                        it.lockVoltage as LockVoltage
                    ),
                    LockTypeWrapper(it.lockType as LockType, it.lockType as LockType),
                    LockKickWrapper(it.lockKick as LockKick, it.lockKick as LockKick),
                    LockReleaseWrapper(
                        it.lockRelease as LockRelease,
                        it.lockRelease as LockRelease
                    ),
                    LockReleaseTimeWrapper(
                        it.lockReleaseTime as LockReleaseTime,
                        it.lockReleaseTime as LockReleaseTime
                    ),
                    LockTypeWrapper(
                        it.lockType as LockType,
                        it.lockType as LockType
                    )
                )
                mAdapter?.addData(items)
            })

            messageData.observe(this@LockAttributesActivity, Observer {
                Toast.makeText(this@LockAttributesActivity, it, LENGTH_LONG).show()
            })

            showProgressbar.observe(this@LockAttributesActivity, Observer { isVisible ->
                activityPostsBinding.progressBar.visibility = if (isVisible) VISIBLE else GONE
            })
        }
    }


    override fun onDestroy() {
        mAdapter = null
        super.onDestroy()
    }

    companion object {
        private val TAG = LockAttributesActivity::class.java.name
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        mAdapter?.filter?.filter(p0)
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        mAdapter?.filter?.filter(p0)
        return false
    }
}
