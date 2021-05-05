package p12100

enum class Direction(val y: Int, val x: Int) {
    UP(-1, 0),
    RIGHT(0, 1),
    DOWN(1, 0),
    LEFT(0, -1)
}

class Board(val size: Int, blocks: MutableList<MutableList<Int>>) {
    val blocks: MutableList<MutableList<Int>> = blocks.map { it.toMutableList() }.toMutableList()
    fun validCoordinate(y: Int, x: Int): Boolean {
        return !(y < 0 || y >= size || x < 0 || x >= size)
    }

    fun move(direction: Direction) {
        var xCoordinates: IntProgression
        var yCoordinates: IntProgression
        val collision: MutableList<MutableList<Int>> = MutableList(size) {MutableList(size) {0} }

        if (direction == Direction.UP || direction == Direction.LEFT) {
            yCoordinates = 0 until size
            xCoordinates = 0 until size
        } else {
            yCoordinates = (size - 1) downTo 0
            xCoordinates = (size - 1) downTo 0
        }

        for (y in yCoordinates) {
            for (x in xCoordinates) {
                if (blocks[y][x] == 0)
                    continue

                val block = blocks[y][x]
                blocks[y][x] = 0
                var (tmpY, tmpX) = listOf(y, x)

                while (true) {
                    tmpY += direction.y
                    tmpX += direction.x

                    if (!validCoordinate(tmpY, tmpX)) {
                        blocks[tmpY - direction.y][tmpX - direction.x] = block
                        break
                    }

                    if (blocks[tmpY][tmpX] != 0) {
                        if (block == blocks[tmpY][tmpX] && collision[tmpY][tmpX] == 0) {
                            blocks[tmpY][tmpX] += block
                            collision[tmpY][tmpX] = 1
                        } else {
                            blocks[tmpY - direction.y][tmpX - direction.x] = block
                        }
                        break
                    }
                }
            }
        }
    }

    fun maxBlocks(): Int {
        return blocks.maxOfOrNull { it.maxOf { it } } ?: 0
    }
}

object Solution {
    fun solve() {
        val size: Int = readLine() ?. toInt() ?: 0
        val blocks: MutableList<MutableList<Int>> = mutableListOf()

        for (i in 0 until size) {
            blocks.add(readLine() ?. split(" ") ?. map { it.toInt() } ?. toMutableList() ?: mutableListOf())
        }

        println(permutation(5, mutableListOf(), size, blocks))
    }

    fun permutation(length: Int, directions: List<Direction>, size: Int, blocks: MutableList<MutableList<Int>>): Int {
        if (length == 0) {
            val board: Board = Board(size, blocks)

            for (direction in directions) {
                board.move(direction)
            }

            return board.maxBlocks()
        }

        return listOf(Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT)
            .map { permutation(length - 1, directions + it, size, blocks) }
            .maxOrNull() ?: 0

    }
}

fun main() {
    Solution.solve()
}