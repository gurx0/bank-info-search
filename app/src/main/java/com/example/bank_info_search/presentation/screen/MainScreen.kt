package com.example.bank_info_search.presentation.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.example.bank_info_search.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel, onNavigateToHistory: () -> Unit) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        TextField(
            value = uiState.binInput,
            onValueChange = viewModel::onBinInputChange,
            label = { Text("Enter BIN") }
        )
        Button(onClick = viewModel::fetchBinDetails) { Text("Get Details") }
        Button(onClick = onNavigateToHistory) { Text("View History") }

        uiState.binDetails?.let { details ->
            Text("Country: ${details.country?.name}")
            Text("Coordinates: ${details.country?.latitude}, ${details.country?.longitude}")
            details.country?.let { country ->
                if (country.latitude != null && country.longitude != null) {
                    Text(
                        text = "Open in Maps",
                        modifier = androidx.compose.ui.Modifier.clickable {
                            val uri = Uri.parse("geo:${country.latitude},${country.longitude}")
                            val intent = Intent(Intent.ACTION_VIEW, uri)
                            context.startActivity(intent)
                        }
                    )
                }
            }
            details.bank?.let { bank ->
                Text(
                    text = "Bank Website: ${bank.url}",
                    modifier = androidx.compose.ui.Modifier.clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://${bank.url}"))
                        context.startActivity(intent)
                    }
                )
                Text(
                    text = "Call Bank: ${bank.phone}",
                    modifier = androidx.compose.ui.Modifier.clickable {
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${bank.phone}"))
                        context.startActivity(intent)
                    }
                )
            }
        }
    }
}
