//package com.example.hotelreservationprogramme
//
//fun main() {
//    // 첫번째 실행 (메뉴 선택)
//
//
//    val menuObject = MainMenu()
//    menuObject.mainMenu()
//
//    println("호텔 프로그램을 종료합니다.")
//}
//
//open class MainMenu {
//    fun mainMenu() {
//
//        var bookingInfo: MutableList<BookingInfo> = mutableListOf()
//
//        while (true) {
//            println("호텔예약 프로그램 입니다.")
//            println("1. 방예약, 2. 예약목록 출력, 3 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입금-출금 내역 목록 출력 6. 예약 변경/취소")
//
//            val readLineExceptionInt = ReadLineExceptionInt()
//            val menu = readLineExceptionInt.checkIfValid()
//
//            when (menu) {
//                1 -> { // 방 예약
//                    val menu1 = Menu1()
//                    bookingInfo.add(menu1.menu1())
//                    println(bookingInfo)
//                }
//
//                2 -> { // 예약목록 출력
//                    val menu2 = Menu2()
//                    menu2.menu2(bookingInfo)
//                }
//
//                3 -> { // 예약목록 (정렬) 출력
//                    val menu3 = Menu3()
//                    menu3.menu3(bookingInfo)
//                }
//                4 -> break // 시스템 종료
//                5 -> { // 금액 입금-출금 내역 목록 출력
//
//                }
//                6 -> { // 예약 변경/취소
//
//                }
//                else -> {}
//            }
//        }
//
//    }
//}
//
//class Menu1: MainMenu() {
//    fun menu1(): BookingInfo {
//
//        var bookingInfo: MutableList<Any> = mutableListOf()
//        val readLinExceptionInt = ReadLineExceptionInt()
//
//        println("예약자분의 성함을 입력해주세요.")
//        val name = readLine()!!
//
//        println("예약할 방번호를 입력해주세요.")
//        var roomNumber = readLinExceptionInt.checkIfValid()
//        val roomNumberObject = RoomNumber()
//        roomNumber = roomNumberObject.checkIfValid(roomNumber)
//
//        println("체크인 날짜를 입력해주세요 표기형식. 20230631")
//        var checkInDate = readLinExceptionInt.checkIfValid()
//        val checkInDateObject = CheckInDate()
//        checkInDate = checkInDateObject.checkIfValid(checkInDate)
//
//
//        println("체크아웃 날짜를 입력해주세요 표기형식. 20230631")
//        var checkOutDate = readLinExceptionInt.checkIfValid()
//        val checkOutDateObject = CheckOutDate()
//        checkOutDate = checkOutDateObject.checkIfValid(checkInDate, checkOutDate)
//
//        val User = BookingInfo(name, roomNumber, checkInDate, checkOutDate)
//
//        return User
//    }
//}
//
//class Menu2 {
//    fun menu2(bookingInfo: MutableList<BookingInfo>) {
//        println("호텔 예약자 목록입니다.")
//        for (i in 0 until bookingInfo.size) {
//            var (name, roomNumber, checkInDate, checkOutDate) = bookingInfo[i]
//            println("${i + 1}. 사용자: ${name}, 방번호: ${roomNumber}호, 체크인: ${checkInDate}, 체크아웃: ${checkOutDate}")
//        }
//    }
//}
//class Menu3 {
//    fun menu3(bookingInfo: MutableList<BookingInfo>) {
//        var bookingInfo = bookingInfo
//        bookingInfo.sortBy{ it.checkInDate }
//        for (i in 0 until bookingInfo.size) {
//            var (name, roomNumber, checkInDate, checkOutDate) = bookingInfo[i]
//            println("${i + 1}. 사용자: ${name}, 방번호: ${roomNumber}호, 체크인: ${checkInDate}, 체크아웃: ${checkOutDate}")
//        }
//    }
//}
//
//data class BookingInfo(var name:String, var roomNumber: Int, var checkInDate: Int, var checkOutDate: Int)
//
//abstract class CheckIfValid {
//    abstract fun checkIfValid(): Int
//    abstract fun checkIfValid(value1: Int): Int
//    abstract fun checkIfValid(value1: Int, value2: Int): Int
//    var todayDate: Int = 20231201
//}
//
//class RoomNumber : CheckIfValid() {
//    override fun checkIfValid(): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun checkIfValid(value1: Int): Int {
//        var roomNumber = value1
//        val readLineExceptionInt = ReadLineExceptionInt()
//        while (true) {
//            if (roomNumber in 100 until 10000) {
//                return roomNumber
//            } else {
//                println("올바르지 않은 방번호 입니다. 방번호는 100~999 영역 이내입니다.")
//                roomNumber = readLineExceptionInt.checkIfValid()
//            }
//        }
//    }
//
//    override fun checkIfValid(value1: Int, value2: Int): Int {
//        TODO("Not yet implemented")
//    }
//}
//
//class CheckInDate : CheckIfValid() {
//    override fun checkIfValid(): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun checkIfValid(value1: Int): Int {
//        var checkInDate = value1
//        val readLineExceptionInt = ReadLineExceptionInt()
//
//        while (true) {
//            if (checkInDate > todayDate) {
//                return checkInDate
//            } else {
//                println("체크인은 지난날은 선택할 수 없습니다.")
//                checkInDate = readLineExceptionInt.checkIfValid()
//            }
//        }
//    }
//
//    override fun checkIfValid(value1: Int, value2: Int): Int {
//        TODO("Not yet implemented")
//    }
//}
//
//class CheckOutDate : CheckIfValid() {
//    override fun checkIfValid(): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun checkIfValid(value1: Int): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun checkIfValid(value1: Int, value2: Int): Int {
//        val checkInDate = value1
//        var checkOutDate = value2
//        val readLineExceptionInt = ReadLineExceptionInt()
//
//        while (true) {
//            if (checkOutDate > checkInDate) {
//                return checkOutDate
//            } else {
//                println("체크인 날짜보다 이전이거나 같을 수는 없습니다. ")
//                checkOutDate = readLineExceptionInt.checkIfValid()
//            }
//        }
//    }
//}
//
//class ReadLineExceptionInt : CheckIfValid() {
//    override fun checkIfValid(): Int {
//        while (true) {
//            try {
//                val num = readLine()!!.toInt()
//                return num
//            } catch (e: java.lang.NumberFormatException) {
//                println("숫자를 입력하세요.")
//            }
//        }
//    }
//
//    override fun checkIfValid(value1: Int): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun checkIfValid(value1: Int, value2: Int): Int {
//        TODO("Not yet implemented")
//    }
//}