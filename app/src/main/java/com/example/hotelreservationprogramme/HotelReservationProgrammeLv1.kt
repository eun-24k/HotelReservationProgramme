package com.example.hotelreservationprogramme

fun main() {
    // 변수 선언
    var menu: Int
    var name: String
    var roomNumber: Int
    var checkInDate: Int
    var checkOutDate: Int

    // 객체 선언


    println("호텔예약 프로그램 입니다.")
    println("1. 방예약, 2. 예약목록 출력, 3 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입금-출금 내역 목록 출력 6. 예약 변경/취소")
    menu = readLine()!!.toInt()
    var menuObject = Menu(menu)
    menuObject.checkIfValid()

    println("예약자분의 성함을 입력해주세요.")
    name = readLine()!!
    roomNumber = readLine()!!.toInt()
    var roomNumberObject = RoomNumber(roomNumber)
    roomNumberObject.checkIfValid()

    println("체크인 날짜를 입력해주세요 표기형식. 20230631")
    checkInDate = readLine()!!.toInt()
    var checkInDateObject = CheckInDate(checkInDate)
    checkInDateObject.checkIfValid()

    println("체크아웃 날짜를 입력해주세요 표기형식. 20230631")
    checkOutDate = readLine()!!.toInt()
    var checkOutDateObject = CheckOutDate(checkOutDate)
    checkOutDateObject.checkIfValid()


    println("호텔 예약이 완료되었습니다.")
}

abstract class CheckIfValid() {
    abstract fun checkIfValid()
    abstract var menu: Int
    abstract var roomNumber: Int
    abstract var checkInDate: Int
    abstract var checkOutDate: Int
    var todayDate: Int = 20231201

}

class Menu(override var menu: Int) : CheckIfValid() {
    override fun checkIfValid() {
        while (true) {
            if (menu == 1) {
                println("예약할 방번호를 입력해주세요.")
                break
            }
        }
    }
}

class RoomNumber(override var roomNumber: Int) : CheckIfValid() {
    override fun checkIfValid() {
        while (true) {
            if (roomNumber in 100 until 10000) {
                break
            } else {
                println("올바르지 않은 방번호 입니다. 방번호는 100~999 영역 이내입니다.")
                roomNumber = readLine()!!.toInt()
            }
        }
    }
}

class CheckInDate(override var checkInDate: Int) : CheckIfValid() {
    override fun checkIfValid() {
        while (true) {
            if (checkInDate > todayDate) {
                break
            } else {
                println("체크인은 지난날은 선택할 수 없습니다.")
                checkInDate = readLine()!!.toInt()
            }
        }
    }
}

class CheckOutDate(override var checkOutDate: Int) : CheckIfValid() {
    override fun checkIfValid() {
        while (true) {
            if (checkOutDate > checkInDate) {
                break
            } else {
                println("체크인 날짜보다 이전이거나 같을 수는 없습니다. ")
                checkOutDate = readLine()!!.toInt()
            }
        }
    }
}