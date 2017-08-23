import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel

class Panel:JPanel{
    var Snakes:ArrayList<Snake> = ArrayList()
    var Food:Food? = null
    var wait = 0

    var window:Window?=null

    constructor(frame:Window){
        window = frame
        Food = Food(window!!.sWidth,window!!.sHeight)

        var i  = 0

        while(i < window!!.sLength){
            if(i == 0)
                Snakes.add( Snake( window!!.sWidth, window!!.sHeight) )
            else
                Snakes.add( Snake( Snakes.get(i-1)) )
            i++
        }
    }

    fun control():Boolean{
        val firstSnake = Snakes.get(0)

        val xCor = firstSnake.x
        val yCor = firstSnake.y
        val width = firstSnake.width
        val height = firstSnake.height

        if(xCor < 0 || yCor < 0 || xCor + width > window!!.sWidth || yCor + height > window!!.sHeight)
            return true

        var i = 1
        while( i < Snakes.size ){
            if( firstSnake.control( Snakes.get(i).getRectangle() ))
                return true
            i++
        }
        return false
    }

    override fun paint(g: Graphics?) {
        super.paint(g)

        val g2d:Graphics2D = g as Graphics2D

        g2d.drawRect(0,0,window!!.sWidth,window!!.sHeight)

        var i = Snakes.size - 1
        while (i >= 0){
            val Snake = Snakes.get(i)

            if (i == 0)
                Snake.shift()
            else
                Snake.shift(Snakes.get(i - 1))

            if (Food!!.control(Snake.getRectangle())) {
                window!!.score++;
                Snakes.add(Snake(Snakes.last()))
            }

            Snake.draw(g2d)

            i--
        }

        Food!!.draw(g2d)
        wait = 0
    }



}