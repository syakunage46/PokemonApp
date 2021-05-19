package com.example.redux.annotation

import com.google.auto.common.BasicAnnotationProcessor
import com.google.auto.service.AutoService
import javax.annotation.processing.Processor
import javax.lang.model.SourceVersion

@AutoService(Processor::class)
class ReduxAnnotationProcessor : BasicAnnotationProcessor() {
    override fun getSupportedSourceVersion(): SourceVersion = SourceVersion.latestSupported()

    override fun getSupportedOptions(): Set<String> = setOf()

    override fun steps(): Iterable<Step> {
        return listOf(ElementReducersStep(processingEnv))
    }
}