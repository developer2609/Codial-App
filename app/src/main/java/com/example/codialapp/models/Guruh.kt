package com.example.codialapp.models

 class Guruh {

     var id: Int? = null
     var name: String? = null
     var mentor: Mentor? = null
     var time: String? = null
     var daysOfWeek: String? = null
     var open: Int? = null
     var mycourse=0



     constructor(
         id: Int?,
         name: String?,
         mentor: Mentor?,
         time: String?,
         daysOfWeek: String?,
         open: Int?,
         mycourse: Int
     ) {
         this.id = id
         this.name = name
         this.mentor = mentor
         this.time = time
         this.daysOfWeek = daysOfWeek
         this.open = open
         this.mycourse = mycourse
     }

     constructor(
         name: String?,
         mentor: Mentor?,
         time: String?,
         daysOfWeek: String?,
         open: Int?,
         mycourse: Int
     ) {
         this.name = name
         this.mentor = mentor
         this.time = time
         this.daysOfWeek = daysOfWeek
         this.open = open
         this.mycourse = mycourse
     }

     constructor()


 }



