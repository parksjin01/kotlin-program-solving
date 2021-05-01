package p1966

data class Page(val index: Int, val priority: Int)

object Printer {
    fun print(pages: List<Page>, targetIndex: Int): Int {
        while (pages.size > 0) {
            if (pages[0].priority == pages.maxOf { it.priority }) {
                val printedPage = pages[0]
                if (printedPage.index == targetIndex) {
                    return 1
                } else {
                    return print(pages.subList(1, pages.size), targetIndex) + 1
                }
            } else {
                return print(pages.subList(1, pages.size) + pages[0], targetIndex)
            }
        }

        return 0
    }
}

object Solution {
    fun solve() {
        val numOfTest: Int = readLine() ?. toInt() ?: 0

        for (i in 0 until numOfTest) {
            val (numOfPage, targetIndex) = readLine() ?. split(" ") ?. map { it.toInt() } ?: listOf(0, 0)

            val pages: List<Page> = readLine()?.split(" ")?.map { it.toInt() }
                ?.mapIndexed { index, priority -> Page(index, priority) } ?: emptyList()

            println(Printer.print(pages, targetIndex))
        }
    }
}

fun main() {
    Solution.solve()
}