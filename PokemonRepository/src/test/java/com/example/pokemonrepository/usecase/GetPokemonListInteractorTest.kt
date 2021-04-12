package com.example.pokemonrepository.usecase

import com.example.pokemonrepository.data.PokemonRepositoryItem
import com.example.pokemonrepository.repository.datasource.PokemonDataSource
import com.example.pokemonrepository.repository.datasource.local.PokemonLocalDataSource
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class GetPokemonListInteractorTest {

    lateinit var pokemonDataSource: PokemonDataSource
    lateinit var pokemonLocalDataSource: PokemonLocalDataSource
    lateinit var pokemonRemoteDataSource: PokemonLocalDataSource
    lateinit var getPokemonList: GetPokemonListInteractor

    @Before
    fun setup(){
        pokemonDataSource = mock()
        getPokemonList = GetPokemonListInteractor(pokemonDataSource)
    }

    @Test
    fun example() {
        pokemonLocalDataSource = mock {
            onBlocking {getPokemonList(0,0)} doReturn emptyList()
        }

        pokemonDataSource = mock {
            on{local} doReturn pokemonLocalDataSource
        }
        getPokemonList = GetPokemonListInteractor(pokemonDataSource)
        runBlockingTest {
            getPokemonList(0,0)
        }
    }

}