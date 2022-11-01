package com.example.codialapp.models

import java.io.Serializable

class Mentor:Serializable {
    var id:Int=0
    var name:String=""
    var surname:String=""
    var number:String=""
    var course:Course?=null

    constructor(id: Int, name: String, surname: String, number: String, course: Course) {
        this.id = id
        this.name = name
        this.surname = surname
        this.number = number
        this.course = course
    }

    constructor(name: String, surname: String, number: String, course: Course) {
        this.name = name
        this.surname = surname
        this.number = number
        this.course = course
    }

    override fun toString(): String {
        return "Mentor(id=$id, name='$name', surname='$surname', number='$number')"
    }


}