import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elephant, the player character
 * 
 * @author Stanley 
 * @version May 2023
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage idle = new GreenfootImage("images/elephant_idle/idle0.png");
    /**
     * Constructor - The code that get run one time when object is created
     */
    public Elephant()
    {
        for (int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/elephant_idle/idle0" + i +".png");
        }
        setImage(idle[0]);
    }
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Moves corresponding with which key is pressed
        if (Greenfoot.isKeyDown("left"))
        {
            move(-1);
        }
        if (Greenfoot.isKeyDown("right"))
        {
            move(1);
        }
        eat();
    }
    
    /**
     * Eat apple and spawn new apple when previous is eaten
     */
    public void eat()
    {
        if (isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            world.createApple();
            elephantSound.play();
        }
        
    }
}
