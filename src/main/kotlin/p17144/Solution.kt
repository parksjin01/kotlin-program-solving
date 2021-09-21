package p17144

enum class Direction(val direction: Point) {
    UP(Point(0, -1)),
    DOWN(Point(0, 1)),
    RIGHT(Point(1, 0)),
    LEFT(Point(-1, 0))
}

data class Point(val x: Int, val y:Int) {
    operator fun plus(other: Direction): Point {
        return Point(x + other.direction.x, y + other.direction.y)
    }

    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

class Room(val height: Int, val width: Int, var roomInfo: MutableList<MutableList<Int>>) {
    private fun pointInRoom(point: Point): Boolean {
        if (point.x < 0 || point.y < 0)
            return false

        if (point.x >= width || point.y >= height)
            return false

        return true
    }

    fun diffuse() {
        val newRoomInfo: Array<Array<Int>> = Array(height) {Array(width) {0} }
        val adjacentDirection: List<Point> = listOf(Point(-1, 0), Point(1, 0), Point(0, -1), Point(0, 1))

        for (y in 0 until height) {
            for (x in 0 until width) {
                val curPos: Point = Point(x, y)
                var currentDust: Int = roomInfo[y][x]

                if (currentDust == -1) {
                    newRoomInfo[y][x] = currentDust
                    continue
                }

                for (dir in adjacentDirection) {
                    val newPos: Point = curPos + dir

                    if (pointInRoom(newPos) && roomInfo[newPos.y][newPos.x] != -1) {
                        currentDust -= roomInfo[y][x] / 5
                        currentDust += roomInfo[newPos.y][newPos.x] / 5
                    }
                }

                newRoomInfo[y][x] = currentDust
            }
        }

        for (y in 0 until height) {
            for (x in 0 until width) {
                roomInfo[y][x] = newRoomInfo[y][x]
            }
        }
    }

    fun countDust(): Int {
        var cnt: Int = 0

        for (y in 0 until height) {
            for (x in 0 until width) {
                if (roomInfo[y][x] != -1)
                    cnt += roomInfo[y][x]
            }
        }

        return cnt
    }
}

class AirCleaner(val position: Pair<Point, Point>) {
    fun circulate(room: Room) {
        var upPosition: Point = position.first
        var upPositionDir: Direction = Direction.UP
        var downPosition: Point = position.second
        var downPositionDir: Direction = Direction.DOWN

        do {
            if (upPosition == Point(0, 0)) {
                upPositionDir = Direction.RIGHT
            } else if (upPosition == Point(room.width - 1, 0)) {
                upPositionDir = Direction.DOWN
            } else if (upPosition == Point(room.width - 1, position.first.y)) {
                upPositionDir = Direction.LEFT
            }

            val nextPoint: Point = upPosition + upPositionDir

            if (nextPoint == position.first) {
                room.roomInfo[upPosition.y][upPosition.x] = 0
            } else if (upPosition != position.first) {
                room.roomInfo[upPosition.y][upPosition.x] = room.roomInfo[nextPoint.y][nextPoint.x]
            }
            upPosition = nextPoint
        } while (upPosition != position.first)

        do {
            if (downPosition == Point(0, room.height - 1)) {
                downPositionDir = Direction.RIGHT
            } else if (downPosition == Point(room.width - 1, room.height - 1)) {
                downPositionDir = Direction.UP
            } else if (downPosition == Point(room.width - 1, position.second.y)) {
                downPositionDir = Direction.LEFT
            }

            val nextPoint: Point = downPosition + downPositionDir

            if (nextPoint == position.second) {
                room.roomInfo[downPosition.y][downPosition.x] = 0
            } else if (downPosition != position.second) {
                room.roomInfo[downPosition.y][downPosition.x] = room.roomInfo[nextPoint.y][nextPoint.x]
            }
            downPosition = nextPoint
        } while (downPosition != position.second)
    }
}

object Solution {
    fun solve() {
        val (height, width, time) = readLine() ?. split(" ") ?. map { it.toInt() } ?: listOf(0, 0, 0)
        val roomInfo: MutableList<MutableList<Int>> = mutableListOf()
        var lastCleanerPoint: Point = Point(0, 0)

        for (i in 0 until height) {
            roomInfo.add(readLine() ?. split(" ") ?. map { it.toInt() } ?. toMutableList() ?: mutableListOf<Int>())

            if (roomInfo[i][0] == -1)
                lastCleanerPoint = Point(0, i)
        }

        val room: Room = Room(height, width, roomInfo)
        val airCleaner: AirCleaner = AirCleaner(Pair(Point(lastCleanerPoint.x, lastCleanerPoint.y - 1), Point(lastCleanerPoint.x, lastCleanerPoint.y)))

        for (t in 0 until time) {
            room.diffuse()
            airCleaner.circulate(room)
        }

        println(room.countDust())
    }
}

fun main() {
    Solution.solve()
}