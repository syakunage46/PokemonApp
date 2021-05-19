package com.example.redux.annotation

import com.google.auto.common.BasicAnnotationProcessor
import com.google.common.collect.ImmutableSetMultimap
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import javax.annotation.processing.Filer
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.Element
import javax.lang.model.element.ElementKind
import javax.lang.model.type.MirroredTypeException
import javax.lang.model.type.TypeMirror
import kotlin.reflect.KClass
import kotlin.reflect.KTypeProjection


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Reducer(val elementReducerInterface: KClass<*>)

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class ElementReducer

class ElementReducersStep(private val processingEnv: ProcessingEnvironment) : BasicAnnotationProcessor.Step{
    companion object {
        const val BUILD_CLASS_NAME = "ReducerHelper"
    }

    private val filer: Filer = processingEnv.filer

    override fun annotations() = setOf(Reducer::class.java.name, ElementReducer::class.java.name)

    override fun process(elementsByAnnotation: ImmutableSetMultimap<String, Element>): MutableSet<out Element> {
        val reducer = elementsByAnnotation[Reducer::class.java.name].firstOrNull() ?: throw Exception("@Reducerが見つかりません。@ReducerをReducerクラスにつけてください")
        val elements = elementsByAnnotation[ElementReducer::class.java.name].filter { it.kind == ElementKind.CLASS }
        generate(reducer, elements)
        return mutableSetOf()
    }

    private fun generate(reducer: Element, elements: List<Element>){
        val packageName = (reducer.asType().asTypeName() as ClassName).packageName

        val star = TypeVariableName("*")
        val list = ClassName("kotlin.collections", "List")
        val reducerClass = (getElementReducerInterfaceType(reducer).asTypeName() as ClassName).parameterizedBy(star)
        val reducerList = list.parameterizedBy(reducerClass)

        val classNames = elements.map{ it.asType().asTypeName() as ClassName }
        val codeBlock = CodeBlock.builder()
            .addStatement("listOf(")
        classNames.forEach {
            codeBlock.addStatement("%T(),", it)
        }

        val elementReducers = PropertySpec.builder("elementReducers", reducerList)
            .initializer(codeBlock.addStatement(")").build())
            .build()
        val typeSpec = TypeSpec.objectBuilder(BUILD_CLASS_NAME).apply {
            addProperty(elementReducers)
        }.build()
        val file = FileSpec.builder(packageName,  BUILD_CLASS_NAME)
            .addType(typeSpec)
            .build()

        file.writeTo(filer)
    }

    private fun getElementReducerInterfaceType(reducer: Element): TypeMirror {
        val reducerAnnotation = reducer.getAnnotation(Reducer::class.java)
        return try {
            val classString = reducerAnnotation.elementReducerInterface.toString()
            processingEnv.elementUtils.getTypeElement(classString).asType()
        } catch (mte: MirroredTypeException) {
            mte.typeMirror
        }
    }
}