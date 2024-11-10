package com.example.menutypeapp

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val buttonPopup: Button = findViewById(R.id.buttonPop)
        val buttonContext: Button = findViewById(R.id.buttonContext)

        // Configuración del botón Pop
        buttonPopup.setOnClickListener { showPopMenu(it) }

        // Registro del botón para el menú contextual
        registerForContextMenu(buttonContext)
    }

    // Creación del menú de opciones
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Manejo de selección en el menú de opciones
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> Toast.makeText(this, "Seleccionaste Item1 en Opciones", Toast.LENGTH_SHORT).show()
            R.id.item2 -> Toast.makeText(this, "Seleccionaste Item2 en Opciones", Toast.LENGTH_SHORT).show()
            R.id.subItem1 -> Toast.makeText(this, "Seleccionaste SubItem1", Toast.LENGTH_SHORT).show()
            R.id.subItem2 -> Toast.makeText(this, "Seleccionaste SubItem2", Toast.LENGTH_SHORT).show()
            R.id.subItem2 -> Toast.makeText(this, "Seleccionaste SubItem3", Toast.LENGTH_SHORT).show()
            R.id.subItem2 -> Toast.makeText(this, "Seleccionaste SubItem4", Toast.LENGTH_SHORT).show()
            R.id.subItem2 -> Toast.makeText(this, "Seleccionaste SubItem5", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    // Creación del menú contextual
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    // Manejo de selección en el menú contextual
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.copy -> Toast.makeText(this, "Seleccionaste Copiar", Toast.LENGTH_SHORT).show()
            R.id.paste -> Toast.makeText(this, "Seleccionaste Pegar", Toast.LENGTH_SHORT).show()
            R.id.cut -> Toast.makeText(this, "Seleccionaste Cortar", Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }

    // Mostrar el menú Popup
    private fun showPopMenu(view: View) {
        val popMenu = PopupMenu(this, view) // Usa PopupMenu en lugar de popmenu
        popMenu.menuInflater.inflate(R.menu.popmenu, popMenu.menu)
        popMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.item1 -> Toast.makeText(this, "Seleccionaste Notificaciones en Popup", Toast.LENGTH_SHORT).show()
                R.id.item2 -> Toast.makeText(this, "Seleccionaste Nuevo Documento en Popup", Toast.LENGTH_SHORT).show()
                R.id.item3 -> Toast.makeText(this, "Seleccionaste Privacidad y Seguridad en Popup", Toast.LENGTH_SHORT).show()
            }
            true
        }
        popMenu.show()
    }
}
