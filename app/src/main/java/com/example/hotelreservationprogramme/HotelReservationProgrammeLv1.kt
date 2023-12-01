package com.example.hotelreservationprogramme

fun main() {
    // 변수 선언
    var menu: Int
    var name: String
    var roomNumber: Int
    var checkInDate: Int
    var checkOutDate: Int

    // 객체 선언

    // 첫번째 실행 (메뉴 선택)
    println("호텔예약 프로그램 입니다.")
    println("1. 방예약, 2. 예약목록 출력, 3 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입금-출금 내역 목록 출력 6. 예약 변경/취소")
    menu = readLine()!!.toInt()
    var menuObject = Menu(menu, 0)
    menuObject.checkIfValid()



    println("호텔 예약이 완료되었습니다.")
}

abstract class CheckIfValid() {
    abstract fun checkIfValid()
    abstract var value1: Int
    abstract var value2: Int
    var todayDate: Int = 20231201

}

class Menu(override var value1: Int, override var value2: Int) : CheckIfValid() {
    var menu = value1
    override fun checkIfValid() {
        while (true) {
            if (menu == 1) {
                break
            } else if (menu == 2) {
                println("수정"); break
            } else if (menu == 3) {
                println("수정"); break
            } else if (menu == 4) {
                println("수정"); break
            } else if (menu == 5) {
                println("수정"); break
            } else if (menu == 6) {
                println("수정"); break
            } else {
                println("수정"); break
            }
        }
    }
}


class RoomNumber(override var value1: Int, override var value2: Int) : CheckIfValid() {
    var roomNumber = value1
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

class CheckInDate(override var value1: Int, override var value2: Int) : CheckIfValid() {
    var checkInDate = value1
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

class CheckOutDate(override var value1: Int, override var value2: Int) : CheckIfValid() {
    var checkOutDate = value1
    var checkInDate = value2
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

class Menu1 :CheckIfValid(){
    fun menu1() {

        println("예약자분의 성함을 입력해주세요.")
        var name = readLine()!!

        println("예약할 방번호를 입력해주세요.")
        var roomNumber = readLine()!!.toInt()
        var roomNumberObject = RoomNumber(roomNumber, 0)
        roomNumberObject.checkIfValid()

        println("체크인 날짜를 입력해주세요 표기형식. 20230631")
        var checkInDate = readLine()!!.toInt()
        var checkInDateObject = CheckInDate(checkInDate, 0)
        checkInDateObject.checkIfValid()

        println("체크아웃 날짜를 입력해주세요 표기형식. 20230631")
        var checkOutDate = readLine()!!.toInt()
        var checkOutDateObject = CheckOutDate(checkOutDate, checkInDate)
        checkOutDateObject.checkIfValid()
    }

}