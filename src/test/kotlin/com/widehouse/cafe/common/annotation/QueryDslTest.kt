package com.widehouse.cafe.common.annotation

import com.widehouse.cafe.config.QueryDslConfig
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@DataJpaTest
@Import(QueryDslConfig::class)
annotation class QueryDslTest
