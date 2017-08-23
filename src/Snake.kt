import java.awt.Color
import java.awt.Graphics2D
import java.awt.Rectangle

class Snake {
    var x = 0
    var y = 0
    var sDirection = 1
    var width = 10
    var height = 10

    constructor(wid:Int, hei:Int){
        x = wid / 2 - width
        y = hei / 2 - height
    }

    constructor(lastSnake: Snake){
        setDirection(lastSnake)
        if(sDirection == 1)
            x = lastSnake.x - width
        else if(sDirection == 3)
            x = lastSnake.x + width
        else x = lastSnake.x

        if(sDirection == 2)
            y = lastSnake.y - height
        else if(sDirection == 4)
            y = lastSnake.y + height
        else y = lastSnake.y
    }

    fun setDirection(lastSnake: Snake){
        sDirection = lastSnake.sDirection
    }

    fun setDirection(d:Int){
        sDirection = d
    }

    fun setLocation(){
        if(sDirection == 1)
            x += width
        else if(sDirection == 2)
            y += height
        else if(sDirection == 3)
            x -= width
        else if(sDirection == 4)
            y -= height
    }

    fun shift(lastSnake: Snake){
        setLocation()
        setDirection(lastSnake)
    }

    fun shift(){
        setLocation()
    }

    fun getRectangle():Rectangle{
        return Rectangle(x, y, width, height)
    }

    fun control(rect:Rectangle):Boolean {
        return Rectangle(x,y,width,height).intersects(rect)
    }

    fun draw(g2d:Graphics2D) {
        g2d.color = Color.GREEN
        g2d.fillRect(x, y, width, height)

    }
}