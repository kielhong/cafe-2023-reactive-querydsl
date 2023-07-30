package com.widehouse.cafe.cafe.data

import org.springframework.data.repository.CrudRepository

interface CafeRepository : CrudRepository<Cafe, Long>, CafeQueryRepository
