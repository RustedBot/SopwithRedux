package com.sopwithredux.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.sopwithredux.Subject;
import com.sopwithredux.World;

/**
 * Created by Carl on 08/03/2017.
 */
public abstract class GameObject extends Subject
{
    protected World world;
    protected Vector2 position, dimension, sourceDimension, direction;
    protected double speed, angle, scaleX, scaleY;
    protected Texture image;
    protected boolean isFlippedX, isFlippedY;

    protected GameObject(Vector2 position, double speed, double angle, boolean isFlippedX, boolean isFlippedY)
    {
        this.position = position;
        this.speed = speed;
        this.angle = angle;
        this.isFlippedX = isFlippedX;
        this.isFlippedY = isFlippedY;
        scaleX = 1.0;
        scaleY = 1.0;
        direction = new Vector2(0, 0);
    }

    protected GameObject(Texture image, Vector2 position, Vector2 dimension, Vector2 sourceDimension,
                         double speed, double angle, boolean isFlippedX, boolean isFlippedY)
    {
        this.image = image;
        this.position = position;
        this.dimension = dimension;
        this.sourceDimension = sourceDimension;
        this.speed = speed;
        this.angle = angle;
        this.isFlippedX = isFlippedX;
        this.isFlippedY = isFlippedY;
        scaleX = 1.0;
        scaleY = 1.0;
        direction = new Vector2(0, 0);
    }

    protected GameObject(World world, Vector2 position, double speed, double angle, boolean isFlippedX, boolean isFlippedY)
    {
        this.world = world;
        this.position = position;
        this.speed = speed;
        this.angle = angle;
        this.isFlippedX = isFlippedX;
        this.isFlippedY = isFlippedY;
        scaleX = 1.0;
        scaleY = 1.0;
        direction = new Vector2(0, 0);
    }

    protected GameObject(World world, Texture image, Vector2 position, Vector2 dimension, Vector2 sourceDimension,
                         double speed, double angle, boolean isFlippedX, boolean isFlippedY)
    {
        this.world = world;
        this.image = image;
        this.position = position;
        this.dimension = dimension;
        this.sourceDimension = sourceDimension;
        this.speed = speed;
        this.angle = angle;
        this.isFlippedX = isFlippedX;
        this.isFlippedY = isFlippedY;
        scaleX = 1.0;
        scaleY = 1.0;
        direction = new Vector2(0, 0);
    }

    public abstract void update();

    public void render(SpriteBatch batch)
    {
        batch.draw(image,
          position.x - dimension.x / 2, position.y - dimension.y / 2,
          dimension.x / 2, dimension.y / 2, // Origin is center point for rotation
          dimension.x, dimension.y,
          (float)scaleX, (float)scaleY,
          (float)angle,
          0, 0, (int)sourceDimension.x, (int)sourceDimension.y,
          isFlippedX, isFlippedY);
    }
}