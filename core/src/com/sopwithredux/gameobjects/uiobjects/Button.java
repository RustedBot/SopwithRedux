package com.sopwithredux.gameobjects.uiobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.sopwithredux.Event;

/**
 * Created by Carl on 31/03/2017.
 */
public class Button extends UIObject
{
    private Texture overlay, underlay;
    private Event buttonClickEvent;
    private Vector2 mousePosition;

//    private final InputProcessor inputProcessor = new InputProcessor()
//    {
//        @Override
//        public boolean keyDown(int keycode)
//        {
//            return false;
//        }
//
//        @Override
//        public boolean keyUp(int keycode)
//        {
//            return false;
//        }
//
//        @Override
//        public boolean keyTyped(char character)
//        {
//            return false;
//        }
//
//        @Override
//        public boolean touchDown(int screenX, int screenY, int pointer, int button)
//        {
//            return false;
//        }
//
//        @Override
//        public boolean touchUp(int screenX, int screenY, int pointer, int button)
//        {
//            if(button == Input.Buttons.LEFT)
//            {
//                if(screenX > mousePosition.x - (dimension.x / 2) && screenX < mousePosition.x + (dimension.x / 2) &&
//                   screenY > mousePosition.y - (dimension.y / 2) && screenY < mousePosition.y + (dimension.y / 2))
//                {
//                    sendEvent(Button.this, buttonClickEvent);
//                    return true;
//                }
//            }
//
//            return false;
//        }
//
//        @Override
//        public boolean touchDragged(int screenX, int screenY, int pointer)
//        {
//            return false;
//        }
//
//        @Override
//        public boolean mouseMoved(int screenX, int screenY)
//        {
//            return false;
//        }
//
//        @Override
//        public boolean scrolled(int amount)
//        {
//            return false;
//        }
//    };

    public Button(Texture image, Texture overlay, Vector2 position, Vector2 dimension, Vector2 sourceDimension,
                  double speed, double angle, boolean isFlippedX, boolean isFlippedY, Event buttonClickEvent)
    {
        super(image, position, dimension, sourceDimension, speed, angle, isFlippedX, isFlippedY);

        this.underlay = image;
        this.overlay = overlay;
        this.buttonClickEvent = buttonClickEvent;
        mousePosition = new Vector2(position.x, Gdx.graphics.getHeight() - position.y);
    }

//    public void init()
//    {
//        Gdx.input.setInputProcessor(inputProcessor);
//    }

    @Override
    public void update()
    {
        if(Gdx.input.getX() > mousePosition.x - (dimension.x / 2) && Gdx.input.getX() < mousePosition.x + (dimension.x / 2) &&
           Gdx.input.getY() > mousePosition.y - (dimension.y / 2) && Gdx.input.getY() < mousePosition.y + (dimension.y / 2))
        {
            image = overlay;

            Gdx.input.setInputProcessor(new InputAdapter()
            {
                @Override
                public boolean touchUp(int screenX, int screenY, int pointer, int button)
                {
                    if(button == Input.Buttons.LEFT)
                    {
                        if(screenX > mousePosition.x - (dimension.x / 2) && screenX < mousePosition.x + (dimension.x / 2) &&
                          screenY > mousePosition.y - (dimension.y / 2) && screenY < mousePosition.y + (dimension.y / 2))
                        {
                            sendEvent(Button.this, buttonClickEvent);
                            return true;
                        }
                    }

                    return false;
                }
            });
        }
        else
        {
            image = underlay;
        }
    }
}
