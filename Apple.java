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
    public void act()
    {
        // Apple falls downwards
        int x = getX();
        int y = getY() + 2;
        setLocation(x, y);
        
        //  Remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if (y >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
}
