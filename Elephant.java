import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elephant, the player character
 * 
 * @author Stanley 
 * @version May 2023
 */
public class Elephant extends Actor
{
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    double velocity = 0;
    //Direction elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Constructor - The code that get run one time when object is created
     */
    public Elephant()
    {
        for (int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i +".png");
            idleRight[i].scale(100,100);
        }
        
        for (int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i +".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100,100);
        }
        
        animationTimer.mark();
        
        //Iitial elephant image
        setImage(idleRight[0]);
    }
    
    /**
     * Animate the elephant
     */
    int imageIndex = 0;
    public void animateElephant()
    {
        if (animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if (facing.equals("right")) {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //Elephant moves depending on velocity
        move((int)(velocity+0.5));
        
        // Changes velocity with which key is pressed, if no key is pressed, let the elephant slow down to a halt
        if (Greenfoot.isKeyDown("left"))
        {
            velocity -= 0.5;
            if (velocity < -6)
            {
                velocity = -6;
            }
            facing = "left";
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            velocity += 0.5;
            if (velocity > 6)
            {
                velocity = 6;
            }
            facing = "right";
        }
        else
        {
            velocity *= 0.9;
        }
        //Animate elephant
        animateElephant();
    }
}
