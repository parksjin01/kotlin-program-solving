package p2628

object Solution {
    fun solve() {
        val (width: Int, height: Int) = readLine() ?. split(" ") ?. map { it.toInt() } ?: listOf(0, 0)
        val cuttingCnt: Int = readLine() ?. toInt() ?: 0
        val horizontalCuttings: MutableList<Int> = mutableListOf()
        val verticalCuttings: MutableList<Int> = mutableListOf()

        val HORIZONTAL: Int = 0
        val VERTICAL: Int = 1

        for (i: Int in 0 until cuttingCnt) {
            readLine() ?. split(" ") ?. map { it.toInt() } ?. let {
                if (it[0] == HORIZONTAL) {
                    horizontalCuttings.add(it[1])
                } else {
                    verticalCuttings.add(it[1])
                }
            }
        }

        horizontalCuttings.add(height)
        verticalCuttings.add(width)

        horizontalCuttings.sort()
        verticalCuttings.sort()

        println(getAreas(horizontalCuttings, verticalCuttings).maxOf { it })
    }

    private fun getAreas(horizontalCuttings: List<Int>, verticalCuttings: List<Int>): List<Int> {
        var startingX: Int = 0
        var startingY: Int = 0
        val areas: MutableList<Int> = mutableListOf()

        for (hc: Int in horizontalCuttings) {
            for (vc: Int in verticalCuttings) {
                areas.add((hc - startingY) * (vc - startingX))
                startingX = vc
            }

            startingY = hc
            startingX = 0
        }

        return areas
    }
}

fun main() {
    Solution.solve()
}