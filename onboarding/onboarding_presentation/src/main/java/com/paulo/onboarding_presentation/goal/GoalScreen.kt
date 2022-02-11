package com.paulo.onboarding_presentation.goal

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
import com.paulo.core.domain.model.GoalType
import com.paulo.onboarding_presentation.components.ActionButton
import com.paulo.onboarding_presentation.components.SelectableButton
import kotlinx.coroutines.flow.collect

@Composable
fun GoalScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: GoalViewModel = hiltViewModel()
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
                text = stringResource(id = R.string.lose_keep_or_gain_weight),
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                buildButton(
                    stringId = R.string.keep,
                    isSelected = viewModel.selectedGoal is GoalType.KeepWeight,
                    onClick = { viewModel.onGoalTypeClick(GoalType.KeepWeight) }
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                buildButton(
                    stringId = R.string.gain,
                    isSelected = viewModel.selectedGoal is GoalType.GainWeight,
                    onClick = { viewModel.onGoalTypeClick(GoalType.GainWeight) }
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                buildButton(
                    stringId = R.string.lose,
                    isSelected = viewModel.selectedGoal is GoalType.LoseWeight,
                    onClick = { viewModel.onGoalTypeClick(GoalType.LoseWeight) }
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