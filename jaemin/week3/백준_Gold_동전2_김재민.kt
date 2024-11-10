package baekjoon

import java.io.*
import java.util.*

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val numberOfCoinKind = st.nextToken().toInt()
    val moneyWeWant = st.nextToken().toInt()
    val coins = mutableSetOf<Int>()
    val answers = IntArray(moneyWeWant+1){10001}

    for(i in 0 until numberOfCoinKind){
        val coin = br.readLine().toInt()
        if(moneyWeWant >= coin ) coins.add(coin)
//        else if(coin == moneyWeWant){             ㅁㅇ럼ㄴ;ㅏ어림너ㅏㅇ리;ㅓㅣㄴ망ㄹ
//            print(1)
//            break
//        }
    }

    for(i in 1..moneyWeWant){
        for(coin in coins){
            if(i-coin == 0){
                answers[i] = 1
                break
            }else if(i-coin > 0){
                answers[i] = if(answers[i] < answers[i-coin]+1) answers[i] else answers[i-coin]+1
            }
        }
    }
    print(if(answers[moneyWeWant]==10001) -1 else answers[moneyWeWant])
}