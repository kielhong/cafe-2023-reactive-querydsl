package com.widehouse.cafe.cafe.repository

import com.widehouse.cafe.cafe.model.Cafe
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository

interface CafeRepository : CrudRepository<Cafe, Long>, QuerydslPredicateExecutor<Cafe>
