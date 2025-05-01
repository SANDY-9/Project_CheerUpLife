package com.cheeruplife.feature.recruit.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cheeruplife.core.designsystem.common.Dimens
import com.cheeruplife.core.designsystem.component.LifeCheckButtonControlView
import com.cheeruplife.core.model.enums.CompanyType

private val companyTypeEntries = CompanyType.entries.map { it.name }

@Composable
internal fun RecruitCompanyTypeFilter(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = Dimens.Margin16,
                bottom = Dimens.Margin8,
            ),
    ) {
        LifeCheckButtonControlView(
            controlSelect = true,
            itemList = companyTypeEntries,
            itemSelectMap = companyTypeEntries.associateWith { true },
            onControlSelectChange = {},
            onItemSelectChange = { _, _ -> }
        )
    }
}

@Preview(name = "RecruitCompanyTypeFilter")
@Composable
private fun PreviewRecruitCompanyTypeFilter() {
    RecruitCompanyTypeFilter()
}