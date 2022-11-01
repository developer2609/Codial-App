package com.example.codialapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build.ID
import com.example.codialapp.databinding.FragmentGuruhBinding
import com.example.codialapp.models.Course
import com.example.codialapp.models.Guruh
import com.example.codialapp.models.Mentor

class MyDbHelper2(context: Context?) :
    SQLiteOpenHelper(context, MyDbHelper2.DB_NAME, null, MyDbHelper2.DB_VERSION), MyDbInterface2 {

    companion object {
        const val DB_NAME = "market_db"
        const val DB_VERSION = 8


        const val COURSE_TABLE = "course_table"
        const val COURSE_ID = "id"
        const val COURSE_NAME = "name"
        const val COURSE_ABOUT = "about"


        const val MENTOR_TABLE = "mentor_table"
        const val MENTOR_ID = "id"
        const val MENTOR_NAME = "name"
        const val MENTOR_SURNAME = "surname"
        const val MENTOR_NUMBER = "number"
        const val MENTOR_COURSE_ID = "course_id"

        const val       TABLE_GURHLAR = "Guruhlartable"

        const val GURHLAR_ID = "Gurihlar_id"

        const val NAME_GURUHLAR = "Guruhlarnomi"

        const val MENTOR_GURUHLAR_ID = "Mentorguruhlarid"

        const val VAQT_GURUHLAR = "Gurhlarvaqt"

        const val KUNLAR_GURUHLAR = "Gurhlarkunlar"

        const val OPEN_CLOSE = "OpenClose"

        const val GURUH_MY_COURSE = "GuruhMyCourse"


        const val GROUP_TABLE = "course_table"
        const val GROUP_ID = "id"
        const val GROUP_NAME = "name"
        const val GROUP_TIME = "time"
        const val GROUP_DAY = "day"
        const val GROUP_MENTOR_ID = "mentor_id"


        const val STUDENT_TABLE = "student_table"
        const val STUDENT_ID = "id"
        const val STUDENT_NAME = "name"
        const val STUDENT_NUMBER = "number"


    }

    override fun onCreate(db: SQLiteDatabase?) {

        val queryCourse =
            "create table $COURSE_TABLE($COURSE_ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE ,$COURSE_NAME TEXT NOT NULL ,$COURSE_ABOUT TEXT NOT NULL ); "
        db?.execSQL(queryCourse)

        val queryMentor =
            "create table $MENTOR_TABLE($MENTOR_ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE ,$MENTOR_NAME TEXT NOT NULL ,$MENTOR_SURNAME TEXT NOT NULL ,$MENTOR_NUMBER TEXT NOT NULL,$MENTOR_COURSE_ID INTEGER NOT NULL);"
        db?.execSQL(queryMentor)

        val queryGuruh=
            "CREATE TABLE $TABLE_GURHLAR ($GURHLAR_ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, $NAME_GURUHLAR TEXT NOT NULL, $MENTOR_GURUHLAR_ID INTEGER NOT NULL, $VAQT_GURUHLAR TEXT NOT NULL, $KUNLAR_GURUHLAR TEXT NOT NULL,$OPEN_CLOSE INTEGER NOT NULL, $GURUH_MY_COURSE INTEGER NOT NULL, FOREIGN KEY ($MENTOR_GURUHLAR_ID) REFERENCES $MENTOR_TABLE($MENTOR_ID))"

          db?.execSQL(queryGuruh)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    override fun addCourse(course: Course) {
        val database = writableDatabase
        var contextValuse = ContentValues()
        contextValuse.put(MyDbHelper2.COURSE_NAME, course.name)
        contextValuse.put(MyDbHelper2.COURSE_ABOUT, course.about)
        database.insert(MyDbHelper2.COURSE_TABLE, null, contextValuse)
        database.close()


    }

//    override fun addMentor(mentor: Guruh) {
//    }

    override fun addMentor(mentor: Mentor) {
        var database = writableDatabase
        var contentValues = ContentValues()
        contentValues.put(MENTOR_NAME, mentor.name)
        contentValues.put(MENTOR_SURNAME, mentor.surname)
        contentValues.put(MENTOR_NUMBER, mentor.number)
        contentValues.put(MENTOR_COURSE_ID, mentor.course?.id)
        database.insert(MENTOR_TABLE, null, contentValues)
        database.close()


    }

    override fun getAllCourse(): List<Course> {

        val list = ArrayList<Course>()
        val query = "Select * from ${MyDbHelper2.COURSE_TABLE}"
        val database = readableDatabase
        val cursor = database.rawQuery(query, null)


        if (cursor.moveToFirst()) {

            do {

                list.add(

                    Course(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)


                    )


                )

            } while (cursor.moveToNext())
        }
        return list


    }

    override fun getAllMentor(): List<Mentor> {

        val lists = ArrayList<Mentor>()
        val query = "select * from $MENTOR_TABLE"
        val database = readableDatabase
        val cursor = database.rawQuery(query, null)

        if (cursor.moveToFirst()) {

            do {

                lists.add(

                    Mentor(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        getCourseById(cursor.getInt(4))


                    )
                )


            } while (cursor.moveToNext())
        }

        return lists


    }

    override fun getCourseById(id: Int): Course {
        val database = readableDatabase
        val cursor = database.query(
            COURSE_TABLE,
            arrayOf(


                COURSE_NAME,
                COURSE_ABOUT,
                COURSE_ID


            ),
            "$COURSE_ID=?",
            arrayOf(id.toString()),
            null, null, null

        )

        cursor.moveToFirst()
        val course = Course(

            cursor.getInt(0),
            cursor.getString(1),
            cursor.getString(2)


        )
        return course

    }

    override fun deleteMentor(mentor: Mentor) {
        val database=writableDatabase
         database.delete(MENTOR_TABLE,"$MENTOR_ID=?", arrayOf(mentor.id.toString()))
        database.close()

    }

    override fun editMentor(mentor: Mentor) {
     val database=writableDatabase
        val contentValues=ContentValues()
        contentValues.put(ID,mentor.id)
        contentValues.put(MENTOR_NAME,mentor.name)
        contentValues.put(MENTOR_SURNAME,mentor.surname)
        contentValues.put(MENTOR_NUMBER,mentor.number)
        database.update(MENTOR_TABLE, contentValues,"$MENTOR_ID=?", arrayOf(mentor.id.toString()))


        database.close()

    }

    override fun addGuruh(guruh: Guruh) {

    var database=writableDatabase
        var contentValues=ContentValues()
        contentValues.put(NAME_GURUHLAR,guruh.name)
        contentValues.put(MENTOR_GURUHLAR_ID,guruh.mentor!!.id)
        contentValues.put(VAQT_GURUHLAR,guruh.time)
        contentValues.put(KUNLAR_GURUHLAR,guruh.daysOfWeek)
        contentValues.put(OPEN_CLOSE,guruh.open)
        contentValues.put(GURUH_MY_COURSE, guruh.mycourse)
        database.insert(TABLE_GURHLAR,null,contentValues)
        database.close()



    }

    override fun getGuruh(): ArrayList<Guruh> {

        val list = ArrayList<Guruh>()
        val query = "select * from $TABLE_GURHLAR"
        val database = this.readableDatabase
        val cursor = database.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {

                val guruhlar = Guruh(
                    cursor.getInt(0),
                    cursor.getString(1),
                    getMentorById(cursor.getInt(2)),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getInt(6)
                )

                list.add(guruhlar)

            } while (cursor.moveToNext())
        }
        return list

    }

    override fun updateGuruh(guruh: Guruh): Int {

return 2

    }

    override fun deleteGuruh(guruh: Guruh) {

    }

    override fun getMentorById(id: Int): Mentor {
        TODO("Not yet implemented")
    }


}