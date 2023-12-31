package com.example.hotelreservationprogramme

fun main() {
    // 첫번째 실행 (메뉴 선택)
    val menuObject = MainMenu()
    menuObject.mainMenu()

    println("호텔 프로그램을 종료합니다.")
}

open class MainMenu {
    fun mainMenu() {

        var bookingInfo: MutableList<BookingInfo> = mutableListOf()

        while (true) {
            println("호텔예약 프로그램 입니다.")
            println("[메뉴]")
            println("1. 방예약, 2. 예약목록 출력, 3 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입금-출금 내역 목록 출력 6. 예약 변경/취소")

            val readLineExceptionInt = ReadLineExceptionInt()
            val menu = readLineExceptionInt.checkIntException()

            when (menu) {
                1 -> { // 방 예약
                    val menu1 = Menu1()
                    bookingInfo.add(menu1.menu1(bookingInfo))
                    println(bookingInfo)
                }

                2 -> { // 예약목록 출력
                    val menu2 = Menu2()
                    menu2.menu2(bookingInfo)
                }

                3 -> { // 예약목록 (정렬) 출력
                    val menu3 = Menu3()
                    menu3.menu3(bookingInfo)
                }

                4 -> break // 시스템 종료
                5 -> { // 금액 입금-출금 내역 목록 출력
                    val menu5 = Menu5()
                    menu5.menu5(bookingInfo)

                }

                6 -> { // 예약 변경/취소

                }

                else -> {}
            }
        }
    }
}

// 메뉴 클래스 --------------------------------------------------------------------------------------

class Menu1 : MainMenu() {
    fun menu1(bookingInfo: MutableList<BookingInfo>): BookingInfo {

        val newName = SubMenu1Name().subMenu1Name()
        val newRoomNumber = SubMenu1RoomNumber().subMenu1RoomNumber()
        var newCheckInDate = SubMenu1CheckInDate().subMenu1CheckInDate()
        newCheckInDate = SubMenu1CheckCheckInDate().subMenu1CheckCheckInDate(
            bookingInfo,
            newRoomNumber,
            newCheckInDate
        )

        var newCheckOutDate = SubMenu1CheckOutDate().subMenu1CheckOutDate(newCheckInDate)
        newCheckOutDate = SubMenu1CheckCheckOutDate().subMenu1CheckCheckOutDate(
            bookingInfo,
            newRoomNumber,
            newCheckInDate,
            newCheckOutDate
        )

        val paymentIn: Int = SubMenu1PaymentIn().subMenu1PaymentIn()
        val paymentOut: Int = SubMenu1PaymentOut().subMenu1PaymentOut()

        val user = BookingInfo(
            newName,
            newRoomNumber,
            newCheckInDate,
            newCheckOutDate,
            paymentIn,
            paymentOut
        )

        return user
    }
}

class SubMenu1Name {
    fun subMenu1Name(): String {
        println("예약자분의 성함을 입력해주세요.")
        val newName = readLine()!!
        return newName
    }
}


class SubMenu1RoomNumber {
    fun subMenu1RoomNumber(): Int {
        println("예약할 방번호를 입력해주세요.")
        val readLinExceptionInt = ReadLineExceptionInt()
        var newRoomNumber = readLinExceptionInt.checkIntException()
        val roomNumberObject = RoomNumber()
        newRoomNumber = roomNumberObject.checkNumber(newRoomNumber)
        return newRoomNumber
    }
}

class SubMenu1CheckInDate {
    fun subMenu1CheckInDate(): Int {
        println("체크인 날짜를 입력해주세요 표기형식. 20230631")
        val readLinExceptionInt = ReadLineExceptionInt()
        var newCheckInDate = readLinExceptionInt.checkIntException()
        val checkInDateObject = CheckInDate()
        newCheckInDate = checkInDateObject.checkNumber(newCheckInDate)
        return newCheckInDate
    }
}

class SubMenu1CheckOutDate {
    fun subMenu1CheckOutDate(newCheckInDate: Int): Int {
        println("체크아웃 날짜를 입력해주세요 표기형식. 20230631")
        val readLinExceptionInt = ReadLineExceptionInt()
        var newCheckOutDate = readLinExceptionInt.checkIntException()
        val checkOutDateObject = CheckOutDate()
        newCheckOutDate = checkOutDateObject.checkNumber(newCheckInDate, newCheckOutDate)
        return newCheckOutDate
    }
}

class SubMenu1PaymentIn {
    fun subMenu1PaymentIn(): Int {
        val paymentIn: Int = (10000..1000000).random()
        return paymentIn
    }
}

class SubMenu1PaymentOut {
    fun subMenu1PaymentOut(): Int {
        val paymentOut: Int = (10000..1000000).random()
        return paymentOut
    }
}

class SubMenu1CheckCheckInDate {
    fun subMenu1CheckCheckInDate(
        bookingInfo: MutableList<BookingInfo>,
        newRoomNumber: Int,
        newCheckInDate: Int
    ): Int {
        var newCheckInDate = newCheckInDate
        while (true) {
            var i = 0
            while (i < bookingInfo.size) {
                var (_, roomNumber, checkInDate, checkOutDate) = bookingInfo[i]
                if ((roomNumber == newRoomNumber) && (checkInDate <= newCheckInDate) && (newCheckInDate <= checkOutDate)) {
                    println("해당 날짜에 이미 방을 사용중입니다. 다른 날짜를 입력하세요.")
                    newCheckInDate = SubMenu1CheckInDate().subMenu1CheckInDate()
                    i = -1
                }
                i++
            }
            break
        }
        return newCheckInDate
    }
}

