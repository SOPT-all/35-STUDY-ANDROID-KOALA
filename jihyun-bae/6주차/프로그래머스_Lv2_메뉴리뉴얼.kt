class Solution {
    val menu = HashMap<String, Int>()
    var courseTemp = ""
    
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val answer: ArrayList<String> = arrayListOf<String>()
        val order = orders.map { it.toCharArray().sorted().joinToString("") }
        
        course.forEach { courseSize ->
            menu.clear()
            
            order.forEach { orderValue ->
                orderValue.Combination(index = 0, size = courseSize)
            }
            
            menu.maxByOrNull { it.value }?.let { popularCourse ->
                if (popularCourse.value > 1) {
                    menu.filter { it.value == popularCourse.value }.map { answer.add(it.key) }
                }
            }
        }
        
        return answer.sorted().toTypedArray()
    }
    
    fun String.Combination(index: Int, size: Int) {
        if (courseTemp.length == size) {
            menu[courseTemp] = menu.getOrDefault(courseTemp, 0) + 1
            return
        }
        
        for (i in index until this.length) {
            courseTemp += this[i]
            this.Combination(index = i + 1, size = size)
            courseTemp = courseTemp.dropLast(1)
        }
    }
}
