package com.fischer.msu.criminalintent2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.fischer.msu.criminalintent2.databinding.FragmentCrimeListBinding
import java.util.*

private const val TAG = "CrimeListFragment"

class CrimeListFragment : Fragment(), CrimeListAdapter.OnItemClickListener {

    private var _binding: FragmentCrimeListBinding? = null
    private val binding get() = checkNotNull(_binding) { "FragmentCrimeListBinding cannot be null" }

    private val viewModel: CrimeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total crimes: ${viewModel.crimes.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrimeListBinding.inflate(inflater, container, false)

        val crimeListAdapter = CrimeListAdapter(this)
        binding.crimeRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.crimeRecyclerView.adapter = crimeListAdapter

        return binding.root
    }

    fun onCrimeClick(crimeId: UUID) {
        // need to add the handl for the click event for a specific crime here
    }

    override fun onItemClick(crime: Crime) {
        TODO("Not yet implemented")
    }

    override fun onContactPoliceClick(crime: Crime) {
        // need to add the handle for the contact police event for a specific crime here
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
