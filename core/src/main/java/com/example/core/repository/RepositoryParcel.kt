package com.example.core.repository

interface RepositoryQuery<T>

class RepositoryParcel<T, Q: RepositoryQuery<T>>(val query: Q) {
    lateinit var result: Result<T>
}

