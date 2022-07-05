package com.example.core.base

typealias BaseMapper<Input, Output> = (Input) -> Output

fun <Input, Output> BaseMapper<Input, Output>.fromToList(input: List<Input>?) =
    input?.map {
        invoke(it)
    }

