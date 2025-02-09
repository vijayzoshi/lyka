package com.example.myapplication

import android.util.Log

class ClassC {

    val classA = ClassA()
    val classB = ClassB()


    fun startClassC(){

        classA.startClassA()
        classB.startClassB()
        Log.i("TAG", "Class C is created")
    }
}