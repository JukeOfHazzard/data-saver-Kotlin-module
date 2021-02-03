import java.util.Random /*this will give the */
import java.util.Scanner /*helps make the random generator possible*/

fun randomInt(): Int{
    return (0..200).random()
}

fun randomString(): String{
    val what = arrayListOf("fire","cold","lightning","necrotic")
    return what.random()
}

class Spell(r: Int, type: String, id: String){
    val range : Int = r
    val dmgType : String = type
    val name : String = id
}

class Encounter(dis: Int, type: String){
    val distance : Int = dis      //All the variables are public unless other wise told
    var alive : Boolean = true    //var allows for changes, thus variable
    val vulnerable: String = type //val doesn't change, it is just a value
}

fun main(){
    //println("Hello World!")
    val fire = Spell(120, "fire","Fire Bolt") //note that strings can't use the single quotes to show
    val ice = Spell(60, "cold","Frost Ray")
    val bolt = Spell(30,"lightning","Witch Bolt")
    val death = Spell(5,"necrotic","Chill Touch")
    val available = listOf(fire, ice, bolt, death)
    //val heal = spell(0,"radiant", "Cure Wounds")
    var play = true
    while(play){
        val creature = Encounter(randomInt(), randomString())
        while(creature.alive){
            println("You approach a person with the following attributes:")
            println("Is vulnerable to ${creature.vulnerable} damage" +
                    " and is ${creature.distance}ft away from you")
            println()
            println("What will you do?")
            println("1> Attack")
            println("2> Run")
            print("Enter number:")
            val act: Int = Scanner(System.`in`).nextInt() /*This will take the next integer typed on keyboard*/
            if (act == 1){
                for (i in available){println(i.name + "> Range: ${i.range} ft does ${i.dmgType} damage")}
                print("Which spell will you cast: ")
                val cast = readLine()//this will read what is typed on the keyboard, is case sensitive
                if (cast == "Fire Bolt"){
                    if (fire.range >= creature.distance && fire.dmgType == creature.vulnerable){
                        print("Hit")
                        creature.alive = false
                        println()
                    }
                    else {
                        if (fire.range < creature.distance) {
                            print("The enemy is to far away for you to cast that spell")
                        } else if (fire.dmgType != creature.vulnerable) {
                            print("The creature is immune to ${fire.dmgType} type damage.")
                        }
                        println()
                    }
                }
                else if(cast == "Frost Ray"){
                    if (ice.range >= creature.distance && ice.dmgType == creature.vulnerable){
                        print("Hit")
                        creature.alive = false
                        println()
                    }
                    else {
                        if (ice.range < creature.distance) {
                            print("The enemy is to far away for you to cast that spell")
                        } else if (ice.dmgType != creature.vulnerable) {
                            print("The creature is immune to ${ice.dmgType} type damage.")
                        }
                        println()
                    }
                }
                else if(cast == "Witch Bolt"){
                    if (bolt.range >= creature.distance && bolt.dmgType == creature.vulnerable){
                        print("Hit")
                        creature.alive = false
                        println()
                    }
                    else {
                        if (bolt.range < creature.distance) {
                            print("The enemy is to far away for you to cast that spell")
                        } else if (bolt.dmgType != creature.vulnerable) {
                            print("The creature is immune to ${bolt.dmgType} type damage.")
                        }
                        println()
                    }
                }
                else if(cast == "Chill Touch"){
                    if (death.range >= creature.distance && death.dmgType == creature.vulnerable){
                        print("Hit")
                        creature.alive = false
                        println()
                    }
                    else {
                        if (death.range < creature.distance) {
                            print("The enemy is to far away for you to cast that spell")
                        } else if (death.dmgType != creature.vulnerable) {
                            print("The creature is immune to ${death.dmgType} type damage.")
                        }
                        println()
                    }
                }
                else{println("You have not learned that spell. Or did you miss cast it?" +
                        "Either way you are an idiot.")}

            }
            else if(act == 2){
                println("You got away")
                creature.alive = false
            }
            else{
                println("That is not a valid option")
            }
        }
        print("Do you want to play again? [Y/N]: ")
        val choose = readLine()
        if(choose == "N"){
            play = false
            println("Thank You for Playing Adventurer")
        }
        else{println("Thank you hero for doing what you could.")}
    }
}