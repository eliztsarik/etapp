package com.eliztsarik.etapp

import com.eliztsarik.etapp.entity.Article
import com.eliztsarik.etapp.entity.User
import com.eliztsarik.etapp.repo.ArticleRepository
import com.eliztsarik.etapp.repo.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepoTest @Autowired constructor(
        val entityManager: TestEntityManager,
        val userRepository: UserRepository,
        val articleRepository: ArticleRepository
) {

    @Test
    fun `When findByIdOrNull then return Article`() {
        val nemo = User("fishnemo", "Nemo", "UnknownFish")
        entityManager.persist(nemo)
        val article = Article("Find Dory", "We're on our way", "Interesting", nemo)
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then retutn User`() {
        val nemo = User("fishnemo", "Nemo", "UnknownFish")
        entityManager.persist(nemo)
        entityManager.flush()
        val user = userRepository.findByLogin(nemo.login)
        assertThat(user).isEqualTo(nemo)
    }
}