class SubMenu1CheckCheckOutDate {
    fun subMenu1CheckCheckOutDate(
        bookingInfo: MutableList<BookingInfo>,
        newRoomNumber: Int,
        newCheckInDate: Int,
        newCheckOutDate: Int
    ): Int {
        while (true) {
            var newCheckOutDate = newCheckOutDate
            var i = 0
            while (i < bookingInfo.size) {
                val (_, roomNumber, checkInDate) = bookingInfo[i]
                if ((roomNumber == newRoomNumber) && (newCheckInDate < newCheckOutDate) && (newCheckOutDate > checkInDate)) {
                    println("해당 날짜에 이미 방을 사용중입니다. 다른 날짜를 입력하세요.")
                    newCheckOutDate = SubMenu1CheckOutDate().subMenu1CheckOutDate(newCheckInDate)
                    i = -1
                }
                i++
            }
            break
        }
        return newCheckOutDate
    }
}

class Menu2 : MainMenu() {
    fun menu2(bookingInfo: MutableList<BookingInfo>) {
        println("호텔 예약자 목록입니다.")
        for (i in 0 until bookingInfo.size) {
            val (name, roomNumber, checkInDate, checkOutDate) = bookingInfo[i]
            println("${i + 1}. 사용자: $name, 방번호: $roomNumber 호, 체크인: $checkInDate, 체크아웃: $checkOutDate")
        }
    }
}

class Menu3 {
    fun menu3(bookingInfo: MutableList<BookingInfo>) {
        bookingInfo.sortBy { it.checkInDate }
        for (i in 0 until bookingInfo.size) {
            val (name, roomNumber, checkInDate, checkOutDate) = bookingInfo[i]
            println("${i + 1}. 사용자: $name, 방번호: $roomNumber 호, 체크인: $checkInDate, 체크아웃: $checkOutDate")
        }
    }
}

class Menu5 {
    fun menu5(bookingInfo: MutableList<BookingInfo>) {
        val checkString = CheckName()
        val userIndex = checkString.checkString(bookingInfo)
        val (_, _, _, _, paymentIn, paymentOut) = bookingInfo[userIndex]

        if (userIndex > 0) {
            println("1. 초기 금액으로 $paymentIn 원 입금되었습니다.")
            println("2. 예약금으로 $paymentOut 원 출금되었습니다.")
        } else {
            println("조회하시는 사용자를 찾을 수 없습니다.")
        }
    }
}


// 데이터 클래스 -------------------------------------------------------------------------------------

data class BookingInfo(
    var name: String,
    var roomNumber: Int,
    var checkInDate: Int,
    var checkOutDate: Int,
    var paymentIn: Int,
    var paymentOut: Int
)

// 인터페이스 ---------------------------------------------------------------------------------------

interface CheckIntException {
    fun checkIntException(): Int
}

interface CheckNumberOneInput {
    fun checkNumber(value1: Int): Int
}

interface CheckNumberTwoInput {
    fun checkNumber(value1: Int, value2: Int): Int
}

interface CheckBookingInfoInput {
    fun checkString(bookingInfo: MutableList<BookingInfo>): Int
}

// 클래스 -------------------------------------------------------------------------------------------

class RoomNumber : CheckNumberOneInput {
    override fun checkNumber(value1: Int): Int {
        var roomNumber = value1
        val readLineExceptionInt = ReadLineExceptionInt()
        while (true) {
            if (roomNumber in 100 until 10000) {
                return roomNumber
            } else {
                println("올바르지 않은 방번호 입니다. 방번호는 100~999 영역 이내입니다.")
                roomNumber = readLineExceptionInt.checkIntException()
            }
        }
    }
}

class CheckInDate : CheckNumberOneInput {
    override fun checkNumber(value1: Int): Int {
        var checkInDate = value1
        val todayDate: Int = 20231201
        val readLineExceptionInt = ReadLineExceptionInt()

        while (true) {
            if (checkInDate > todayDate) {
                return checkInDate
            } else {
                println("체크인은 지난날은 선택할 수 없습니다.")
                checkInDate = readLineExceptionInt.checkIntException()
            }
        }
    }
}

class CheckOutDate : CheckNumberTwoInput {
    override fun checkNumber(value1: Int, value2: Int): Int {
        val checkInDate = value1
        var checkOutDate = value2
        val readLineExceptionInt = ReadLineExceptionInt()

        while (true) {
            if (checkOutDate > checkInDate) {
                return checkOutDate
            } else {
                println("체크인 날짜보다 이전이거나 같을 수는 없습니다. ")
                checkOutDate = readLineExceptionInt.checkIntException()
            }
        }
    }
}

class CheckName : CheckBookingInfoInput {
    override fun checkString(bookingInfo: MutableList<BookingInfo>): Int {
        println("조회하실 사용자 이름을 입력하세요.")
        var checkName = readLine()!!
        var userIndex = -1
        for (i in bookingInfo.indices) {
            val (name) = bookingInfo[i]
            if (checkName == name) {
                userIndex = i
                break
            }
        }
        return userIndex
    }

}


class ReadLineExceptionInt : CheckIntException {
    override fun checkIntException(): Int {
        while (true) {
            try {
                val num = readLine()!!.toInt()
                return num
            } catch (e: java.lang.NumberFormatException) {
                println("숫자를 입력하세요.")
            }
        }
    }
}