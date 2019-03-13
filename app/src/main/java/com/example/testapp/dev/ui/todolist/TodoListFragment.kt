package com.example.testapp.dev.ui.todolist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.dev.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import javax.inject.Inject

@SuppressLint("ValidFragment")
class TodoListFragment @Inject constructor(
    private val viewModelFactory: ViewModelProvider.Factory
) : Fragment() {

    private val viewModel: TodoListViewModel by viewModels { viewModelFactory }
    
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_todo_list, container, false)
        recyclerView = view.findViewById(R.id.todo_list)
        fab = view.findViewById(R.id.fab)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //removed logic
    }

}
