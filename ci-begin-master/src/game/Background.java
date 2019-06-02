package game;

import tklibs.SpriteUtils;

public class Background extends GameObject{

    int bgh;

    public Background(){
        image= SpriteUtils.loadImage("assets/images/Background/0.png");
        position.set(0,Settings.GAME_HEIGH-Settings.BACKGROUND_HEIGH);
        bgh=image.getHeight();
        position.y =Settings.GAME_HEIGH-bgh;
    }
    @Override
    public void run(){
        position.y += Settings.BACKGROUND_IMAGE;
        if(position.y >=0){
            position.y =0;
        }
    }
}
