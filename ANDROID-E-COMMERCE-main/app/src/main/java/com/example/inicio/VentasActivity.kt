package com.example.inicio.com.example.inicio

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.inicio.R

class VentasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ventas)

        // Encuentra el Spinner por su ID
        val spinner = findViewById<Spinner>(R.id.Categoria)

        // Verificar si el Spinner existe
        if (spinner != null) {
            // Obtiene el array de opciones desde el archivo strings.xml
            val opciones = resources.getStringArray(R.array.Categorias)

            if (opciones != null && opciones.isNotEmpty()) {
                val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)

                // Establece el diseño para cada opción del menú desplegable
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                // Asigna el adaptador al Spinner
                spinner.adapter = adapter

                spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View,
                        position: Int,
                        id: Long
                    ) {
                        val opcionSeleccionada = parent.getItemAtPosition(position).toString()
                        Toast.makeText(this@VentasActivity, "Seleccionaste: $opcionSeleccionada", Toast.LENGTH_SHORT).show()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // Aquí puedes dejarlo vacío si no necesitas manejar este caso
                    }
                }
            } else {
                // Si no hay opciones disponibles, mostrar un mensaje
                Toast.makeText(this, "No se encontraron categorías", Toast.LENGTH_SHORT).show()
            }
        } else {
            // Si no se encuentra el Spinner, mostrar un mensaje
            Toast.makeText(this, "Error: Spinner no encontrado", Toast.LENGTH_SHORT).show()
        }
    }
}
