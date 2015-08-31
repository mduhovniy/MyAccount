package info.duhovniy.maxim.myaccount;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class Album extends AppCompatActivity implements View.OnTouchListener {

    private float downXValue;
    private float downYValue;
    private Animation slide_left;
    private Animation slide_right;
    private Animation slide_down;
    private Animation slide_up;

    private Animation push_up_in;
    private Animation push_up_out;
    private Animation push_up_to_bottom;
    private Animation zoom_enter;
    private Animation zoom_out;
    private Animation hyperspace_jump;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        image = (ImageView) findViewById(R.id.imageView);

        slide_left = AnimationUtils.loadAnimation(Album.this, R.anim.slide_left);
        slide_right = AnimationUtils.loadAnimation(Album.this, R.anim.slide_right);
        slide_down = AnimationUtils.loadAnimation(Album.this, R.anim.slide_down);
        slide_up = AnimationUtils.loadAnimation(Album.this, R.anim.slide_up);

        push_up_in = AnimationUtils.loadAnimation(Album.this, R.anim.push_up_in);
        push_up_out = AnimationUtils.loadAnimation(Album.this, R.anim.push_up_out);

        zoom_enter = AnimationUtils.loadAnimation(Album.this, R.anim.zoom_enter);
        zoom_out = AnimationUtils.loadAnimation(Album.this, R.anim.zoom_exit);

        hyperspace_jump = AnimationUtils.loadAnimation(Album.this, R.anim.hyperspace_jump);

        image.setImageResource(R.drawable.img1);
        image.startAnimation(hyperspace_jump);
        image.setOnTouchListener(this);
    }

    protected void goRight() {
        image.startAnimation(slide_right);
        image.setImageResource(R.drawable.img2);
        Toast.makeText(this, "Slide right", Toast.LENGTH_SHORT).show();
    }

    protected void goLeft() {
        image.setImageResource(R.drawable.img3);
        image.startAnimation(slide_left);
        Toast.makeText(this, "Slide left", Toast.LENGTH_SHORT).show();
    }

    protected void goTop() {
        image.setImageResource(R.drawable.img4);
        image.startAnimation(slide_up);
        Toast.makeText(this, "Slide top", Toast.LENGTH_SHORT).show();
    }

    protected void goBottom() {
        image.setImageResource(R.drawable.img5);
        image.startAnimation(slide_down);
        Toast.makeText(this, "Slide bottom", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                // store the X value when the user's finger was pressed down
                downYValue = event.getY();
                downXValue = event.getX();
                return true;
            }

            case MotionEvent.ACTION_UP: {
                float yDelta = downYValue - event.getY();

                if (Math.abs(yDelta) < 100) {

                    float currentX = event.getX();

                    // going backwards: pushing stuff to the right
                    if (downXValue < currentX) {
                        goRight();
                    }

                    // going forwards: pushing stuff to the left
                    if (downXValue > currentX) {
                        goLeft();
                    }
                } else {
                    // going bottom
                    if (yDelta < 0) {
                        goBottom();
                    } else { // going top
                        goTop();
                    }
                }

                break;
            }
        }

        // if you return false, these actions will not be recorded
        return false;
    }

}
