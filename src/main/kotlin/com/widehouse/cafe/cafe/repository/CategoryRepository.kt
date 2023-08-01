package com.widehouse.cafe.cafe.repository

import com.widehouse.cafe.cafe.model.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Long>, CategoryQueryRepository
