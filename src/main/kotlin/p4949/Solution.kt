package p4949

import java.lang.Exception
import java.util.*

object BracketChecker {
    fun check(sentence: String): Boolean {
        val stack: Stack<Char> = Stack()

        for (character in sentence) {
            if (character in listOf('(', '[')) {
                stack.push(character)
            } else if (character in listOf(')', ']')) {
                try {
                    val lastLeftBracket: Char = stack.pop()

                    when (character) {
                        ')' -> if (lastLeftBracket != '(') return false
                        ']' -> if (lastLeftBracket != '[') return false
                    }
                } catch (e: Exception) {
                    return false
                }
            }
        }

        if (stack.isNotEmpty())
            return false

        return true
    }
}

object Solution {
    fun solve() {
        while (true) {
            val sentence: String = readLine() ?: ""

            if (sentence == ".")
                break

            if (BracketChecker.check(sentence)) {
                println("yes")
            } else {
                println("no")
            }
        }
    }
}

fun main() {
    Solution.solve()
}