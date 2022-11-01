package com.example.codialapp.models

import java.io.Serializable

class Course: Serializable {

    var id:Int=0
    var name:String=""
    var about:String=""

    constructor( name: String, about: String) {
        this.name = name
        this.about = about
    }

    constructor(id: Int, name: String, about: String) {
        this.id = id
        this.name = name
        this.about = about
    }


    override fun toString(): String {
        return "Course(id=$id, name='$name', about='$about')"
    }


}