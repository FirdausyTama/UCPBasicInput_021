package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun DaftarMain(modifier: Modifier = Modifier) {
    Column() {
        HeaderSection()
        var nama by remember { mutableStateOf("") }
        var noTelpon by remember { mutableStateOf("") }
        var memilihJk by remember { mutableStateOf("") }

        var namasv by remember { mutableStateOf("") }
        var noTelponsv by remember { mutableStateOf("") }
        var memilihJksv by remember { mutableStateOf("") }

        val listJk = listOf("Laki-laki", "Perempuan")

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Text(
                text = "Yuk Lengkapi Data Dirimu!",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama") },
                placeholder = { Text("Masukan Nama Anda") }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                value = noTelpon,
                onValueChange = { noTelpon = it },
                label = { Text("No Tlp") },
                placeholder = { Text("Masukan No Tlp") }
            )
            Text(
                text = "Jenis Kelamin",
                modifier = Modifier.padding(start = 5.dp)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                listJk.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = memilihJk == item,
                            onClick = {
                                memilihJk = item
                            }
                        )
                        Text(item)
                    }
                }
            }
            Button(modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Blue) ,onClick = {
                namasv = nama
                noTelponsv = noTelpon
                memilihJksv = memilihJk
            }) {
                Text(
                    "Simpan"

                )
            }
            Box(modifier = Modifier) {

                ElevatedCard(
                    colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Text(text = "Nomor Handphone",
                        modifier = Modifier.padding(10.dp))
                    ElevatedCard(
                        colors = CardDefaults.cardColors(containerColor = Color.Blue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    ) {
                        Row (verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            Icon(
                                imageVector = Icons.Filled.Call,
                                contentDescription = "",
                                modifier = Modifier.size(30.dp)
                                    .padding(start = 10.dp),
                                Color.White
                            )
                            DetailSurat(isinya = noTelponsv)
                        }
                    }
                    Text(text = "Jenis Kelamin",
                        modifier = Modifier.padding(10.dp))
                    ElevatedCard(
                        colors = CardDefaults.cardColors(containerColor = Color.Blue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .padding(bottom = 20.dp)
                    ) {
                        Row (verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "",
                                modifier = Modifier.size(30.dp)
                                    .padding(start = 10.dp),
                                Color.White
                            )
                            DetailSurat(isinya = memilihJksv)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Blue)
            .padding(15.dp)
    )
    {
        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column {
                Icon(imageVector = Icons.Filled.Menu,
                    contentDescription = "",
                    modifier = Modifier.size(40.dp),
                    Color.White
                )
                Text(
                    text = "Halo,",
                    modifier = Modifier .padding(top = 10.dp),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Ini harusnya nama",
                    modifier = Modifier,
                    fontSize = 20.sp,
                    color = Color.White
                )

            }
            Box(
                contentAlignment = Alignment.BottomStart
            )
            {
                Image(painter = painterResource(id = R.drawable.orang2),
                    contentDescription = null, modifier = Modifier.size(100.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}

@Composable
fun DetailSurat(
    isinya: String
){
    Row (
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    )
    {
        Text(text = ":",
            modifier = Modifier.padding(start = 10.dp),
            Color.White)
        Text(text = isinya,
            modifier = Modifier.padding(start = 10.dp),
            Color.White)
    }
}