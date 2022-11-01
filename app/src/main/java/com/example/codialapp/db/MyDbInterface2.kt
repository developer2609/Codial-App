package com.example.codialapp.db

import com.example.codialapp.models.Course
import com.example.codialapp.models.Guruh
import com.example.codialapp.models.Mentor

interface MyDbInterface2 {

   fun  addCourse(course: Course)

   fun getAllCourse():List<Course>
   fun getAllMentor():List<Mentor>
   fun getCourseById(id:Int):Course

   fun deleteMentor(mentor: Mentor)
    fun editMentor(mentor: Mentor)


   fun addGuruh(guruh: Guruh)
   fun getGuruh(): ArrayList<Guruh>
   fun updateGuruh(guruh: Guruh): Int
   fun deleteGuruh(guruh: Guruh)
   fun getMentorById(id: Int): Mentor


   fun addMentor(mentor: Mentor)
}

fun MyDbInterface2.addMentor(mentor: Mentor) {

}