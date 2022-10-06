import kotlin.random.Random

val options = arrayOf("Rock", "Paper", "Scissor")
var life = 3
var highScore = 0

fun getGameChoice(optionsParam: Array<String>): Int = Random.nextInt(0,  optionsParam.size)
fun getUserChoice(): String {
    var isValidChoice = false
    var userChoice = ""
    while (!isValidChoice) {
        //ask player
        println("Please enter one of the following: ")
        for (option in options) {
            println(" - $option")
        }
        println(".")

        val userInput = readLine()
        if (userInput != null && userInput in options) {
            isValidChoice = true
            userChoice = userInput
        } else {
            println("You must enter a valid input.")
        }
    }
    return userChoice
}

fun main() {
    while (life > 0) {
        println("Let's play Rock Paper Scissors. You have $life left. Your highscore: $highScore")
        val gameChoice = getGameChoice(options)
        val gameChose = options[gameChoice]
        val playerChose = getUserChoice()
        if (playerChose == gameChose) {
            println("Tie!")
        } else if (playerChose == options[0] && gameChose == options[1] || playerChose == options[1] && gameChose == options[2]
            || playerChose == options[2] && gameChose == options[0]) {
            println("You loose!")
            life--
        } else {
            println("You win!")
            highScore++
        }
        println("Game picked: $gameChose \n You picked: $playerChose")
    }
    println("GAME Over!!! Your Highcore: $highScore")
}