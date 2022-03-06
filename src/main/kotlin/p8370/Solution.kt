package p8370

object Solution {
    fun solve() {
        val (businessRows: Int, businessSeatsPerRow: Int, economicRows: Int, economicSeatsPerRow: Int) =
            readLine() ?. split(" ") ?. map { it.toInt() } ?: listOf(0, 0, 0, 0)

        println(businessRows * businessSeatsPerRow + economicRows * economicSeatsPerRow)
    }
}

fun main() {
    Solution.solve()
}