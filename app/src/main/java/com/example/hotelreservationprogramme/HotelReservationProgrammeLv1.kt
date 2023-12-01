package com.example.hotelreservationprogramme

fun main() {
    // 변수 선언
    var todayDate: Int = 20231201
    var menu: Int
    var name: String
    var roomNumber: Int
    var checkInDate: Int
    var checkOutDate: Int

    println("호텔예약 프로그램 입니다.")
    println("1. 방예약, 2. 예약목록 출력, 3 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입금-출금 내역 목록 출력 6. 예약 변경/취소")
    menu = readLine()!!.toInt()
    while (true) {
        if (menu == 1) {
            println("예약자분의 성함을 입력해주세요.")
            name = readLine()!!
            println("예약할 방번호를 입력해주세요.")
            break
        }
    }
    roomNumber = readLine()!!.toInt()
    while (true) {
        if (roomNumber in 100 until 10000) {
            println("체크인 날짜를 입력해주세요 표기형식. 20230631")
            checkInDate = readLine()!!.toInt()

            break
        } else {
            println("올바르지 않은 방번호 입니다. 방번호는 100~999 영역 이내입니다.")
            roomNumber = readLine()!!.toInt()
        }
    }

    while (true) {
        if (checkInDate > todayDate) {
            println("체크아웃 날짜를 입력해주세요 표기형식. 20230631")
            checkOutDate = readLine()!!.toInt()
            break
        } else {
            println("체크인은 지난날은 선택할 수 없습니다.")
            checkInDate = readLine()!!.toInt()
        }
    }

    while (true) {
        if (checkOutDate > checkInDate) {
            println("호텔 예약이 완료되었습니다.")
            break
        } else {
            println("체크인 날짜보다 이전이거나 같을 수는 없습니다. ")
            checkOutDate = readLine()!!.toInt()
        }

    }
}
