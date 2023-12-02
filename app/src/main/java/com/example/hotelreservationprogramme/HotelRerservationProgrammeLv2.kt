package com.example.hotelreservationprogramme

import android.content.res.TypedArray

fun main() {
    // 첫번째 실행 (메뉴 선택)


    val menuObject = MainMenu()
    menuObject.mainMenu()

    println("호텔 예약이 완료되었습니다.")
}

class MainMenu {
    fun mainMenu() {
        println("호텔예약 프로그램 입니다.")
        println("1. 방예약, 2. 예약목록 출력, 3 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입금-출금 내역 목록 출력 6. 예약 변경/취소")

        val readLineExceptionInt = ReadLineExceptionInt()
        val menu = readLineExceptionInt.checkIfValid()
        var bookingInfo = mutableListOf<List<Any>>()

        while (true) {
            if (menu == 1) {
                val menu1 = Menu1()
                bookingInfo.add(menu1.menu1())
                break
            } else if (menu == 2) {
                val menu2 = Menu2()
                menu2.menu2(bookingInfo)
                println("--"); break
            } else if (menu == 3) {
                println("--"); break
            } else if (menu == 4) {
                println("--"); break
            } else if (menu == 5) {
                println("--"); break
            } else if (menu == 6) {
                println("--"); break
            } else {
                println("--"); break
            }
        }
    }
}

class Menu1 {
    fun menu1(): List<Any> {

        var bookingInfo = mutableListOf<Any>()
        val readLinExceptionInt = ReadLineExceptionInt()

        println("예약자분의 성함을 입력해주세요.")
        val name = readLine()!!
        bookingInfo.add(name)

        println("예약할 방번호를 입력해주세요.")
        var roomNumber = readLinExceptionInt.checkIfValid()
        val roomNumberObject = RoomNumber()
        roomNumber = roomNumberObject.checkIfValid(roomNumber)
        bookingInfo.add(roomNumber)

        println("체크인 날짜를 입력해주세요 표기형식. 20230631")
        var checkInDate = readLinExceptionInt.checkIfValid()
        val checkInDateObject = CheckInDate()
        checkInDate = checkInDateObject.checkIfValid(checkInDate)
        bookingInfo.add(checkInDate)


        println("체크아웃 날짜를 입력해주세요 표기형식. 20230631")
        var checkOutDate = readLinExceptionInt.checkIfValid()
        val checkOutDateObject = CheckOutDate()
        checkOutDate = checkOutDateObject.checkIfValid(checkInDate, checkOutDate)
        bookingInfo.add(checkOutDate)

        return bookingInfo
    }
}

class Menu2 {
    fun menu2(bookingInfo: MutableList<List<Any>>) {
        println("호텔 예약자 목록입니다.")
        for (i in bookingInfo.indices) {
            println("1. 사용자: ${bookingInfo[i][0]}, 방번호: ${bookingInfo[i][1]}호, 체크인: ${bookingInfo[i][2]}, 체크아웃: ${bookingInfo[i][3]}")
        }


    }
}

abstract class CheckIfValid {
    abstract fun checkIfValid() : Int
    abstract fun checkIfValid(value1: Int) : Int
    abstract fun checkIfValid(value1: Int, value2: Int) : Int
    var todayDate: Int = 20231201
}

class RoomNumber : CheckIfValid() {
    override fun checkIfValid() : Int {
        TODO("Not yet implemented")
    }

    override fun checkIfValid(value1: Int) : Int {
        var roomNumber = value1
        val readLineExceptionInt = ReadLineExceptionInt()
        while (true) {
            if (roomNumber in 100 until 10000) {
                return roomNumber
            } else {
                println("올바르지 않은 방번호 입니다. 방번호는 100~999 영역 이내입니다.")
                roomNumber = readLineExceptionInt.checkIfValid()
            }
        }
    }
    override fun checkIfValid(value1: Int, value2: Int) : Int{
        TODO("Not yet implemented")
    }
}

class CheckInDate : CheckIfValid() {
    override fun checkIfValid() : Int{
        TODO("Not yet implemented")
    }

    override fun checkIfValid(value1: Int) : Int {
        var checkInDate = value1
        val readLineExceptionInt = ReadLineExceptionInt()

        while (true) {
            if (checkInDate > todayDate) {
                return checkInDate
            } else {
                println("체크인은 지난날은 선택할 수 없습니다.")
                checkInDate = readLineExceptionInt.checkIfValid()
            }
        }
    }

    override fun checkIfValid(value1: Int, value2: Int) : Int{
        TODO("Not yet implemented")
    }
}

class CheckOutDate : CheckIfValid() {
    override fun checkIfValid() : Int{
        TODO("Not yet implemented")
    }

    override fun checkIfValid(value1: Int) : Int{
        TODO("Not yet implemented")
    }

    override fun checkIfValid(value1: Int, value2: Int): Int {
        val checkInDate = value1
        var checkOutDate = value2
        val readLineExceptionInt = ReadLineExceptionInt()

        while (true) {
            if (checkOutDate > checkInDate) {
                return checkOutDate
            } else {
                println("체크인 날짜보다 이전이거나 같을 수는 없습니다. ")
                checkOutDate = readLineExceptionInt.checkIfValid()
            }
        }
    }
}

class ReadLineExceptionInt : CheckIfValid() {
    override fun checkIfValid(): Int {
        while (true) {
            try {
                val num = readLine()!!.toInt()
                return num
            } catch (e: java.lang.NumberFormatException) {
                println("숫자를 입력하세요.")
            }
        }
    }

    override fun checkIfValid(value1: Int) : Int{
        TODO("Not yet implemented")
    }

    override fun checkIfValid(value1: Int, value2: Int) : Int{
        TODO("Not yet implemented")
    }
}