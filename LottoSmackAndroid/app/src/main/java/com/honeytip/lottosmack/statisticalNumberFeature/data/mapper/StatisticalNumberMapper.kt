package com.honeytip.lottosmack.statisticalNumberFeature.data.mapper

import com.honeytip.lottosmack.statisticalNumberFeature.data.remote.StatisticalNumberDto
import com.honeytip.lottosmack.statisticalNumberFeature.domain.model.StatisticalNumber

fun StatisticalNumberDto.toStatisticalNumber() : StatisticalNumber {
    return StatisticalNumber(
        rank = rank,
        number = number
    )
}