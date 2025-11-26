package com.carracing.game;

import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    private MainActivity mActivity;

    public WebAppInterface(MainActivity activity) {
        this.mActivity = activity;
    }

    @JavascriptInterface
    public void showToast(String message) {
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void showExitDialog() {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mActivity.showExitDialog();
            }
        });
    }

    @JavascriptInterface
    public void gameOver(int score) {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mActivity, "Game Over! Your score: " + score, Toast.LENGTH_LONG).show();
            }
        });
    }

    @JavascriptInterface
    public void sendScore(int score) {
        // Handle score from HTML game
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // You can save score or show notification
            }
        });
    }
}