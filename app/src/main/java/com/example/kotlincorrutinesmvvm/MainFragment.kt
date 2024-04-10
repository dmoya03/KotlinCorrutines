package com.example.kotlincorrutinesmvvm

// MainFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincorrutinesmvvm.ViewModel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Manejar la acción del botón
        view.findViewById<Button>(R.id.buttonGetData).setOnClickListener {
            getData(view)
        }
    }

    private fun getData(_view: View) {
        // Mostrar el texto de carga
        _view.findViewById<TextView>(R.id.textViewData).text = "Cargando..."

        // Llamar a la función fetchData del ViewModel
        viewModel.fetchData { result ->
            // Actualizar la vista con los datos obtenidos
            GlobalScope.launch(Dispatchers.Main) {
                _view.findViewById<TextView>(R.id.buttonGetData).text = result
            }
        }
    }
}
