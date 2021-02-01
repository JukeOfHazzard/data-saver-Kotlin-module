/**/
import java.util.Random /*this will give the */
import java.util.Scanner

fun randomInt(): Int{
    return (0..200).random()
}

fun randomString(): String{
    val what = arrayListOf("fire","cold","lightning","necrotic")
    return what.random()
}

class Spell(r: Int, type: String, id: String){
    public val range : Int = r
    public val dmgType : String = type
    public val name : String = id
}

class Encounter(dis: Int, type: String){
    public val distance : Int = dis
    public var alive : Boolean = true
    public val vulnerable: String = type
}

fun main(args: Array<String>) {
    //println("Hello World!")
    val fire = Spell(120, "fire","Fire Bolt") /*note that strings can't use the single quotes to show*/
    val ice = Spell(60, "cold","Frost Ray")
    val bolt = Spell(30,"lightning","Witch Bolt")
    val death = Spell(0,"necrotic","Chill Touch")
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
            val act: Int = Scanner(System.`in`).nextInt() /*This will take the next integer typed in*/
            if (act == 1){
                for (i in available){println(i.name)}
                print("Which spell will you cast: ")
                val cast = readLine()
                if (cast == "Fire Bolt"){
                    if (fire.range >= creature.distance && fire.dmgType == creature.vulnerable){
                        print("Hit")
                        creature.alive = false
                    }
                    else {
                        if (fire.range < creature.distance) {
                            print("The enemy is to far away for you to cast that spell")
                        } else if (fire.dmgType != creature.vulnerable) {
                            print("The creature is immune to ${fire.dmgType} type damage.")
                        }
                    }
                }
                else if(cast == "Frost Ray"){
                    if (ice.range >= creature.distance && ice.dmgType == creature.vulnerable){
                        print("Hit")
                        creature.alive = false
                    }
                    else {
                        if (ice.range < creature.distance) {
                            print("The enemy is to far away for you to cast that spell")
                        } else if (ice.dmgType != creature.vulnerable) {
                            print("The creature is immune to ${ice.dmgType} type damage.")
                        }
                    }
                }
                else if(cast == "Witch Bolt"){
                    if (bolt.range >= creature.distance && bolt.dmgType == creature.vulnerable){
                        print("Hit")
                        creature.alive = false
                    }
                    else {
                        if (bolt.range < creature.distance) {
                            print("The enemy is to far away for you to cast that spell")
                        } else if (bolt.dmgType != creature.vulnerable) {
                            print("The creature is immune to ${bolt.dmgType} type damage.")
                        }
                    }
                }
                else if(cast == "Chill Touch"){
                    if (death.range >= creature.distance && death.dmgType == creature.vulnerable){
                        print("Hit")
                        creature.alive = false
                    }
                    else {
                        if (death.range < creature.distance) {
                            print("The enemy is to far away for you to cast that spell")
                        } else if (death.dmgType != creature.vulnerable) {
                            print("The creature is immune to ${death.dmgType} type damage.")
                        }
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
        if(choose == "N"){play = false}
        else{println("Thank for being a ")}
    }
}