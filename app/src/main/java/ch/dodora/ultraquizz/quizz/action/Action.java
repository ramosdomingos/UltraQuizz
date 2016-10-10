package ch.dodora.ultraquizz.quizz.action;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;

import ch.dodora.ultraquizz.R;

/**
 * Created by rdomi on 10/10/2016.
 */

public final class Action {
    private static final long BUTTON_PRESSED = 10;
    private static final long NEXT_QUESTION = 100;
    private static final long RIGHT_ANSWER = 200;
    private static final long FALSE_ANSWER = 500;
    private static final long INVALID_OPERATION = 1000;
    private Context context;
    private Vibrator vibrator;
    private AudioManager am;
    private MediaPlayer mp;

    public Action(Context context) {
        this.context = context;

        vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        final int STREAM_TYPE = AudioManager.STREAM_SYSTEM;
        int volume = (int) (am.getStreamMaxVolume(STREAM_TYPE) * 0.7);
        am.setStreamVolume(STREAM_TYPE, volume, AudioManager.FLAG_PLAY_SOUND);
        playSong(R.raw.sound_next);
    }

    private void playSong(int rawId) {
        if (mp != null && mp.isPlaying()) mp.stop();
        mp = MediaPlayer.create(context, rawId);
        mp.start();
    }

    public void nextQuestion() {
        vibrator.cancel();
        vibrator.vibrate(NEXT_QUESTION);
        playSong(R.raw.sound_next);
    }

    public void rightAnswer() {
        vibrator.cancel();
        vibrator.vibrate(RIGHT_ANSWER);
        playSong(R.raw.sound_right);
    }

    public void falseAnswer() {
        vibrator.cancel();
        vibrator.vibrate(FALSE_ANSWER);
        playSong(R.raw.sound_false);
    }

    public void invalidOperation() {
        vibrator.cancel();
        vibrator.vibrate(INVALID_OPERATION);
        playSong(R.raw.sound_bonus);
    }

    public void buttonPressed() {
        vibrator.cancel();
        vibrator.vibrate(BUTTON_PRESSED);
        playSong(R.raw.sound_bonus);
    }
}