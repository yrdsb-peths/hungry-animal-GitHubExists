import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A collectable for the player character
 * 
 * @author Stanley 
 * @version May 2023
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    double ySpeed = 0;
    int xSpeed = 0;
    static int level = 1;
    public void act()
    {
        // Apple falls downwards, the longer the apple falls the faster it gets
        int x = getX() + xSpeed;
        int y = getY() + (int)(ySpeed+0.5);
        ySpeed += 0.1+0.02*level;
        setLocation(x, y);
        //Bounce if touching elephant
        bounce();
        
        MyWorld world = (MyWorld) getWorld();

        //If apple touches sides of stage reverse trajectary
        if (getX() >= world.getWidth() || getX() <= 0)
        {
            xSpeed *= -1;
        }
        //  Remove apple and draw game over when apple gets to bottom
        if (y >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
       
    }
    
    /**
     * Bounce the apple if touched by the elephant
     */
    
    public void bounce()
    {
        if (isTouching(Elephant.class))
        {
            ySpeed = -8;
            xSpeed = Greenfoot.getRandomNumber(4+level)-(4+level)/2;
            setLocation(getX(), 215);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            elephantSound.play();
        }
        
    }
    //Increase difficulty as level gets higher, like higher gravity and horizontal movement after bounce
    public static void increaseLevel()
    {
        level += 1;
    }
}
