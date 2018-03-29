package sourcecode.thangdang.boucingball;

/**
 * Created by Admin on 27-Mar-18.
 */
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.util.SparseIntArray;

public class SoundManager {

    private SoundPool mSoundPool;

    private SparseIntArray mSoundPoolMap = new SparseIntArray();

    private Handler mHandler = new Handler();
    private boolean mMuted = false;
    private Context context;

    private static final int MAX_STREAMS = 10;
    private static final int STOP_DELAY_MILLIS = 3000;

    private static SoundManager _instance = null;

    public SoundManager() {
        mSoundPool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
    }

    public static SoundManager getInstance(){
        if (_instance == null) {
            _instance = new SoundManager();
        }

        return _instance;
    }

    public void init(Context context){
        this.context = context;
        _instance.initStreamTypeMedia((Activity)context);
        _instance.addSound(R.raw.beep1);
        _instance.addSound(R.raw.explode);
        _instance.addSound(R.raw.loselife);

    }

    /**
     * Put the sounds to their correspondig keys in sound pool.
     */
    public void addSound(int soundID) {
        mSoundPoolMap.put(soundID, mSoundPool.load(context, soundID, 1));
    }

    /**
     * Find sound with the key and play it
     */
    public void playSound(int soundID) {
        if(mMuted){
            return;
        }

        boolean hasSound = mSoundPoolMap.indexOfKey(soundID) >= 0;
        if(!hasSound){
            return;
        }

        final int soundId = mSoundPool.play(mSoundPoolMap.get(soundID), 1, 1, 1, 0, 1f);
        scheduleSoundStop(soundId);
    }

    /**
     * Schedule the current sound to stop after set milliseconds
     */
    private void scheduleSoundStop(final int soundId){
        mHandler.postDelayed(new Runnable() {
            public void run() {
                mSoundPool.stop(soundId);
            }
        }, STOP_DELAY_MILLIS);
    }

    /**
     * Initialize the control stream with the activity to music
     */
    public static void initStreamTypeMedia(Activity activity){
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    public static int getStreamMusicLevel(Activity activity){
        AudioManager am = (AudioManager) activity.getSystemService(Context.AUDIO_SERVICE);
        return am.getStreamVolume(AudioManager.STREAM_MUSIC);
    }

    /**
     * Is sound muted
     */
    public void setMuted(boolean muted) {
        this.mMuted = muted;
    }

}