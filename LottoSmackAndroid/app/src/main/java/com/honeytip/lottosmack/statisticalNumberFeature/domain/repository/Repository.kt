package com.honeytip.lottosmack.statisticalNumberFeature.domain.repository

import com.honeytip.lottosmack.statisticalNumberFeature.domain.model.StatisticalNumber

interface Repository {
    fun getStatisticalNumber(): List<StatisticalNumber>
}