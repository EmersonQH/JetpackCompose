package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                val listaUsuarios = remember { mutableStateListOf<Usuario>() }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ){
                        ScreenCRUD(listaUsuarios)
                    }
                }
            }
        }
    }
}
@Composable
fun ScreenCRUD( listaUsuarios: MutableList<Usuario>){
    var nombre by remember { mutableStateOf("") }
    var fechaRegistro by remember { mutableStateOf("") }
    var tipoSangre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var montoPago by remember { mutableStateOf("") }

    var isEditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Agregar Asistente") }

    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(12.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ) {
            Formulario(
                nombre = nombre,
                funNombre = { nombre = it },
                fechaRegistro = fechaRegistro,
                funFechaRegistro = { fechaRegistro = it },
                tipoSangre = tipoSangre,
                funTipoSangre = { tipoSangre = it },
                telefono = telefono,
                funTelefono = { telefono = it },
                correo = correo,
                funCorreo = { correo = it },
                montoPago = montoPago,
                funMontoPago = { montoPago = it },


                isEditando = isEditando,
                funIsEditando = { isEditando = false },
                textButton = textButton,
                funTextButton = { textButton = it },
                listaUsuarios = listaUsuarios,
                funResetCampos = {
                    nombre = ""
                    fechaRegistro = ""
                    tipoSangre = ""
                    telefono = ""
                    correo = ""
                    montoPago = ""

                }
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(listaUsuarios) { usuario ->

                        CardUsuario(
                            funNombre = { nombre = it },
                            funFechaRegistro = { fechaRegistro = it },
                            funTipoSangre =  { tipoSangre = it },
                            funTelefono = {telefono = it},
                            funCorreo =  { correo = it },
                            funMontoPago ={montoPago = it},

                            usuario = usuario,
                            funTextButton = { textButton = it },
                            funIsEditando = { isEditando = it },
                            funBorrarUsuario = { borrarUsuario(it, listaUsuarios ) }
                        )
                    }
                }
            }
        }
    }
}

fun agregarUsuario(nombre: String, fechaRegistro : String, tipoSangre : String,
                   tefefono : String,correo: String, montoPago : String,
                   listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.add(Usuario(nombre, fechaRegistro, tipoSangre, tefefono, correo, montoPago))
}

fun editarUsuario(nombre: String, fechaRegistro : String, tipoSangre : String,
                  tefefono : String,correo: String, montoPago : String,
                  listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.forEach { usuario ->
        if (usuario.nombre == nombre) {
            usuario.fechaRegistro = fechaRegistro
            usuario.tipoSangre = tipoSangre
            usuario.tefefono = tefefono
            usuario.correo = correo
            usuario.montoPago = montoPago

        }
    }
}

fun borrarUsuario(nombre: String, listaUsuarios: MutableList<Usuario>) {
    listaUsuarios.forEach { usuario ->
        if (usuario.nombre == nombre) {
            listaUsuarios.remove(usuario)
        }
    }
}










