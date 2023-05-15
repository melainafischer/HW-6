package com.fischer.msu.criminalintent2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fischer.msu.criminalintent2.databinding.ListItemCrimePoliceBinding
import android.text.format.DateFormat
import java.util.*

class CrimeHolder(
    private val binding: ListItemCrimePoliceBinding,
    private val onCrimeClickListener: CrimeListAdapter.OnItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title

        // Format the date
        val formattedDate = DateFormat.format("MMM d, yyyy", crime.date).toString()
        binding.crimeDate.text = formattedDate

        binding.root.setOnClickListener {
            onCrimeClickListener.onItemClick(crime)
        }

        binding.crimeSolved.visibility = if (crime.isSolved) {
            View.VISIBLE
        } else {
            View.GONE
        }

        binding.crimeSolved.visibility = if (crime.isSolved) {
            View.VISIBLE
            }
        else{
            View.GONE
            }
        }
    }

class PoliceHolder(
    private val binding: ListItemCrimePoliceBinding,
    private val onCrimeClickListener: CrimeListAdapter.OnItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title

        // Format the date
        val formattedDate = DateFormat.format("MMM d, yyyy", crime.date).toString()
        binding.crimeDate.text = formattedDate

        binding.contactPoliceButton.setOnClickListener {
            onCrimeClickListener.onContactPoliceClick(crime)
        }
    }
}


class CrimeListAdapter(private val onCrimeClickListener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_NORMAL = 1
        const val VIEW_TYPE_POLICE = 2
    }

    private var crimeList = emptyList<Crime>()

    interface OnItemClickListener {
        fun onItemClick(crime: Crime)
        fun onContactPoliceClick(crime: Crime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_TYPE_POLICE) {
            val binding = ListItemCrimePoliceBinding.inflate(inflater, parent, false)
            PoliceHolder(binding, onCrimeClickListener)
        } else {
            val binding = ListItemCrimePoliceBinding.inflate(inflater, parent, false)
            CrimeHolder(binding, onCrimeClickListener)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val crime = crimeList[position]
        if (holder is CrimeHolder) {
            holder.bind(crime)
        } else if (holder is PoliceHolder) {
            holder.bind(crime, onCrimeClicked)
        }
    }

    override fun getItemCount(): Int = crimeList.size

    override fun getItemViewType(position: Int): Int {
        val crime = crimeList[position]
        return if (crime.requiresPolice) {
            VIEW_TYPE_POLICE
        } else {
            VIEW_TYPE_NORMAL
        }
    }

    fun setCrimeList(crimeList: List<Crime>) {
        this.crimeList = crimeList
        notifyDataSetChanged()
    }
}