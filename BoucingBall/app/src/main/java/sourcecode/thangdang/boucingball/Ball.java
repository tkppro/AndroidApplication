package sourcecode.thangdang.boucingball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;


/**
 * Created by Admin on 20-Mar-18.
 */

public class Ball {
    private int x, y, dx, dy, radius;

    public Ball(int x, int y, int dx, int dy, int radius) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void moving(){
        x += dx;
        y += dy;
    }
    public boolean hitAnotherBall(Ball anotherBall){
        if(Math.sqrt(Math.pow((this.x-anotherBall.x),2) + Math.pow((this.y-anotherBall.y),2)) < this.radius + anotherBall.radius)
        {
            this.dx = -this.dx;
            anotherBall.dx = -anotherBall.dx;
            return true;
        }
        return false;
    }

    public void drawBall(Canvas canvas, Paint paint){
        canvas.drawCircle(x, y, radius, paint);
    }

    public void drawBall(Canvas canvas, Bitmap bitmap){
        canvas.drawBitmap(bitmap, x, y, null);
    }

    public void checkTouchingBoundary(int canvasWidth, int canvasHeight){
        if(x > canvasWidth || x < 0)
            dx = -dx;
        if( y < 0)
            dy = -dy;
    }

    public void checkTouchingWithHandle(Handle handle){
//        if(Math.sqrt(Math.pow((this.x-handle.getX()),2) + Math.pow((this.y-handle.getY()),2)) < handle.getHeight() + this.radius)
//        {
//            dx = -dx;
//            Log.d("handle","dung");
//        }
        if((handle.getX() < this.x && this.x < handle.getX() + handle.getWidth()) && (handle.getY() - radius < y && y < handle.getY()))
        {
            dy = -dy;
        }
    }

    public boolean checkTouchingWithBrick(Brick brick){
        if(brick.getVisibility()) {
            if ((brick.getX() < x && x < brick.getX() + brick.getWidth())
                    && (brick.getY() + brick.getHeight() < y && y < brick.getY() + brick.getHeight() + radius)) {
                dy = - dy;

                brick.setInVisible();
                return true;
            }
        }
        return false;
    }
}
