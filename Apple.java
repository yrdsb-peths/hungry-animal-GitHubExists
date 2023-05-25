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
    int speed = 1;
    public void act()
    {
        // Apple falls downwards
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        //  Remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if (y >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
