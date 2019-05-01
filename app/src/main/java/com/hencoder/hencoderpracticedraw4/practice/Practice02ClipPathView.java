package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice02ClipPathView extends View {
    Paint paint = new Paint();
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice02ClipPathView(Context context) {
        super(context);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path = new Path();
        path.addCircle(point1.x + bitmap.getWidth() - 50, point1.y + bitmap.getHeight() - 50,
                100, Path.Direction.CW);

//        Path path1 = new Path();
//        path1.addCircle(point1.x + bitmap.getWidth() - 50, point1.y + bitmap.getHeight() - 50,
//                100, Path.Direction.CCW);

        canvas.save();
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        Path path1 = new Path();
        path1.addCircle(point2.x + bitmap.getWidth() - 50, point2.y + bitmap.getHeight() - 50,
                100, Path.Direction.CW);
        path1.setFillType(Path.FillType.INVERSE_WINDING);
        canvas.clipPath(path1);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

    }
}
