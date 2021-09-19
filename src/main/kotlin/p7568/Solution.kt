package p7568

data class Person(val weight: Int, val height: Int): Comparable<Person> {
    constructor(list: List<Int>) : this(list[0], list[1])

    override fun compareTo(other: Person): Int {
        if (this.weight > other.weight && this.height > other.height) {
            return 1
        } else if (this.weight < other.weight && this.height < other.height) {
            return -1
        } else {
            return 0
        }
    }
}

object Solution {
    fun solve() {
        val numOfPeople: Int = readLine() ?. toInt() ?: 0
        val people: MutableList<Person> = mutableListOf()

        for (i in 0 until numOfPeople) {
            people.add(Person(readLine() ?. split(" ") ?. map { it.toInt() } ?. toList() ?: emptyList<Int>()))
        }

        println(people.map {
            person -> people.count {
                person < it
            } + 1
        } .joinToString(" "))
    }
}

fun main() {
    Solution.solve()
}