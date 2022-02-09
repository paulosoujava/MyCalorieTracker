package com.paulo.onboarding_presentation.gender

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
import com.paulo.core.domain.model.Gender
import com.paulo.onboarding_presentation.components.ActionButton
import com.paulo.onboarding_presentation.components.SelectableButton
import kotlinx.coroutines.flow.collect

@Composable
fun GenderScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: GenderViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { ev ->
            when (ev) {
                is UiEvent.Navigate -> onNavigate(ev)
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
                text = stringResource(id = R.string.whats_your_gender),
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                buildButton(
                    stringId = R.string.male,
                    isSelected = viewModel.selectedGender is Gender.Male,
                    onClick = { viewModel.onGenderClick(Gender.Male) }
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                buildButton(
                    stringId = R.string.female,
                    isSelected = viewModel.selectedGender is Gender.Female,
                    onClick = { viewModel.onGenderClick(Gender.Female) }
                )
                /*SelectableButton(
                    text = stringResource(id = R.string.male),
                    isSelected = viewModel.selectedGender is Gender.Male,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onGenderClick(Gender.Male)
                    },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                SelectableButton(
                    text = stringResource(id = R.string.female),
                    isSelected = viewModel.selectedGender is Gender.Female,
                    color = MaterialTheme.colors.primaryVariant,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onGenderClick(Gender.Female)
                    },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal
                    )
                )*/
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