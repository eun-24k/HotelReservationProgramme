package com.example.hotelreservationprogramme

fun main() {
    println("호텔예약 프로그램 입니다.")
    println("1. 방예약, 2. 예약목록 출력, 3 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입금-출금 내역 목록 출력 6. 예약 변경/취소")
    var menu:Int = readLine()!!.toInt()
    println("예약자분의 성함을 입력해주세요.")
    var name:String = readLine()!!
    println("예약할 방번호를 입력해주세요.")
    var roomNumber:Int = readLine()!!.toInt()
    println("체크인 날짜를 입력해주세요 표기형식. 20230631")
    var checkInDate:Int = readLine()!!.toInt()
    println("체크아웃 날짜를 입력해주세요 표기형식. 20230631")
    var checkOutDate:Int = readLine()!!.toInt()
    println("호텔 예약이 완료되었습니다.")

}