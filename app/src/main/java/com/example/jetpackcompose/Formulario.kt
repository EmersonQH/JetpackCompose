package com.example.jetpackcompose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Formulario(
    nombre: String,
    funNombre: (String) -> Unit,
    fechaRegistro : String,
    funFechaRegistro: (String) -> Unit,
    tipoSangre: String,
    funTipoSangre: (String) -> Unit,
    telefono: String,
    funTelefono: (String) -> Unit,
    correo: String,
    funCorreo: (String) -> Unit,
    montoPago: String,
    funMontoPago: (String) -> Unit,

    isEditando: Boolean,
    funIsEditando: () -> Unit,
    textButton: String,
    funTextButton: (String) -> Unit,
    listaUsuarios: MutableList<Usuario>,
    funResetCampos: () -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nombre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funNombre(it) },
        label = { Text(text = "Nombre") },
        //enabled = !isEditando
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = fechaRegistro,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funFechaRegistro(it) },
        label = { Text(text = "Fecha Registro") },

    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = tipoSangre,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funTipoSangre(it) },
        label = { Text(text = "Tipo Sangre") },

    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = telefono,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funTelefono(it) },
        label = { Text(text = "Telefono") },

    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = correo,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funCorreo(it) },
        label = { Text(text = "Correo") }
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = montoPago,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        onValueChange = { funMontoPago(it) },
        label = { Text(text = "Monto de Pago") },
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))



    Button(modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
        onClick = {
            if (isEditando) {
                editarUsuario(nombre,fechaRegistro,tipoSangre,telefono,correo,montoPago,listaUsuarios)
                funTextButton("Agregar Asistente")
                funIsEditando()

            } else {
                agregarUsuario(nombre,fechaRegistro,tipoSangre,telefono,correo,montoPago,listaUsuarios)
            }
            funResetCampos()
        }
    ) {
        Text(
            color = Color.White,
            text = textButton
        )
    }
}

