import java.awt.Color
import java.awt.Graphics2D
import java.awt.Rectangle
import java.util.*

class Food{
    var width = 10
    var height = 10
    var x = 10
    var y = 10
    var sWidth = 300
    var sHeight = 300

    constructor(wid:Int,hei:Int){
        sWidth = wid
        sHeight = hei
        setLocation()
    }

    fun setLocation(){
        val xDir = sWidth / width
        val yDir = sHeight / height

        val rn = Random()
        x = rn.nextInt(xDir) * width
        y = rn.nextInt(yDir) * width
    }

    fun control(snake:Rectangle):Boolean{
        if(Rectangle(x, y, width, height).intersects(snake)){
            setLocation()
            return true
        }
        return false
    }

    fun draw(g2d:Graphics2D){
        g2d.color = Color.RED
        g2d.fillRect(x,y,width,height)
    }
}