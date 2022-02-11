package com.paulo.onboarding_presentation.activity

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.paulo.core.util.UiEvent
import com.paulo.core_ui.LocalSpacing
import com.paulo.core.R
import com.paulo.core.domain.model.ActivityLevel
import com.paulo.core.domain.model.Gender
import com.paulo.onboarding_presentation.components.ActionButton
import com.paulo.onboarding_presentation.components.SelectableButton
import kotlinx.coroutines.flow.collect

@Composable
fun ActivityScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: ActivityViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { ev ->
            when (ev) {
                is UiEvent.Navigate -> onNavigate(ev)
                else -> Unit
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.whats_your_activity_level),
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                buildButton(
                    stringId = R.string.low,
                    isSelected = viewModel.selectedActivityLevel is ActivityLevel.Low,
                    onClick = { viewModel.onActivityLevelClick(ActivityLevel.Low) }
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                buildButton(
                    stringId = R.string.medium,
                    isSelected = viewModel.selectedActivityLevel is ActivityLevel.Medium,
                    onClick = { viewModel.onActivityLevelClick(ActivityLevel.Medium) }
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                buildButton(
                    stringId = R.string.high,
                    isSelected = viewModel.selectedActivityLevel is ActivityLevel.High,
                    onClick = { viewModel.onActivityLevelClick(ActivityLevel.High) }
                )
            }
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = viewModel::onNextClick,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun buildButton(stringId: Int, isSelected: Boolean, onClick: () -> Unit) {
    SelectableButton(
        text = stringResource(id = stringId),
        isSelected = isSelected,
        color = MaterialTheme.colors.primaryVariant,
        selectedTextColor = Color.White,
        onClick = onClick,
        textStyle = MaterialTheme.typography.button.copy(
            fontWeight = FontWeight.Normal
        )
    )
}