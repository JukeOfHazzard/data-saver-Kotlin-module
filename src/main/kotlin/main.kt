/**/
import java.util.Random /*this will give the */

class spell(r: Int, type: String, id: String){
    private val range : Int = r
    private val dmgType : String = type
    private val name : String = id
}

class encounter(){
    private val distance : Int = 50
    private val alive : Boolean = true
}

fun main(args: Array<String>) {
    println("Hello World!")
    val fire = spell(120, "fire","Fire Bolt") /*note that strings can't use the single quotes to show*/
    val ice = spell(60, "cold","Frost Ray")
    val enemy = encounter()
}
