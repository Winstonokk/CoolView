package com.barnettwong.view_library.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.barnettwong.view_library.R;

import java.util.LinkedHashMap;



public class WaterMark {
    private static LinkedHashMap<String, BitmapDrawable> mBitmapCache = new LinkedHashMap<String, BitmapDrawable>();
    private Context mContext;
    private String mContent;
    private BitmapDrawable mBitmapDrawable;
    private static final int HORIZONTAL_SPACING = 160;
    private static final int VERTICAL_SPACEING = 110;
    private static final int ROTATION = 20;
    private static final int TEXT_SIZE = 20;

    public Context getContext() {
        return mContext;
    }

    public String getContent() {
        return mContent;
    }

    public BitmapDrawable getBitmapDrawable() {
        return mBitmapDrawable;
    }

    public static class Builder {
        private Context mContext;
        private String mContent;
        private int mContentColor;
        private int mContentTextSize;
        private int mBackGroudColor;
        private int mRotateAngle;
        private int mPaddingRight;
        private int mPaddingBottom;
        private Bitmap mBitmap;
        private BitmapDrawable mBitmapDrawable;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setContent(String content) {
            this.mContent = content;
            return this;
        }

        public Builder setContentColor(int contentColor) {
            this.mContentColor = contentColor;
            return this;
        }

        public Builder setContentTextSize(int contentTextSize) {
            this.mContentTextSize = contentTextSize;
            return this;
        }

        public Builder setBackGroudColor(int backGroudColor) {
            this.mBackGroudColor = backGroudColor;
            return this;
        }

        public Builder setRotateAngle(int rotateAngle) {
            this.mRotateAngle = rotateAngle;
            return this;
        }

        public Builder setHorizontalPadding(int padding) {
            this.mPaddingRight = padding;
            return this;
        }

        public Builder setVerticalPadding(int padding) {
            this.mPaddingBottom = padding;
            return this;
        }

        private int getScreenWidth() {
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics dm = new DisplayMetrics();
            wm.getDefaultDisplay().getMetrics(dm);
            int width = dm.widthPixels;
            return width;
        }

        private int getScreenHeight() {
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics dm = new DisplayMetrics();
            wm.getDefaultDisplay().getMetrics(dm);
            int height = dm.heightPixels;
            return height;
        }

        public WaterMark build() {
            initParameter();
            mBitmapDrawable = getBitmapDrawableFromCache();
            if (mBitmapDrawable == null) {
                createBitmapDrawable();
            }
            WaterMark waterMark = new WaterMark();
            waterMark.mContext = mContext;
            waterMark.mContent = mContent;
            waterMark.mBitmapDrawable = mBitmapDrawable;
            return waterMark;

        }

        private void initParameter() {
            if (TextUtils.isEmpty(mContent)) {
                String userName = "BarnettWong";
                String hostPhoneNum = "13244889847";
                if (!TextUtils.isEmpty(hostPhoneNum)) {
                    String suffix = hostPhoneNum.substring(hostPhoneNum.length() - 4, hostPhoneNum.length());
                    mContent = userName + suffix;
                } else {
                    String userId = "1993kxhp";
                    String suffix = userId.substring(userId.length() - 4, userId.length());
                    mContent = userName + suffix;
                }
            }

            if (mBackGroudColor == 0) {
                mBackGroudColor = mContext.getResources().getColor(android.R.color.white);
            }
            if (mContentColor == 0) {
                mContentColor = mContext.getResources().getColor(R.color.water_mark_color);
            }
            if (mContentTextSize == 0) {
                float fontScale = mContext.getResources().getDisplayMetrics().scaledDensity;
                mContentTextSize = (int) (TEXT_SIZE / 2 * fontScale + 0.5f);
            }
            if (mRotateAngle == 0) {
                mRotateAngle = ROTATION;
            }
            if (mPaddingRight == 0) {
                final float scale = mContext.getResources().getDisplayMetrics().density;
                mPaddingRight = (int) (HORIZONTAL_SPACING / 2 * scale + 0.5f);
            }
            if (mPaddingBottom == 0) {
                final float scale = mContext.getResources().getDisplayMetrics().density;
                mPaddingBottom = (int) (VERTICAL_SPACEING / 2 * scale + 0.5f);
            }
        }

        private BitmapDrawable getBitmapDrawableFromCache() {
            String waterMarkConfiguration = mContent + "_" + mContentColor + "_" + mContentTextSize + "_" + mBackGroudColor + "_" + mRotateAngle + "_" + mPaddingRight + "_" + mPaddingBottom;
            for (String key : mBitmapCache.keySet()) {
                if (key.equals(waterMarkConfiguration)) {
                    return mBitmapCache.get(waterMarkConfiguration);
                }
            }
            return null;
        }

        private void createBitmapDrawable() {
            TextPaint paint = new TextPaint();
            paint.setColor(mContentColor);
            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setTextSize(mContentTextSize);

            Rect rect = new Rect();
            paint.getTextBounds(this.mContent, 0, this.mContent.length(), rect);

            int textWidth = rect.width();
            int textHeight = rect.height();

            mBitmap = Bitmap.createBitmap(getScreenWidth(), getScreenHeight(), Bitmap.Config.RGB_565);

            Canvas canvas = new Canvas(mBitmap);
            canvas.drawColor(mBackGroudColor);

            double sinRotateAngle = Math.sin(ROTATION);
            double cosRotateAngle = Math.cos(ROTATION);
            int canvasHeight = (int) ((getScreenHeight() * cosRotateAngle + getScreenWidth() * sinRotateAngle) * 1.5);
            int canvasWidth = (int) (getScreenHeight() * sinRotateAngle + getScreenWidth() * cosRotateAngle);

            canvas.rotate(-mRotateAngle, getScreenWidth() / 2, getScreenHeight() / 2);

            int startX = 0;
            int startY = 0;
            int i = 1;
            for (int positionY = startY; positionY <= canvasHeight; positionY += (textHeight + mPaddingBottom)) {
                i++;
                if (i % 2 == 0) {
                    startX = -getScreenWidth() + +textWidth + (mPaddingRight - textWidth) / 2;
                } else {
                    startX = -getScreenWidth();
                }
                for (float positionX = startX; positionX <= canvasWidth; positionX += (textWidth + mPaddingRight)) {
                    canvas.drawText(mContent, positionX, positionY, paint);
                }
            }

            mBitmapDrawable = new BitmapDrawable(mContext.getResources(), mBitmap);
            mBitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            mBitmapDrawable.setDither(true);

            String waterMarkConfiguration = mContent + "_" + mContentColor + "_" + mContentTextSize + "_" + mBackGroudColor + "_" + mRotateAngle + "_" + mPaddingRight + "_" + mPaddingBottom;
            mBitmapCache.put(waterMarkConfiguration, mBitmapDrawable);
        }
    }
}
