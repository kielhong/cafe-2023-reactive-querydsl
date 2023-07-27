package com.widehouse.cafe.cafe.data

import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Long>, CategoryQueryRepository
