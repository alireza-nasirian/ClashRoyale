package model.cards;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;

import java.util.HashMap;

/**
 * The type Sprite.
 */
public class Sprite
{

    protected Image image;
    protected double positionX;
    protected double positionY;
    protected double velocityX;
    protected double velocityY;
    protected double width;
    protected double height;
    protected double HitSpeed;
    protected Speed speed;
    protected Target target;
    protected int range;
    protected boolean isAreaSplash;
    protected int count;
    protected int cost;
    protected HashMap<Integer, Integer> HP;
    protected HashMap<Integer, Integer> damage;

    /**
     * Instantiates a new Sprite.
     */
    public Sprite()
    {
        positionX = 0;
        positionY = 0;
        velocityX = 0;
        velocityY = 0;
    }

    /**
     * Sets image.
     *
     * @param i the image
     */
    public void setImage(Image i)
    {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }

    /**
     * Sets image with file name.
     *
     * @param filename the filename
     */
    public void setImage(String filename)
    {
        Image i = new Image(filename);
        setImage(i);
    }

    /**
     * Sets position.
     *
     * @param x the x
     * @param y the y
     */
    public void setPosition(double x, double y)
    {
        positionX = x;
        positionY = y;
    }

    /**
     * Sets velocity.
     *
     * @param x the x
     * @param y the y
     */
    public void setVelocity(double x, double y)
    {
        velocityX = x;
        velocityY = y;
    }

    /**
     * Add velocity.
     *
     * @param x the x
     * @param y the y
     */
    public void addVelocity(double x, double y)
    {
        velocityX += x;
        velocityY += y;
    }

    /**
     * calculates the new position based on the Sprite's velocity.
     *
     * @param time the time of move
     */
    public void update(double time)
    {
        positionX += velocityX * time;
        positionY += velocityY * time;
    }

    /**
     *  draws the associate Image to the canvas (via the GraphicsContext class) using the position as coordinates.
     *
     * @param gc the GraphicsContext.
     */
    public void render(GraphicsContext gc)
    {
        gc.drawImage( image, positionX, positionY );
    }

    /**
     * returns a JavaFX Rectangle2D object, useful in collision detection due to its intersects method.
     *
     * @return a JavaFX Rectangle2D object
     */
    public Rectangle2D getBoundary()
    {
        return new Rectangle2D(positionX,positionY,width,height);
    }

    /**
     * determines whether the bounding box of this Sprite intersects with that of another Sprite.
     *
     * @param s another sprite
     * @return the boolean
     */
    public boolean intersects(Sprite s)
    {
        return s.getBoundary().intersects( this.getBoundary() );
    }

    public String toString()
    {
        return " Position: [" + positionX + "," + positionY + "]"
                + " Velocity: [" + velocityX + "," + velocityY + "]";
    }
}