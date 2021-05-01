package p1966

data class Page(val index: Int, val priority: Int)

class Printer(val queue: MutableList<Page>) {
    var counter: Int = 0

    fun isMostTopPriority(page: Page): Boolean {
        return page.priority == queue.maxOf { page -> page.priority }
    }

    fun moveToBack(queue: MutableList<Page>): Unit {
        queue.add(queue.removeAt(0))
    }

    fun isTargetPage(page: Page, targetIndex: Int): Boolean {
        return page.index == targetIndex
    }

    fun print(targetIndex: Int): Int {
        while (!queue.isEmpty()) {
            if (isMostTopPriority(queue[0])) {
                val printedPage: Page = queue.removeFirst()

                if (isTargetPage(printedPage, targetIndex)) {
                    return counter + 1
                } else {
                    counter += 1
                }
            } else {
                moveToBack(queue)
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

            val printer: Printer = Printer(pages.toMutableList())
            println(printer.print(targetIndex))
        }
    }
}

fun main() {
    Solution.solve()
}