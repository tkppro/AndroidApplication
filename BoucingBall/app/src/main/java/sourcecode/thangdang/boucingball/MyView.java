package sourcecode.thangdang.boucingball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Admin on 04-Mar-18.
 */
public class MyView extends View implements Runnable {



    private int x1=250, y1=600, dx1=10, dy1=10;
   // private int x2=500, y2=100, dx2=10, dy2=10;
    private int radius = 50;
    private int xHandle = 10, yHandle = 10, width = 200, height = 30;
    Bitmap ball, ballResize, background, backgroundResize;
    SoundManager sound;
    String result;
    boolean GAME_OVER;

    ArrayList<Brick> lists;

    private Ball ballOne, ballTwo;
    private Handle handle;
    private Brick brick;
    private int point;

    public MyView(Context  context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ballOne = new Ball(x1 ,y1, dx1, dy1, radius);
      //  ballTwo = new Ball(x2 ,y2, dx2, dy2, radius);
        handle = new Handle(xHandle, yHandle, width, height);
        ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        ballResize = Bitmap.createScaledBitmap(ball,50,50,false);
        background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        sound = SoundManager.getInstance();
        sound.init(context);
        result = "0";

        lists = new ArrayList<Brick>();

        for (int i = 0; i < 5; i++) {
            brick = new Brick(110 * i , 0, 105, 70);
            //if(brick.getVisibility()) {
//            brick.drawBrick(canvas, paint);
            lists.add(brick);
            // }
        }

        for(int i = 0; i < 5; i++) {
            brick = new Brick(110 * i, 75, 105, 70);
            // if(brick.getVisibility()) {
//            brick.drawBrick(canvas, paint);
            lists.add(brick);
            //}
        }

        for(int i = 0; i < 5; i++) {
            brick = new Brick(110 * i, 150, 105, 70);
            // if(brick.getVisibility()) {
//            brick.drawBrick(canvas, paint);
            lists.add(brick);
            // }
        }


    }

    public boolean isBrokenAll(){
        for(Brick element : lists) {
            if (element.getVisibility()) {
                return false;
            }
        }
        return true;
    }



    @Override

    protected void onDraw(Canvas canvas) {

        // TODO Auto-generated method stub

        super.onDraw(canvas);


        int x = getWidth();

        int y = getHeight();

        canvas.drawBitmap(backgroundResize, 0, 0, null);

        Paint paint = new Paint();

        paint.setStyle(Paint.Style.FILL);


        // Use Color.parseColor to define HTML colors

        paint.setColor(Color.parseColor("#CD5C5C"));
//        canvas.drawCircle(x1, y1, radius, paint);
        ballOne.drawBall(canvas, ballResize);
    //    ballOne.drawBall(canvas,paint);
        paint.setColor(Color.parseColor("#ff33cc"));
     //   ballTwo.drawBall(canvas,paint);


        handle.drawHandle(canvas, paint);
        paint.setColor(Color.parseColor("#000066"));



        for(Brick element : lists){
            element.drawBrick(canvas, paint);
            if(element.getVisibility()) {
                if (ballOne.checkTouchingWithBrick(element)) {
                    sound.playSound(R.raw.explode);
                    point += 10;
                }
            }
        }

        result = String.valueOf(point);
        paint.setTextSize(50);
        canvas.drawText(result,0,800,paint);
//        if(!isBrokenAll()) {
//            Log.d("isBroke", "false");
//        }

        if(ballOne.getY() > 1000 || isBrokenAll()) {
            sound.playSound(R.raw.loselife);
            restartGame(lists, ballOne, handle);

        }

        update(x, y);
        invalidate();



    }


    public void restartGame(ArrayList<Brick> lists, Ball ballOne, Handle handle){

        for(Brick element : lists)
            element.setVisible();

        point = 0;
        ballOne.setX(x1);
        ballOne.setY(y1);
        ballOne.setDx(dx1);
        ballOne.setDy(dy1);
        handle.setX(this.getWidth() / 2 - handle.getWidth()/2);
        handle.setY(this.getHeight() - 100);

    }


    void	update(int width, int height)
    {
        ballOne.moving();
     //   ballTwo.moving();
        ballOne.checkTouchingBoundary(width, height);
    //    ballTwo.checkTouchingBoundary(width, height);
//        ballOne.hitAnotherBall(ballTwo);
        ballOne.checkTouchingWithHandle(handle);
        //handle.checkTouchingWithBall(ballTwo);
     //   ballTwo.checkTouchingWithHandle(handle);
//        ballOne.checkTouchingWithBrick(lists);
    }

    @Override
    public void run() {

    }


    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld)
    {
        handle.setX(this.getWidth() / 2 - handle.getWidth()/2);
        handle.setY(this.getHeight() - 100);

        backgroundResize = Bitmap.createScaledBitmap(background,800,1000,false);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        boolean handled = false;

        int xTouch;
        int yTouch;
        int actionIndex = event.getActionIndex();

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:

                xTouch = (int) event.getX(0);
                yTouch = (int) event.getY(0);

                handle.setX(xTouch);
                invalidate();
                Log.d("touch","x" + xTouch + " -- " + yTouch);
                handled = true;
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                xTouch = (int) event.getX(actionIndex);
                yTouch = (int) event.getY(actionIndex);


                handled = true;
                break;

            case MotionEvent.ACTION_MOVE:
                final int pointerCount = event.getPointerCount();

                for (actionIndex = 0; actionIndex < pointerCount; actionIndex++) {

                    xTouch = (int) event.getX(actionIndex);
                    yTouch = (int) event.getY(actionIndex);
                    handle.setX(xTouch);


                }


                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_UP:

                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_POINTER_UP:

                invalidate();
                handled = true;
                break;

            case MotionEvent.ACTION_CANCEL:

                handled = true;
                break;

            default:
                // do nothing
                break;
        }

        return super.onTouchEvent(event) || handled;
    }
}