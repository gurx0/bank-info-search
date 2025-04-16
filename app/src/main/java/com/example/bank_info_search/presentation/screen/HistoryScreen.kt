package com.example.bank_info_search.presentation.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.example.bank_info_search.data.models.HistoryItem
import com.example.bank_info_search.data.models.BinDomainModel
import com.example.bank_info_search.presentation.viewmodel.HistoryViewModel
import androidx.core.net.toUri

@Composable
fun HistoryScreen(viewModel: HistoryViewModel) {
    val history by viewModel.history.collectAsState()
    var expandedItem by rememberSaveable { mutableStateOf<Int?>(null) }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(history) { item ->
            HistoryListItem(
                historyItem = item,
                isExpanded = expandedItem == item.id,
                onItemClicked = {
                    expandedItem = if (expandedItem == item.id) null else item.id
                }
            )
        }
    }
}

@Composable
fun HistoryListItem(
    historyItem: HistoryItem,
    isExpanded: Boolean,
    onItemClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClicked() },
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "BIN: ${historyItem.bin}",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
                color = MaterialTheme.colorScheme.primary
            )

            if (isExpanded) {
                HorizontalDivider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
                ExpandedDetails(historyItem.data)
            }
        }
    }
}

@Composable
fun ExpandedDetails(binResponse: BinDomainModel) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        binResponse.scheme?.let {
            Text("Scheme: $it", style = MaterialTheme.typography.bodyMedium)
        }
        binResponse.type?.let {
            Text("Type: $it", style = MaterialTheme.typography.bodyMedium)
        }
        binResponse.brand?.let {
            Text("Brand: $it", style = MaterialTheme.typography.bodyMedium)
        }
        binResponse.country?.let { country ->
            Text(
                "Country: ${country.name?: "-"}", style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                "Coordinates: ${country.latitude?: "-"}, ${country.longitude?: "-"}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {
                    val uri = "geo:${country.latitude},${country.longitude}".toUri()
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    context.startActivity(intent)
                }
            )
        }
        binResponse.bank?.let { bank ->

            Text("Bank: ${bank.name?: "-"}", style = MaterialTheme.typography.bodyMedium)
            Text(
                "Website: ${bank.url?: "-"}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_VIEW, "https://${bank.url}".toUri())
                    context.startActivity(intent)
                }
            )

            Text(
                "Phone: ${bank.phone?: "-"}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_DIAL, "tel:${bank.phone}".toUri())
                    context.startActivity(intent)
                }
            )
        }
    }
}
