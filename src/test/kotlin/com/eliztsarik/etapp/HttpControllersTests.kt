package com.eliztsarik.etapp

import com.eliztsarik.etapp.entity.Article
import com.eliztsarik.etapp.entity.User
import com.eliztsarik.etapp.repo.ArticleRepository
import com.eliztsarik.etapp.repo.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest
class HttpControllersTests(
        @Autowired
        val mockMvc: MockMvc
) {
    @MockBean
    private lateinit var userRepository: UserRepository

    @MockBean
    private lateinit var articleRepository: ArticleRepository

    @Test
    fun `List Articles`() {
        val nemo = User("fishnemo", "Nemo", "UnknownFish")
        val article1 = Article("Find Dory 1", "We're on our way", "Interesting", nemo)
        val article2 = Article("Find Dory 3", "We're on our way", "Interesting", nemo)
        every { articleRepository.findAllByOrderByAddedAtDesc() } returns listOf(article1, article2)
        mockMvc.perform()
    }
}