class Lesson(name: String,classroom: MutableList<Int>, dayDate: Int, start: Int, end: Int, teacher: MutableList<String>){
    var typeLesson=name
    var classroomList=classroom
    var day=dayDate
    var timeStart=start
    var timeEnd=end
    var teacherList=teacher
}

class NNBL(day:Int, classroom:Int){
    var BL=Array(day,{Array(classroom,{ mutableListOf<Lesson>()})})
    private var GBL=mutableListOf<Lesson>()
    fun updateId(id: Int){
        var lesson=GBL[id]
        for (i in lesson.classroomList){
            if (BL[lesson.day-1][i-1].isEmpty()){
                BL[lesson.day-1][i-1].add(lesson)
            } else {
                for (ii in BL[lesson.day-1][i-1]){
                    if(lesson.timeStart<ii.timeStart){
                        BL[lesson.day-1][i-1].add(BL[lesson.day-1][i-1].indexOf(ii),lesson)
                        break
                    }
                }
            }
        }
    }
    fun add(newLesson: Lesson){ GBL.add(newLesson); updateId(GBL.indexOf(newLesson)) }
    fun read(day: Int, classroom: Int, id: Int): Lesson{ return BL[day][classroom][id] }
    fun del(day: Int, classroom: Int, id: Int){ GBL.removeAt(GBL.indexOf(BL[day][classroom][id])) }
}
