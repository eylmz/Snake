import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.Timer

class Window:JFrame,KeyListener{
    var sWidth = 300
    var sHeight = 300
    var sLength = 3
    var score = 0

    var firstSnake:Snake? = null
    var panel:Panel? = null



    var timer:Timer? = null

    constructor(){
        this.title = "SnakeLin"
        this.setSize(sWidth + 4,sHeight + 30)
        this.defaultCloseOperation = EXIT_ON_CLOSE
        this.setLocationRelativeTo(null)

        addKeyListener(this)

        panel = Panel(this)
        firstSnake = panel!!.Snakes.get(0)

        timer = Timer(150,{
            if( panel!!.control() ){
                JOptionPane.showMessageDialog(this,"Score : " + score,"Game Over",JOptionPane.INFORMATION_MESSAGE)
                System.exit(0)
                timer!!.stop()
            }else {
                panel!!.repaint()
            }
        })
        timer!!.start()

        add(panel)

        this.isVisible = true
    }

    override fun keyPressed(e: KeyEvent?) {
        if(panel!!.wait == 0) {
            when (firstSnake!!.sDirection) {
                1, 3 ->
                    if (e!!.keyCode == KeyEvent.VK_UP)
                        firstSnake!!.setDirection(4)
                    else if (e.keyCode == KeyEvent.VK_DOWN)
                        firstSnake!!.setDirection(2)
                2, 4 ->
                    if (e!!.keyCode == KeyEvent.VK_LEFT)
                        firstSnake!!.setDirection(3)
                    else if (e.keyCode == KeyEvent.VK_RIGHT)
                        firstSnake!!.setDirection(1)
            }
            panel!!.wait = 1
        }
    }

    override fun keyReleased(e: KeyEvent?) {

    }

    override fun keyTyped(e: KeyEvent?) {

    }

}