//- **`Lv4`**
//AddOperation(더하기), SubtractOperation(빼기), MultiplyOperation(곱하기), DivideOperation(나누기) 연산 클래스들을
//AbstractOperation라는 클래스명으로 만들어 사용하여 추상화하고
//Calculator 클래스의 내부 코드를 변경합니다.
//- Lv3 와 비교해서 어떠한 점이 개선 되었는지 스스로 생각해 봅니다.
//- hint. 클래스간의 결합도, 의존성(의존성역전원칙)

package com.example.calculator_hojeong

fun main() {
    // 이름 지정
    var calculatorName = "호정의 계산기 Lv3"

    // 입력값 받기
    println("연산을 진행할 첫 번째 값을 입력해주세요.")
    var num1 = readLine()!!.toInt()
    println("연산을 진행할 두 번째 값을 입력해주세요.")
    var num2 = readLine()!!.toInt()

    // 추가 입력값 num3로 받기
    var num3 = 0

    // 연산 타입 입력받기
    println("어떤 연산을 진행하실래요?(1(더하기)/2(빼기)/3(곱하기)/4(나누기) 중 입력)")
    var calculationOption = readLine()!!.toInt()

    // 클래스별 인스턴스 생성
    // 수퍼 클래스
    val calc = Calculation()

    // 첫 연산 시 서브 클래스별 연산 결과
    var additionResult: Int = calc.add(num1, num2)
    var subtractionResult = calc.subtract(num1, num2)
    var multiplicationResult = calc.multiply(num1, num2)
    var divisionResult = calc.divide(num1, num2)
    var calculationResult : Int = 0
    var moreCalculationOption : Int = 0

    if (calculationOption == 1){
        calculationResult = additionResult
        num3 = 0
    } else if (calculationOption == 2){
        calculationResult = subtractionResult
        num3 = 0
    } else if (calculationOption == 3){
        calculationResult = multiplicationResult
        num3 = 1
    } else if (calculationOption == 4){
        calculationResult = divisionResult
        num3 = 1
    } else {
        calculationResult = 99999999
        println("입력값이 잘못되었습니다.")
    }

    while (num3 != -1) {
        if (calculationOption == 1 || moreCalculationOption == 1) {
            println("더하기 연산을 수행합니다.")
            calculationResult += num3
            println(calculationResult)
            println("추가 연산을 진행하시려면 1~5 중 하나를 입력하세요.(1(더하기)/2(빼기)/3(곱하기)/4(나누기)/-1(종료))")
            moreCalculationOption = readLine()!!.toInt()
            if (moreCalculationOption == -1){
                break
            }
            calculationOption = 0
            println("추가 연산하려는 숫자를 입력하세요.(-1을 입력하면 종료)")
            num3 = readLine()!!.toInt()
        } else if (calculationOption == 2 || moreCalculationOption == 2) {
            println("빼기 연산을 수행합니다.")
            calculationResult -= num3
            println(calculationResult)
            println("추가 연산을 진행하시려면 1~5 중 하나를 입력하세요.(1(더하기)/2(빼기)/3(곱하기)/4(나누기)/-1(종료))")
            moreCalculationOption = readLine()!!.toInt()
            if (moreCalculationOption == -1){
                break
            }
            calculationOption = 0
            println("추가 연산하려는 숫자를 입력하세요.(-1을 입력하면 종료)")
            num3 = readLine()!!.toInt()
        } else if (calculationOption == 3 || moreCalculationOption == 3) {
            println("곱하기 연산을 수행합니다.")
            calculationResult *= num3
            println(calculationResult)
            println("추가 연산을 진행하시려면 1~5 중 하나를 입력하세요.(1(더하기)/2(빼기)/3(곱하기)/4(나누기)/-1(종료))")
            moreCalculationOption = readLine()!!.toInt()
            if (moreCalculationOption == -1){
                break
            }
            calculationOption = 0
            println("추가 연산하려는 숫자를 입력하세요.(-1을 입력하면 종료)")
            num3 = readLine()!!.toInt()
        } else if (calculationOption == 4 || moreCalculationOption == 4) {
            println("나누기 연산을 수행합니다.")
            calculationResult /= num3
            println(calculationResult)
            println("추가 연산을 진행하시려면 1~5 중 하나를 입력하세요.(1(더하기)/2(빼기)/3(곱하기)/4(나누기)/-1(종료))")
            moreCalculationOption = readLine()!!.toInt()
            if (moreCalculationOption == -1){
                break
            }
            calculationOption = 0
            println("추가 연산하려는 숫자를 입력하세요.(-1을 입력하면 종료)")
            num3 = readLine()!!.toInt()
        } else {
            println("옵션값이 잘못되었습니다.")
        }
    }
}

// 추상 클래스
abstract class AbstractOperation {

}

//// 수퍼 클래스
//open class Calculation() {
//    fun calculate(num1: Int, num2: Int, operationOption: String){
//        println("${num1}과 ${num2}의 ${operationOption} 연산을 수행합니다.")
//    }
//}
//
//// 서브 클래스 - 더하기
//class AddOperation() : Calculation() {
//    fun add(num1: Int, num2: Int): Int{
//        return(num1 + num2)
//    }
//}
//
//// 서브 클래스 - 빼기
//class SubtractOperation() : Calculation() {
//    fun subtract(num1: Int, num2: Int): Int {
//        return (num1 - num2)
//    }
//}
//
//// 서브 클래스 - 곱하기
//class MultiplyOperation() : Calculation() {
//    fun multiply(num1: Int, num2: Int): Int  {
//        return(num1 * num2)
//    }
//}
//
//// 서브 클래스 - 나누기
//class DivideOperation() : Calculation() {
//    fun divide(num1: Int, num2: Int): Int {
//        return(num1 / num2)
//    }
//}

class Calculation: AbstractOperation() {
    fun add(a: Int, b: Int) : Int {
        return a + b
    }
    fun subtract(a:Int, b: Int) : Int {
        return a - b
    }
    fun multiply(a: Int, b: Int) : Int {
        return a * b
    }
    fun divide(a: Int, b: Int) : Int {
        return a / b
    }
}

