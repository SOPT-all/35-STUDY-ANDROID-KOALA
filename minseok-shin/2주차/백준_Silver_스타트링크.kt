package week1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var cnt = 0

    var (F, S, G, U, D) = br.readLine().split(' ').map { it.toInt() }

    while (true){
        if ( cnt>F ){
            bw.write("use the stairs")
            break
        }
        else{
            when {
                G>S -> {
                    if (S+U>F){
                        if (S-D>0){
                            S-=D
                        }
                    }else{
                        S += U
                    }
                    cnt ++
                }
                G<S  -> {
                    if (S-D<1){
                        if (S+U<F+1){
                            S+=U
                        }
                    }
                    else{
                        S-= D
                    }
                    cnt ++
                }
                else -> {
                    bw.write(cnt.toString())
                    break
                }
            }
        }
    }

    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
