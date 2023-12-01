package com.example.hotelreservationprogramme

fun main() {
    // 변수 선언


    // 객체 선언

    // 첫번째 실행 (메뉴 선택)
    println("호텔예약 프로그램 입니다.")
    println("1. 방예약, 2. 예약목록 출력, 3 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입금-출금 내역 목록 출력 6. 예약 변경/취소")
    var mainMenu: Int = readLine()!!.toInt()
    var menuObject = MainMenu(mainMenu)
    menuObject.mainMenu(mainMenu)


    println("호텔 예약이 완료되었습니다.")
}

abstract class CheckIfValid() {
    abstract fun checkIfValid(value1: Int)
    abstract fun checkIfValid(value1: Int, value2: Int)
    var todayDate: Int = 20231201

}

class MainMenu(menu: Int) {
    fun mainMenu(menu: Int) {
        while (true) {
            if (menu == 1) {
                var menu1 = Menu1()
                menu1.menu1()
                break
            } else if (menu == 2) {
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


class RoomNumber() : CheckIfValid() {
    override fun checkIfValid(roomNumber: Int) {
        var roomNumber = roomNumber
        while (true) {
            if (roomNumber in 100 until 10000) {
                break
            } else {
                println("올바르지 않은 방번호 입니다. 방번호는 100~999 영역 이내입니다.")
                roomNumber = readLine()!!.toInt()
            }
        }
    }

    override fun checkIfValid(value1: Int, value2: Int) {
        TODO("Not yet implemented")
    }
}

class CheckInDate() : CheckIfValid() {
    override fun checkIfValid(checkInDate: Int) {
        var checkInDate = checkInDate
        while (true) {
            if (checkInDate > todayDate) {
                break
            } else {
                println("체크인은 지난날은 선택할 수 없습니다.")
                checkInDate = readLine()!!.toInt()
            }
        }
    }

    override fun checkIfValid(value1: Int, value2: Int) {
        TODO("Not yet implemented")
    }
}
class CheckOutDate() : CheckIfValid() {
    override fun checkIfValid(value1: Int) {
        TODO("Not yet implemented")
    }

    override fun checkIfValid(checkInDate: Int, checkOutDate: Int) {
        var checkInDate = checkInDate
        var checkOutDate = checkOutDate
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

class Menu1 {
    fun menu1() {

        println("예약자분의 성함을 입력해주세요.")
        var name = readLine()!!

        println("예약할 방번호를 입력해주세요.")
        var roomNumber = readLine()!!.toInt()
        var roomNumberObject = RoomNumber()
        roomNumberObject.checkIfValid(roomNumber)

        println("체크인 날짜를 입력해주세요 표기형식. 20230631")
        var checkInDate = readLine()!!.toInt()
        var checkInDateObject = CheckInDate()
        checkInDateObject.checkIfValid(checkInDate)

        println("체크아웃 날짜를 입력해주세요 표기형식. 20230631")
        var checkOutDate = readLine()!!.toInt()
        var checkOutDateObject = CheckOutDate()
        checkOutDateObject.checkIfValid(checkInDate, checkOutDate)
    }

}