package com.example.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;

public class Sprite {
    private Bitmap bitmap;
    private List<Rect> frames;//массив где будут картинки
    private int frameWidth;//ширина, размер
    private int frameHeight;
    private int currentFrame;//текущий кадр
    private double frameTime;//время анимации(фпс)
    private double timeForCurrentFrame;//текущее время кадра
    private double x;//координаты верхней точки спрайта
    private double y;
    private double velocityX;//то на сколько обьект передвигается
    private double velocityY;
    private int padding;//внутренний отступ
    //alt+insert=быстро создать
    public Sprite(Bitmap bitmap, double x, double y, double velocityX, double velocityY, Rect initialFrame) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.frames = new ArrayList<>();
        this.frames.add(initialFrame);
        this.currentFrame = 0;
        this.timeForCurrentFrame = 0.0;
        this.frameTime = 0.1;
        this.frameWidth = initialFrame.width();
        this.frameHeight = initialFrame.height();
        this.padding = 20;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public List<Rect> getFrames() {
        return frames;
    }

    public void setFrames(List<Rect> frames) {
        this.frames = frames;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }

    public void setFrameHeight(int frameHeight) {
        this.frameHeight = frameHeight;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame % frames.size();
    }

    public double getFrameTime() {
        return frameTime = Math.abs(timeForCurrentFrame);
    }

    public void setFrameTime(double frameTime) {
        this.frameTime = frameTime;
    }

    public double getTimeForCurrentFrame() {
        return timeForCurrentFrame;
    }

    public void setTimeForCurrentFrame(double timeForCurrentFrame) {
        this.timeForCurrentFrame = Math.abs(timeForCurrentFrame);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }
    public void addFrame(Rect rect){
        frames.add(rect);
    }
    public void update(int ms){
        timeForCurrentFrame += ms;
        if(timeForCurrentFrame>=frameTime){
            currentFrame = (currentFrame+1)% frames.size();
            timeForCurrentFrame = timeForCurrentFrame-frameTime;
        }
        x=x+velocityX * ms/1000.0;
        y=y+velocityY * ms/1000.0;
    }
    public void draw(Canvas canvas){
        Paint paint = new Paint();
        Rect destination = new Rect((int)x,(int)y,(int)x+frameWidth,(int)y+frameHeight);
        canvas.drawBitmap(bitmap,frames.get(currentFrame), destination, paint);
    }

}
