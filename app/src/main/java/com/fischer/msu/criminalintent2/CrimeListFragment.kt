package com.fischer.msu.criminalintent2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fischer.msu.criminalintent2.databinding.FragmentCrimeListBinding
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*

//private const val TAG = "CrimeListFragment"

class CrimeListFragment : Fragment() { //CrimeListAdapter.OnItemClickListener {

    private var _binding: FragmentCrimeListBinding? = null
    private val binding get() = checkNotNull(_binding) { "FragmentCrimeListBinding cannot be null" }

    private val crimeListViewModel: CrimeListViewModel by viewModels()

    //private var job: Job? = null
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total crimes: ${crimeListViewModel.crimes.size}")
    }*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrimeListBinding.inflate(inflater, container, false)

        /*val crimeListAdapter = CrimeListAdapter(this)
        binding.crimeRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.crimeRecyclerView.adapter = crimeListAdapter*/

        return binding.root
    }

    /*override fun onStart() {
        super.onStart()

        job = viewLifecycleOwner.lifecycleScope.launch {
            val crimes = crimeListViewModel.loadCrimes()
            binding.crimeRecyclerView.adapter = CrimeListAdapter(crimes)
        }
    }

    override fun onStop() {
        super.onStop()
        job?.cancel()
    }*/

    fun onCrimeClick(crimeId: UUID) {
        // need to add the handl for the click event for a specific crime here
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                //val crimes = crimeListViewModel.loadCrimes()
                binding.crimeRecyclerView.adapter =
                    CrimeListAdapter(crimes){
                        findNavController().navigate(
                            //R.id.show_crime_detail
                        CrimeListFragmentDirections.showCrimeDetail()
                        )
                    }
            }
        }
    }

    override fun onItemClick(crime: Crime) {
        TODO("Not yet implemented")
    }

    override fun onContactPoliceClick(crime: Crime) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
