package week12

fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
    val video = LongArray(play_time.toSeconds() + 1) // 영상의 총 길이
    logs.forEach { log ->
        val (start, end) = log.split("-")
        video[start.toSeconds()]++
        video[end.toSeconds()]--
    }
    for (i in 1 until video.size) video[i] += video[i - 1]

    val index = getAdvTime(video, adv_time.toSeconds())
    return String.format("%02d:%02d:%02d", index / 3600, index / 60 % 60, index % 60)
}

fun String.toSeconds(): Int {
    val (hour, minute, second) = split(":").map { it.toInt() }
    return hour * 3600 + minute * 60 + second
}

fun getAdvTime(video: LongArray, advTime: Int): Int {
    var views = video.take(advTime).sum()
    var index = 0
    var maxViews = views
    for (i in 1 until video.size - advTime) {
        views = views + video[i + advTime - 1] - video[i - 1]
        if (maxViews < views) {
            maxViews = views
            index = i
        }
    }
    return index
}