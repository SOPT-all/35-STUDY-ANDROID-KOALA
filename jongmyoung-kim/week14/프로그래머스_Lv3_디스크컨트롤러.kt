package week14

import java.util.PriorityQueue

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        val sortedJobs = jobs.mapIndexed { idx, job -> Triple(job[0], job[1], idx) }.sortedBy { it.first } // 작업의 요청 시간 순
        val jobQueue = PriorityQueue<Triple<Int, Int, Int>>(compareBy({ it.second }, { it.first }, { it.third })) // 소요, 요청, 번호
        var index = 0
        var totalTime = 0
        var turnaround = 0

        while (jobQueue.isNotEmpty() || index < sortedJobs.size) {
            while (index < sortedJobs.size && sortedJobs[index].first <= totalTime) jobQueue.offer(sortedJobs[index++])

            if (jobQueue.isNotEmpty()) {
                val job = jobQueue.poll()

                totalTime += job.second
                turnaround += totalTime - job.first
            } else totalTime = sortedJobs[index].first
        }
        return turnaround / jobs.size
    }
}
