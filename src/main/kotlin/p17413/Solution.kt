package p17413

import java.io.BufferedReader
import java.io.InputStreamReader

object StringUtils {
    fun isTag(word: String): Boolean {
        return word.first() == '<' && word.last() == '>' && word.length >= 3
    }

    fun parse(sentence: String): List<String> {
        val words: MutableList<String> = mutableListOf()
        var index: Int = 0

        while (index < sentence.length) {
            if (sentence[index] == '<') {
                val targetIndex: Int = sentence.substring(index).indexOfFirst { it == '>' } + 1 + index
                words.add(sentence.substring(index, targetIndex))
                index = targetIndex
            } else {
                var targetIndex: Int = sentence.substring(index).indexOfFirst { it == '<' }

                if (targetIndex == -1) {
                    targetIndex = sentence.length
                } else {
                    targetIndex += index
                }

                words.addAll(sentence.substring(index, targetIndex).split(" "))
                index = targetIndex
            }
        }

        return words
    }

    fun reverseSentence(sentence: String): String {
        val parsedSentence: List<String> = parse(sentence)
        return parsedSentence.map { if (isTag(it)) it else it.reversed() }.reduce { word1, word2 ->
            if (word1.last() == '>' || word2.first() == '<') {
                word1 + word2
            } else {
                word1 + " " + word2
            }
        }
    }
}

object Solution {
    fun solve() {
        val reader: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
        System.out.println(StringUtils.reverseSentence(reader.readLine() ?: ""))
    }
}

fun main() {
    Solution.solve()
}