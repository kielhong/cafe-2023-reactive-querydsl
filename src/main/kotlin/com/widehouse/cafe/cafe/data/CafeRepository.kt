package com.widehouse.cafe.cafe.data

import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository

interface CafeRepository : CrudRepository<Cafe, Long>, QuerydslPredicateExecutor<Cafe>
